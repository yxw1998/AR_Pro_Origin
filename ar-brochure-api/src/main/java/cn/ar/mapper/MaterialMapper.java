package cn.ar.mapper;

import cn.ar.entity.Material;
import cn.ar.entity.Media;
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
public interface MaterialMapper {

    /**
     * 添加素材详情信息
     * @param materialVo
     * @return
     */
    int insert(Material materialVo);

    /**
     * 通过customerCode和OBS素材名来查询素材
     * @param materialVo
     * @return
     */
    Material checkRepeat(Material materialVo);

    /**
     * 通过media查询附属文件列表
     * @param media
     * @return
     */
    List<Material> selByCodeShow(Media media);

    /**
     * 批量增加附属文件信息
     * @param materialList
     * @return
     */
    int insertList(@Param("materialList") List<Material> materialList);
}