package cn.ar.vuforia;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.cookie.DateUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SignatureException;
import java.util.Date;

/**
 * @author YangXw
 * @date 2021/12/1 0001 17:17
 * @description
 */
public class VuforiaUtil {
    private static String accessKey = "[ server access key ]";
    private static String secretKey = "[ server secret key ]";

    private String targetId = "[ target id ]";
    private String url = "https://vws.vuforia.com";

    public static String getRequest(HttpPost httpPost){
        String method = "GET";
        String contentType = "";
        String hexDigest = "d41d8cd98f00b204e9800998ecf8427e";
        String dateValue = DateUtils.formatDate(new Date()).replaceFirst("[+]00:00$", "");
        String requestPath = httpPost.getURI().getPath();
        String toDigest = new String(method + "\n" + hexDigest + "\n" + contentType + "\n" + dateValue + "\n" + requestPath);
        String shaHashed = "";
        try {
            System.out.println("toDigest----> " + toDigest);
            shaHashed = calculateRFC2104HMAC(secretKey, toDigest);
        } catch (SignatureException e) {
            e.printStackTrace();
        }
        return new String(shaHashed);
    }

    public static String getPost(String json, HttpPost httpPost){
        String method = "POST";
        String contentType = "application/json";
        String hexDigest = contentMD5(json);
        String dateValue = DateUtils.formatDate(new Date()).replaceFirst("[+]00:00$", "");
        String requestPath = httpPost.getURI().getPath();
        String toDigest = new String(method + "\n" + hexDigest + "\n" + contentType + "\n" + dateValue + "\n" + requestPath);
        String shaHashed = "";
        try {
            System.out.println("toDigest----> " + toDigest);
            shaHashed = calculateRFC2104HMAC(secretKey, toDigest);
        } catch (SignatureException e) {
            e.printStackTrace();
        }
        return new String(shaHashed);
    }

    public static String calculateRFC2104HMAC(String key, String data) throws SignatureException {
        String result = "";
        try {
            // get an hmac_sha1 key from the raw key bytes 从原始密钥字节中获取hmac_sha1密钥
            SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), "HmacSHA1");

            // get an hmac_sha1 Mac instance and initialize with the signing key 获取一个hmac_sha1 Mac实例，并使用签名密钥进行初始化
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);

            // compute the hmac on input data bytes 计算输入数据字节的hmac
            byte[] rawHmac = mac.doFinal(data.getBytes());

            // base64-encode the hmac base64编码了hmac
            result = new String(Base64.encodeBase64(rawHmac, false));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static String contentMD5(String json) {
        return DigestUtils.md5Hex(json.getBytes(StandardCharsets.UTF_8)).toLowerCase();
    }



}
