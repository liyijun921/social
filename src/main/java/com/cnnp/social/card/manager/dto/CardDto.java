/*
 *
 * Copyright 2016 IBM or CNNP.
 * 
 */
package com.cnnp.social.card.manager.dto;

/**
 * Created by Damon on 16/5/31.
 */
public class CardDto {
    private String cardid;
    private String cardno;
    private String cardname;
    private String cardtype;
    private int cardWidth;
    private String hasMore;
    private String hasMoreAddr;
    private String styleClass;

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getCardname() {
        return cardname;
    }

    public void setCardname(String cardname) {
        this.cardname = cardname;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    public int getCardWidth() {
        return cardWidth;
    }

    public void setCardWidth(int cardWidth) {
        this.cardWidth = cardWidth;
    }

    public String getHasMore() {
        return hasMore;
    }

    public void setHasMore(String hasMore) {
        this.hasMore = hasMore;
    }

    public String getHasMoreAddr() {
        return hasMoreAddr;
    }

    public void setHasMoreAddr(String hasMoreAddr) {
        this.hasMoreAddr = hasMoreAddr;
    }

    public String getStyleClass() {
        return styleClass;
    }

    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }
}
