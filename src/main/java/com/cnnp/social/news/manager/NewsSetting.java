/*
 *
 * Copyright 2016 IBM or CNNP.
 * 
 */
package com.cnnp.social.news.manager;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Damon on 16/6/6.
 */

@ConfigurationProperties(prefix = "news")
public class NewsSetting {
    private String linkaddr;

    public String getLinkaddr() {
        return linkaddr;
    }

    public void setLinkaddr(String linkaddr) {
        this.linkaddr = linkaddr;
    }
}
