package cn.ar.service;

import cn.ar.common.GeneralResult;
import cn.ar.dto.PermissionDto;
import cn.ar.entity.Customer;
import cn.ar.entity.UnCustomerUserPermission;

import java.util.List;

/**
 * @author YangXw
 * @date 2021/11/22 0022 17:52
 * @description
 */
public interface CustomerService {

    /**
     * 创建主体账号
     * @param customer
     * @return
     */
    GeneralResult insert(Customer customer,String userSessCode,String comSessCode);

    /**
     * 通过编号查询主体账号信息详情
     * @param customer
     * @return
     */
    GeneralResult selCustomerByCode(Customer customer);

    /**
     * 查询主体账号信息详情列表
     * @param customer
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult selCustomerList(Customer customer,String userSessCode,String comSessCode);

    /**
     * 主体账号登录
     * @param customer
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult login(Customer customer, String userSessCode, String comSessCode);

    /**
     * 查询主体人员账号登录详情列表
     * @param customer
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult selLoginLog(Customer customer, String userSessCode, String comSessCode);

    /**
     * 主体账号登出
     * @param code
     * @param token
     * @return
     */
    GeneralResult logout(String code, String token);

    /**
     * 操作主体用户权限
     * @param permissionDto
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult operateCustomerUserPermission(PermissionDto permissionDto, String userSessCode, String comSessCode);

    /**
     * 查询主体子账户权限
     * @param unCustomerUserPermission
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult selCustomerUserPermissionList(UnCustomerUserPermission unCustomerUserPermission, String userSessCode, String comSessCode);
}
