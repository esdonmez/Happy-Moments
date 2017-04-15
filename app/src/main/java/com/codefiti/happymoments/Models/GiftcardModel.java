package com.codefiti.happymoments.Models;

import java.util.List;
import java.util.UUID;

/**
 * Created by baris on 7/12/2016.
 */
public class GiftcardModel {
    public UUID CompanyId;

    public List<Integer> Coupons;

    public GiftcardModel(UUID companyId, List<Integer> coupons) {
        CompanyId = companyId;
        Coupons = coupons;
    }

    public GiftcardModel() {
    }

    public UUID getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(UUID companyId) {
        CompanyId = companyId;
    }

    public List<Integer> getCoupons() {
        return Coupons;
    }

    public void setCoupons(List<Integer> coupons) {
        Coupons = coupons;
    }
}
