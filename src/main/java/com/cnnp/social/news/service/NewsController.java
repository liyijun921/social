/*
 *
 * Copyright 2016 IBM or CNNP.
 * 
 */
package com.cnnp.social.news.service;

import com.cnnp.social.news.manager.NewsManager;
import com.cnnp.social.news.manager.dto.AttachmentsAddDto;
import com.cnnp.social.news.manager.dto.NewsAddDto;
import com.cnnp.social.news.manager.dto.NewsDto;
import com.cnnp.social.news.manager.dto.News_AttDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Damon on 16/5/31.
 */
@RestController
@RequestMapping("/api/v1.0/news")
public class NewsController {
    @Autowired
    private NewsManager newsManager;

    @RequestMapping(value = "/{cardid}", method = RequestMethod.GET)
    public
    @ResponseBody
    List<NewsDto> findMany(@PathVariable("cardid") String cardid, @RequestParam("size") int topcount) {
        return newsManager.findTopNews("", cardid, topcount);
    }
    
    @RequestMapping(value = "/one", method = RequestMethod.GET)
    public
    @ResponseBody
    News_AttDto view(@RequestParam String newid) {
        return newsManager.findOneNew(newid);
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public
    @ResponseBody
    List<NewsDto> viewtest(@RequestParam String title) {
        return newsManager.findARTICLEall(title);
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void save(@RequestBody NewsAddDto news) {
    	newsManager.saveNews(news); 		
	}
}
