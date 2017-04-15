package com.codefiti.happymoments.Models;

/**
 * Created by baris on 7/12/2016.
 */
public class ResultContext<T> {
    public Boolean IsSuccess ;

    public String Message ;

    public T Data ;

    public ResultContext() {
    }

    public ResultContext(Boolean isSuccess, String message, T data) {
        IsSuccess = isSuccess;
        Message = message;
        Data = data;
    }

    public Boolean getSuccess() {
        return IsSuccess;
    }

    public void setSuccess(Boolean success) {
        IsSuccess = success;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }
}
