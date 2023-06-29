package cn.pinming.material.model.form;

import java.io.Serializable;

/**
 * @author changlezhong
 * @description
 */
public class WeighDataAssembleForm implements Serializable {

    private static final long serialVersionUID = 5578481601270642024L;

    /**
     * 第一条称重数据称重id
     */
    private String first;
    /**
     * 第二条称重数据称重id
     */
    private String second;
    /**
     * 归属方code
     */
    private String attributionCode;

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getAttributionCode() {
        return attributionCode;
    }

    public void setAttributionCode(String attributionCode) {
        this.attributionCode = attributionCode;
    }
}
