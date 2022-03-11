package cn.ar.service.impl;

import cn.ar.common.GeneralResult;
import cn.ar.dto.ResourceVo;
import cn.ar.entity.*;
import cn.ar.mapper.*;
import cn.ar.service.ResourceService;
import cn.ar.util.NewSnowUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangXw
 * @date 2021/12/6 0006 10:25
 * @description
 */
@Service
@Slf4j
public class ResourceServiceImpl implements ResourceService {

    private BasePicMapper basePicMapper;

    private MediaMapper mediaMapper;

    private ClassifyMapper classifyMapper;

    private MaterialMapper materialMapper;

    private InterAnimationMapper interAnimationMapper;

    private ProjectMapper projectMapper;

    private InterBaseParamMapper baseParamMapper;

    private MediaModelParamMapper modelParamMapper;

    private UserScanLogMapper userScanLogMapper;

    private CustomerLeftMapper customerLeftMapper;


    @Autowired
    public void setCustomerLeftMapper(CustomerLeftMapper customerLeftMapper) {
        this.customerLeftMapper = customerLeftMapper;
    }

    @Autowired
    public void setUserScanLogMapper(UserScanLogMapper userScanLogMapper) {
        this.userScanLogMapper = userScanLogMapper;
    }

    @Autowired
    public void setModelParamMapper(MediaModelParamMapper modelParamMapper) {
        this.modelParamMapper = modelParamMapper;
    }

    @Autowired
    public void setBaseParamMapper(InterBaseParamMapper baseParamMapper) {
        this.baseParamMapper = baseParamMapper;
    }

    @Autowired
    public void setBasePicMapper(BasePicMapper basePicMapper) {
        this.basePicMapper = basePicMapper;
    }

    @Autowired
    public void setMediaMapper(MediaMapper mediaMapper) {
        this.mediaMapper = mediaMapper;
    }

    @Autowired
    public void setClassifyMapper(ClassifyMapper classifyMapper) {
        this.classifyMapper = classifyMapper;
    }

    @Autowired
    public void setMaterialMapper(MaterialMapper materialMapper) {
        this.materialMapper = materialMapper;
    }

    @Autowired
    public void setInterAnimationMapper(InterAnimationMapper interAnimationMapper) {
        this.interAnimationMapper = interAnimationMapper;
    }

    @Autowired
    public void setProjectMapper(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }

    @Override
    public GeneralResult insertBasePic(BasePic basePicVo, String userSessCode, String comSessCode) {
        if (basePicMapper.selByCode(basePicVo) != null || basePicMapper.selByName(basePicVo) != null) {
            throw new RuntimeException("基准图已经存在,请查看obs文件名是否重复!!");
        }
        basePicVo.setCreaterCode(comSessCode);
        return GeneralResult.success(basePicMapper.insert(basePicVo));
    }

    @Override
    public void insertMedia(Media mediaVo, String userSessCode, String comSessCode) {
        mediaVo.setCreaterCode(comSessCode);
        if (mediaVo.getMediaType() != 4 && mediaMapper.selByName(mediaVo) != null) {
            throw new RuntimeException(mediaVo.getMediaObsName() + " 资源已经存在,请查看obs文件名是否重复!!");
        }
        if (mediaVo.getMediaCode() == null) {
            mediaVo.setMediaCode(String.valueOf(NewSnowUtil.getId()));
        }
        mediaMapper.insert(mediaVo);
    }

    @Deprecated
    @Override
    public GeneralResult insertClassify(Classify classifyVo, String userSessCode, String comSessCode) {
        classifyVo.setCreaterCode(comSessCode);
        if (classifyMapper.checkRepeat(classifyVo) != null) {
            throw new RuntimeException("此分类名已经存在!");
        }
        if (classifyVo.getClassCode() == null) {
            classifyVo.setClassCode(String.valueOf(NewSnowUtil.getId()));
        }
        return GeneralResult.success(classifyMapper.insert(classifyVo));
    }

    @Override
    public void insertMaterial(Material materialVo, String userSessCode, String comSessCode) {
        materialVo.setCreaterCode(comSessCode);
        if (materialMapper.checkRepeat(materialVo) != null) {
            throw new RuntimeException("此素材已经存在,请查看obs文件名是否重复!!");
        }
        if (materialVo.getMaterialCode() == null) {
            materialVo.setMaterialCode(String.valueOf(NewSnowUtil.getId()));
        }
        materialMapper.insert(materialVo);
    }

    @Override
    public void insertAnimation(InterAnimation animationVo, String userSessCode, String comSessCode) {
        animationVo.setCreaterCode(comSessCode);
        if (interAnimationMapper.checkRepeat(animationVo) != null) {
            throw new RuntimeException(animationVo.getAnimationName() + "交互动作已经存在,请查看obs文件名是否重复!");
        }
        if (animationVo.getAnimationCode() == null) {
            animationVo.setAnimationCode(String.valueOf(NewSnowUtil.getId()));
        }
        interAnimationMapper.insert(animationVo);
    }

    @Override
    @Transactional
    @Deprecated
    public GeneralResult uploadResource(ResourceVo resourceVo, String userSessCode, String comSessCode) {
        insertBasePic(resourceVo.getBasePic(), userSessCode, comSessCode);
        resourceVo.getClassifyList().forEach(data -> insertClassify(data, userSessCode, comSessCode));
        resourceVo.getMediaList().forEach(data -> insertMedia(data, userSessCode, comSessCode));
        resourceVo.getMaterialList().forEach(data -> insertMaterial(data, userSessCode, comSessCode));
        resourceVo.getAnimationList().forEach(data -> insertAnimation(data, userSessCode, comSessCode));
//        12.17 add
//        resourceVo.getBaseParamList().forEach(data -> insertBaseParam(data, userSessCode, comSessCode));
        return GeneralResult.success("");
    }

    @Override
    public GeneralResult showResource(ResourceVo resourceVo, String userSessCode, String comSessCode) {
        System.out.println("项目编号 : " + resourceVo.getProjectCode());
//        ----- 查询基准图列表
        BasePic basePic = new BasePic();
        basePic.setProjectCode(resourceVo.getProjectCode());
        basePic.setCustomerCode(comSessCode);
        List<BasePic> basePicList = basePicMapper.selBasePicList(basePic);

        if (basePicList == null) {
            return GeneralResult.fail("没有相关记录!");
        }
        resourceVo.setBasePicList(new ArrayList<BasePic>());
        resourceVo.setMediaList(new ArrayList<Media>());
        resourceVo.setClassifyList(new ArrayList<Classify>());
        resourceVo.setMaterialList(new ArrayList<Material>());
        resourceVo.setAnimationList(new ArrayList<InterAnimation>());
        resourceVo.setModelParamList(new ArrayList<MediaModelParam>());
        resourceVo.setBaseParamList(new ArrayList<>());
        basePicList.forEach(data -> {

            List<Classify> classifyList = classifyMapper.selByCodeShow(data);

            Media media = new Media();
            media.setProjectCode(resourceVo.getProjectCode());
            media.setCustomerCode(comSessCode);
            media.setBasePicCode(data.getBasePicCode());
            List<Media> mediaList = mediaMapper.selMediaList(media);

            for (int i = 0; i < mediaList.size(); i++) {
                if (materialMapper.selByCodeShow(mediaList.get(i)) != null) {
                    resourceVo.getMaterialList().addAll(materialMapper.selByCodeShow(mediaList.get(i)));
                }

                if (interAnimationMapper.selByCodeShow(mediaList.get(i)) != null) {
                    resourceVo.getAnimationList().addAll(interAnimationMapper.selByCodeShow(mediaList.get(i)));
                }

                if (modelParamMapper.selByCodeShow(mediaList.get(i)) != null) {
                    resourceVo.getModelParamList().addAll(modelParamMapper.selByCodeShow(mediaList.get(i)));
                }

                if (baseParamMapper.selByCodeShow(mediaList.get(i)) != null) {
                    resourceVo.getBaseParamList().addAll(baseParamMapper.selByCodeShow(mediaList.get(i)));
                }
            }


            resourceVo.getClassifyList().addAll(classifyList);
            resourceVo.getMediaList().addAll(mediaList);
        });

        resourceVo.getBasePicList().addAll(basePicList);
        deduct(comSessCode);
        return GeneralResult.success(resourceVo);
    }

    @Override
    public GeneralResult selBasePic(BasePic basePic) {
        ResourceVo resourceVo = new ResourceVo();
        resourceVo.setBasePic(basePicMapper.selByCode(basePic));
        Classify classify = new Classify();
        classify.setCustomerCode(basePic.getCustomerCode());
        classify.setProjectCode(basePic.getProjectCode());
        classify.setBasePicCode(basePic.getBasePicCode());
        resourceVo.setClassifyList(classifyMapper.selClassifyList(classify));
        return GeneralResult.success(resourceVo);
    }

    @Override
    public GeneralResult insertProject(ProjectInfo projectInfo, String userSessCode, String comSessCode) {
        projectInfo.setCustomerCode(comSessCode);
        if (projectMapper.selByName(projectInfo) != null) {
            return GeneralResult.fail("该项目已存在");
        }
        projectInfo.setProjectCode(String.valueOf(NewSnowUtil.getId()));
        projectInfo.setCreaterCode(comSessCode);
        projectMapper.insert(projectInfo);
        return GeneralResult.success(projectInfo);
    }

    @Override
    public GeneralResult selClassifyList(Classify classify, String userSessCode, String comSessCode) {
        return GeneralResult.success(classifyMapper.selClassifyList(classify));
    }

    @Override
    public GeneralResult selMediaList(Media media, String userSessCode, String comSessCode) {
        return GeneralResult.success(mediaMapper.selMediaList(media));
    }

    @Override
    public GeneralResult selAnimationList(Media media, String userSessCode, String comSessCode) {
        return GeneralResult.success(interAnimationMapper.selByCodeShow(media));
    }

    @Override
    public GeneralResult selMaterialList(Media media, String userSessCode, String comSessCode) {
        return GeneralResult.success(materialMapper.selByCodeShow(media));
    }

    @Override
    public GeneralResult selProjectList(ProjectInfo projectInfo, String userSessCode, String comSessCode) {
        return GeneralResult.success(projectMapper.selProjectList(projectInfo));
    }

    @Override
    public GeneralResult insertBaseParamList(List<InterBaseParam> baseParamList, String userSessCode, String comSessCode) {
        baseParamList.forEach(data -> {
            if (baseParamMapper.checkRepeat(data) != null) {
                throw new RuntimeException("请不要重复添加已存在的参数名称!");
            }
        });
        for (int i = 0; i < baseParamList.size(); i++) {
            baseParamList.get(i).setCreaterCode(comSessCode);
        }

        return GeneralResult.success(baseParamMapper.insertList(baseParamList));
    }

    @Override
    public GeneralResult selBaseParamByCode(InterBaseParam baseParam, String userSessCode, String comSessCode) {
        baseParam.setCustomerCode(comSessCode);
        return GeneralResult.success(baseParamMapper.selBaseParamByMediaCode(baseParam));
    }

    @Override
    public GeneralResult insertClassifyList(List<Classify> classifyList, String userSessCode, String comSessCode) {
        classifyList.forEach(data -> {
            if (classifyMapper.checkRepeat(data) != null) {
                throw new RuntimeException("此分类名已经存在!");
            }
        });
        for (int i = 0; i < classifyList.size(); i++) {
            classifyList.get(i).setCreaterCode(comSessCode);
        }
        return GeneralResult.success(classifyMapper.insertClassifyList(classifyList));
    }

    @Override
    public GeneralResult selBasePicList(BasePic basePic, String userSessCode, String comSessCode) {

        return GeneralResult.success(basePicMapper.selBasePicList(basePic));
    }

    @Override
    @Transactional(rollbackFor = {RuntimeException.class})
    public GeneralResult uploadResourceAMB(ResourceVo resourceVo, String userSessCode, String comSessCode) {
//        添加动作
        List<InterAnimation> animationList = resourceVo.getAnimationList();
        if (animationList != null && !animationList.isEmpty()) {
            for (int i = 0; i < animationList.size(); i++) {
                if (interAnimationMapper.checkRepeat(animationList.get(i)) != null) {
                    throw new RuntimeException(animationList.get(i).getIconObsName()
                            + "已存在,请查看编号或OBS文件名是否重复");
                }
                animationList.get(i).setCreaterCode(comSessCode);
            }
            interAnimationMapper.insertList(animationList);
        }

//        添加附属文件
        List<Material> materialList = resourceVo.getMaterialList();
        if (materialList != null && !materialList.isEmpty()) {
            for (int i = 0; i < materialList.size(); i++) {
                if (materialMapper.checkRepeat(materialList.get(i)) != null) {
                    throw new RuntimeException(materialList.get(i).getMaterialObsName()
                            + "已存在,请查看编号或OBS文件名是否重复");
                }
                materialList.get(i).setCreaterCode(comSessCode);
            }
            materialMapper.insertList(materialList);
        }

//        添加基本参数
        List<InterBaseParam> baseParamList = resourceVo.getBaseParamList();
        if (baseParamList != null && !baseParamList.isEmpty()) {
            for (int i = 0; i < baseParamList.size(); i++) {
                if (baseParamMapper.checkRepeat(baseParamList.get(i)) != null) {
                    throw new RuntimeException(baseParamList.get(i).getBaseParamKey()
                            + "已存在,请查看参数名是否重复");
                }
                baseParamList.get(i).setCreaterCode(comSessCode);
            }
            baseParamMapper.insertList(baseParamList);
        }

//        添加模型参数
        List<MediaModelParam> modelParamList = resourceVo.getModelParamList();
        if (modelParamList != null && !modelParamList.isEmpty()) {
            for (int i = 0; i < modelParamList.size(); i++) {
                if (modelParamMapper.checkRepeat(modelParamList.get(i)) != null) {
                    throw new RuntimeException(modelParamList.get(i).getModelParamCode()
                            + "已存在,请查看参数名是否重复");
                }
                modelParamList.get(i).setCreaterCode(comSessCode);
            }
            modelParamMapper.insertList(modelParamList);
        }
        return GeneralResult.success("");
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public GeneralResult selResourceAMB(Media media, String userSessCode, String comSessCode) {
        ResourceVo resourceVo = new ResourceVo();
        resourceVo.setBaseParamList(baseParamMapper.selByCodeShow(media));
        resourceVo.setAnimationList(interAnimationMapper.selByCodeShow(media));
        resourceVo.setMaterialList(materialMapper.selByCodeShow(media));
        resourceVo.setModelParamList(modelParamMapper.selByCodeShow(media));
//        扣除次数
        deduct(media.getCustomerCode());
//        添加用户扫描记录
        UserScanLog userScanLog = new UserScanLog();
        userScanLog.setUserCode(userSessCode);
        userScanLog.setCustomerCode(media.getCustomerCode());
        userScanLog.setProjectCode(media.getProjectCode());
        userScanLog.setMediaCode(media.getMediaCode());
        recordUserScan(userScanLog);
        return GeneralResult.success(resourceVo);
    }

    @Override
    public GeneralResult selBasePicByCid(BasePic basePic) {
        ResourceVo resourceVo = new ResourceVo();
        BasePic baseDto = basePicMapper.selBasePicByCloudId(basePic);
        resourceVo.setBasePic(baseDto);
        resourceVo.setClassifyList(classifyMapper.selByCodeShow(baseDto));
        return GeneralResult.success(resourceVo);
    }

    /**
     * 扣除用户使用次数
     *
     * @param customerCode
     */
    private void deduct(String customerCode) {
        customerLeftMapper.updateLeft(customerCode, -1);
    }

    /**
     * 添加用户扫描记录
     */
    private void recordUserScan(UserScanLog userScanLog) {
        userScanLogMapper.insert(userScanLog);
    }
}
