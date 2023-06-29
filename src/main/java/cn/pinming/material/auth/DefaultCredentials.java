package cn.pinming.material.auth;

import cn.pinming.material.exception.MaterialException;
import cn.pinming.material.exception.MaterialExceptionMessage;

/**
 * @author changlezhong
 * @description
 */
public class DefaultCredentials implements Credentials {

    private final String appKey;
    private final String appSecretKey;

    @Override
    public String getAppKey() {
        return appKey;
    }

    @Override
    public String getAppSecretKey() {
        return appSecretKey;
    }

    public DefaultCredentials(String appKey, String appSecretKey) {
        if (appKey == null || appKey.equals("")) {
            throw new MaterialException(MaterialExceptionMessage.EMPTY_APP_KEY);
        }
        if (appSecretKey == null || appSecretKey.equals("")) {
            throw new MaterialException(MaterialExceptionMessage.EMPTY_APP_SECRET_KEY);
        }
        this.appKey = appKey;
        this.appSecretKey = appSecretKey;
    }


}
