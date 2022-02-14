package cn.ar.service;

import cn.ar.common.GeneralResult;
import cn.ar.entity.CustomerUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author YangXw
 * @date 2021/11/23 0023 15:09
 * @description
 */
public interface CustomerUserService {

    /**
     * 创建主体用户信息
     * @param customerUser
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult insert(CustomerUser customerUser,String userSessCode,String comSessCode);
    /**
     * 通过编号查询主体用户信息详情
     * @param customerUser
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult selCustomerUserByCode(CustomerUser customerUser,String userSessCode,String comSessCode);


    /**
     * 查询主体用户信息详情列表
     * @param comSessCode
     * @param userSessCode
     * @param customerUser
     * @return
     */
    GeneralResult selCustomerUserList(CustomerUser customerUser,String userSessCode, String comSessCode);

    /**
     * 用户登录
     * @param customerUser
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult login(CustomerUser customerUser, String userSessCode, String comSessCode);

    /**
     * 主体用户
     * @param code
     * @param token
     * @return
     */
    GeneralResult logout(String code, String token);
}
