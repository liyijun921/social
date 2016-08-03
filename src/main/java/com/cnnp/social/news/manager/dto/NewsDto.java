/*
 *
 * Copyright 2016 IBM or CNNP.
 * 
 */
package com.cnnp.social.news.manager.dto;

import com.cnnp.social.card.manager.dto.CardDto;

import java.util.Date;

/**
 * Created by Damon on 16/5/31.
 */
public class NewsDto {
    private String title;
    private String subTitle;
    private String author;
    private String site;
    private Date publishDate;
    private String priority;
    private String imagePath;
    private String linkAddr;
    private boolean isLatest=false;
    private CardDto belongCard;
    private String newsfield;
    private String orgName;
    private int id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public CardDto getBelongCard() {
        return belongCard;
    }

    public void setBelongCard(CardDto belongCard) {
        this.belongCard = belongCard;
    }

    public String getLinkAddr() {
        return linkAddr;
    }

    public void setLinkAddr(String linkAddr) {
        this.linkAddr = linkAddr;
    }

	public boolean isLatest() {
		return isLatest;
	}

	public void setLatest(boolean isLatest) {
		this.isLatest = isLatest;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getNewsfield() {
        return newsfield;
    }

    public void setNewsfield(String newsfield) {
        this.newsfield = newsfield;
    }
	public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

}
