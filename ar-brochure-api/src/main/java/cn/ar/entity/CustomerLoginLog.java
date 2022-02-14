package cn.ar.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * customer_login_log
 * @author 
 */
@ApiModel(value="cn.ar.entity.CustomerLoginLog")
@Data
@JsonIgnoreProperties({"id","addTime","updateTime","enable","activity","createrCode"})
public class CustomerLoginLog implements Serializable {
    private Long id;

    /**
     * 主体编号
     */
    @ApiModelProperty(value="主体编号")
    private String customerCode;

    /**
     * 主体用户编号
     */
    @ApiModelProperty(value="主体用户编号")
    private String customerUserCode;

    /**
     * 登陆时间
     */
    @ApiModelProperty(value="登陆时间")
    @JsonFormat(timezone = "GMT+8" , pattern = "yyyy-MM-dd HH:mm:ss")
    private Date loginTime;

    /**
     * 登录类型 1 账号密码 2 小程序
     */
    @ApiModelProperty(value="登录类型 1 账号密码 2 小程序")
    private Integer loginType;

    /**
     * 登录令牌
     */
    @ApiModelProperty(value="登录令牌")
    private String token;

    /**
     * 下线时间
     */
    @ApiModelProperty(value="下线时间")
    @JsonFormat(timezone = "GMT+8" , pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

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