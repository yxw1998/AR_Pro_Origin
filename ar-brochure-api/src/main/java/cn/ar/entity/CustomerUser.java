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
 * customer_user
 * @author 
 */
@ApiModel(value="cn.ar.entity.CustomerUser")
@Data
@JsonIgnoreProperties({"id","addTime","updateTime","enable","activity","createrCode"})
public class CustomerUser implements Serializable {
    private Long id;

    /**
     * 主题编号（雪花唯一）
     */
    @ApiModelProperty(value="主题编号（雪花唯一）")
    @NotBlank(message = " 提示 :  主体编号不能为null值或空字符",groups = InsertGroup.class)
    private String customerCode;

    /**
     * 主体用户编号（雪花唯一）
     */
    @ApiModelProperty(value="主体用户编号（雪花唯一）")
    private String customerUserCode;

    /**
     * 主体用户账号
     */
    @ApiModelProperty(value="主体用户账号")
    @NotBlank(message = " 提示 :  账号不能为null值或空字符",groups = InsertGroup.class)
    private String customerUserAccount;

    /**
     * 密码（MD5）
     */
    @ApiModelProperty(value="密码（MD5）")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotBlank(message = " 提示 :  密码不能为null值或空字符",groups = InsertGroup.class)
    private String password;

    /**
     * 主体用户姓名
     */
    @ApiModelProperty(value="主体用户姓名")
    private String name;

    /**
     * 性别 0 女 1 男
     */
    @ApiModelProperty(value="性别 0 女 1 男")
    private Integer sex;

    /**
     * 邮箱
     */
    @ApiModelProperty(value="邮箱")
    private String email;

    /**
     * 手机号
     */
    @ApiModelProperty(value="手机号")
    private String phone;

    /**
     * 公众号OPENID
     */
    @ApiModelProperty(value="公众号OPENID")
    private String pubOpenId;

    /**
     * 小程序OPENID
     */
    @ApiModelProperty(value="小程序OPENID")
    private String miniOpenId;

    /**
     * 会员等级
     */
    @ApiModelProperty(value="会员等级")
    private Integer vipLevel;

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
     * 主体用户编号列表
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> customerUserCodeList;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String token;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Permission> permissionList;
}