package com.codefiti.happymoments.Models;

import java.util.UUID;

/**
 * Created by baris on 7/12/2016.
 */
public class CompanyModel {
    public UUID CompanyId ;

    public String Name ;

    public String Image ;

    public CompanyModel() {
    }

    public CompanyModel(UUID companyId, String name, String image) {
        CompanyId = companyId;
        Name = name;
        Image = image;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public UUID getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(UUID companyId) {
        CompanyId = companyId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
