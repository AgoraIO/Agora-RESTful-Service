package io.agora.demo.restfulapi;

import io.agora.demo.restfulapi.license.LicenseActivationResponse;
import io.agora.demo.restfulapi.license.LicenseInfo;
import io.agora.demo.restfulapi.license.LicenseRetrieveResponse;
import io.agora.demo.restfulapi.service.AgoraService;

import java.util.ArrayList;
import java.util.List;

public class LicenseDemo {

    //Customer ID
    private static final String USER_NAME = "";

    //Customer Certificate
    private static final String PWD = "";

    private static final String APP_ID = "";


    public static void main(String[] args) {
        AgoraService agoraService = new AgoraService(USER_NAME, PWD);

        List<LicenseInfo> licenseInfoList = new ArrayList<>();

        //retrieve license
        int pageNum = 1;
        LicenseRetrieveResponse retrieveResponse = agoraService.retrieveLicense(APP_ID, pageNum);
        licenseInfoList.addAll(retrieveResponse.getElements());
        while(retrieveResponse.getHasMore()) {
            retrieveResponse = agoraService.retrieveLicense(APP_ID, ++pageNum);
            licenseInfoList.addAll(retrieveResponse.getElements());
        }

        //activate license
        String credential = "aa"; //replace with real credential
        String custom = "bb"; //replace with real custom
        LicenseActivationResponse activationResponse = agoraService.activateLicense(APP_ID, custom, credential);
        System.out.println(activationResponse.getCert());
    }
}
