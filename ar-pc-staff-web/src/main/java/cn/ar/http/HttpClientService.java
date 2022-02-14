package cn.ar.http;

import org.springframework.http.HttpHeaders;

import java.util.List;

/**
 * @author YangXw
 * @date 2021/11/18 0018 16:39
 * @description
 */

public interface HttpClientService {

    /**
     * json请求
     *
     * @param url
     * @param json
     * @return
     */
    String doPost(String url, Object json);

    /**
     * json请求
     *
     * @param url
     * @param json
     * @param cookieList
     * @return
     */
    String doPost(String url, Object json, List<String> cookieList);


    /**
     * 发送http请求
     * <p>自定义header</p>
     *
     * @param url        请求路径
     * @param json       请求的json报文
     * @param cookieList cookice
     * @param header     请求头
     * @return
     */
    String doPost(String url, Object json, List<String> cookieList, HttpHeaders header);
}
