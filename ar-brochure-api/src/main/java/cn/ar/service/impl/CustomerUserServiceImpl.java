package cn.ar.service.impl;

import cn.ar.common.GeneralResult;
import cn.ar.entity.CustomerUser;
import cn.ar.mapper.CustomerUserMapper;
import cn.ar.service.CustomerUserService;
import cn.ar.util.MD5;
import cn.ar.util.NewSnowUtil;
import cn.ar.util.RedisUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YangXw
 * @date 2021/11/23 0023 15:10
 * @description
 */
@Service
public class CustomerUserServiceImpl implements CustomerUserService {

    private CustomerUserMapper customerUserMapper;

    private RedisUtil redisUtil;

    @Autowired
    public void setCustomerUserMapper(CustomerUserMapper customerUserMapper) {
        this.customerUserMapper = customerUserMapper;
    }

    @Autowired
    public void setRedisUtil(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    @Override
    public GeneralResult insert(CustomerUser customerUser,String userSessCode,String comSessCode) {
        if (customerUserMapper.selCustomerUserByAccount(customerUser) != null) {
            return GeneralResult.fail("账号已存在,请重新输入!");
        }
        try {
            customerUser.setCreaterCode(userSessCode);
            customerUser.setCustomerUserCode(String.valueOf(NewSnowUtil.getId()));
            customerUser.setPassword(MD5.getSmallSign(customerUser.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
//        12.20 up
        customerUserMapper.insert(customerUser);
        return GeneralResult.success(customerUser.getCustomerUserCode());
    }

    @Override
    public GeneralResult selCustomerUserByCode(CustomerUser customerUser,String userSessCode,String comSessCode) {
        return GeneralResult.success(customerUserMapper.selCustomerUserByCode(customerUser));
    }


    @Override
    public GeneralResult selCustomerUserList(CustomerUser customerUser,String userSessCode, String comSessCode) {
        if (customerUser.getPagination() == 1) {
            PageHelper.startPage(customerUser.getPage(), customerUser.getPageNum());
        }
        return GeneralResult.success(new PageInfo<>(customerUserMapper.selCustomerUserList(customerUser.getCustomerUserCodeList(),comSessCode)));
    }

    @Override
    public GeneralResult login(CustomerUser customerUser, String userSessCode, String comSessCode) {
        try {
            CustomerUser loginCustomerUser = customerUserMapper.selCustomerUserByAccount(customerUser);
            if (loginCustomerUser == null) {
                return GeneralResult.fail("用户账号不存在!");
            }
            if (!loginCustomerUser.getPassword().equals(MD5.getSmallSign(customerUser.getPassword()))){
                return GeneralResult.fail("用户名密码错误!");
            }
            String token = MD5.getSmallSign(loginCustomerUser.getCustomerCode()+loginCustomerUser.getPassword()+System.currentTimeMillis());
            redisUtil.set(loginCustomerUser.getCustomerCode() + loginCustomerUser.getCustomerUserCode() + "loginToken",token,600);
            loginCustomerUser.setToken(token);
            loginCustomerUser.setPassword(null);
            customerUserMapper.insertLogin(loginCustomerUser);
            return GeneralResult.success(loginCustomerUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GeneralResult logout(String code, String token) {
        redisUtil.del(code + "loginToken");
        return GeneralResult.success(customerUserMapper.logout(code,token));
    }
}
