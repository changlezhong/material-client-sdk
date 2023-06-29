package cn.pinming.material.signature;

import cn.pinming.material.common.enums.SignatureMethod;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


/**
 * @author changlezhong
 * @date 2023/6/15
 */
public class Signature implements Serializable {

    /**
     * 请求Region
     */
    private String endpoint;
    /**
     * apiService
     */
    private String apiService;
    /**
     * appKey
     */
    private String appKey;
    /**
     * 请求时间戳, 1分钟内的请求属于有效请求
     */
    private String timestamp;
    /**
     * 请求唯一标识(32位无连接符uuid, 小写字母、数字组合)
     */
    private String requestId;
    /**
     * 签名算法(默认HmacSHA256)
     */
    private String signatureMethod = SignatureMethod.HmacSHA256.name();
    /**
     * 签名值
     */
    private String signature;

    public Map<String, String> signatureMap() {
        Map<String, String> map = new HashMap<>();
        map.put(SignatureConstant.API_SERVICE_HEARER_NAME, this.apiService);
        map.put(SignatureConstant.APP_KEY_PARAM_HEADER_NAME, this.appKey);
        map.put(SignatureConstant.TIMESTAMP_HEADER_NAME, this.timestamp);
        map.put(SignatureConstant.REQUEST_ID_HEADER_NAME, this.requestId);
        map.put(SignatureConstant.SIGNATURE_METHOD_HEADER_NAME, this.signatureMethod);
        map.put(SignatureConstant.SIGNATURE_HEADER_NAME, this.signature);
        return map;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getApiService() {
        return apiService;
    }

    public void setApiService(String apiService) {
        this.apiService = apiService;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getSignatureMethod() {
        return signatureMethod;
    }

    public void setSignatureMethod(String signatureMethod) {
        this.signatureMethod = signatureMethod;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
