package cn.ar.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author YangXw
 * @date 2021/12/15 15:39
 */
@Data
public class ImageDtoH {

    /**
     * 图片文件Base64编码字符串
     */
    private String file;

    /**
     * 偏移量，指定搜索结果返回起始位置，取值为大于或等于0的整数，默认为0。
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer offset;

    /**
     * 返回被检索图像的数量，取值为1~100的整数，默认为10。
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer limit;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String path;

}
