package io.agora.demo.restfulapi.license;

public class LicenseActivationRequest {
    private String custom;
    private String credential;

    public LicenseActivationRequest() {

    }

    public LicenseActivationRequest(String custom, String credential) {
        this.custom = custom;
        this.credential = credential;
    }

    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }
}
