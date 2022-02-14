package cn.ar.mapper;

import cn.ar.entity.BasePic;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BasePicMapper {

    /**
     * 添加基准图详情信息
     * @param basePic
     * @return
     */
    int insert(BasePic basePic);

    /**
     * 通过customerCode和OBS文件名、文件路径查询基准图
     * @param basePic
     * @return
     */
    BasePic selByName(BasePic basePic);

    /**
     * 通过customerCode和basePicCode查询基准图
     * @param basePic
     * @return
     */
    BasePic selByCode(BasePic basePic);

    /**
     * 通过云数据库唯一识别号查询基准图信息
     * @param basePic
     * @return
     */
    BasePic selByTargetId(BasePic basePic);

    /**
     * 查询主体项目基准图详情信息列表
     * @param basePic
     * @return
     */
    List<BasePic> selBasePicList(BasePic basePic);

    /**
     * 通过cloudId查询主体项目基准图详情
     * @param basePic
     * @return
     */
    BasePic selBasePicByCloudId(BasePic basePic);
}