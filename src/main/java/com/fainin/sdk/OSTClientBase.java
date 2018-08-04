package com.fainin.sdk;

import com.fainin.sdk.auth.AuthenticationProvider;
import com.fainin.sdk.client.OSTHttpClient;
import com.fainin.sdk.config.OSTConfiguration;
import com.fainin.sdk.response.OSTApiResponse;

import java.util.TreeMap;

/**
 * Created by hishamaborob on 23-Mar-18.
 */
abstract public class OSTClientBase {

    private OSTHttpClient ostHttpClient;

    private OSTConfiguration ostConfiguration;

    private AuthenticationProvider authenticationProvider;

    public OSTClientBase(OSTHttpClient ostHttpClient, AuthenticationProvider authenticationProvider,
                         OSTConfiguration ostConfiguration) {

        this.ostHttpClient = ostHttpClient;
        this.ostConfiguration = ostConfiguration;
        this.authenticationProvider = authenticationProvider;
    }

    protected <T extends OSTApiResponse> T signAndExecutePostRequest(
            final String endpoint, final TreeMap<String, String> queryParameters, final Class<T> tClass) {

        authenticationProvider.signRequest(endpoint, queryParameters);
        return ostHttpClient.doPost(endpoint, queryParameters, tClass);
    }

    protected <T extends OSTApiResponse> T signAndExecuteGetRequest(
            final String endpoint, final TreeMap<String, String> queryParameters, final Class<T> tClass) {

        authenticationProvider.signRequest(endpoint, queryParameters);
        return ostHttpClient.doGet(endpoint, queryParameters, tClass);
    }

    protected OSTHttpClient getOstHttpClient() {
        return ostHttpClient;
    }

    protected OSTConfiguration getOstConfiguration() {
        return ostConfiguration;
    }

    protected AuthenticationProvider getAuthenticationProvider() {
        return authenticationProvider;
    }
}
