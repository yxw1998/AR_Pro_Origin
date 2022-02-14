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

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * customer
 *
 * @author
 */
@ApiModel(value = "cn.ar.entity.Customer")
@Data
@JsonIgnoreProperties({"id", "addTime", "updateTime", "enable", "activity", "createrCode"})
public class Customer implements Serializable {
    private Long id;

    /**
     * 主体编号(雪花唯一)
     */
    @ApiModelProperty(value = "主体编号(雪花唯一)")
    private String customerCode;

    /**
     * 主体账号
     */
    @ApiModelProperty(value = "主体账号")
    private String customerAccount;

    /**
     * 密码（MD5）
     */
    @ApiModelProperty(value = "密码（MD5）")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotBlank(message = " 提示 :  密码不能为null值或空字符",groups = InsertGroup.class)
    private String password;

    /**
     * 主体名称
     */
    @ApiModelProperty(value = "主体名称")
    private String name;

    /**
     * 联系人姓名
     */
    @ApiModelProperty(value = "联系人姓名")
    private String linkName;

    /**
     * 联系人邮箱
     */
    @ApiModelProperty(value = "联系人邮箱")
    @Email(message = " 提示 :  请输入正确的邮箱格式",groups = InsertGroup.class)
    private String linkEmail;

    /**
     * 联系人电话
     */
    @ApiModelProperty(value = "联系人电话")
    private String linkPhone;

    /**
     * 认证类型 0 个人 1 企业
     */
    @ApiModelProperty(value = "认证类型 0 个人 1 企业")
    private Integer checkType;

    /**
     * 认证状态 0 未认证 1 认证中 2 已认证
     */
    @ApiModelProperty(value = "认证状态 0 未认证 1 认证中 2 已认证")
    private Integer checkStatus;

    /**
     * 证件类型 0 身份证 1 营业执照
     */
    @ApiModelProperty(value = "证件类型 0 身份证 1 营业执照")
    private Integer cardType;

    /**
     * 证件号码
     */
    @ApiModelProperty(value = "证件号码")
    private String cardNo;

    /**
     * 证件正面照
     */
    @ApiModelProperty(value = "证件正面照")
    private String cardPosPic;

    /**
     * 证件反面照
     */
    @ApiModelProperty(value = "证件反面照")
    private String cardNegPic;

    /**
     * Vip等级
     */
    @ApiModelProperty(value = "Vip等级")
    private Integer vipLevel;

    /**
     * 公众号OPENID
     */
    @ApiModelProperty(value = "公众号OPENID")
    private String pubOpenId;

    /**
     * 小程序OPENID
     */
    @ApiModelProperty(value = "小程序OPENID")
    private String miniOpenId;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date addTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**
     * 是否启用 true 启用 false 不启用
     */
    @ApiModelProperty(value = "是否启用 true 启用 false 不启用")
    private Boolean enable;

    /**
     * 是否删除 true 未删除 false 已删除
     */
    @ApiModelProperty(value = "是否删除 true 未删除 false 已删除")
    private Boolean activity;

    /**
     * 创建人编号
     */
    @ApiModelProperty(value = "创建人编号")
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
    private List<String> customerCodeList;

    /**
     * 主体用户人员编号列表
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> customerUserCodeList;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String token;

    private List<Permission> permissionList;

}