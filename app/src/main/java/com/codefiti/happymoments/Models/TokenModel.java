package com.codefiti.happymoments.Models;

/**
 * Created by baris on 7/12/2016.
 */
public class TokenModel {
    public String access_token ;

    public String token_type ;

    public String expire_in ;

    public String error ;

    public TokenModel() {
    }

    public TokenModel(/*String access_token, */String token_type/*, String expire_in, String error*/) {
        //this.access_token = access_token;
        this.token_type = token_type;
        //this.expire_in = expire_in;
        //this.error = error;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getExpire_in() {
        return expire_in;
    }

    public void setExpire_in(String expire_in) {
        this.expire_in = expire_in;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
