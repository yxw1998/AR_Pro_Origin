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
 * @date 2021/11/19 0019 17:41
 * @description
 */
@RestController
@RequestMapping("/managerUser")
@Slf4j
@Api(tags = "普通用户管理相关接口")
public class ManagerUserController {

    private HttpClientService httpClientService;

    @Autowired
    public void setHttpClientService(HttpClientService httpClientService) {
        this.httpClientService = httpClientService;
    }


    @ApiOperation("添加管理员账号")
    @PostMapping(value = "/register", produces = "application/json;charset=utf-8")
    public Object register(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("managerUser/register",userSessCode,comSessCode),json);
    }

    @ApiOperation("管理员登录")
    @PostMapping(value = "/login", produces = "application/json;charset=utf-8")
    public Object login(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("managerUser/login",userSessCode,comSessCode),json);
    }

    @ApiOperation("管理员登出")
    @PostMapping(value = "/logout", produces = "application/json;charset=utf-8")
    public Object logout(String userSessCode, String comSessCode, HttpServletRequest request) {
        String token = request.getHeader("token");
        return httpClientService.doPost(HttpUrl.getArManagementUrlLogOut("managerUser/logout",userSessCode,token),null);
    }

    @ApiOperation("查询管理员信息详情")
    @PostMapping(value = "/selByMaUserCode", produces = "application/json;charset=utf-8")
    public Object selByMaUserCode(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("managerUser/selByMaUserCode",userSessCode,comSessCode),json);
    }

    @ApiOperation("查询管理员信息详情列表")
    @PostMapping(value = "/selAllMaUser", produces = "application/json;charset=utf-8")
    public Object selAllMaUser(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("managerUser/selAllMaUser",userSessCode,comSessCode),json);
    }

    @ApiOperation("查询管理员登录详情列表")
    @PostMapping(value = "/selLoginLog", produces = "application/json;charset=utf-8")
    public Object selLoginLog(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("managerUser/selLoginLog",userSessCode,comSessCode),json);
    }

    @ApiOperation("查询主体账号登录记录列表")
    @PostMapping(value = "/selCustomerLoginLog", produces = "application/json;charset=utf-8")
    public Object selCustomerLoginLog(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("managerUser/selCustomerLoginLog",userSessCode,comSessCode),json);
    }

    @ApiOperation("操作管理员权限")
    @PostMapping(value = "/operatePermissionList", produces = "application/json;charset=utf-8")
    public Object operatePermissionList(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("managerUser/operatePermissionList",userSessCode,comSessCode),json);
    }

    @ApiOperation("查询全部基础权限")
    @PostMapping(value = "/selBasePermission", produces = "application/json;charset=utf-8")
    public Object selBasePermission(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("managerUser/selBasePermission",userSessCode,comSessCode),json);
    }

    @ApiOperation("操作主体权限")
    @PostMapping(value = "/operateCustomerPermission", produces = "application/json;charset=utf-8")
    public Object operateCustomerPermission(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("managerUser/operateCustomerPermission",userSessCode,comSessCode),json);
    }


}
