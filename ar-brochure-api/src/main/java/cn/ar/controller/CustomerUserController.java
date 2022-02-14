package cn.ar.controller;

import cn.ar.common.GeneralResult;
import cn.ar.entity.CustomerUser;
import cn.ar.service.CustomerUserService;
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
 * @date 2021/11/23 0023 15:13
 * @description
 */
@RestController
@RequestMapping("/customer/user")
@Slf4j
@Api(tags = "主体人员账号相关接口")
public class CustomerUserController {

    private CustomerUserService customerUserService;

    @Autowired
    public void setCustomerUserService(CustomerUserService customerUserService) {
        this.customerUserService = customerUserService;
    }


    @ApiOperation("创建主体子账号信息")
    @PostMapping("/register")
    public GeneralResult register(@RequestBody @Validated({InsertGroup.class}) CustomerUser customerUser, String userSessCode, String comSessCode){
        log.info("创建主体人员账号信息----->{}" + customerUser);
        return customerUserService.insert(customerUser,userSessCode,comSessCode);
    }

    @ApiOperation("主体人员账号登录")
    @PostMapping("/login")
    public GeneralResult login(@RequestBody CustomerUser customerUser, String userSessCode, String comSessCode){
        log.info("主体人员账号登录----->{}" + customerUser);
        return customerUserService.login(customerUser,userSessCode,comSessCode);
    }

    @ApiOperation("主体人员账号登出")
    @PostMapping("/logout")
    public GeneralResult logout(String code, String token){
        log.info("主体人员账号登出----->{} code: " + code + " token " + token);
        return customerUserService.logout(code,token);
    }

    @ApiOperation("查询主体人员账号详情")
    @PostMapping("/selCustomerUserByCode")
    public GeneralResult selCustomerUserByCode(@RequestBody CustomerUser customerUser, String userSessCode, String comSessCode){
        log.info("查询主体人员账号详情----->{}" + customerUser);
        return customerUserService.selCustomerUserByCode(customerUser,userSessCode,comSessCode);
    }

    @ApiOperation("查询主体人员账号详情列表")
    @PostMapping("/selCustomerUserList")
    public GeneralResult selCustomerUserList(@RequestBody CustomerUser customerUser, String userSessCode, String comSessCode){
        log.info("查询主体人员账号详情列表----->{}" + customerUser);
        return customerUserService.selCustomerUserList(customerUser,userSessCode,comSessCode);
    }

}
