package cn.pinming.material.http;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.http.Method;
import cn.pinming.material.common.request.ServiceRequest;
import cn.pinming.material.common.response.SingleResponse;
import cn.pinming.material.exception.MaterialException;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @author changlezhong
 * @date 2023/6/16
 */
public class HttpClient {

    private static final int HTTP_TIMEOUT = 60000;

    public static <T> T doGet(ServiceRequest request) throws MaterialException {
        HttpRequest getRequest = HttpUtil.createRequest(Method.GET, request.getUri());
        headersInit(request, getRequest);
        String resp = getRequest.form(request.getParams()).timeout(HTTP_TIMEOUT).execute().body();
        return (T) getResponseData(resp, request.getResponseClass());
    }

    public static <T> T doPost(ServiceRequest request) throws MaterialException {
        HttpRequest postRequest = HttpUtil.createRequest(Method.POST, request.getUri());
        headersInit(request, postRequest);
        String resp = postRequest.body(request.getBody()).timeout(HTTP_TIMEOUT).execute().body();
        return (T) getResponseData(resp, request.getResponseClass());
    }

    public static <T> T doDelete(ServiceRequest request) throws MaterialException {
        HttpRequest deleteRequest = HttpUtil.createRequest(Method.DELETE, request.getUri());
        headersInit(request, deleteRequest);
        String resp = deleteRequest.form(request.getParams()).timeout(HTTP_TIMEOUT).execute().body();
        return (T) getResponseData(resp, request.getResponseClass());
    }

    public static <T> T doPut(ServiceRequest request) throws MaterialException {
        HttpRequest putRequest = HttpUtil.createRequest(Method.PUT, request.getUri());
        headersInit(request, putRequest);
        String resp = putRequest.body(request.getBody()).timeout(HTTP_TIMEOUT).execute().body();
        return (T) getResponseData(resp, request.getResponseClass());
    }

    private static <T> T getResponseData(String resp, Class<T> clazz) throws MaterialException {
        SingleResponse singleResponse = JSONObject.parseObject(resp, SingleResponse.class);
        boolean success = singleResponse.isSuccess();
        if (success) {
            Object responseData = singleResponse.getData();
            if (responseData instanceof JSONObject) {
                JSONObject jsonObject = (JSONObject) singleResponse.getData();
                T data = jsonObject.toJavaObject(clazz);
                return data;
            } else {
                return (T) responseData;
            }
        }
        throw new MaterialException(singleResponse.getErrCode(), singleResponse.getErrMessage());
    }

    private static void headersInit(ServiceRequest serviceRequest, HttpRequest httpRequest) {
        Map<String, String> headers = serviceRequest.getHeaders();
        headers.forEach((k, v) -> httpRequest.header(k, v));
    }

}
