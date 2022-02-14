package cn.ar.controller;

import cn.ar.common.GeneralResult;
import cn.ar.dto.PermissionDto;
import cn.ar.entity.Customer;
import cn.ar.entity.ManagerUser;
import cn.ar.entity.UnManagerPermission;
import cn.ar.entity.UserInfo;
import cn.ar.service.ManagerUserService;
import cn.ar.service.UserService;
import cn.ar.validationGroup.InsertGroup;
import cn.ar.validationGroup.InsertGroup2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangXw
 * @date 2021/11/19 0019 17:41
 * @description
 */
@RestController
@RequestMapping("/managerUser")
@Slf4j
@Api(tags = "管理员相关接口")
public class ManagerUserController {

    private ManagerUserService managerUserService;

    @Autowired
    public void setManagerUserService(ManagerUserService managerUserService) {
        this.managerUserService = managerUserService;
    }

    @ApiOperation("添加管理员账号")
    @PostMapping("/register")
    public GeneralResult register(@RequestBody @Validated({InsertGroup.class}) ManagerUser managerUser, String userSessCode, String comSessCode) {
        log.info("添加管理员账号----->{}" + managerUser);
        return managerUserService.insert(managerUser, userSessCode, comSessCode);
    }


    @ApiOperation("管理员登录")
    @PostMapping("/login")
    public GeneralResult login(@RequestBody ManagerUser managerUser, String userSessCode, String comSessCode) {
        log.info("管理员登录----->{}" + managerUser);
        return managerUserService.login(managerUser, userSessCode, comSessCode);
    }

    @ApiOperation("管理员登出")
    @PostMapping("/logout")
    public GeneralResult logout(String code, String token) {
        log.info("管理员登出----->{} code: " + code + " token " + token);
        return managerUserService.logout(code,token);
    }

    @ApiOperation("查询管理员信息详情")
    @PostMapping("/selByMaUserCode")
    public GeneralResult selByMaUserCode(@RequestBody ManagerUser managerUser, String userSessCode, String comSessCode) {
        log.info("查询管理员信息详情----->{}" + managerUser);
        return managerUserService.selByMaUserCode(managerUser, userSessCode, comSessCode);
    }

    @ApiOperation("查询管理员信息详情列表")
    @PostMapping("/selAllMaUser")
    public GeneralResult selAllMaUser(@RequestBody ManagerUser managerUser, String userSessCode, String comSessCode) {
        log.info("查询管理员信息详情列表----->{}");
        return managerUserService.selAllMaUser(managerUser, userSessCode, comSessCode);
    }

    @ApiOperation("查询管理员登录记录列表")
    @PostMapping("/selLoginLog")
    public GeneralResult selLoginLog(@RequestBody ManagerUser managerUser, String userSessCode, String comSessCode) {
        log.info("查询管理员登录记录列表----->{}");
        return managerUserService.selLoginLog(managerUser, userSessCode, comSessCode);
    }

    @ApiOperation("查询主体账号登录记录列表")
    @PostMapping("/selCustomerLoginLog")
    public GeneralResult selCustomerLoginLog(@RequestBody Customer customer, String userSessCode, String comSessCode) {
        log.info("查询主体账号登录记录列表----->{}");
        return managerUserService.selCustomerLoginLog(customer, userSessCode, comSessCode);
    }

    @ApiOperation("操作管理员权限")
    @PostMapping("/operatePermissionList")
    public GeneralResult operatePermissionList(@RequestBody PermissionDto permissionDto, String userSessCode, String comSessCode) {
        log.info("操作管理员权限----->{}" + permissionDto.getUnManagerPermissionList());
        return managerUserService.insertPermissionList(permissionDto, userSessCode, comSessCode);
    }

    @ApiOperation("查询全部基础权限")
    @PostMapping("/selBasePermission")
    public GeneralResult selBasePermission(@RequestBody PermissionDto permissionDto,String userSessCode, String comSessCode) {
        log.info("查询全部基础权限----->{}" );
        return managerUserService.selBasePermission(permissionDto,userSessCode, comSessCode);
    }

    @ApiOperation("操作主体权限")
    @PostMapping("/operateCustomerPermission")
    public GeneralResult operateCustomerPermission(@RequestBody @Validated({InsertGroup2.class}) PermissionDto permissionDto, String userSessCode, String comSessCode) {
        log.info("操作主体权限----->{}" + permissionDto.getUnCustomerPermissionList());
        return managerUserService.operateCustomerPermission(permissionDto, userSessCode, comSessCode);
    }



}
