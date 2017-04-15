package com.codefiti.happymoments.Models;

import java.util.Date;

/**
 * Created by baris on 7/12/2016.
 */
public class NotificationModel {
    public int NotificationId ;

    public String ProfileImage ;

    public String FirstName ;

    public String FullName ;

    public Boolean IsThanks ;

    public Boolean IsRead ;

    public Boolean IsVoice ;

    public Boolean IsText ;

    public String TextMessage ;

    public String VoiceMessage ;

    public Date CreatedDate ;

    public String Background ;

    public String MesOpacity ;

    public String MicOpacity ;

    public NotificationModel() {
    }

    public NotificationModel(int notificationId, String profileImage, String firstName, String fullName/*, Boolean isThanks, Boolean isRead, Boolean isVoice, Boolean isText, String textMessage, String voiceMessage, Date createdDate, String background, String mesOpacity, String micOpacity*/) {
        NotificationId = notificationId;
        ProfileImage = profileImage;
        FirstName = firstName;
        FullName = fullName;
        /*IsThanks = isThanks;
        IsRead = isRead;
        IsVoice = isVoice;
        IsText = isText;
        TextMessage = textMessage;
        VoiceMessage = voiceMessage;
        CreatedDate = createdDate;
        Background = background;
        MesOpacity = mesOpacity;
        MicOpacity = micOpacity;*/
    }

    public int getNotificationId() {
        return NotificationId;
    }

    public void setNotificationId(int notificationId) {
        NotificationId = notificationId;
    }

    public String getProfileImage() {
        return ProfileImage;
    }

    public void setProfileImage(String profileImage) {
        ProfileImage = profileImage;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public Boolean getThanks() {
        return IsThanks;
    }

    public void setThanks(Boolean thanks) {
        IsThanks = thanks;
    }

    public Boolean getRead() {
        return IsRead;
    }

    public void setRead(Boolean read) {
        IsRead = read;
    }

    public Boolean getVoice() {
        return IsVoice;
    }

    public void setVoice(Boolean voice) {
        IsVoice = voice;
    }

    public Boolean getText() {
        return IsText;
    }

    public void setText(Boolean text) {
        IsText = text;
    }

    public String getTextMessage() {
        return TextMessage;
    }

    public void setTextMessage(String textMessage) {
        TextMessage = textMessage;
    }

    public String getVoiceMessage() {
        return VoiceMessage;
    }

    public void setVoiceMessage(String voiceMessage) {
        VoiceMessage = voiceMessage;
    }

    public Date getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(Date createdDate) {
        CreatedDate = createdDate;
    }

    public String getBackground() {
        return Background;
    }

    public void setBackground(String background) {
        Background = background;
    }

    public String getMesOpacity() {
        return MesOpacity;
    }

    public void setMesOpacity(String mesOpacity) {
        MesOpacity = mesOpacity;
    }

    public String getMicOpacity() {
        return MicOpacity;
    }

    public void setMicOpacity(String micOpacity) {
        MicOpacity = micOpacity;
    }
}
