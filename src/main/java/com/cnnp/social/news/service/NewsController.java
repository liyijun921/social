/*
 *
 * Copyright 2016 IBM or CNNP.
 * 
 */
package com.cnnp.social.news.service;

import com.cnnp.social.news.manager.NewsManager;
import com.cnnp.social.news.manager.dto.NewsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Damon on 16/5/31.
 */
@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsManager newsManager;

    @RequestMapping(value = "/{cardid}", method = RequestMethod.GET)
    public
    @ResponseBody
    List<NewsDto> findMany(@PathVariable("cardid") String cardid, @RequestParam("size") int topcount) {
        return newsManager.findTopNews("", cardid, topcount);
    }
}
