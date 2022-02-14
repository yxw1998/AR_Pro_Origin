package cn.ar.util;

import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;

public class MD5 {

    /**
     * MD5加密方法 私有
     *
     * @param source
     * @return
     */
    private static String getSMALLMD5(byte[] source) {
        String s = null;
        char hexDigits[] = { // 用来将字节转换成 16 进制表示的字符
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            md.update(source);
            // MD5 的计算结果是一个 128 位的长整数，
            byte tmp[] = md.digest();
            // 用字节表示就是 16 个字节
            char str[] = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符，
            // 所以表示成 16 进制需要 32 个字符
            int k = 0; // 表示转换结果中对应的字符位置
            for (int i = 0; i < 16; i++) { // 从第一个字节开始，对 MD5 的每一个字节
                // 转换成 16 进制字符的转换
                byte byte0 = tmp[i]; // 取第 i 个字节
                str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换,
                // >>> 为逻辑右移，将符号位一起右移
                str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
            }
            // 换后的结果转换为字符串
            s = new String(str);

        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return s;
    }

    private static String getBIGMD5(byte[] source) {
        String s = null;
        char hexDigits[] = { // 用来将字节转换成 16 进制表示的字符
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            md.update(source);
            byte tmp[] = md.digest(); // MD5 的计算结果是一个 128 位的长整数，
            // 用字节表示就是 16 个字节
            char str[] = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符，
            // 所以表示成 16 进制需要 32 个字符
            int k = 0; // 表示转换结果中对应的字符位置
            for (int i = 0; i < 16; i++) { // 从第一个字节开始，对 MD5 的每一个字节
                // 转换成 16 进制字符的转换
                byte byte0 = tmp[i]; // 取第 i 个字节
                str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换,
                // >>> 为逻辑右移，将符号位一起右移
                str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
            }
            s = new String(str); // 换后的结果转换为字符串

        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return s;
    }

    /**
     * 参数MD5小写加密
     *
     * @param string 需要加密的参数
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getSmallSign(String string) throws UnsupportedEncodingException {

        if (!StringUtils.isEmpty(string)) {
            String sign = getSMALLMD5(string.getBytes("UTF-8"));
            return sign;
        } else {
            return null;
        }
    }

    /**
     * 参数MD5大写加密
     *
     * @param string 需要加密的参数
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getBigSign(String string) throws UnsupportedEncodingException {

        if (!StringUtils.isEmpty(string)) {
            String sign = getBIGMD5(string.getBytes("UTF-8"));
            return sign;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(MD5.getSmallSign("admin"));
            System.out.println(MD5.getBigSign("admin"));
        } catch (Exception e) {

        }
    }
}
