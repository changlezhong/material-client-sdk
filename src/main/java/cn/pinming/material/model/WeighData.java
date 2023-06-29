package cn.pinming.material.model;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author changlezhong
 * @description
 */
public class WeighData implements Serializable {
    private static final long serialVersionUID = 345883061972892409L;

    /**
     * 车牌号
     */
    private String truckNo;

    /**
     * 材料名称
     */
    private String material;

    /**
     * 重量
     */
    private BigDecimal weight;

    /**
     * 称重单位
     */
    private String unit;

    /**
     * 称重时间
     */
    private String weighTime;

    /**
     * 是否重组过 true 是 false 否
     */
    private boolean combine;

    /**
     * 称重照片
     */
    private List<String> pic;

    public String getTruckNo() {
        return truckNo;
    }

    public void setTruckNo(String truckNo) {
        this.truckNo = truckNo;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getWeighTime() {
        return weighTime;
    }

    public void setWeighTime(String weighTime) {
        this.weighTime = weighTime;
    }

    public List<String> getPic() {
        return pic;
    }

    public void setPic(List<String> pic) {
        this.pic = pic;
    }

    public boolean isCombine() {

        return combine;
    }

    public void setCombine(boolean combine) {
        this.combine = combine;
    }
}
