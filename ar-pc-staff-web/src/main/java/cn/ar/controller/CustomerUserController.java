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
@RequestMapping("/customer/user")
@Slf4j
@Api(tags = "主体账号相关接口")
public class CustomerUserController {

    private HttpClientService httpClientService;

    @Autowired
    public void setHttpClientService(HttpClientService httpClientService) {
        this.httpClientService = httpClientService;
    }


    @ApiOperation("添加主体账号信息")
    @PostMapping(value = "/register", produces = "application/json;charset=utf-8")
    public Object register(@RequestBody String json, String userSessCode, String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("/customer/user/register",userSessCode,comSessCode),json);
    }

    @ApiOperation("主体用户账号登录")
    @PostMapping(value = "/login", produces = "application/json;charset=utf-8")
    public Object login(@RequestBody String json, String userSessCode, String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("/customer/user/login",userSessCode,comSessCode),json);
    }

    @ApiOperation("主体用户账号登出")
    @PostMapping(value = "/logout", produces = "application/json;charset=utf-8")
    public Object logout(String userSessCode, String comSessCode, HttpServletRequest request) {
        String token = request.getHeader("token");
        return httpClientService.doPost(HttpUrl.getArManagementUrlLogOut("/customer/user/logout",userSessCode,token),null);
    }

    @ApiOperation("主体账号信息详情查询")
    @PostMapping(value = "/selCustomerUserByCode", produces = "application/json;charset=utf-8")
    public Object selCustomerByCode(@RequestBody String json, String userSessCode, String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("/customer/user/selCustomerUserByCode",userSessCode,comSessCode),json);
    }

    @ApiOperation("查询主体账号信息详情列表")
    @PostMapping(value = "/selCustomerUserList", produces = "application/json;charset=utf-8")
    public Object selCustomerList(@RequestBody String json, String userSessCode, String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("/customer/user/selCustomerUserList",userSessCode,comSessCode),json);
    }
}
