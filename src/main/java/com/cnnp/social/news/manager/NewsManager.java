/*
 *
 * Copyright 2016 IBM or CNNP.
 * 
 */
package com.cnnp.social.news.manager;

import com.cnnp.social.news.manager.dto.AttachmentsDto;
import com.cnnp.social.news.manager.dto.NewsDto;
import com.cnnp.social.news.manager.dto.News_AttDto;
import com.cnnp.social.schedule.manager.dto.ScheduleDto;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.awt.font.TextMeasurer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
               "is_remote, sendSite,attUrl,imageUrl, dateCreated,newsfield from (SELECT art.id, art.main_attach_id, art.article_id AS articleId, art.title, art.brief, art.org_name AS orgName, " +
                "art.is_remote, art.send_site AS sendSite,att.url as attUrl, case when att.FILE_FROM='主附件' then att.PATH ELSE art.image_Url END AS imageUrl,  art.publish_date AS dateCreated  ,news_field as newsfield " +
                " FROM pb2_ARTICLE art LEFT JOIN pb2_attachments att ON art.main_attach_id = att.id WHERE art.status = 2 " +
                " AND (art.cat_id = ? OR art.cat_id in (SELECT cat.id FROM pb2_articlecat cat WHERE cat.parent_id = ?))" +
                "AND art.valid_date >= TO_CHAR(sysdate,'YYYY-MM-DD')" +
                "ORDER BY art.publish_date DESC, art.audit_date DESC) where rownum<="+topcount;
        		obs=new Object[]{cardcode,cardcode};
        if(cardcode.equals("9999")){
        	sql="select rownum,id, main_attach_id, articleId, title, brief, orgName, "+ 
               "is_remote, sendSite,attUrl,imageUrl, dateCreated,newsfield  from (SELECT art.id, art.main_attach_id, art.article_id AS articleId, art.title, art.brief, art.org_name AS orgName, " +
                    "art.is_remote, art.send_site AS sendSite,att.url as attUrl, case when att.FILE_FROM='主附件' then att.PATH ELSE art.image_Url END AS imageUrl,  art.publish_date AS dateCreated  ,news_field as newsfield " +
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
                newsDto.setNewsfield(resultSet.getString("newsfield"));
                newsDto.setOrgName(resultSet.getString("orgName"));
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
    
    
    
    public List<NewsDto> findARTICLEall(String title) {
    	Object[] obs=null;
    	
    	String sql = "select rownum,id, main_attach_id, articleId, title, brief, orgName, "+ 
                "is_remote, sendSite,attUrl,imageUrl, dateCreated,newsfield from (SELECT art.id, art.main_attach_id, art.article_id AS articleId, art.title, art.brief, art.org_name AS orgName, " +
                 "art.is_remote, art.send_site AS sendSite,att.url as attUrl, case when att.FILE_FROM='主附件' then att.PATH ELSE art.image_Url END AS imageUrl,  art.publish_date AS dateCreated  ,news_field as newsfield " +
                 " FROM pb2_ARTICLE art LEFT JOIN pb2_attachments att ON art.main_attach_id = att.id WHERE art.status = 2) " +
                " where title like '%" + title +"%'";
        		obs=new Object[]{};
        		 final Calendar today=Calendar.getInstance();
        		 return jdbcTemplate.query(sql, obs, new RowMapper<NewsDto>() {
        	            @Override
        	            public NewsDto mapRow(ResultSet resultSet, int i) throws SQLException {
        	                NewsDto newsDto = new NewsDto();
        	                newsDto.setId(resultSet.getInt("id"));
        	                newsDto.setTitle(resultSet.getString("title"));
        	                newsDto.setSite(resultSet.getString("sendSite"));
        	                newsDto.setImagePath(resultSet.getString("imageUrl"));
        	                newsDto.setPublishDate(resultSet.getDate("dateCreated"));
        	                newsDto.setNewsfield(resultSet.getString("newsfield"));
        	                newsDto.setOrgName(resultSet.getString("orgName"));
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

    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public List<News_AttDto> findARTICLE(String id) {
    	Object[] obs=null;
    	
        String sql = "select art.title,art.SUB_TITLE,art.author,art.priority,art.show_way,art.attach_content_id,art.article_id,art.audit_date,art.auditor_id,art.auditor_name,art.author_name,art.author_id, "+ 
               "art.content,art.date_created,art.image_url,art.last_updated,art.main_attach_id,art.message_id,art.news_field,art.news_topic,art.access_count,art.publish_date,art.status,art.valid_date," +
                "art.valid_day,art.reminder_id,art.id from PB2_ARTICLE art where art.ID = ?";
        		obs=new Object[]{id};
      
        return jdbcTemplate.query(sql, obs, new RowMapper<News_AttDto>() {
            @Override
            public News_AttDto mapRow(ResultSet resultSet, int i) throws SQLException {
            	News_AttDto News_AttDto = new News_AttDto();
            	News_AttDto.setId(resultSet.getInt("id"));
            	News_AttDto.setTitle(resultSet.getString("title"));  
            	News_AttDto.setaccess_count(resultSet.getInt("access_count"));
            	News_AttDto.setarticle_id(resultSet.getString("article_id"));
            	News_AttDto.setattach_content_id(resultSet.getString("attach_content_id"));
            	News_AttDto.setaudit_date(resultSet.getString("audit_date"));
            	News_AttDto.setauditor_id(resultSet.getString("auditor_id"));
            	News_AttDto.setauditor_name(resultSet.getString("auditor_name"));
            	News_AttDto.setAuthor(resultSet.getString("author"));
            	News_AttDto.setauthor_id(resultSet.getString("author_id"));
            	News_AttDto.setauthor_name(resultSet.getString("author_name"));
            	News_AttDto.setcontent(resultSet.getString("content"));
            	News_AttDto.setdate_created(resultSet.getString("date_created"));
            	News_AttDto.setimage_url(resultSet.getString("image_url"));
            	News_AttDto.setlast_updated(resultSet.getString("last_updated"));
            	News_AttDto.setmain_attach_id(resultSet.getString("main_attach_id"));
            	News_AttDto.setmessage_id(resultSet.getString("message_id"));
            	News_AttDto.setnews_field(resultSet.getString("news_field"));
            	News_AttDto.setshow_way(resultSet.getString("show_way"));
            	News_AttDto.setstatus(resultSet.getString("status"));
            	News_AttDto.setvalid_date(resultSet.getString("valid_date"));
            	News_AttDto.setvalid_day(resultSet.getString("valid_day"));
                return News_AttDto;
            }
        });
      
    }

    public List<AttachmentsDto> findAttachments(String id,String attid) {
    	Object[] obs=null;

        String sql = "select att.id as att_id,att.date_created as att_date_created,att.file_from as att_file_from,att.file_type as att_file_type,att.name as att_name,att.path as att_path,att.size_ as att_size,att.type as att_type,att.uploader as att_uploader,att.url as att_url from PB2_ATTACHMENTS att where id in (select ATTACH_ID from PB2_ARTICLE_ATTACHS where ARTICLE_ID=?) ";
        		obs=new Object[]{id};
        		
        if(id.equals("")){		
            sql = "select att.id as att_id,att.date_created as att_date_created,att.file_from as att_file_from,att.file_type as att_file_type,att.name as att_name,att.path as att_path,att.size_ as att_size,att.type as att_type,att.uploader as att_uploader,att.url as att_url from PB2_ATTACHMENTS att where id =? ";
    		obs=new Object[]{attid};
        }
        		 return jdbcTemplate.query(sql, obs, new RowMapper<AttachmentsDto>() {
        	     @Override
        	     public AttachmentsDto mapRow(ResultSet resultSet, int i) throws SQLException {
        	            
        	            AttachmentsDto attDtos = new AttachmentsDto();
        	                  	            	
        	            attDtos.setId(resultSet.getInt("att_id"));
        	            attDtos.setDate_created(resultSet.getDate("att_date_created"));
        	            attDtos.setFile_from(resultSet.getString("att_file_from"));
        	            attDtos.setFile_type(resultSet.getString("att_file_type"));
        	            attDtos.setName(resultSet.getString("att_name"));
        	            attDtos.setPath(resultSet.getString("att_path"));
        	            attDtos.setType(resultSet.getString("att_type"));
        	            attDtos.setUploader(resultSet.getString("att_uploader"));
        	            attDtos.setUrl(resultSet.getString("att_url"));
        	            attDtos.setSize(resultSet.getString("att_size"));  
        	            	
        	            return attDtos;
        	      }
        	});
    }
    
    public int updataaccess_count(String id,int count) {
    	Object[] obs=null;
    	count =count+1;
        String sql = "update PB2_ARTICLE set access_count=? where id=?";
             
        		obs=new Object[]{count,id};
        		return jdbcTemplate.update(sql, obs);            
    }
    
    public News_AttDto findOneNew(String id) {
    	
    	News_AttDto news_attdto = new News_AttDto();
    	List<News_AttDto> artDtos = new ArrayList<News_AttDto>();
    	artDtos = findARTICLE(id);
    	if (artDtos.isEmpty()) {
    		return new News_AttDto();
    	}
    	news_attdto = artDtos.get(0);
    	
    	List<AttachmentsDto> attdtos = new ArrayList<AttachmentsDto>();
    	attdtos = findAttachments(id,"");    	
    	if (news_attdto.getmain_attach_id()!=null) {
        	List<AttachmentsDto> attachmentsDtos = findAttachments("",news_attdto.getmain_attach_id());
        	if (!attachmentsDtos.isEmpty()) {
        		attdtos.add(attachmentsDtos.get(0));
        	}       	
    	}
    	
    	if (news_attdto.getattach_content_id()!=null) {
        	List<AttachmentsDto> attachmentsDtos = findAttachments("",news_attdto.getattach_content_id());
        	if (!attachmentsDtos.isEmpty()) {
        		attdtos.add(attachmentsDtos.get(0));
        	}       	
    	}
    	int i=updataaccess_count(id,news_attdto.getaccess_count());
    	if (!attdtos.isEmpty()) {    			
    		news_attdto.setAttachments(attdtos);
		}
    	return news_attdto;
    }


}
