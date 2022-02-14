package cn.ar.mapper;

import cn.ar.common.GeneralResult;
import cn.ar.entity.BasePic;
import cn.ar.entity.Classify;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YangXw
 */
@Mapper
@Repository
public interface ClassifyMapper {

    /**
     * 添加分类详情信息
     * @param classifyVo
     * @return
     */
    int insert(Classify classifyVo);

    /**
     * 通过customer和名字查找分类
     * @param classifyVo
     * @return
     */
    Classify checkRepeat(Classify classifyVo);

    /**
     * 通过basePicCode和projectCode查询分类列表
     * @param basePic
     * @return
     */
    List<Classify> selByCodeShow(BasePic basePic);

    /**
     * 查询主体项目分类详情列表
     * @param classify
     * @return
     */
    List<Classify> selClassifyList(Classify classify);

    /**
     * 添加主体项目分类详情信息列表
     * @param classifyList
     * @return
     */
    int insertClassifyList(@Param("classifyList") List<Classify> classifyList);
}