package cn.ar.dto;

import cn.ar.entity.*;
import lombok.Data;

import java.util.List;

/**
 * @author YangXw
 * @date 2021/12/6 0006 13:46
 * @description
 */
@Data
public class ResourceVo {

    private BasePic basePic;
    private List<Classify> classifyList;
    private List<Media> mediaList;
    private List<Material> materialList;
    private List<InterAnimation> animationList;

    private List<InterBaseParam> baseParamList;

    /**
     * 12 24
     */
    private List<MediaModelParam> modelParamList;
}
