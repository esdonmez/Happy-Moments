package com.codefiti.happymoments.Models;

import java.util.UUID;

/**
 * Created by baris on 7/12/2016.
 */
public class PostPayModel {
    public UUID PostId ;

    public String TextMessage ;

    public int Price ;

    public UUID CardId ;

    public Boolean IsNewCard ;

    public String CardNumber ;

    public String CardName ;

    public String Month ;

    public String Year ;

    public String CvcCode ;

    public PostPayModel() {
    }

    public PostPayModel(UUID postId, String textMessage, int price, UUID cardId, Boolean isNewCard, String cardNumber, String cardName, String month, String year, String cvcCode) {
        PostId = postId;
        TextMessage = textMessage;
        Price = price;
        CardId = cardId;
        IsNewCard = isNewCard;
        CardNumber = cardNumber;
        CardName = cardName;
        Month = month;
        Year = year;
        CvcCode = cvcCode;
    }

    public UUID getPostId() {
        return PostId;
    }

    public void setPostId(UUID postId) {
        PostId = postId;
    }

    public String getTextMessage() {
        return TextMessage;
    }

    public void setTextMessage(String textMessage) {
        TextMessage = textMessage;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public UUID getCardId() {
        return CardId;
    }

    public void setCardId(UUID cardId) {
        CardId = cardId;
    }

    public Boolean getNewCard() {
        return IsNewCard;
    }

    public void setNewCard(Boolean newCard) {
        IsNewCard = newCard;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(String cardNumber) {
        CardNumber = cardNumber;
    }

    public String getCardName() {
        return CardName;
    }

    public void setCardName(String cardName) {
        CardName = cardName;
    }

    public String getMonth() {
        return Month;
    }

    public void setMonth(String month) {
        Month = month;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getCvcCode() {
        return CvcCode;
    }

    public void setCvcCode(String cvcCode) {
        CvcCode = cvcCode;
    }
}
