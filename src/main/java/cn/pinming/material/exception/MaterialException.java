package cn.pinming.material.exception;

/**
 * @author changlezhong
 * @description
 */
public class MaterialException extends RuntimeException {

    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 错误信息
     */
    private String errorMessage;

    public MaterialException(MaterialExceptionMessage bizExceptionMessageEnum) {
        this.errorCode = bizExceptionMessageEnum.errorCode();
        this.errorMessage = bizExceptionMessageEnum.errorMessage();
    }

    public MaterialException(MaterialExceptionMessage bizExceptionMessageEnum, String format) {
        this.errorCode = bizExceptionMessageEnum.errorCode();
        this.errorMessage = String.format(bizExceptionMessageEnum.errorMessage(), format);
    }

    public MaterialException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.errorMessage = message;
    }

    public String errorCode() {
        return errorCode;
    }

    public String errorMessage() {
        return errorMessage;
    }
}
