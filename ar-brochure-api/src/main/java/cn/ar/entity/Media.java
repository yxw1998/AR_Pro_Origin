package cn.ar.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * media
 * @author YangXw
 */
@ApiModel(value="cn.ar.entity.Media")
@Data
@JsonIgnoreProperties({"id", "addTime", "updateTime", "enable", "activity", "createrCode"})
public class Media implements Serializable {
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
     * 资源编号
     */
    @ApiModelProperty(value="资源编号")
    private String mediaCode;

    /**
     * 资源类型 1.图 2.视 3.音 4.文 5.3D普通模型 6.
3D动画模型

     */
    @ApiModelProperty(value="资源类型 1.图 2.视 3.音 4.文 5.3D普通模型 6.3D动画模型")
    private Integer mediaType;

    /**
     * 资源标题
     */
    @ApiModelProperty(value="资源标题")
    private String mediaTitle;

    /**
     * 资源简介
     */
    @ApiModelProperty(value="资源简介")
    private String mediaIntroduce;

    /**
     * 资源排序顺序
     */
    @ApiModelProperty(value="资源排序顺序")
    private Integer mediaSequence;

    /**
     * 是否可交互 true 可交互 false 不可交互
     */
    @ApiModelProperty(value="是否可交互 true 可交互 false 不可交互")
    private Boolean isInteraction;

    /**
     * 资源OBS文件名称
     */
    @ApiModelProperty(value="资源OBS文件名称")
    private String mediaObsName;

    /**
     * 资源文件名称
     */
    @ApiModelProperty(value="资源文件名称")
    private String mediaName;

    /**
     * 资源OBS文件路径
     */
    @ApiModelProperty(value="资源OBS文件路径")
    private String mediaObsPath;

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