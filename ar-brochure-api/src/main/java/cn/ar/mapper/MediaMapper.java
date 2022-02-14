package cn.ar.mapper;

import cn.ar.entity.Classify;
import cn.ar.entity.Media;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YangXw
 */
@Mapper
@Repository
public interface MediaMapper {

    /**
     * 添加媒体资源详情信息
     * @param mediaVo
     * @return
     */
    int insert(Media mediaVo);

    /**
     * 通过customerCode和OBS资源名来查询资源
     * @param mediaVo
     * @return
     */
    Media selByName(Media mediaVo);

    /**
     * 通过classify查询资源信息列表
     * @param classify
     * @return
     */
    List<Media> selByCodeShow(Classify classify);

    /**
     * 查询主体项目media列表详情
     * @param media
     * @return
     */
    List<Media> selMediaList(Media media);
}