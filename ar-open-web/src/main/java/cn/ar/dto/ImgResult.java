package cn.ar.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

/**
 * @author YangXw
 * @date 2022/01/27 16:10
 */
@Data
public class ImgResult {

    /**
     * 图片唯一识别ID
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String cont_sign;

    private List<ImageBlock> result;

}
