package cn.ar.service.impl;

import cn.ar.common.GeneralResult;
import cn.ar.dto.PermissionDto;
import cn.ar.entity.Customer;
import cn.ar.entity.ManagerUser;
import cn.ar.entity.UnCustomerUserPermission;
import cn.ar.entity.UnManagerPermission;
import cn.ar.mapper.CustomerMapper;
import cn.ar.mapper.ManagerUserMapper;
import cn.ar.mapper.UnCustomerUserPermissionMapper;
import cn.ar.mapper.UnManagerPermissionMapper;
import cn.ar.service.ManagerUserService;
import cn.ar.util.MD5;
import cn.ar.util.NewSnowUtil;
import cn.ar.util.RedisUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangXw
 * @date 2021/11/22 0022 15:29
 * @description
 */
@Service
public class ManagerUserServiceImpl implements ManagerUserService {

    private ManagerUserMapper managerUserMapper;
    private CustomerMapper customerMapper;
    private UnManagerPermissionMapper unManagerPermissionMapper;
    private UnCustomerUserPermissionMapper unCustomerUserPermissionMapper;
    private RedisUtil redisUtil;

    @Autowired
    public void setManagerUserMapper(ManagerUserMapper managerUserMapper) {
        this.managerUserMapper = managerUserMapper;
    }

    @Autowired
    public void setUnCustomerUserPermissionMapper(UnCustomerUserPermissionMapper unCustomerUserPermissionMapper) {
        this.unCustomerUserPermissionMapper = unCustomerUserPermissionMapper;
    }

    @Autowired
    public void setUnManagerPermissionMapper(UnManagerPermissionMapper unManagerPermissionMapper) {
        this.unManagerPermissionMapper = unManagerPermissionMapper;
    }

    @Autowired
    public void setCustomerMapper(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    @Autowired
    public void setRedisUtil(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    @Override
    public GeneralResult insert(ManagerUser managerUser, String userSessCode, String comSessCode) {
        if (managerUserMapper.selByMaUserAccount(managerUser) != null) {
            return GeneralResult.fail("账号已存在,请重新输入!");
        }
        try {
            managerUser.setCreaterCode(userSessCode);
            managerUser.setManagerUserCode(String.valueOf(NewSnowUtil.getId()));
            managerUser.setPassword(MD5.getSmallSign(managerUser.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return GeneralResult.success(managerUserMapper.insert(managerUser));
    }

    @Override
    public GeneralResult login(ManagerUser managerUser, String userSessCode, String comSessCode) {
        try {
            ManagerUser loginManagerUser = managerUserMapper.selByMaUserAccount(managerUser);
            if (loginManagerUser == null) {
                return GeneralResult.fail("用户名不存在，请重新输入！");
            }
            if (!loginManagerUser.getPassword().equals(MD5.getSmallSign(managerUser.getPassword()))) {
                return GeneralResult.fail("用户名密码不正确，请重新输入！");
            }
            String token = MD5.getSmallSign(loginManagerUser.getManagerUserCode() + loginManagerUser.getPassword() + System.currentTimeMillis());
            loginManagerUser.setToken(token);
            loginManagerUser.setPassword(null);
            redisUtil.set("" + loginManagerUser.getManagerUserCode() + "loginToken", token, 600);
            managerUserMapper.insertLogin(loginManagerUser);
            return GeneralResult.success(loginManagerUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GeneralResult selByMaUserCode(ManagerUser managerUser, String userSessCode, String comSessCode) {
        return GeneralResult.success(managerUserMapper.selByMaUserCode(managerUser));
    }

    @Override
    public GeneralResult selAllMaUser(ManagerUser managerUser, String userSessCode, String comSessCode) {
        if (managerUser.getPagination() == 1) {
            PageHelper.startPage(managerUser.getPage(), managerUser.getPageNum());
        }
        return GeneralResult.success(new PageInfo<>(managerUserMapper.selAllMaUser(managerUser.getManagerUserCodeList())));
    }

    @Override
    public GeneralResult logout(String code, String token) {
        redisUtil.del(code + "loginToken");
        return GeneralResult.success(managerUserMapper.logout(code, token));
    }

    @Override
    public GeneralResult selLoginLog(ManagerUser managerUser, String userSessCode, String comSessCode) {
        if (managerUser.getPagination() == 1) {
            PageHelper.startPage(managerUser.getPage(), managerUser.getPageNum());
        }
        return GeneralResult.success(new PageInfo<>(managerUserMapper.selLoginLog(managerUser.getManagerUserCodeList())));
    }

    @Override
    public GeneralResult selCustomerLoginLog(Customer customer, String userSessCode, String comSessCode) {
        if (customer.getPagination() == 1) {
            PageHelper.startPage(customer.getPage(), customer.getPageNum());
        }
        return GeneralResult.success(new PageInfo<>(customerMapper.selCustomerLoginLog(customer.getCustomerCodeList())));
    }

    @Override
    public GeneralResult insertPermissionList(PermissionDto permissionDto, String userSessCode, String comSessCode) {
        List<UnManagerPermission> addList = new ArrayList<>();
        List<UnManagerPermission> delList = new ArrayList<>();
        //判断操作类型
        permissionDto.getUnManagerPermissionList().forEach(data -> {
            if (data.getType() == 0) {
                delList.add(data);
            }
            if (data.getType() == 1) {
                addList.add(data);
            }
        });

        List<String> repeatList = new ArrayList<>();
//        添加
        if (addList.size() > 0) {
            List<UnManagerPermission> insertList = new ArrayList<>();
            addList.forEach(data -> {
                UnManagerPermission result = unManagerPermissionMapper.selPermission(data);
                if (result != null) {
                    repeatList.add(result.getPermissionCode());
                } else {
                    data.setCreaterCode(userSessCode);
                    insertList.add(data);
                }
            });
            if (insertList.size() > 0) {
                unManagerPermissionMapper.insert(insertList);
            }
        }

        if (delList.size() > 0) {
//            删除操作
        }

        if (repeatList.size() > 0) {
            return GeneralResult.warn("以下权限已重复，请不要重复添加", repeatList);
        }
        return GeneralResult.success("操作成功");
    }

    @Override
    public GeneralResult selBasePermission(PermissionDto permissionDto,String userSessCode, String comSessCode) {
        if (permissionDto.getType() == 0){
        return GeneralResult.success(unManagerPermissionMapper.selManagerBasePermission());
        }
        return GeneralResult.success(unManagerPermissionMapper.selCustomerBasePermission());
    }

    @Override
    public GeneralResult operateCustomerPermission(PermissionDto permissionDto, String userSessCode, String comSessCode) {
        List<UnCustomerUserPermission> addList = new ArrayList<>();
        List<UnCustomerUserPermission> delList = new ArrayList<>();
        //判断操作类型
        permissionDto.getUnCustomerPermissionList().forEach(data -> {
            if (data.getType() == 0) {
                delList.add(data);
            }
            if (data.getType() == 1) {
                addList.add(data);
            }
        });

        List<String> repeatList = new ArrayList<>();
//        添加
        if (addList.size() > 0) {
            List<UnCustomerUserPermission> insertList = new ArrayList<>();
            addList.forEach(data -> {
                UnCustomerUserPermission result = unCustomerUserPermissionMapper.selCustomerPermission(data);
                if (result != null) {
                    repeatList.add(result.getPermissionCode());
                } else {
                    data.setCreaterCode(userSessCode);
                    insertList.add(data);
                }
            });
            if (insertList.size() > 0) {
                unCustomerUserPermissionMapper.insert(insertList);
            }
        }

        if (delList.size() > 0) {
//            删除操作
        }

        if (repeatList.size() > 0) {
            return GeneralResult.warn("以下权限已重复，请不要重复添加", repeatList);
        }
        return GeneralResult.success("操作成功");
    }
}
