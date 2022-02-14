package cn.ar.controller;

import cn.ar.common.GeneralResult;
import cn.ar.entity.UserInfo;
import cn.ar.entity.UserProHistory;
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
@RequestMapping("/user")
@Slf4j
@Api(tags = "普通用户管理相关接口")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public GeneralResult register(@RequestBody @Validated({InsertGroup.class}) UserInfo userInfo, String userSessCode, String comSessCode){
        log.info("用户注册----->{}" + userInfo);
        return userService.insert(userInfo,userSessCode,comSessCode);
    }

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public GeneralResult login(@RequestBody UserInfo userInfo,String userSessCode,String comSessCode){
        log.info("用户登录----->{}" + userInfo);
        return userService.login(userInfo,userSessCode,comSessCode);
    }

    @ApiOperation("查询用户账号信息详情")
    @PostMapping("/selByUserCode")
    public GeneralResult selByUserCode(@RequestBody UserInfo userInfo,String userSessCode,String comSessCode){
        log.info("查询用户账号信息详情----->{}" + userInfo);
        return userService.selByUserCode(userInfo,userSessCode,comSessCode);
    }

    @ApiOperation("查询用户账号信息详情列表")
    @PostMapping("/selAllUser")
    public GeneralResult selAllUser(@RequestBody UserInfo userInfo,String userSessCode,String comSessCode){
        log.info("查询用户账号信息详情列表----->{}");
        return userService.selAllUser(userInfo,userSessCode,comSessCode);
    }

    @ApiOperation("通过miniOpenId查询用户信息")
    @PostMapping("/selUserByMiniOpenId")
    public GeneralResult selUserByMiniOpenId(@RequestBody UserInfo userInfo,String userSessCode,String comSessCode){
        log.info("通过miniOpenId查询用户信息----->{}");
        return userService.selUserByMiniOpenId(userInfo,userSessCode,comSessCode);
    }

    @ApiOperation("小程序注册")
    @PostMapping("/appletsRegister")
    public GeneralResult appletsRegister(@RequestBody @Validated({InsertGroup2.class}) UserInfo userInfo, String userSessCode, String comSessCode){
        log.info("小程序注册");
        return userService.appletsRegister(userInfo,userSessCode,comSessCode);
    }

    @ApiOperation("新增用户浏览项目记录[小程序端]")
    @PostMapping("/insertUserProHistoryMini")
    public GeneralResult insertUserProHistoryMini(@RequestBody UserProHistory userProHistory, String userSessCode, String comSessCode){
        log.info("新增用户浏览项目记录[小程序端]");
        return userService.insertUserProHistoryMini(userProHistory,userSessCode,comSessCode);
    }

    @ApiOperation("通过miniOpenId查询用户浏览项目历史记录[小程序端]")
    @PostMapping("/selHistoryByMini")
    public GeneralResult selHistoryByMini(@RequestBody UserProHistory userProHistory, String userSessCode, String comSessCode){
        log.info("通过miniOpenId查询用户浏览项目历史记录[小程序端]");
        return userService.selHistoryByMini(userProHistory,userSessCode,comSessCode);
    }


}
