package cn.ar.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * 
 * @author YangXw
 * @TableName media_model_param
 */
@Data
@JsonIgnoreProperties({"id", "addTime", "updateTime", "enable", "activity", "createrCode"})
public class MediaModelParam implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 所属主体编号
     */
    private String customerCode;

    /**
     * 所属项目编号
     */
    private String projectCode;

    /**
     * 所属资源编号
     */
    private String mediaCode;

   /**
     * 模型参数编号
     */
    private String modelParamCode;

    /**
     * 模型位置参数
     */
    private String placeParam;

    /**
     * 模型缩放参数
     */
    private String zoomParam;

    /**
     * 模型旋转参数
     */
    private String rotateParam;

    /**
     * 创建时间
     */
    private Date addTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否启用 true 启用 false 不启用
     */
    private Boolean enable;

    /**
     * 是否删除 true 未删除 false 已删除
     */
    private Boolean activity;

    /**
     * 创建人编号
     */
    private String createrCode;

    private static final long serialVersionUID = 1L;
}