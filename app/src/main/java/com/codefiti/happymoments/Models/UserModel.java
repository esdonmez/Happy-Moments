package com.codefiti.happymoments.Models;

/**
 * Created by baris on 7/12/2016.
 */
public class UserModel {
    public String UserId ;

    public String UserName ;

    public String FirstName ;

    public String MiddleName ;

    public String LastName ;

    public String FullName ;

    public Boolean Verified;

    public String Photo ;

    public int TotalMoney ;

    public int TotalPaid ;

    public int TotalGetPaid ;

    public int TotalPost ;

    public String Token ;
    public Boolean LiveNotification ;
    public Boolean WeeklyNotification ;
    public Boolean RandomNotification ;

    public UserModel() {
    }

    public UserModel(String userId, String userName, String firstName, String middleName, String lastName, String fullName, Boolean verified, String photo, int totalMoney, int totalPaid, int totalGetPaid, int totalPost, String token, Boolean liveNotification, Boolean weeklyNotification, Boolean randomNotification) {
        UserId = userId;
        UserName = userName;
        FirstName = firstName;
        MiddleName = middleName;
        LastName = lastName;
        FullName = fullName;
        Verified = verified;
        Photo = photo;
        TotalMoney = totalMoney;
        TotalPaid = totalPaid;
        TotalGetPaid = totalGetPaid;
        TotalPost = totalPost;
        Token = token;
        LiveNotification = liveNotification;
        WeeklyNotification = weeklyNotification;
        RandomNotification = randomNotification;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public Boolean getVerified() {
        return Verified;
    }

    public void setVerified(Boolean verified) {
        Verified = verified;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public int getTotalMoney() {
        return TotalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        TotalMoney = totalMoney;
    }

    public int getTotalPaid() {
        return TotalPaid;
    }

    public void setTotalPaid(int totalPaid) {
        TotalPaid = totalPaid;
    }

    public int getTotalGetPaid() {
        return TotalGetPaid;
    }

    public void setTotalGetPaid(int totalGetPaid) {
        TotalGetPaid = totalGetPaid;
    }

    public int getTotalPost() {
        return TotalPost;
    }

    public void setTotalPost(int totalPost) {
        TotalPost = totalPost;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public Boolean getLiveNotification() {
        return LiveNotification;
    }

    public void setLiveNotification(Boolean liveNotification) {
        LiveNotification = liveNotification;
    }

    public Boolean getWeeklyNotification() {
        return WeeklyNotification;
    }

    public void setWeeklyNotification(Boolean weeklyNotification) {
        WeeklyNotification = weeklyNotification;
    }

    public Boolean getRandomNotification() {
        return RandomNotification;
    }

    public void setRandomNotification(Boolean randomNotification) {
        RandomNotification = randomNotification;
    }
}
