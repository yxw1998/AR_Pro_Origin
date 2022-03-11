package cn.ar.controller;


import cn.ar.common.GeneralResult;
import cn.ar.dto.PermissionDto;
import cn.ar.entity.Customer;
import cn.ar.entity.CustomerTopup;
import cn.ar.entity.ManagerUser;
import cn.ar.entity.UnCustomerUserPermission;
import cn.ar.service.CustomerService;
import cn.ar.validationGroup.InsertGroup;
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
 * @date 2021/11/22 0022 17:12
 * @description
 */

@RestController
@RequestMapping("/customer")
@Slf4j
@Api(tags = "主体账号相关接口")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ApiOperation("创建主体账号信息")
    @PostMapping("/register")
    public GeneralResult register(@RequestBody @Validated({InsertGroup.class}) Customer customer, String userSessCode, String comSessCode) {
        log.info("创建主体账号信息----->{}" + customer);
        return customerService.insert(customer, userSessCode, comSessCode);
    }

    @ApiOperation("主体账号登录")
    @PostMapping("/login")
    public GeneralResult login(@RequestBody Customer customer, String userSessCode, String comSessCode) {
        log.info("主体账号登录----->{}" + customer);
        return customerService.login(customer, userSessCode, comSessCode);
    }

    @ApiOperation("主体账号登出")
    @PostMapping("/logout")
    public GeneralResult logout(String code, String token) {
        log.info("主体账号登出----->{} code: " + code + " token " + token);
        return customerService.logout(code, token);
    }


    @ApiOperation("查询主体账号信息详情")
    @PostMapping("/selCustomerByCode")
    public GeneralResult selCustomerByCode(@RequestBody Customer customer, String userSessCode, String comSessCode) {
        log.info("查询主体账号信息详情----->{}" + customer);
        return customerService.selCustomerByCode(customer);
    }

    @ApiOperation("查询主体账号信息详情列表")
    @PostMapping("/selCustomerList")
    public GeneralResult selCustomerList(@RequestBody Customer customer, String userSessCode, String comSessCode) {
        log.info("查询主体账号信息详情列表----->{}");
        return customerService.selCustomerList(customer, userSessCode, comSessCode);
    }

    @ApiOperation("查询主体账号子人员登录记录列表")
    @PostMapping("/selLoginLog")
    public GeneralResult selLoginLog(@RequestBody Customer customer, String userSessCode, String comSessCode) {
        log.info("查询主体账号子人员登录记录列表----->{}");
        return customerService.selLoginLog(customer, userSessCode, comSessCode);
    }

    @ApiOperation("操作主体子用户权限")
    @PostMapping("/operateCustomerUserPermission")
    public GeneralResult operateCustomerUserPermission(@RequestBody @Validated({InsertGroup.class}) PermissionDto permissionDto, String userSessCode, String comSessCode) {
        log.info("操作主体子用户权限----->{}" + permissionDto.getUnCustomerUserPermissionList());
        return customerService.operateCustomerUserPermission(permissionDto, userSessCode, comSessCode);
    }

    @ApiOperation("查询主体子账户权限列表")
    @PostMapping("/selCustomerUserPermissionList")
    public GeneralResult selCustomerUserPermissionList(@RequestBody @Validated({InsertGroup.class}) UnCustomerUserPermission unCustomerUserPermission , String userSessCode, String comSessCode) {
        log.info("查询主体子账户权限列表----->{}" + unCustomerUserPermission);
        return customerService.selCustomerUserPermissionList(unCustomerUserPermission, userSessCode, comSessCode);
    }

    @ApiOperation("查询主体账号剩余扫描次数")
    @PostMapping("/selCustomerLeft")
    public GeneralResult selCustomerLeft(@RequestBody Customer customer , String userSessCode, String comSessCode) {
        log.info("查询主体账号剩余扫描次数----->{}" + customer);
        return customerService.selCustomerLeft(customer, userSessCode, comSessCode);
    }

    @ApiOperation("查询主体账号充值次数记录")
    @PostMapping("/selCustomerTopup")
    public GeneralResult selCustomerTopup(@RequestBody Customer customer , String userSessCode, String comSessCode) {
        log.info("查询主体账号充值次数记录----->{}" + customer);
        return customerService.selCustomerTopup(customer, userSessCode, comSessCode);
    }

    @ApiOperation("主体账号扫描次数充值")
    @PostMapping("/insertCustomerTopup")
    public GeneralResult insertCustomerTopup(@RequestBody CustomerTopup customerTopup , String userSessCode, String comSessCode) {
        log.info("主体账号充值次数----->{}" + customerTopup);
        return customerService.insertCustomerTopup(customerTopup, userSessCode, comSessCode);
    }
}
