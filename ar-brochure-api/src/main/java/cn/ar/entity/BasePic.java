package cn.ar.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * base_pic
 * @author YangXw
 */
@ApiModel(value="cn.ar.entity.BasePic")
@Data
@JsonIgnoreProperties({"id", "addTime", "updateTime", "enable", "activity", "createrCode"})
public class BasePic implements Serializable {
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
     * 基准图编号
     */
    @ApiModelProperty(value="基准图编号")
    private String basePicCode;

    /**
     * 基准图文件名称
     */
    @ApiModelProperty(value="基准图文件名称")
    private String basePicName;

    /**
     * 云识别数据库唯一识别号
     */
    @ApiModelProperty(value="云识别数据库唯一识别号")
    private String cloudTargetId;

    /**
     * 基准图OBS文件名称
     */
    @ApiModelProperty(value="基准图OBS文件名称")
    private String baseObsName;

    /**
     * 基准图OBS文件路径（文件夹）
     */
    @ApiModelProperty(value="基准图OBS文件路径（文件夹）")
    private String baseObsPath;

    /**
     * fSet文件名称
     */
    @ApiModelProperty(value="基准图OBS文件路径（文件夹）")
    private String fsetName;

    /**
     * fSet文件OBS路径
     */
    @ApiModelProperty(value="基准图OBS文件路径（文件夹）")
    private String fsetObsPath;

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