package cn.ar.mapper;

import cn.ar.entity.Media;
import cn.ar.entity.MediaModelParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author EINTOO
* @description 针对表【media_model_param】的数据库操作Mapper
* @createDate 2021-12-24 09:18:49
* @Entity cn.ar.entity.MediaModelParam
*/
@Mapper
@Repository
public interface MediaModelParamMapper {


    /**
     * 添加模型参数
     * @param record
     * @return
     */
    int insert(MediaModelParam record);

    /**
     * 添加模型参数列表
     * @param mediaModelParamList
     * @return
     */
    int insertList(@Param("mediaModelParamList") List<MediaModelParam> mediaModelParamList);

    /**
     * 检验重复
     * @param mediaModelParam
     * @return
     */
    MediaModelParam checkRepeat(MediaModelParam mediaModelParam);

    /**
     * 通过资源编号查询模型参数列表
     * @param media
     * @return
     */
    List<MediaModelParam> selByCodeShow(Media media);


}
