package cn.ar.util.huawei;//package com.open.api.utils;
//

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @date
 */
public class HttpUtil {

    private static final String APPLICATION_JSON = "application/json;charset=UTF-8";

    public static String httpPostAPI(String url, String json, String token) throws HttpException, IOException {
        String jsonStr = "";
        String URL = url;

        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod(URL.toString());

        try {
            postMethod.addRequestHeader("Content-Type", APPLICATION_JSON);
            List<Header> headers = new ArrayList<Header>();
//            headers.add(new Header("contentLength", URL.toString().length() + ""));
            headers.add(new Header("X-Auth-Token", token));

            httpClient.getHostConfiguration().getParams().setParameter("http.default-headers", headers);
            postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());

            httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(3000);

            if (StringUtils.isNotBlank(json)) {
                RequestEntity requestEntity = new ByteArrayRequestEntity(json.getBytes("UTF-8"));
                postMethod.setRequestEntity(requestEntity);
            }

            int statusCode = httpClient.executeMethod(postMethod);
            if (statusCode != HttpStatus.SC_OK) {

            } else {
                InputStream responseBody = postMethod.getResponseBodyAsStream();
                jsonStr = IOUtils.toString(responseBody, "UTF-8");
            }
        } finally {
            postMethod.releaseConnection();
        }
        return jsonStr;
    }

    public static String httpPostWithJSON(String url, String json,String token) throws Exception {
        HttpClient httpclient = new HttpClient();
        PostMethod method = new PostMethod(url);
        RequestEntity requestEntity = new StringRequestEntity(json);
        method.setRequestEntity(requestEntity);
        method.addRequestHeader("Content-Type", APPLICATION_JSON);
        method.addRequestHeader("X-Auth-Token", token);
        method.addRequestHeader("Connection", "keep-alive");
        int result = httpclient.executeMethod(method);
        String response = method.getResponseBodyAsString();
        method.releaseConnection();
        return response;
    }

}
