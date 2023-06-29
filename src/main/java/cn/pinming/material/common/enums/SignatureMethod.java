package cn.pinming.material.common.enums;

/**
 * @author changlezhong
 * @date 2023/6/15
 */
public enum SignatureMethod {
    HmacSHA256,HmacSHA512
    ;

    public static boolean check(String signatureMethod) {
        if (signatureMethod == null || signatureMethod.equals("")) {
            return false;
        }
        for (SignatureMethod value : SignatureMethod.values()) {
            if (value.name().equals(signatureMethod)) {
                return true;
            }
        }
        return false;
    }

}
