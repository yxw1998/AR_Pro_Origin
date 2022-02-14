package cn.ar.http.impl;

import cn.ar.http.HttpClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author YangXw
 * @date 2021/11/18 0018 16:41
 * @description
 */
@Service
@Slf4j
public class HttpClientServiceImpl implements HttpClientService {

    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public String doPost(String url, Object json) {
        return doPost(url, json, null);
    }

    @Override
    public String doPost(String url, Object json, List<String> cookieList) {
        return doPost(url, json, cookieList, new HttpHeaders());
    }

    @Override
    public String doPost(String url, Object json, List<String> cookieList, HttpHeaders header) {
        log.info("url--->{} " + url);
        if (cookieList != null) {
            header.put("cookie", cookieList);
        }
        header.setContentType(MediaType.APPLICATION_JSON);
        return restTemplate.exchange(url, HttpMethod.POST,new HttpEntity<>(json,header),String.class).getBody();
    }
}
