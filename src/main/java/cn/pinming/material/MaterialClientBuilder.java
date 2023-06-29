package cn.pinming.material;

import cn.pinming.material.auth.DefaultCredentialProvider;
import cn.pinming.material.exception.MaterialException;
import cn.pinming.material.exception.MaterialExceptionMessage;

/**
 * @author changlezhong
 * @description
 */
public class MaterialClientBuilder implements MaterialBuilder {

    @Override
    public Material build(String host, String appKey, String appSecretKey) {
        checkHost(host);
        return new MaterialClient(host, getDefaultCredentialProvider(appKey, appSecretKey));
    }

    private static DefaultCredentialProvider getDefaultCredentialProvider(String appKey, String appSecretKey) {
        return new DefaultCredentialProvider(appKey, appSecretKey);
    }

    private static void checkHost(String host) {
        if (host == null || host.equals("")) {
            throw new MaterialException(MaterialExceptionMessage.EMPTY_HOST);
        }
    }

}
