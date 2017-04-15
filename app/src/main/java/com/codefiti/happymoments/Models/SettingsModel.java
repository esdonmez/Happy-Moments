package com.codefiti.happymoments.Models;

/**
 * Created by baris on 7/12/2016.
 */
public class SettingsModel {
    public Boolean LiveNotification ;

    public Boolean WeeklyNotification ;

    public Boolean RandomNotification ;

    public Boolean IsFreeze;

    public SettingsModel() {
    }

    public SettingsModel(Boolean liveNotification, Boolean weeklyNotification, Boolean randomNotification, Boolean isFreeze) {
        LiveNotification = liveNotification;
        WeeklyNotification = weeklyNotification;
        RandomNotification = randomNotification;
        IsFreeze = isFreeze;
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

    public Boolean getFreeze() {
        return IsFreeze;
    }

    public void setFreeze(Boolean freeze) {
        IsFreeze = freeze;
    }
}
