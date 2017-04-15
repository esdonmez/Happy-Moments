package com.codefiti.happymoments.Models;

/**
 * Created by baris on 7/12/2016.
 */
public class CardModel {
    public String CardId;

    public String CardName ;

    public String CardNumber ;

    public String Month ;

    public String Year ;

    public String CardImage ;

    public CardModel(String cardId) {
        CardId = cardId;
    }

    public CardModel(String cardId, String cardName, String cardNumber, String month, String year, String cardImage) {
        CardId = cardId;
        CardName = cardName;
        CardNumber = cardNumber;
        Month = month;
        Year = year;
        CardImage = cardImage;
    }

    public String getCardId() {
        return CardId;
    }

    public void setCardId(String cardId) {
        CardId = cardId;
    }

    public String getCardName() {
        return CardName;
    }

    public void setCardName(String cardName) {
        CardName = cardName;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(String cardNumber) {
        CardNumber = cardNumber;
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

    public String getCardImage() {
        return CardImage;
    }

    public void setCardImage(String cardImage) {
        CardImage = cardImage;
    }
}
