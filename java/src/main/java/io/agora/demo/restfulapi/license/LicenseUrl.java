package io.agora.demo.restfulapi.license;

public class LicenseUrl {
    private static final String RETRIEVE_URL = "https://api.agora.io/dev/v3/apps/%s/licenses?pageNumber=%d";
    private static final String ACTIVATE_URL = "https://api.agora.io/dev/v3/apps/%s/licenses/activation";

    public static String retrieveUrl(String appId, int pageNum) {
        return String.format(RETRIEVE_URL, appId, pageNum);
    }

    public static String activateUrl(String appId) {
        return String.format(ACTIVATE_URL, appId);
    }

}
