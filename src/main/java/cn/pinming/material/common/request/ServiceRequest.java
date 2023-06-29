package cn.pinming.material.common.request;

import cn.hutool.http.Method;
import cn.pinming.material.MaterialConfiguration;
import cn.pinming.material.auth.Credentials;
import cn.pinming.material.auth.CredentialsProvider;
import cn.pinming.material.common.enums.ApiService;
import cn.pinming.material.common.enums.SignatureMethod;
import cn.pinming.material.signature.Signature;
import cn.pinming.material.signature.SignatureFactory;
import java.util.Map;

/**
 * @author changlezhong
 * @description
 */
public abstract class ServiceRequest<T, R> {

    private String uri;
    private Method httpMethod;
    private Class<R> responseClass;
    private Map<String, String> headers;
    private Map<String, Object> params;
    private String body;

    public ServiceRequest(MaterialConfiguration materialConfiguration, ApiService apiService, T t) {
        this.initRequest(materialConfiguration, apiService, t);
    }

    protected void init(MaterialConfiguration materialConfiguration, ApiService apiService) {
        String endpoint = materialConfiguration.getEndpoint();
        CredentialsProvider credentialsProvider = materialConfiguration.getCredsProvider();
        this.setHttpMethod(apiService.httpMethod());
        this.setResponseClass(apiService.clazz());
        Credentials credentials = credentialsProvider.getCredentials();
        String appKey = credentials.getAppKey();
        String appSecretKey = credentials.getAppSecretKey();
        // 签名参数
        Signature signature = new Signature();
        signature.setEndpoint(endpoint);
        signature.setApiService(apiService.name());
        signature.setAppKey(appKey);
        signature.setSignatureMethod(SignatureMethod.HmacSHA256.name());
        String sdkSignature = SignatureFactory.signatureSdkProduce(signature, appSecretKey);
        signature.setSignature(sdkSignature);
        this.setHeaders(signature.signatureMap());
        this.setUri(endpoint + apiService.apiPath());
    }

    abstract void initRequest(MaterialConfiguration materialConfiguration, ApiService apiService, T t);

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Method getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(Method httpMethod) {
        this.httpMethod = httpMethod;
    }

    public Class<R> getResponseClass() {
        return responseClass;
    }

    public void setResponseClass(Class<R> responseClass) {
        this.responseClass = responseClass;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
