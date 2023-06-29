package cn.pinming.material.signature;

import cn.pinming.material.common.enums.ApiService;
import cn.pinming.material.exception.MaterialException;
import cn.pinming.material.exception.MaterialExceptionMessage;
import cn.pinming.material.util.LogUtil;
import cn.pinming.material.util.UuidUtil;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author changlezhong
 * @date 2023/6/14
 *
 * 签名参数顺序
 * httpMethod + endpoint + requestPath + "?" + apiService=xxx + &appKey=xxx + &timestamp=xxx + &requestId=xxx + &signatureMethod=xxx
 * 例：
 * GEThttp://localhost:8008/api/user?apiService=USER&secretId=dsfsrwef&timestamp=1686898416209&requestId=10cd83f9adc74ae5801658d6ccb31e61&signatureMethod=HmacSHA256
 * 加密：
 * HmacSHA256(签名) 得到 signature 值
 */
public class SignatureFactory {

    public static String signatureHttpProduce(Signature signature, String secretKey) {
        String signatureMethod = signature.getSignatureMethod();
        ApiService apiService = ApiService.valueOf(signature.getApiService());
        String signatureStr = apiService.httpMethod().name() + signature.getEndpoint() +
                apiService.apiPath() + "?apiService=" + signature.getApiService() +
                "&appKey=" + signature.getAppKey() + "&timestamp=" +
                signature.getTimestamp() + "&requestId=" + signature.getRequestId() +
                "&signatureMethod=" + signatureMethod;
        return hmacSHAEncrypt(signatureStr, secretKey, signatureMethod);
    }

    public static String signatureSdkProduce(Signature signature, String secretKey) {
        signature.setTimestamp(String.valueOf(System.currentTimeMillis()));
        signature.setRequestId(UuidUtil.uuidWithoutConnector());
        return signatureHttpProduce(signature, secretKey);
    }

    private static String hmacSHAEncrypt(String signatureStr, String secretKey, String signatureMethod) {
        String hash;
        try {
            Mac sha_HMAC = Mac.getInstance(signatureMethod);
            SecretKeySpec secret_key = new SecretKeySpec(secretKey.getBytes(), signatureMethod);
            sha_HMAC.init(secret_key);
            byte[] bytes = sha_HMAC.doFinal(signatureStr.getBytes());
            hash = byteArrayToHexString(bytes);
        } catch (Exception e) {
            LogUtil.getLog().error(signatureMethod + " encrypt error." + e.getMessage());
            throw new MaterialException(MaterialExceptionMessage.SIGNATURE_ENCRYPT_ERROR);
        }
        return hash;
    }

    private static String byteArrayToHexString(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String temp;
        for (int n = 0; b != null && n < b.length; n++) {
            temp = Integer.toHexString(b[n] & 0XFF);
            if (temp.length() == 1) {
                hs.append('0');
            }
            hs.append(temp);
        }
        return hs.toString().toLowerCase();
    }

//    public static void main(String[] args) {
//        String l = String.valueOf(System.currentTimeMillis());
//        System.out.println(l);
//        String s = UuidUtil.uuidWithoutConnector();
//        System.out.println(s);
//        Signature signature = new Signature();
//        signature.setEndpoint("http://localhost:8080");
//        signature.setApiService("ASSEMBLE");
//        signature.setAppKey("7DE4BD442893CF8F");
//        signature.setTimestamp(l);
//        signature.setRequestId(s);
//        signature.setSignatureMethod("HmacSHA256");
//        System.out.println(signatureHttpProduce(signature, "27CD9862376F5F18F9F6595894864828"));
//    }

}
