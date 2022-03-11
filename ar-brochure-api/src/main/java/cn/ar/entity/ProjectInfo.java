package cn.ar.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * project
 * @author 
 */
@ApiModel(value="cn.ar.entity.ProjectInfo")
@Data
@JsonIgnoreProperties({"id","addTime","updateTime","enable","activity","createrCode"})
public class ProjectInfo implements Serializable {
    private Long id;

    /**
     * 所属主体编号
     */
    @ApiModelProperty(value="所属主体编号")
    private String customerCode;

    /**
     * 项目编号
     */
    @ApiModelProperty(value="项目编号")
    private String projectCode;

    /**
     * 项目名称
     */
    @ApiModelProperty(value="项目名称")
    private String projectName;

    /**
     * 项目简介
     */
    @ApiModelProperty(value="项目简介")
    private String projectIntroduce;

    /**
     * 文件后缀
     */
    @ApiModelProperty(value="识别方式 0：不追踪 1：单个追踪 2：无缝追踪")
    private String trackType;

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