package cn.ar.service;

import cn.ar.common.GeneralResult;
import cn.ar.dto.ResourceVo;
import cn.ar.entity.*;
import javafx.animation.Animation;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author YangXw
 * @date 2021/12/6 0006 10:23
 * @description
 */
public interface ResourceService {

    /**
     * 添加基准图信息详情
     * @param basePicVo
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult insertBasePic(BasePic basePicVo, String userSessCode, String comSessCode);

    /**
     * 添加媒体资源详情信息
     * @param mediaVo
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    void insertMedia(Media mediaVo, String userSessCode, String comSessCode);

    /**
     * 添加分类详情信息
     * @param classifyVo
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult insertClassify(Classify classifyVo, String userSessCode, String comSessCode);

    /**
     * 添加素材详情信息
     * @param materialVo
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    void insertMaterial(Material materialVo, String userSessCode, String comSessCode);

    /**
     * 添加动画详情信息
     * @param animationVo
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    void insertAnimation(InterAnimation animationVo, String userSessCode, String comSessCode);

    /**
     * 资源上传
     * @param resourceVo
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult uploadResource(ResourceVo resourceVo, String userSessCode, String comSessCode);

    /**
     * 资源展示
     * @param resourceVo
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult showResource(ResourceVo resourceVo, String userSessCode, String comSessCode);

    /**
     * 查询主体项目基准图详情
     * @param basePic
     * @return
     */
    GeneralResult selBasePic(BasePic basePic);

    /**
     * 添加主体项目详情
     * @param projectInfo
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult insertProject(ProjectInfo projectInfo, String userSessCode, String comSessCode);


    /**
     * 查询主体项目分类详情列表
     * @param classify
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult selClassifyList(Classify classify, String userSessCode, String comSessCode);

    /**
     * 查询主体项目基准图绑定资源详情列表
     * @param media
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult selMediaList(Media media, String userSessCode, String comSessCode);

    /**
     * 查询主体项目指定资源交互动画详情列表
      * @param media
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult selAnimationList(Media media, String userSessCode, String comSessCode);

    /**
     * 查询主体项目指定资源附属文件详情列表
     * @param media
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult selMaterialList(Media media, String userSessCode, String comSessCode);

    /**
     * 查询主体项目信息详情列表
     * @param projectInfo
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult selProjectList(ProjectInfo projectInfo, String userSessCode, String comSessCode);

    /**
     * 添加资源交互基本参数列表
     * @param baseParamList
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult insertBaseParamList(List<InterBaseParam> baseParamList, String userSessCode, String comSessCode);    /**

     * 通过基本参数编号查询基本参数详情
     * @param baseParam
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult selBaseParamByCode(InterBaseParam baseParam, String userSessCode, String comSessCode);

    /**
     * 添加分类详情信息列表
     * @param classifyList
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult insertClassifyList(List<Classify> classifyList,String userSessCode, String comSessCode);

    /**
     * 查询主体项目基准图详情信息列表
     * @param basePic
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult selBasePicList(BasePic basePic, String userSessCode, String comSessCode);

    /**
     * 上传资源详情信息列表[动画，附属文件，基本参数]
     * @param resourceVo
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult uploadResourceAMB(ResourceVo resourceVo, String userSessCode, String comSessCode);

    /**
     * 查询资源详情信息列表[动画，附属文件，基本参数]
     * @param media
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult selResourceAMB(Media media, String userSessCode, String comSessCode);

    /**
     * 通过cloudId查询主体项目基准图详情
     * @param basePic
     * @return
     */
    GeneralResult selBasePicByCid(BasePic basePic);
}
