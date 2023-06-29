package cn.pinming.material;

import cn.pinming.material.auth.CredentialsProvider;

/**
 * @author changlezhong
 * @description
 */
public class MaterialConfiguration {

    private String endpoint;
    private CredentialsProvider credsProvider;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public CredentialsProvider getCredsProvider() {
        return credsProvider;
    }

    public void setCredsProvider(CredentialsProvider credsProvider) {
        this.credsProvider = credsProvider;
    }

}
