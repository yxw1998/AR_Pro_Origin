package cn.ar.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * classify
 * @author YangXw
 */
@ApiModel(value="cn.ar.entity.Classify")
@Data
@JsonIgnoreProperties({"id", "addTime", "updateTime", "enable", "activity", "createrCode"})
public class Classify implements Serializable {
    /**
     *  
     */
    @ApiModelProperty(value=" ")
    private Long id;

    /**
     * 所属主体编号
     */
    @ApiModelProperty(value="所属主体编号")
    private String customerCode;

    /**
     * 所属项目编号
     */
    @ApiModelProperty(value="所属项目编号")
    private String projectCode;

    /**
     * 所属基准图编号
     */
    @ApiModelProperty(value="所属基准图编号")
    private String basePicCode;

    /**
     * 分类编号
     */
    @ApiModelProperty(value="分类编号")
    private String classCode;

    /**
     * 分类名称
     */
    @ApiModelProperty(value="分类名称")
    private String className;

    /**
     * 分类简介
     */
    @ApiModelProperty(value="分类简介")
    private String classIntroduce;

    /**
     * 分类排序顺序
     */
    @ApiModelProperty(value="分类排序顺序")
    private Integer classSequence;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private Date addTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value="更新时间")
    private Date updateTime;

    /**
     * 是否启用 true 启用 false 不启用
     */
    @ApiModelProperty(value="是否启用 true 启用 false 不启用")
    private Boolean enable;

    /**
     * 是否删除 true 未删除 false 已删除
     */
    @ApiModelProperty(value="是否删除 true 未删除 false 已删除")
    private Boolean activity;

    /**
     * 创建人编号
     */
    @ApiModelProperty(value="创建人编号")
    private String createrCode;

    private static final long serialVersionUID = 1L;
}