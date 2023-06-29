package cn.pinming.material.exception;

/**
 * @author changlezhong
 * @description
 */
public enum MaterialExceptionMessage {

    SYSTEM_ERROR("500", "系统异常"),
    INVALID_REQUEST_ID("INVALID_REQUEST_ID", "无效的requestId, 1分钟内已请求使用过"),
    INVALID_TIMESTAMP("INVALID_TIMESTAMP", "无效的timestamp, 超出1分钟"),
    INVALID_APP_KEY("INVALID_APP_KEY", "无效的APP_KEY"),
    INVALID_APP_KEY_STATUS("INVALID_APP_KEY_STATUS", "APP_KEY状态异常(%s)"),
    INVALID_SIGNATURE("INVALID_SIGNATURE", "无效的签名"),
    SIGNATURE_ENCRYPT_ERROR("SIGNATURE_ENCRYPT_ERROR", "签名加密异常"),
    DATA_ENCRYPT_ERROR("DATA_ENCRYPT_ERROR", "数据加密异常"),
    DATA_DECRYPT_ERROR("DATA_DECRYPT_ERROR", "数据解密异常"),
    INVALID_SIGNATURE_PARAM_VALUE("INVALID_PARAM_VALUE", "无效的签名header值(%s)"),
    EMPTY_HOST("EMPTY_HOST", "host不能为空"),
    EMPTY_APP_KEY("EMPTY_APP_KEY", "appKey不能为空"),
    EMPTY_APP_SECRET_KEY("EMPTY_APP_SECRET_KEY", "appSecretKey不能为空"),
    EMPTY_CREDS("EMPTY_CREDS", "creds不能为空"),
    INVALID_CREDENTIALS("INVALID_CREDENTIALS", "非法的credentials"),
    ENCODE_PARAM_VALUE_MAP_ERROR("ENCODE_PARAM_VALUE_MAP_ERROR", "参数编码异常"),
    ;

    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 错误信息
     */
    private String errorMessage;

    MaterialExceptionMessage(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String errorCode() {
        return errorCode;
    }

    public String errorMessage() {
        return errorMessage;
    }
}
