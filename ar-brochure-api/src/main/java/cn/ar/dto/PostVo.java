package cn.ar.dto;

import cn.ar.entity.BasePic;
import lombok.Data;

import java.util.List;

/**
 * @author YangXw
 * @date 2021/12/6 0006 14:21
 * @description
 */
@Data
public class PostVo {

    /**
     * 请求雪花数量
     */
    private Integer num;

    /**
     * 雪花编号列表
     */
    private List<String> snowList;

    /**
     * 基准图编号
     */
    private String basePicCode;
}
