package cn.ar.dto;

import cn.ar.entity.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

/**
 * @author YangXw
 * @date 2021/12/6 0006 13:46
 * @description
 */
@Data
public class ResourceVo {

    private String projectCode;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BasePic basePic;
    private List<BasePic> basePicList;
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
