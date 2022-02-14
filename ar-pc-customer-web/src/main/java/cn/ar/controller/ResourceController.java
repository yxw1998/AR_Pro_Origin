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
@RequestMapping("/resource")
@Slf4j
@Api(tags = "资源管理模块接口")
public class ResourceController {

    private HttpClientService httpClientService;

    @Autowired
    public void setHttpClientService(HttpClientService httpClientService) {
        this.httpClientService = httpClientService;
    }


    @ApiOperation("根据数量获取雪花编号")
    @PostMapping(value = "/getSnow", produces = "application/json;charset=utf-8")
    public Object getSnow(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("resource/getSnow",userSessCode,comSessCode),json);
    }

    @ApiOperation("上传资源详情信息")
    @PostMapping(value = "/uploadResource", produces = "application/json;charset=utf-8")
    public Object uploadResource(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("resource/uploadResource",userSessCode,comSessCode),json);
    }

    @ApiOperation("资源展示")
    @PostMapping(value = "/showResource", produces = "application/json;charset=utf-8")
    public Object showResource(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("resource/showResource",userSessCode,comSessCode),json);
    }

    @ApiOperation("查询主体项目基准图详情")
    @PostMapping(value = "/selBasePic", produces = "application/json;charset=utf-8")
    public Object selBasePic(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("resource/selBasePic",userSessCode,comSessCode),json);
    }

    @ApiOperation("添加主体项目信息")
    @PostMapping(value = "/insertProject", produces = "application/json;charset=utf-8")
    public Object insertProject(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("resource/insertProject",userSessCode,comSessCode),json);
    }

    @ApiOperation("查询主体项目信息详情列表")
    @PostMapping(value = "/selProjectList", produces = "application/json;charset=utf-8")
    public Object selProjectList(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("resource/selProjectList",userSessCode,comSessCode),json);
    }

    @ApiOperation("添加主体项目分类信息")
    @PostMapping(value = "/insertClassify", produces = "application/json;charset=utf-8")
    public Object insertClassify(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("resource/insertClassify",userSessCode,comSessCode),json);
    }

    @ApiOperation("添加主体项目基准图绑定媒体资源信息")
    @PostMapping(value = "/insertMediaList", produces = "application/json;charset=utf-8")
    public Object insertMediaList(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("resource/insertMediaList",userSessCode,comSessCode),json);
    }

    @ApiOperation("添加主体项目指定资源交互动画信息列表")
    @PostMapping(value = "/insertAnimationList", produces = "application/json;charset=utf-8")
    public Object insertAnimationList(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("resource/insertAnimationList",userSessCode,comSessCode),json);
    }

    @ApiOperation("添加主体项目指定资源附属文件信息列表")
    @PostMapping(value = "/insertMaterialList", produces = "application/json;charset=utf-8")
    public Object insertMaterialList(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("resource/insertMaterialList",userSessCode,comSessCode),json);
    }

    @ApiOperation("查询主体项目分类详情列表")
    @PostMapping(value = "/selClassifyList", produces = "application/json;charset=utf-8")
    public Object selClassifyList(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("resource/selClassifyList",userSessCode,comSessCode),json);
    }

    @ApiOperation("查询主体项目基准图绑定资源详情列表")
    @PostMapping(value = "/selMediaList", produces = "application/json;charset=utf-8")
    public Object selMediaList(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("resource/selMediaList",userSessCode,comSessCode),json);
    }

    @ApiOperation("查询主体项目指定资源交互动画详情列表")
    @PostMapping(value = "/selAnimationList", produces = "application/json;charset=utf-8")
    public Object selAnimationList(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("resource/selAnimationList",userSessCode,comSessCode),json);
    }

    @ApiOperation("查询主体项目指定资源附属文件详情列表")
    @PostMapping(value = "/selMaterialList", produces = "application/json;charset=utf-8")
    public Object selMaterialList(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("resource/selMaterialList",userSessCode,comSessCode),json);
    }

    @ApiOperation("添加资源交互基本参数列表")
    @PostMapping(value = "/insertBaseParam", produces = "application/json;charset=utf-8")
    public Object insertBaseParam(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("resource/insertBaseParam",userSessCode,comSessCode),json);
    }

    @ApiOperation("通过基本参数编号查询基本参数详情")
    @PostMapping(value = "/selBaseParamByCode", produces = "application/json;charset=utf-8")
    public Object selBaseParamByCode(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("resource/selBaseParamByCode",userSessCode,comSessCode),json);
    }

    @ApiOperation("添加基本参数信息列表")
    @PostMapping(value = "/insertBaseParamList", produces = "application/json;charset=utf-8")
    public Object insertBaseParamList(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("resource/insertBaseParamList",userSessCode,comSessCode),json);
    }

    @ApiOperation("添加基准图信息")
    @PostMapping(value = "/insertBasePic", produces = "application/json;charset=utf-8")
    public Object insertBasePic(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("resource/insertBasePic",userSessCode,comSessCode),json);
    }

    @ApiOperation("查询主体项目基准图详情信息列表")
    @PostMapping(value = "/selBasePicList", produces = "application/json;charset=utf-8")
    public Object selBasePicList(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("resource/selBasePicList",userSessCode,comSessCode),json);
    }

    @ApiOperation("上传资源详情信息列表[动画，附属文件，基本参数]")
    @PostMapping(value = "/uploadResourceAMB", produces = "application/json;charset=utf-8")
    public Object uploadResourceAMB(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("resource/uploadResourceAMB",userSessCode,comSessCode),json);
    }

    @ApiOperation("查询资源详情信息列表[动画，附属文件，基本参数]")
    @PostMapping(value = "/selResourceAMB", produces = "application/json;charset=utf-8")
    public Object selResourceAMB(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("resource/selResourceAMB",userSessCode,comSessCode),json);
    }


}
