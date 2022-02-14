package cn.ar.entity;

import cn.ar.validationGroup.InsertGroup;
import cn.ar.validationGroup.InsertGroup2;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
 * user
 * @author YangXw
 */
@ApiModel(value="cn.ar.entity.UserInfo")
@Data
@JsonIgnoreProperties({"id","addTime","updateTime","enable","activity","createrCode"})
public class UserInfo implements Serializable {
    private Long id;

    /**
     * 用户编号（雪花、唯一）
     */
    @ApiModelProperty(value="用户编号（雪花、唯一）")
    private String userCode;

    /**
     * 用户账号
     */
    @ApiModelProperty(value="用户账号")
    private String userAccount;

    /**
     * 用户密码（MD5）
     */
    @ApiModelProperty(value="用户密码(MD5)")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotBlank(message = " 提示 :  密码不能为null值或空字符",groups = InsertGroup.class)
    private String password;

    /**
     * 用户姓名
     */
    @ApiModelProperty(value="用户姓名")
    private String name;

    /**
     * 性别 0 女 1 男
     */
    @ApiModelProperty(value="性别 0 女 1 男")
    private Integer sex;

    /**
     * 手机号
     */
    @ApiModelProperty(value="手机号")
    private String phone;

    /**
     * 身份证
     */
    @ApiModelProperty(value="身份证")
    private String idCard;

    /**
     * 头像名称
     */
    @ApiModelProperty(value="头像名称")
    private String headPic;

    /**
     * 微信名称
     */
    @ApiModelProperty(value="微信名称")
    private String wxName;

    /**
     * 公众号OPENID
     */
    @ApiModelProperty(value="公众号OPENID")
    private String pubOpenid;

    /**
     * 小程序OPENID
     */
    @ApiModelProperty(value="小程序OPENID")
    @NotBlank(message = " 提示 :  miniOpenId不能为null值或空字符",groups = InsertGroup2.class)
    private String miniOpenid;

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
     * 用户编号列表
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> userCodeList;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String token;
}