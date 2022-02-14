package cn.ar.service;

import cn.ar.common.GeneralResult;
import cn.ar.dto.PermissionDto;
import cn.ar.entity.Customer;
import cn.ar.entity.ManagerUser;
import cn.ar.entity.UnManagerPermission;

/**
 * @author YangXw
 * @date 2021/11/22 0022 11:32
 * @description
 */
public interface ManagerUserService {

    /**
     * 用户注册添加
     * @param managerUser
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult insert(ManagerUser managerUser,String userSessCode,String comSessCode);

    /**
     * 用户登录
     * @param managerUser
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult login(ManagerUser managerUser,String userSessCode,String comSessCode);


    /**
     * 用户登录
     * @param managerUser
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult selByMaUserCode(ManagerUser managerUser,String userSessCode,String comSessCode);


    /**
     * 查询用户详情列表
     * @param managerUser
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult selAllMaUser(ManagerUser managerUser,String userSessCode,String comSessCode);

    /**
     * 管理员账号登出
     * @param code
     * @param token
     * @return
     */
    GeneralResult logout(String code, String token);

    /**
     * 查询管理员登录记录列表
     * @param managerUser
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult selLoginLog(ManagerUser managerUser, String userSessCode, String comSessCode);

    /**
     * 查询主体账号登录记录列表
     * @param customer
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult selCustomerLoginLog(Customer customer, String userSessCode, String comSessCode);


    /**
     * 添加管理员权限
     * @param permissionDto
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult insertPermissionList(PermissionDto permissionDto, String userSessCode, String comSessCode);

    /**
     * 查询全部基本权限
     * @param permissionDto （type 0 管理员 1 主体）
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult selBasePermission(PermissionDto permissionDto,String userSessCode, String comSessCode);

    /**
     * 操作主体权限
     * @param permissionDto
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult operateCustomerPermission(PermissionDto permissionDto, String userSessCode, String comSessCode);
}
