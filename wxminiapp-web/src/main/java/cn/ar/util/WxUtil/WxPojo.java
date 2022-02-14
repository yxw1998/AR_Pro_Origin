package cn.ar.util.WxUtil;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author YangXw
 * @date 2021/12/18 17:15
 */
@Data
class WxPojo {
    /**
     * 用户唯一标识 (code2Session)
     */
    private String openid;

    /**
     * 会话密钥 (code2Session)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String session_key;

    /**
     * 用户在开放平台的唯一标识符 (code2Session)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String unionid;

    /**
     * 获取到的凭证 (AccessToken)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String access_token;

    /**
     * 凭证有效时间，单位：秒。目前是7200秒之内的值 (AccessToken)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer expires_in;

    /**
     * 错误码
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errcode;

    /**
     * 错误信息
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errmsg;

    /**
     * 用户手机号信息
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PhoneInfo phone_info;
}
