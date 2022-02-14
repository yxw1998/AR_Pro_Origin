package cn.ar.service.impl;

import cn.ar.common.GeneralResult;
import cn.ar.dto.PermissionDto;
import cn.ar.entity.Customer;
import cn.ar.entity.UnCustomerUserPermission;
import cn.ar.mapper.CustomerMapper;
import cn.ar.mapper.UnCustomerUserPermissionMapper;
import cn.ar.service.CustomerService;
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
 * @date 2021/11/22 0022 17:53
 * @description
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerMapper customerMapper;

    private UnCustomerUserPermissionMapper unCustomerUserPermissionMapper;

    private RedisUtil redisUtil;

    @Autowired
    public void setCustomerMapper(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    @Autowired
    public void setUnCustomerUserPermissionMapper(UnCustomerUserPermissionMapper unCustomerUserPermissionMapper) {
        this.unCustomerUserPermissionMapper = unCustomerUserPermissionMapper;
    }

    @Autowired
    public void setRedisUtil(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    @Override
    public GeneralResult insert(Customer customer, String userSessCode, String comSessCode) {
        if (customerMapper.selectByCustomerAccount(customer) != null) {
            return GeneralResult.fail("账号已存在,请重新输入!");
        }
        try {
            customer.setCreaterCode(userSessCode);
            customer.setCustomerCode(String.valueOf(NewSnowUtil.getId()));
            customer.setPassword(MD5.getSmallSign(customer.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return GeneralResult.success(customerMapper.insert(customer));
    }

    @Override
    public GeneralResult selCustomerByCode(Customer customer) {
        return GeneralResult.success(customerMapper.selCustomerByCode(customer));
    }

    @Override
    public GeneralResult selCustomerList(Customer customer, String userSessCode, String comSessCode) {
        if (customer.getPagination() == 1) {
            PageHelper.startPage(customer.getPage(), customer.getPageNum());
        }
        return GeneralResult.success(new PageInfo<>(customerMapper.selCustomerList(customer.getCustomerCodeList())));
    }

    @Override
    public GeneralResult login(Customer customer, String userSessCode, String comSessCode) {
        try {
            Customer loginCustomer = customerMapper.selectByCustomerAccount(customer);
            if (loginCustomer == null) {
                return GeneralResult.fail("用户账号不存在!");
            }
            if (!loginCustomer.getPassword().equals(MD5.getSmallSign(customer.getPassword()))) {
                return GeneralResult.fail("用户名密码错误!");
            }
            String token = MD5.getSmallSign(loginCustomer.getCustomerCode() + loginCustomer.getPassword() + System.currentTimeMillis());
            redisUtil.set(loginCustomer.getCustomerCode() + "" + "loginToken", token, 600);
            loginCustomer.setToken(token);
            loginCustomer.setPassword(null);
            customerMapper.insertLogin(loginCustomer);
            return GeneralResult.success(loginCustomer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GeneralResult selLoginLog(Customer customer, String userSessCode, String comSessCode) {
        if (customer.getPagination() == 1) {
            PageHelper.startPage(customer.getPage(), customer.getPageNum());
        }
        return GeneralResult.success(new PageInfo<>(customerMapper.selLoginLog(userSessCode, customer.getCustomerUserCodeList())));
    }

    @Override
    public GeneralResult logout(String customerCode, String token) {
        redisUtil.del(customerCode + "loginToken");
        return GeneralResult.success(customerMapper.logout(customerCode,token));
    }

    @Override
    public GeneralResult operateCustomerUserPermission(PermissionDto permissionDto, String userSessCode, String comSessCode) {
        List<UnCustomerUserPermission> addList = new ArrayList<>();
        List<UnCustomerUserPermission> delList = new ArrayList<>();
        //判断操作类型
        permissionDto.getUnCustomerUserPermissionList().forEach(data -> {
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
                UnCustomerUserPermission result = unCustomerUserPermissionMapper.selCustomerUserPermission(data);
                if (result != null) {
                    repeatList.add(result.getPermissionCode());
                } else {
                    data.setCreaterCode(userSessCode);
                    insertList.add(data);
                }
            });
            if (insertList.size() > 0) {
                unCustomerUserPermissionMapper.insertCustomerUser(insertList);
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
    public GeneralResult selCustomerUserPermissionList(UnCustomerUserPermission unCustomerUserPermission, String userSessCode, String comSessCode) {
        return GeneralResult.success(customerMapper.selCustomerUserPermissionList(unCustomerUserPermission));
    }
}
