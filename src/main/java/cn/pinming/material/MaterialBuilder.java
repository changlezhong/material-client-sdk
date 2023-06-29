package cn.pinming.material;

/**
 * @author changlezhong
 * @description
 */
public interface MaterialBuilder {

    Material build(String host, String appKey, String appSecretKey);

}
