package com.codefiti.happymoments.Models;

/**
 * Created by baris on 7/12/2016.
 */
public class ReadNotificationModel {
    public int NotificationId ;

    public ReadNotificationModel() {
    }

    public ReadNotificationModel(int notificationId) {
        NotificationId = notificationId;
    }

    public int getNotificationId() {
        return NotificationId;
    }

    public void setNotificationId(int notificationId) {
        NotificationId = notificationId;
    }
}
