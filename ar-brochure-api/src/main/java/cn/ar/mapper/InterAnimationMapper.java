package cn.ar.mapper;

import cn.ar.entity.InterAnimation;
import cn.ar.entity.Media;
import javafx.animation.Animation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * @author YangXw
 */
@Mapper
@Repository
public interface InterAnimationMapper {


    /**
     * 添加交互动画详情信息
     * @param record
     * @return
     */
    int insert(InterAnimation record);

    /**
     * 通过customerCode和动画名称查询动画
     * @param animationVo
     * @return
     */
    InterAnimation checkRepeat(InterAnimation animationVo);

    /**
     * 通过media查询动画交互列表
     * @param media
     * @return
     */
    List<InterAnimation> selByCodeShow(Media media);

    /**
     * 批量增加动画列表
     * @param animationList
     * @return
     */
    int insertList(@Param("animationList") List<InterAnimation> animationList);
}