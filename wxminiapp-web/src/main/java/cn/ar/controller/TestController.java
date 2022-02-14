package cn.ar.controller;

import cn.ar.http.HttpClientService;
import cn.ar.http.path.HttpUrl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author YangXw
 * @date 2021/11/18 0018 17:11
 * @description
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    private HttpClientService httpClientService;

    @Autowired
    public void setHttpClientService(HttpClientService httpClientService) {
        this.httpClientService = httpClientService;
    }

    @PostMapping(value = "/success", produces = "application/json;charset=utf-8")
    public Object success(@RequestBody String json,String userSessCode,String comSessCode) {
        return httpClientService.doPost(HttpUrl.getArManagementUrl("test/success",userSessCode,comSessCode),json);
    }
}
