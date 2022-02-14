package cn.ar.util.WxUtil;

import lombok.Data;

/**
 * @author YangXw
 * @date 2021/12/18 17:16
 */
@Data
public class WaterMark {

    /**
     * 用户获取手机号操作的时间戳
     */
    private Integer timestamp;

    /**
     * 小程序appid
     */
    private String appid;
}
