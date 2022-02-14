package cn.ar.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * inter_base_param
 * @author 
 */
@ApiModel(value="cn.ar.entity.InterBaseParam")
@Data
@JsonIgnoreProperties({"id","addTime","updateTime","enable","activity","createrCode"})
public class InterBaseParam implements Serializable {
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
     * 所属项目编号
     */
    @ApiModelProperty(value="所属分类编号")
    private String classCode;

    /**
     * 所属资源编号
     */
    @ApiModelProperty(value="所属资源编号")
    private String mediaCode;

    /**
     * 交互基本参数编号
     */
    @ApiModelProperty(value="交互基本参数编号")
    private String baseParamCode;

    /**
     * 交互基本参数
     */
    @ApiModelProperty(value="交互基本参数")
    private String baseParamKey;

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