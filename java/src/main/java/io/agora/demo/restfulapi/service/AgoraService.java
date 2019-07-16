package io.agora.demo.restfulapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.agora.demo.restfulapi.license.LicenseActivationRequest;
import io.agora.demo.restfulapi.license.LicenseActivationResponse;
import io.agora.demo.restfulapi.license.LicenseRetrieveResponse;
import io.agora.demo.restfulapi.license.LicenseUrl;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class AgoraService {
    private HttpClient httpClient;
    private ObjectMapper objectMapper;

    public AgoraService(String userName, String pwd) {
        this.httpClient = buildHttpClient(userName, pwd);
        this.objectMapper = new ObjectMapper();
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private HttpClient buildHttpClient(String userName, String pwd) {
        Credentials credentials = new UsernamePasswordCredentials(userName, pwd);
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(AuthScope.ANY, credentials);
        return HttpClientBuilder.create().setDefaultCredentialsProvider(credsProvider).build();
    }

    public LicenseRetrieveResponse retrieveLicense(String appId, int pageNum) {
        HttpGet httpGet = new HttpGet(LicenseUrl.retrieveUrl(appId, pageNum));
        String result = call(httpGet);

        try {
            return objectMapper.readValue(result, LicenseRetrieveResponse.class);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public LicenseActivationResponse activateLicense(String appId, String custom, String credential) {
        HttpPost httpPost = new HttpPost(LicenseUrl.activateUrl(appId));
        LicenseActivationRequest request = new LicenseActivationRequest(custom, credential);
        return callWithBody(httpPost, request, LicenseActivationResponse.class);
    }


    private String call(HttpUriRequest request) {
        HttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(request);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        int statusCode = httpResponse.getStatusLine().getStatusCode();
        String result = null;
        try {
            result = EntityUtils.toString(httpResponse.getEntity());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        if(statusCode != HttpStatus.SC_OK) {
            throw new RuntimeException(String.format("%d - %s", statusCode, result));
        }

        return result;
    }

    private <R, B> R callWithBody(HttpEntityEnclosingRequestBase http, B body, Class<R> clazz) {
        String json = null;
        try {
            json = objectMapper.writeValueAsString(body);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);

        http.setEntity(entity);

        String result = call(http);

        try {
            return objectMapper.readValue(result, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

}
