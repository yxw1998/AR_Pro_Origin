package cn.ar.entity;

import cn.ar.validationGroup.InsertGroup;
import cn.ar.validationGroup.InsertGroup2;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

/**
 * un_customer_user_permission
 * @author 
 */
@ApiModel(value="cn.ar.entity.UnCustomerUserPermission")
@Data
@JsonIgnoreProperties({"id","addTime","updateTime","enable","activity","createrCode"})
public class UnCustomerUserPermission implements Serializable {
    private Long id;

    /**
     * 主体编号
     */
    @ApiModelProperty(value="主体编号")
    @NotBlank(message = "主体编号不能为null值或空字符",groups = {InsertGroup.class,InsertGroup2.class})
    private String customerCode;

    /**
     * 主体用户编号
     */
    @ApiModelProperty(value="主体用户编号")
    @NotBlank(message = "主体用户编号不能为null值或空字符",groups = InsertGroup.class)
    @Null(message = "主体账号权限分配接口 主体用户编号必须为null值",groups = InsertGroup2.class)
    private String customerUserCode;

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
     * 权限等级 1 模块权限 2 网页权限 3 功能权限
     */
    @ApiModelProperty(value="权限等级 1 模块权限 2 网页权限 3 功能权限")
    private Integer permissionLevel;

    /**
     * 父权限编号 模块父权限为0
     */
    @ApiModelProperty(value="父权限编号 模块父权限为0")
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

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer type;

    private static final long serialVersionUID = 1L;
}