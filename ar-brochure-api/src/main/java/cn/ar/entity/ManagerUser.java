package cn.ar.entity;

import cn.ar.validationGroup.InsertGroup;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * manager_user
 * @author 
 */
@ApiModel(value="cn.ar.entity.ManagerUser")
@Data
@JsonIgnoreProperties({"id","addTime","updateTime","enable","activity","createrCode"})
public class ManagerUser implements Serializable {
    private Long id;

    /**
     * 管理员编号（雪花唯一）
     */
    @ApiModelProperty(value="管理员编号（雪花唯一）")
    private String managerUserCode;

    /**
     * 管理员账号
     */
    @ApiModelProperty(value="管理员账号")
    private String managerUserAccount;

    /**
     * 密码（MD5）
     */
    @ApiModelProperty(value="密码（MD5）")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotBlank(message = " 提示 :  密码不能为null值或空字符",groups = InsertGroup.class)
    private String password;

    /**
     * 姓名
     */
    @ApiModelProperty(value="姓名")
    private String name;

    /**
     * 手机号
     */
    @ApiModelProperty(value="手机号")
    private String phone;

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

    @ApiModelProperty("页数")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer page;

    @ApiModelProperty("条数")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer pageNum;

    @ApiModelProperty("是否分页 0不分 1分页")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer pagination;

    /**
     * 管理员用户编号列表
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> managerUserCodeList;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String token;

    /**
     * 权限列表
     */
    private List<Permission> permissionList;
}