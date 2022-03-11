package cn.ar.util.huawei;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


/**
 * @author YangXw
 * @date 2021/12/15 14:49
 */
@Component
public class HuaWeiUtil {
    private static RestTemplate restTemplate = new RestTemplate();
    private static ObjectMapper objectMapper = new ObjectMapper();

    private static String getToken(){
        Object json = "{\n" +
                " \"auth\": {\n" +
                "  \"identity\": {\n" +
                "   \"methods\": [\n" +
                "    \"password\"\n" +
                "   ],\n" +
                "   \"password\": {\n" +
                "    \"user\": {\n" +
                "     \"domain\": {\n" +
                "      \"name\": \"name\"\n" +
                "     },\n" +
                "     \"name\": \"name\",\n" +
                "     \"password\": \"pwd\"\n" +
                "    }\n" +
                "   }\n" +
                "  },\n" +
                "  \"scope\": {\n" +
                "   \"project\": {\n" +
                "    \"name\": \"cn-north-1\"\n" +
                "   }\n" +
                "  }\n" +
                " }\n" +
                "}";
        String url = "https://iam.cn-north-1.myhuaweicloud.com/v3/auth/tokens";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String token = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(json, headers), String.class)
                .getHeaders()
                .getFirst("X-Subject-Token");
        return token;
    }

    public static String imageSearch(Object json){
        String jsonStr = null;
        try {
            jsonStr = objectMapper.writeValueAsString(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(jsonStr);
        String imageSearchUrl = "https://imagesearch.cn-north-1.myhuaweicloud.com/v1/0da5069b4800f2c92ff1c00b8ba521b5/xx/image/search";
        String result = "";
        try {
           result = HttpUtil.httpPostWithJSON(imageSearchUrl,jsonStr,getToken());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String imageAdd(Object json){
        String jsonStr = null;
        try {
            jsonStr = objectMapper.writeValueAsString(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        String imageSearchUrl = "https://imagesearch.cn-north-1.myhuaweicloud.com/v1/0da5069b4800f2c92ff1c00b8ba521b5/xx/image";
        String result = "";
        try {
           result = HttpUtil.httpPostWithJSON(imageSearchUrl,jsonStr,getToken());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
