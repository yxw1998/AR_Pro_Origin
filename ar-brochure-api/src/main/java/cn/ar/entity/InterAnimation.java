package cn.ar.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * inter_animation
 * @author 
 */
@ApiModel(value="cn.ar.entity.InterAnimation")
@Data
@JsonIgnoreProperties({"id","addTime","updateTime","enable","activity","createrCode"})
public class InterAnimation implements Serializable {
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
     * 所属资源编号
     */
    @ApiModelProperty(value="所属资源编号")
    private String mediaCode;

    /**
     * 动画编号
     */
    @ApiModelProperty(value="动画编号")
    private String animationCode;

    /**
     * 动画名称（default，run，walk）
     */
    @ApiModelProperty(value="动画名称（default，run，walk）")
    private String animationName;

    /**
     * 指令参数拼接字符串
     */
    @ApiModelProperty(value="指令参数拼接字符串")
    private String paramStr;

    /**
     * 图标OBS文件名称
     */
    @ApiModelProperty(value="图标OBS文件名称")
    private String iconObsName;

    /**
     * 图标名称
     */
    @ApiModelProperty(value="图标名称")
    private String iconName;

    /**
     * 图标OBS文件路径
     */
    @ApiModelProperty(value="图标OBS文件路径")
    private String iconObsPath;

    /**
     * 文件后缀
     */
    @ApiModelProperty(value="文件后缀")
    private String fileSuffix;

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