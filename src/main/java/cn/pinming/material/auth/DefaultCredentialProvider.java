package cn.pinming.material.auth;

import cn.pinming.material.exception.MaterialException;
import cn.pinming.material.exception.MaterialExceptionMessage;

/**
 * @author changlezhong
 * @description
 */
public class DefaultCredentialProvider implements CredentialsProvider {

    private volatile Credentials creds;

    public DefaultCredentialProvider(String appKey, String appSecretKey) {
        checkCredentials(appKey, appSecretKey);
        setCredentials(new DefaultCredentials(appKey, appSecretKey));
    }

    @Override
    public synchronized void setCredentials(Credentials creds) {
        if (creds == null) {
            throw new MaterialException(MaterialExceptionMessage.EMPTY_CREDS);
        }

        checkCredentials(creds.getAppKey(), creds.getAppSecretKey());
        this.creds = creds;
    }

    @Override
    public Credentials getCredentials() {
        if (this.creds == null) {
            throw new MaterialException(MaterialExceptionMessage.INVALID_CREDENTIALS);
        }

        return this.creds;
    }

    private static void checkCredentials(String appKey, String appSecretKey) {
        if (appKey == null || appKey.equals("")) {
            throw new MaterialException(MaterialExceptionMessage.EMPTY_APP_KEY);
        }

        if (appSecretKey == null || appSecretKey.equals("")) {
            throw new MaterialException(MaterialExceptionMessage.EMPTY_APP_SECRET_KEY);
        }
    }
}
