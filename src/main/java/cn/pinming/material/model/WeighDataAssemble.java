package cn.pinming.material.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author changlezhong
 * @description
 */
public class WeighDataAssemble implements Serializable {

    private static final long serialVersionUID = -8361277899342300221L;

    /**
     * 称重数据对象
     */
    private List<WeighData> weighData;

    public List<WeighData> getWeighData() {
        return weighData;
    }

    public void setWeighData(List<WeighData> weighData) {
        this.weighData = weighData;
    }
}
