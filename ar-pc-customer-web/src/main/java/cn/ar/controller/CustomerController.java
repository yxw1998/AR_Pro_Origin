package cn.ar.controller;

import cn.ar.http.HttpClientService;
import cn.ar.http.path.HttpUrl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author YangXw
 * @date 2021/11/23 0023 10:04
 * @description
 */
@RestController
@RequestMapping("/customer")
@Slf4j
@Api(tags = "主体账号相关接口")
public class CustomerController {

    private HttpClientService httpClientService;

    @Autowired
    public void setHttpClientService(HttpClientService httpClientService) {
        this.httpClientService = httpClientService;
    }


    @ApiOperation("添加主体账号信息")
    @PostMapping(value = "/register", produces = "application/json;charset=utf-8")
    public Object register(@RequestBody String json, String userSessCode, String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("customer/register",userSessCode,comSessCode),json);
    }

    @ApiOperation("主体账号登录")
    @PostMapping(value = "/login", produces = "application/json;charset=utf-8")
    public Object login(@RequestBody String json, String userSessCode, String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("customer/login",userSessCode,comSessCode),json);
    }

    @ApiOperation("主体账号登出")
    @PostMapping(value = "/logout", produces = "application/json;charset=utf-8")
    public Object logout(String userSessCode, String comSessCode, HttpServletRequest request) {
        String token = request.getHeader("token");
        return httpClientService.doPost(HttpUrl.getArManagementUrlLogOut("customer/logout",userSessCode,token),null);
    }

    @ApiOperation("主体账号信息详情查询")
    @PostMapping(value = "/selCustomerByCode", produces = "application/json;charset=utf-8")
    public Object selCustomerByCode(@RequestBody String json, String userSessCode, String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("customer/selCustomerByCode",userSessCode,comSessCode),json);
    }

    @ApiOperation("主体账号信息详情列表查询")
    @PostMapping(value = "/selCustomerList", produces = "application/json;charset=utf-8")
    public Object selCustomerList(@RequestBody String json, String userSessCode, String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("customer/selCustomerList",userSessCode,comSessCode),json);
    }


    @ApiOperation("查询主体账号子人员登录记录列表")
    @PostMapping(value = "/selLoginLog", produces = "application/json;charset=utf-8")
    public Object selLoginLog(@RequestBody String json, String userSessCode, String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("customer/selLoginLog",userSessCode,comSessCode),json);
    }

    @ApiOperation("操作主体子用户权限")
    @PostMapping(value = "/operateCustomerUserPermission", produces = "application/json;charset=utf-8")
    public Object operateCustomerUserPermission(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("customer/operateCustomerUserPermission",userSessCode,comSessCode),json);
    }

    @ApiOperation("查询主体子账户权限列表")
    @PostMapping(value = "/selCustomerUserPermissionList", produces = "application/json;charset=utf-8")
    public Object selCustomerUserPermissionList(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("customer/selCustomerUserPermissionList",userSessCode,comSessCode),json);
    }

    @ApiOperation("查询主体账号剩余扫描次数")
    @PostMapping(value = "/selCustomerLeft", produces = "application/json;charset=utf-8")
    public Object selCustomerLeft(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("customer/selCustomerLeft",userSessCode,comSessCode),json);
    }

    @ApiOperation("查询主体账号充值次数记录")
    @PostMapping(value = "/selCustomerTopup", produces = "application/json;charset=utf-8")
    public Object selCustomerTopup(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("customer/selCustomerTopup",userSessCode,comSessCode),json);
    }
}
