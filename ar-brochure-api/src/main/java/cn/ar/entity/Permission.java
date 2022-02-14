package cn.ar.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * un_manager_permission
 * @author 
 */
@ApiModel(value="cn.ar.entity.UnManagerPermission")
@Data
@JsonIgnoreProperties({"id","addTime","updateTime","enable","activity","createrCode"})
public class Permission implements Serializable {
    private Long id;

    /**
     * 权限编号
     */
    @ApiModelProperty(value="权限编号")
    private String permissionCode;

    /**
     * 权限名称
     */
    @ApiModelProperty(value="权限名称")
    private String permissionName;

    /**
     * 权限等级 1模块权限 2.网页权限 3.功能权限
     */
    @ApiModelProperty(value="权限等级 1模块权限 2.网页权限 3.功能权限")
    private Integer permissionLevel;

    /**
     * 父权限编号，模块的父权限编号为0
     */
    @ApiModelProperty(value="父权限编号，模块的父权限编号为0")
    private String parentCode;

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