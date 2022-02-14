package cn.ar.util.WxUtil;

import lombok.Data;

/**
 * @author YangXw
 * @date 2021/12/18 17:19
 */
@Data
public class PhoneInfo {

    /**
     * 用户绑定的手机号
     */
    private String phoneNumber;

    /**
     * 没有区号的手机号
     */
    private String purePhoneNumber;

    /**
     * 区号
     */
    private String countryCode;

    /**
     * 数据水印
     */
    private WaterMark watermark;
}
