package cn.pinming.material.auth;

/**
 * @author changlezhong
 * @description
 */
public interface CredentialsProvider {

    void setCredentials(Credentials creds);

    Credentials getCredentials();

}
