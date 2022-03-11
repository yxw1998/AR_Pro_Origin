package cn.ar.util.WxUtil;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.AlgorithmParameters;
import java.security.Key;
import java.security.Security;
import java.util.Base64;

/**
 * @author YangXw
 * @date 2021/12/8 0008 17:01
 * @description
 */
@Component
@Slf4j
public class WxUtil {

    private static RestTemplate restTemplate = new RestTemplate();
    private static ObjectMapper objectMapper = new ObjectMapper();


    private static final String APPID = "ak";
    private static final String SECRET = "sk";

    private static boolean initialized = false;

    /**
     * 登录
     *
     * @param code
     * @return
     */
    public static WxPojo getCode2Session(String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + APPID + "&secret=" + SECRET + "&js_code=" + code + "&grant_type=authorization_code";
        String json = restTemplate.exchange(url, HttpMethod.GET, null, String.class).getBody();
        log.info("getCode2Session  --->{}" + json);

        WxPojo pojo = new WxPojo();
        try {
            pojo = objectMapper.readValue(json, WxPojo.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return pojo;
    }

    public static String getOpenId(String code) {
        return getCode2Session(code).getOpenid();
    }

    /**
     * 接口调用凭证
     *
     * @return
     */
    public static String getAccessToken() {
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + APPID + "&secret=" + SECRET;
        String json = restTemplate.exchange(url, HttpMethod.GET, null, String.class).getBody();
        log.info("getAccessToken  --->{}" + json);

        WxPojo pojo = new WxPojo();
        try {
            pojo = objectMapper.readValue(json, WxPojo.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return pojo.getAccess_token();
    }

    public static boolean isSignature(String rowData, String signature) {
        log.info("isSignature  --->{}" + signature);
        return AlgorithmUtil.SHA1(rowData + SECRET).equals(signature);
    }

    /**
     * 获取用户手机号
     *
     * @param code
     */
    public static String getPhone(String code) {
        String url = "https://api.weixin.qq.com/wxa/business/getuserphonenumber?access_token=" + getAccessToken();
        String json = "{\"code\":\"" + code + "\"}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String body = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(json, headers), String.class).getBody();
        WxPojo wxPojo = null;
        try {
            wxPojo = objectMapper.readValue(body, WxPojo.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return wxPojo.getPhone_info().getPhoneNumber();
    }

    /**
     * 开放数据的加密与解密
     *
     * @param encryptedData
     * @param session_key
     * @param iv
     * @return
     */
    public static String encryptedDataDecode(String encryptedData, String session_key, String iv) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] data = decoder.decode(encryptedData);
        byte[] aesKey = decoder.decode(session_key);
        byte[] IV = decoder.decode(iv);
        return new String(decrypt(data, aesKey, IV));
    }

    /**
     * AES-128-CBC解密初始化
     */
    private static void initialize() {
        if (initialized) {
            return;
        }
        Security.addProvider(new BouncyCastleProvider());
        initialized = true;
    }

    /**
     * 生成iv
     *
     * @param iv
     * @return
     */
    private static AlgorithmParameters generateIv(byte[] iv) throws Exception {
        AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
        parameters.init(new IvParameterSpec(iv));
        return parameters;
    }

    /**
     * 执行解密操作
     *
     * @param encryptedData
     * @param aesKey
     * @param ivByte
     * @return
     */
    private static byte[] decrypt(byte[] encryptedData, byte[] aesKey, byte[] ivByte) {
        initialize();
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            Key sKeySpec = new SecretKeySpec(aesKey, "AES");
            cipher.init(Cipher.DECRYPT_MODE, sKeySpec, generateIv(ivByte));
            byte[] result = cipher.doFinal(encryptedData);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}


