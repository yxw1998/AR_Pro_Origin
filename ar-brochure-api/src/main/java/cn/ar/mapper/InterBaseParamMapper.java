package cn.ar.mapper;

import cn.ar.entity.InterBaseParam;
import cn.ar.entity.Media;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YangXw
 */
@Mapper
@Repository
public interface InterBaseParamMapper {

    /**
     * 添加资源交互基本参数列表
     * @param record
     * @return
     */
    int insert(InterBaseParam record);

    /**
     * 校验重复
     * @param baseParam
     * @return
     */
    InterBaseParam checkRepeat(InterBaseParam baseParam);

    /**
     * 通过基本参数编号查询基本参数详情
     * @param baseParam
     * @return
     */
    List<InterBaseParam> selBaseParamByMediaCode(InterBaseParam baseParam);

    /**
     * 批量增加资源交互参数信息列表
     * @param baseParamList
     * @return
     */
    int insertList(@Param("baseParamList") List<InterBaseParam> baseParamList);

    /**
     * 通过mediaCode查询列表
     * @param media
     * @return
     */
    List<InterBaseParam> selByCodeShow(Media media);
}