package com.codefiti.happymoments.Models;

import java.util.UUID;

/**
 * Created by baris on 7/12/2016.
 */
public class PostModel {
    public UUID PostId ;

    public String ProfileImage ;

    public String Day ;

    public String Month ;

    public Boolean IsPaid ;

    public String Image ;

    public int Type ;

    public String Name ;

    public String Header ;

    public String Description ;

    public PostModel() {
    }

    public PostModel(UUID postId, String profileImage, String day, String month, Boolean isPaid, String image, int type, String name, String header, String description) {
        PostId = postId;
        ProfileImage = profileImage;
        Day = day;
        Month = month;
        IsPaid = isPaid;
        Image = image;
        Type = type;
        Name = name;
        Header = header;
        Description = description;
    }

    public UUID getPostId() {
        return PostId;
    }

    public void setPostId(UUID postId) {
        PostId = postId;
    }

    public String getProfileImage() {
        return ProfileImage;
    }

    public void setProfileImage(String profileImage) {
        ProfileImage = profileImage;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }

    public String getMonth() {
        return Month;
    }

    public void setMonth(String month) {
        Month = month;
    }

    public Boolean getPaid() {
        return IsPaid;
    }

    public void setPaid(Boolean paid) {
        IsPaid = paid;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getHeader() {
        return Header;
    }

    public void setHeader(String header) {
        Header = header;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
