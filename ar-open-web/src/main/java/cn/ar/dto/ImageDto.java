package cn.ar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author YangXw
 * @date 2021/11/15 0015 17:15
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageDto {
    /**
     * 库名
     */
    private String collectionName;

    /**
     * 图片base64编码
     */
    private String queryContent;

    /**
     * 图片签名列表
     */
    private List<String> contSignList;

    /**
     * 图片签名
     */
    private String contSign;

    /**
     * 更新的摘要信息，最长256B。样例：{"name":"周杰伦", "id":"666"}
     */
    private String brief;

    /**
     * 更新的分类信息，tag间以逗号分隔，最多2个tag。样例："100,11"
     */
    private String tags;

    /**
     * 召回数量
     */
    private Integer topK;

}
