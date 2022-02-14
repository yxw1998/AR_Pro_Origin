package cn.ar.controller;

import cn.ar.dto.PostVo;
import cn.ar.common.GeneralResult;
import cn.ar.dto.ResourceVo;
import cn.ar.entity.*;
import cn.ar.service.ResourceService;
import cn.ar.util.NewSnowUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javafx.animation.Animation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangXw
 * @date 2021/12/6 0006 10:18
 * @description
 */
@RestController
@RequestMapping("/resource")
@Api(tags = "资源管理模块接口")
@Slf4j
public class ResourceController {

    private ResourceService resourceService;

    @Autowired
    public void setResourceService(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @ApiOperation("上传资源详情信息")
    @PostMapping(value = "/uploadResource",produces = "application/json;charset=utf-8")
    @Deprecated
    public GeneralResult uploadResource(@RequestBody ResourceVo resourceVo, String userSessCode, String comSessCode){
        System.out.println("上传资源详情信息---> " + resourceVo);
        return resourceService.uploadResource(resourceVo,userSessCode,comSessCode);
    }

    @ApiOperation("根据数量获取雪花编号")
    @PostMapping(value = "/getSnow",produces = "application/json;charset=utf-8")
    public GeneralResult getSnow(@RequestBody PostVo postVo, String userSessCode, String comSessCode){
        log.info("根据数量获取雪花编号---->" + postVo.getNum());
        List<String> snowList = new ArrayList<>();
        for (Integer i = 0; i < postVo.getNum(); i++) {
            snowList.add(String.valueOf(NewSnowUtil.getId()));
        }
        return GeneralResult.success(snowList);
    }

    @ApiOperation("资源展示")
    @PostMapping(value = "/showResource",produces = "application/json;charset=utf-8")
    public GeneralResult showResource(@RequestBody ResourceVo resourceVo, String userSessCode, String comSessCode){
        log.info("资源展示 ---- > " + resourceVo.getBasePic());
        return resourceService.showResource(resourceVo,userSessCode,comSessCode);
    }

    @ApiOperation("添加主体项目信息")
    @PostMapping(value = "/insertProject",produces = "application/json;charset=utf-8")
    public GeneralResult insertProject(@RequestBody ProjectInfo projectInfo, String userSessCode, String comSessCode){
        log.info("添加主体项目信息 ---- > " + projectInfo);
        return resourceService.insertProject(projectInfo,userSessCode,comSessCode);
    }

    @ApiOperation("查询主体项目信息详情列表")
    @PostMapping(value = "/selProjectList",produces = "application/json;charset=utf-8")
    @Deprecated
    public GeneralResult selProjectList(@RequestBody ProjectInfo projectInfo, String userSessCode, String comSessCode){
        log.info("查询主体项目信息详情列表 ---- > " + projectInfo);
        return resourceService.selProjectList(projectInfo,userSessCode,comSessCode);
    }

    @ApiOperation("查询主体项目基准图详情")
    @PostMapping(value = "/selBasePic",produces = "application/json;charset=utf-8")
    public GeneralResult selBasePic(@RequestBody BasePic basePic, String userSessCode, String comSessCode){
        log.info("查询主体项目基准图详情 ---- > " + basePic);
        return resourceService.selBasePic(basePic);
    }

    @ApiOperation("添加主体项目分类信息")
    @PostMapping(value = "/insertClassify",produces = "application/json;charset=utf-8")
    public GeneralResult insertClassify(@RequestBody ResourceVo resourceVo, String userSessCode, String comSessCode){
        log.info("添加主体项目分类信息 ---- > " + resourceVo.getClassifyList());
        return resourceService.insertClassifyList(resourceVo.getClassifyList(),userSessCode,comSessCode);
    }

    @ApiOperation("添加主体项目基准图绑定媒体资源信息")
    @PostMapping(value = "/insertMediaList",produces = "application/json;charset=utf-8")
    public GeneralResult insertMediaList(@RequestBody ResourceVo resourceVo, String userSessCode, String comSessCode){
        log.info("添加主体项目基准图绑定媒体资源信息 ---- > " + resourceVo.getMediaList());
        resourceVo.getMediaList().forEach(data -> {
            resourceService.insertMedia(data,userSessCode,comSessCode);
        });
        return GeneralResult.success("");
    }


    @ApiOperation("添加主体项目指定资源交互动画信息列表")
    @PostMapping(value = "/insertAnimationList",produces = "application/json;charset=utf-8")
    @Transactional
    public GeneralResult insertAnimationList(@RequestBody ResourceVo resourceVo, String userSessCode, String comSessCode){
        log.info("添加主体项目指定资源交互动画信息列表 ---- > " + resourceVo.getAnimationList());
        resourceVo.getAnimationList().forEach(data -> {
            resourceService.insertAnimation(data,userSessCode,comSessCode);
        });
        return GeneralResult.success("");
    }

    @ApiOperation("添加主体项目指定资源附属文件信息列表")
    @PostMapping(value = "/insertMaterialList",produces = "application/json;charset=utf-8")
    @Transactional
    public GeneralResult insertMaterialList(@RequestBody ResourceVo resourceVo, String userSessCode, String comSessCode){
        log.info("添加主体项目指定资源附属文件信息列表 ---- > " + resourceVo.getMaterialList());
        resourceVo.getMaterialList().forEach(data -> {
            resourceService.insertMaterial(data,userSessCode,comSessCode);
        });
        return GeneralResult.success("");
    }

    @ApiOperation("查询主体项目分类详情列表")
    @PostMapping(value = "/selClassifyList",produces = "application/json;charset=utf-8")
    public GeneralResult selClassifyList(@RequestBody Classify classify, String userSessCode, String comSessCode){
        log.info("查询主体项目分类详情列表 ---- > " + classify);
        return resourceService.selClassifyList(classify,userSessCode,comSessCode);
    }

    @ApiOperation("查询主体项目基准图绑定资源详情列表")
    @PostMapping(value = "/selMediaList",produces = "application/json;charset=utf-8")
    public GeneralResult selMediaList(@RequestBody Media media, String userSessCode, String comSessCode){
        log.info("查询主体项目基准图绑定资源详情列表 ---- > " + media);
        return resourceService.selMediaList(media,userSessCode,comSessCode);
    }

    @ApiOperation("查询主体项目指定资源交互动画详情列表")
    @PostMapping(value = "/selAnimationList",produces = "application/json;charset=utf-8")
    public GeneralResult selAnimationList(@RequestBody Media media, String userSessCode, String comSessCode){
        log.info("查询主体项目指定资源交互动画详情列表 ---- > " + media);
        return resourceService.selAnimationList(media,userSessCode,comSessCode);
    }

    @ApiOperation("查询主体项目指定资源附属文件详情列表")
    @PostMapping(value = "/selMaterialList",produces = "application/json;charset=utf-8")
    public GeneralResult selMaterialList(@RequestBody Media media, String userSessCode, String comSessCode){
        log.info("查询主体项目指定资源附属文件详情列表 ---- > " + media);
        return resourceService.selMaterialList(media,userSessCode,comSessCode);
    }


    @ApiOperation("查询基本参数详情列表")
    @PostMapping(value = "/selBaseParamByCode",produces = "application/json;charset=utf-8")
    public GeneralResult selBaseParamByCode(@RequestBody InterBaseParam baseParam, String userSessCode, String comSessCode){
        log.info("通过基本参数编号查询基本参数详情 ---- > " + baseParam);
        return resourceService.selBaseParamByCode(baseParam,userSessCode,comSessCode);
    }

    @ApiOperation("添加主体项目基准图信息")
    @PostMapping(value = "/insertBasePic",produces = "application/json;charset=utf-8")
    public GeneralResult insertBasePic(@RequestBody BasePic basePic, String userSessCode, String comSessCode){
        log.info("添加主体项目基准图信息 ---- > " + basePic);
        return resourceService.insertBasePic(basePic,userSessCode,comSessCode);
    }

    @ApiOperation("添加资源交互基本参数列表[false]")
    @PostMapping(value = "/insertBaseParamList",produces = "application/json;charset=utf-8")
    public GeneralResult insertBaseParamList(@RequestBody ResourceVo resourceVo, String userSessCode, String comSessCode){
        log.info("添加资源交互基本参数列表 ---- > " + resourceVo.getBaseParamList());
        return resourceService.insertBaseParamList(resourceVo.getBaseParamList(),userSessCode,comSessCode);
    }

    @ApiOperation("查询主体项目基准图详情信息列表")
    @PostMapping(value = "/selBasePicList",produces = "application/json;charset=utf-8")
    public GeneralResult selBasePicList(@RequestBody BasePic basePic, String userSessCode, String comSessCode){
        log.info("查询主体项目基准图详情信息列表 ---- > " + basePic);
        return resourceService.selBasePicList(basePic,userSessCode,comSessCode);
    }

    @ApiOperation("上传资源详情信息列表[动画，附属文件，基本参数]")
    @PostMapping(value = "/uploadResourceAMB",produces = "application/json;charset=utf-8")
    public GeneralResult uploadResourceAMB(@RequestBody ResourceVo resourceVo, String userSessCode, String comSessCode){
        System.out.println("上传资源详情信息列表[动画，附属文件，基本参数]---> " + resourceVo);
        return resourceService.uploadResourceAMB(resourceVo,userSessCode,comSessCode);
    }

    @ApiOperation("查询资源详情信息列表[动画，附属文件，基本参数]")
    @PostMapping(value = "/selResourceAMB",produces = "application/json;charset=utf-8")
    public GeneralResult selResourceAMB(@RequestBody Media media, String userSessCode, String comSessCode){
        System.out.println("查询资源详情信息列表[动画，附属文件，基本参数]---> " + media);
        return resourceService.selResourceAMB(media,userSessCode,comSessCode);
    }

    @ApiOperation("通过cloudId查询主体项目基准图详情")
    @PostMapping(value = "/selBasePicByCid",produces = "application/json;charset=utf-8")
    public GeneralResult selBasePicByCid(@RequestBody BasePic basePic, String userSessCode, String comSessCode){
        log.info("通过cloudId查询主体项目基准图详情 ---- > " + basePic);
        return resourceService.selBasePicByCid(basePic);
    }

}
