package com.codefiti.happymoments.Models;

/**
 * Created by baris on 7/12/2016.
 */
public class DeleteCardModel {
    public String CardId;

    public DeleteCardModel() {
    }

    public DeleteCardModel(String cardId) {
        CardId = cardId;
    }

    public String getCardId() {
        return CardId;
    }

    public void setCardId(String cardId) {
        CardId = cardId;
    }
}
