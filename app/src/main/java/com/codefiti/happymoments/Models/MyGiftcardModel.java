package com.codefiti.happymoments.Models;

/**
 * Created by baris on 7/12/2016.
 */
public class MyGiftcardModel {
    public String Status ;

    public String ExpireDate ;

    public Integer Money ;

    public String Code ;

    public String QRCode ;

    public String CompanyName ;

    public String Logo ;

    public String CoverImage ;

    public MyGiftcardModel() {
    }

    public MyGiftcardModel(String status, String expireDate, Integer money, String code, String QRCode, String companyName, String logo, String coverImage) {
        Status = status;
        ExpireDate = expireDate;
        Money = money;
        Code = code;
        this.QRCode = QRCode;
        CompanyName = companyName;
        Logo = logo;
        CoverImage = coverImage;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getExpireDate() {
        return ExpireDate;
    }

    public void setExpireDate(String expireDate) {
        ExpireDate = expireDate;
    }

    public Integer getMoney() {
        return Money;
    }

    public void setMoney(Integer money) {
        Money = money;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getQRCode() {
        return QRCode;
    }

    public void setQRCode(String QRCode) {
        this.QRCode = QRCode;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getLogo() {
        return Logo;
    }

    public void setLogo(String logo) {
        Logo = logo;
    }

    public String getCoverImage() {
        return CoverImage;
    }

    public void setCoverImage(String coverImage) {
        CoverImage = coverImage;
    }
}
