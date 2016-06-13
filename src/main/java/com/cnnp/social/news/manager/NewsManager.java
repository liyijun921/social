/*
 *
 * Copyright 2016 IBM or CNNP.
 * 
 */
package com.cnnp.social.news.manager;

import com.cnnp.social.news.manager.dto.NewsDto;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.awt.font.TextMeasurer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Damon on 16/5/31.
 */

@Component
public class NewsManager {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NewsSetting newsSetting;
    public List<NewsDto> findTopNews(String site, String cardcode, int topcount) {
    	Object[] obs=null;
        String sql = "select rownum,id, main_attach_id, articleId, title, brief, orgName, "+ 
               "is_remote, sendSite,attUrl,imageUrl, dateCreated from (SELECT art.id, art.main_attach_id, art.article_id AS articleId, art.title, art.brief, art.org_name AS orgName, " +
                "art.is_remote, art.send_site AS sendSite,att.url as attUrl, case when att.FILE_FROM='主附件' then att.PATH ELSE art.image_Url END AS imageUrl,  art.publish_date AS dateCreated " +
                " FROM pb2_ARTICLE art LEFT JOIN pb2_attachments att ON art.main_attach_id = att.id WHERE art.status = 2 " +
                " AND (art.cat_id = ? OR art.cat_id in (SELECT cat.id FROM pb2_articlecat cat WHERE cat.parent_id = ?))" +
                "AND art.valid_date >= TO_CHAR(sysdate,'YYYY-MM-DD')" +
                "ORDER BY art.is_top DESC, art.publish_date DESC, art.audit_date DESC) where rownum<="+topcount;
        		obs=new Object[]{cardcode,cardcode};
        if(cardcode.equals("9999")){
        	sql="select rownum,id, main_attach_id, articleId, title, brief, orgName, "+ 
               "is_remote, sendSite,attUrl,imageUrl, dateCreated  from (SELECT art.id, art.main_attach_id, art.article_id AS articleId, art.title, art.brief, art.org_name AS orgName, " +
                    "art.is_remote, art.send_site AS sendSite,att.url as attUrl, case when att.FILE_FROM='主附件' then att.PATH ELSE art.image_Url END AS imageUrl,  art.publish_date AS dateCreated " +
                    " FROM pb2_ARTICLE art LEFT JOIN pb2_attachments att ON art.main_attach_id = att.id WHERE art.status = 2 " +
                    "AND art.IS_TOP=1 " +
                    "AND art.valid_date >= TO_CHAR(sysdate,'YYYY-MM-DD')" +
                    "ORDER BY art.is_top DESC, art.publish_date DESC, art.audit_date DESC) where rownum<="+topcount;
        	obs=new Object[]{};
        }
        final Calendar today=Calendar.getInstance();
        
        final SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        return jdbcTemplate.query(sql, obs, new RowMapper<NewsDto>() {
            @Override
            public NewsDto mapRow(ResultSet resultSet, int i) throws SQLException {
                NewsDto newsDto = new NewsDto();
                newsDto.setId(resultSet.getInt("id"));
                newsDto.setTitle(resultSet.getString("title"));
                newsDto.setSite(resultSet.getString("sendSite"));
                newsDto.setImagePath(resultSet.getString("imageUrl"));
                newsDto.setPublishDate(resultSet.getDate("dateCreated"));
                if(newsDto.getPublishDate()!=null){
                	Calendar publishDay=Calendar.getInstance();
                	 publishDay.setTime(newsDto.getPublishDate());
                	 if(minus(today, publishDay)<7){
                		 newsDto.setLatest(true);
                	 }
                }
               
                //if(Calendar.getInstance().newsDto.getPublishDate())
                newsDto.setSubTitle(resultSet.getString("brief"));
                newsDto.setLinkAddr(newsSetting.getLinkaddr().replace("{0}",resultSet.getString("id")));
                return newsDto;
            }
        });

    }
    private int minus(Calendar c1,Calendar c2){
    	long l=c1.getTimeInMillis()-c2.getTimeInMillis();
    	int days=new Long(l/(1000*60*60*24)).intValue();
    	return days;
    }
}
