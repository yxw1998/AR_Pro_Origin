package cn.ar.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * material
 * @author 
 */
@ApiModel(value="cn.ar.entity.Material")
@Data
@JsonIgnoreProperties({"id", "addTime", "updateTime", "enable", "activity", "createrCode"})
public class Material implements Serializable {
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
     * 素材编号
     */
    @ApiModelProperty(value="素材编号")
    private String materialCode;

    /**
     * 素材类型 1 贴图 2 xxx
     */
    @ApiModelProperty(value="素材类型 1 贴图 2 xxx")
    private Integer materialType;

    /**
     * 素材Obs文件名称
     */
    @ApiModelProperty(value="素材Obs文件名称")
    private String materialObsName;

    /**
     * 素材文件名称
     */
    @ApiModelProperty(value="素材文件名称")
    private String materialName;

    /**
     * 素材Obs文件路径
     */
    @ApiModelProperty(value="素材Obs文件路径")
    private String materialObsPath;

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