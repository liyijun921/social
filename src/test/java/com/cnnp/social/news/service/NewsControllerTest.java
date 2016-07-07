package com.cnnp.social.news.service; 
import com.cnnp.social.news.manager.dto.NewsDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**==========================
* NewsController Tester. 
* 
* @author <Authors name> 
* @since <pre>五月 31, 2016</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class NewsControllerTest {
    private MockMvc mockMvc;
    private RestTemplate restTemplate = new TestRestTemplate();
@Before 
public void setUp() throws Exception {
    mockMvc= MockMvcBuilders.standaloneSetup(new NewsController()).build();
} 

/** 
* 
* Method: findMany(@PathVariable("cardid") String cardid, @RequestParam("size") int topcount) 
* 
*/ 
@Test
public void testFindMany() throws Exception {
  //  List<NewsDto> list= restTemplate.getForObject("http://localhost:8080/social/news/7?size=10", List.class);

   // RequestBuilder request = get("http://localhost:8080/news/7?size=10");
//    mockMvc.perform(request)
//            .andExpect(status().isOk())
//            .andExpect(content().string(equalTo("[]")));
} 


} 
