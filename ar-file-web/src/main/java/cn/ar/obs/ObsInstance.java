package cn.ar.obs;


import com.obs.services.ObsClient;
import com.obs.services.model.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author YangXw
 * @date 2021/11/30 0030 10:01
 * @description
 */

public class ObsInstance {

    public static final String AK = "AK";
    public static final String SK = "SK";
    public static final String ENDPOINT = "ENDPOINT";
    private static ObsClient obsClient = new ObsClient(AK, SK, ENDPOINT);

    /**
     * URL访问OBS 授权
     */
    @NotNull
    public static TemporarySignatureResponse createTemporarySignature(String objectName) {
        long expireSeconds = 1800;
        TemporarySignatureRequest request = new TemporarySignatureRequest(HttpMethodEnum.GET, expireSeconds);
//        request.setBucketName("ar-test-1130");
//        request.setBucketName("ar-prod");
        request.setObjectKey(objectName);

        Map<String, Object> queryParams = new HashMap<String, Object>();
        queryParams.put("x-image-process", "image/resize,m_fixed,w_100,h_100/rotate,100");
        request.setQueryParams(queryParams);

        TemporarySignatureResponse response = obsClient.createTemporarySignature(request);
        return response;
    }

    /**
     * 基于表单上传
     *
     * @return
     */
    @NotNull
    public static PostSignatureResponse createPostSignature() {
        PostSignatureRequest request = new PostSignatureRequest();
        // 设置表单参数
        Map<String, Object> formParams = new HashMap<String, Object>();
        // 设置对象访问权限为公共读
        formParams.put("x-obs-acl", "public-read");
        // 设置对象MIME类型
        formParams.put("content-type", "text/plain");
        request.setFormParams(formParams);
        // 设置表单上传请求有效期，单位：秒
        request.setExpires(3600);
        PostSignatureResponse response = obsClient.createPostSignature(request);

        // 获取表单上传请求参数
        System.out.println("policy---->" + response.getPolicy());
        System.out.println("getSignature---->" + response.getSignature());
        return response;
    }

    public static void putObject(String objName,String path){
        obsClient.putObject("intoo-log",objName,new File(path));
    }
    /**
     * 日志上传服务
     * @param objName
     * @param file
     */
    public static void putObject(String objName,File file){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        obsClient.putObject("intoo-log",objName,fis);
        if (fis!=null){
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 关闭桶
     */
    public static void close() {
        try {
            obsClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


