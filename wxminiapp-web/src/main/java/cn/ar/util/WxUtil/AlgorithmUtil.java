package cn.ar.util.WxUtil;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author YangXw
 * @date 2021/12/9 0009 10:10
 * @description
 */
public class AlgorithmUtil {

    /**
     * SHA1加密
     * @param str
     * @return
     */
    public static String SHA1(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        } else {
            return DigestUtils.sha1Hex(str);
        }
    }

    /**
     * MD5加密（小写）
     * @param str
     * @return
     */
    public static String MD5(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        } else {
            return DigestUtils.md5Hex(str);
        }
    }





}
