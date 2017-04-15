package com.codefiti.happymoments.Models;

/**
 * Created by baris on 7/12/2016.
 */
public class LoginModel {
    public String AccessToken;

    public LoginModel(String accessToken) {
        AccessToken = accessToken;
    }

    public String getAccessToken() {
        return AccessToken;
    }

    public void setAccessToken(String accessToken) {
        AccessToken = accessToken;
    }
}
