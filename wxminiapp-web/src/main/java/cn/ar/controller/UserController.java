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

/**
 * @author YangXw
 * @date 2021/11/19 0019 17:41
 * @description
 */
@RestController
@RequestMapping("/user")
@Slf4j
@Api(tags = "普通用户管理相关接口")
public class UserController {

    private HttpClientService httpClientService;

    @Autowired
    public void setHttpClientService(HttpClientService httpClientService) {
        this.httpClientService = httpClientService;
    }


    @ApiOperation("创建用户账号信息")
    @PostMapping(value = "/register", produces = "application/json;charset=utf-8")
    public Object register(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("user/register",userSessCode,comSessCode),json);
    }

    @ApiOperation("用户登录")
    @PostMapping(value = "/login", produces = "application/json;charset=utf-8")
    public Object login(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("user/login",userSessCode,comSessCode),json);
    }

    @ApiOperation("查询用户账号详情")
    @PostMapping(value = "/selByUserCode", produces = "application/json;charset=utf-8")
    public Object selByUserCode(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("user/selByUserCode",userSessCode,comSessCode),json);
    }


    @ApiOperation("查询用户账号详情列表")
    @PostMapping(value = "/selAllUser", produces = "application/json;charset=utf-8")
    public Object selAllUser(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("user/selAllUser",userSessCode,comSessCode),json);
    }

    @ApiOperation("根据小程序OPENID查询用户信息")
    @PostMapping(value = "/selUserByMiniOpenId", produces = "application/json;charset=utf-8")
    public Object selUserByMiniOpenId(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("user/selUserByMiniOpenId",userSessCode,comSessCode),json);
    }

    @ApiOperation("小程序注册")
    @PostMapping(value = "/appletsRegister", produces = "application/json;charset=utf-8")
    public Object appletsRegister(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("user/appletsRegister",userSessCode,comSessCode),json);
    }

    @ApiOperation("新增用户浏览项目记录[小程序端]")
    @PostMapping(value = "/insertUserProHistoryMini", produces = "application/json;charset=utf-8")
    public Object insertUserProHistoryMini(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("user/insertUserProHistoryMini",userSessCode,comSessCode),json);
    }

    @ApiOperation("通过miniOpenId查询用户浏览项目历史记录[小程序端]")
    @PostMapping(value = "/selHistoryByMini", produces = "application/json;charset=utf-8")
    public Object selHistoryByMini(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("user/selHistoryByMini",userSessCode,comSessCode),json);
    }
}
