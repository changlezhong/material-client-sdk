package cn.pinming.material.signature;

/**
 * @author changlezhong
 * @date 2023/6/14
 */
public class SignatureConstant {

    /**
     * Api服务
     */
    public static String API_SERVICE_HEARER_NAME = "X-material-apiService";
    /**
     * appKey
     */
    public static String APP_KEY_PARAM_HEADER_NAME = "X-material-appKey";
    /**
     * 请求时间戳, 1分钟内的请求属于有效请求
     */
    public static String TIMESTAMP_HEADER_NAME = "X-material-timestamp";
    /**
     * 请求唯一标识(32位无连接符uuid, 小写字母、数字组合)
     */
    public static String REQUEST_ID_HEADER_NAME = "X-material-requestId";
    /**
     * 签名算法
     */
    public static String SIGNATURE_METHOD_HEADER_NAME = "X-material-signatureMethod";
    /**
     * 签名值
     */
    public static String SIGNATURE_HEADER_NAME = "X-material-signature";
    
}
