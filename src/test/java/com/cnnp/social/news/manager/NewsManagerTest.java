package com.cnnp.social.news.manager;

import com.cnnp.social.news.manager.dto.NewsDto;
import com.cnnp.social.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
* NewsManager Tester. 
* 
* @author <Authors name> 
* @since <pre>五月 31, 2016</pre> 
* @version 1.0 
*/ 
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@EnableConfigurationProperties({NewsSetting.class})
public class NewsManagerTest {
    @Autowired
    private NewsManager newsManager;

@Before 
public void setUp() throws Exception { 
     
} 

/** 
* 
* Method: findTopNews(String site, String cardcode, int topcount) 
* 
*/ 
@Test
public void testFindTopNews() throws Exception {
    List<NewsDto> list=newsManager.findTopNews("03","5",10);
    for(NewsDto dto : list){
        System.out.print(dto.getImagePath());
        System.out.println(dto.getLinkAddr());
        System.out.println(dto.getPublishDate());
        System.out.println(dto.isLatest());
        System.out.println(dto.getTitle());
    }
    assertNotNull(list);
    assertEquals(10,list.size());
}


} 
