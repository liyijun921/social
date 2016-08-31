package com.cnnp.social.collspace.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.collspace.manager.dto.CollspaceDto;
import com.cnnp.social.collspace.manager.dto.CollspaceRemarkDto;
import com.cnnp.social.collspace.manager.dto.CollspaceTopicDto;
import com.cnnp.social.collspace.manager.dto.CollspaceTopic_RDto;
import com.cnnp.social.collspace.manager.dto.CollspaceUserDto;
import com.cnnp.social.collspace.repository.dao.CollspaceDao;
import com.cnnp.social.collspace.repository.dao.CollspaceRamarkDao;
import com.cnnp.social.collspace.repository.dao.CollspaceTopicDao;
import com.cnnp.social.collspace.repository.dao.CollspaceUserDao;
import com.cnnp.social.collspace.repository.entity.TCollspace;
import com.cnnp.social.collspace.repository.entity.TCollspaceRemark;
import com.cnnp.social.collspace.repository.entity.TCollspaceTopic;
import com.cnnp.social.collspace.repository.entity.TCollspaceUser;
import com.cnnp.social.schedule.repository.entity.TSchedule;


@EnableTransactionManagement
@Component

public class CollspaceManager {
	@Autowired
	private CollspaceDao collspaceDao;
	@Autowired
	private CollspaceUserDao collspaceUserDao;
	@Autowired
	private CollspaceTopicDao topicDao;
	@Autowired
	private CollspaceRamarkDao ramarkDao;
	
	private DozerBeanMapper mapper = new DozerBeanMapper();
	
	@Transactional
	public CollspaceDto findoneColl(long collid){
		TCollspace collspaceEntry = collspaceDao.find(collid);
		if(collspaceEntry==null){
			return new CollspaceDto();
		}		
		CollspaceDto collspaceDto=new CollspaceDto();
		mapper.map(collspaceEntry, collspaceDto);
		List<TCollspaceUser> collspaceUserEntries=collspaceUserDao.findmember(collid);
		collspaceDto.setUser(collspaceUserEntries);		
		return collspaceDto;		
	}
	/**
	 * 我参加的空间
	 * @param userid
	 * @return
     */
	//我参加的空间
	public List<CollspaceDto> findByFilter(String userid){
		List<TCollspaceUser> collspaceUserEntries = collspaceUserDao.find(userid);
		if(collspaceUserEntries==null){
			return new ArrayList<CollspaceDto>();
		}
		List<CollspaceDto> collspaceDtos=new ArrayList<CollspaceDto>();
		
		for(TCollspaceUser user : collspaceUserEntries){
			CollspaceUserDto dto=new CollspaceUserDto();
			mapper.map(user, dto);
			TCollspace collspaceEntries = collspaceDao.findall(dto.getCollspaceid());
			CollspaceDto coll=new CollspaceDto();
			mapper.map(collspaceEntries, coll);
			collspaceDtos.add(coll);
		}		
		return collspaceDtos;		
	}
	/**
	 * 我管理的空间
	 * @param userid
	 * @return
     */
	//我管理的空间
	public List<CollspaceDto> findMyColl(String userid){
		List<TCollspaceUser> collspaceUserEntries = collspaceUserDao.find(userid,"1");
		if(collspaceUserEntries==null){
			return new ArrayList<CollspaceDto>();
		}
		List<CollspaceDto> collspaceDtos=new ArrayList<CollspaceDto>();
		
		for(TCollspaceUser user : collspaceUserEntries){
			CollspaceUserDto dto=new CollspaceUserDto();
			mapper.map(user, dto);
			TCollspace collspaceEntries = collspaceDao.find(dto.getCollspaceid());
			CollspaceDto coll=new CollspaceDto();
			mapper.map(collspaceEntries, coll);
			collspaceDtos.add(coll);
		}		
		return collspaceDtos;		
	}
	/**
	 * 公共空间
	 * @param userid
	 * @return
     */
	//公共空间
	public List<CollspaceDto> findOpenColl(String userid){
		List<TCollspace> collspaceEntries = collspaceDao.findOpen();
		if(collspaceEntries==null){
			return new ArrayList<CollspaceDto>();
		}
		List<CollspaceDto> collspaceDtos=new ArrayList<CollspaceDto>();
		
		for(TCollspace user : collspaceEntries){
			CollspaceDto dto=new CollspaceDto();
			mapper.map(user, dto);
			collspaceDtos.add(dto);
		}		
		return collspaceDtos;		
	}
	
	/**
	 * 空间成员
	 * @param collspaceid，type
	 * @return
     */
	//空间成员
	public List<CollspaceUserDto> findmember(long collspaceid, String type){
		List<TCollspaceUser> collspaceUserEntries = collspaceUserDao.findmember(collspaceid,type);
		if(collspaceUserEntries==null){
			return new ArrayList<CollspaceUserDto>();
		}
		List<CollspaceUserDto> collspaceUserDtos=new ArrayList<CollspaceUserDto>();
		
		for(TCollspaceUser user : collspaceUserEntries){
			CollspaceUserDto dto=new CollspaceUserDto();
			mapper.map(user, dto);			
			collspaceUserDtos.add(dto);
		}		
		return collspaceUserDtos;		
	}
	
	//修改空间成员
	public void findmemberup(long collspaceid,String userid, String type){
		TCollspaceUser collspaceUserEntry = collspaceUserDao.findmemberup(userid, collspaceid);					
		if(collspaceUserEntry==null){
			return;
		}
		CollspaceUserDto dto=new CollspaceUserDto();
		mapper.map(collspaceUserEntry, dto);
		collspaceUserEntry.setType(type);
		collspaceUserEntry = collspaceUserDao.save(collspaceUserEntry);
	}
	
	public void savecoll(CollspaceDto collspace,String type) {
		if (collspace == null) {
			return;
		}
		// 保存空间主表
		TCollspace collspaceEntry = new TCollspace();		
		mapper.map(collspace, collspaceEntry);
        long collspaceid = 0;	
        List<TCollspaceUser> collspaceUserEntries=new ArrayList<TCollspaceUser>();
		if (type.equals("add")) {	
			if (collspaceDao.findid()==0){
				collspaceid=1;			
			}else{
				collspaceid = collspaceDao.findmaxid()+1;			
			}
			collspaceEntry.setCollspaceid(collspaceid);
			for(TCollspaceUser UserEntry : collspaceEntry.getUser()){				
				UserEntry.setCollspaceid(collspaceid);				
				collspaceUserEntries.add(UserEntry);				
			}
		}else{
			if (collspace.getUser() != null) {
				List<TCollspaceUser> UserEntries = collspaceUserDao.findmember(collspace.getCollspaceid());
				collspaceUserDao.delete(UserEntries);				
			}					
		}		
		collspaceDao.save(collspaceEntry);		
		
	}
	
	public Boolean delOneCollspace(long collid){
		TCollspace collspaceEntry = collspaceDao.find(collid);
		if(collspaceEntry==null){
			return false;
		}
		List<TCollspaceTopic> topicEntries = topicDao.find(collid);
		List<TCollspaceRemark> remarkEntries = ramarkDao.findtopic(collid);		
		ramarkDao.delete(remarkEntries);
		topicDao.delete(topicEntries);
		collspaceDao.delete(collspaceEntry);	
		return true;
	}	
		
	public CollspaceTopicDto saveTopic(CollspaceTopicDto topic,String type) {
		if (topic == null) {
			return new CollspaceTopicDto();
		}
		CollspaceTopicDto topicdto=new CollspaceTopicDto();
		TCollspaceTopic topicEntry = new TCollspaceTopic();		
		mapper.map(topic, topicEntry);
        long topicid = 0;	
        Date now = new Date(); 
		if (type.equals("add")) {	
			if (topicDao.findid()==0){
				topicid=1;			
			}else{
				topicid = topicDao.findmaxid()+1;			
			}
			
			topicEntry.setTopicid(topicid);		
			topicEntry.setCreatetime(now);
			topicEntry.setUpdatetime(now);
		}else{
			topicEntry.setUpdatetime(now);
		}
		topicDao.save(topicEntry);		
		mapper.map(topicEntry, topicdto);
		return topicdto;
	}
	
	public List<CollspaceTopicDto> findalltopic(long collspaceid){
		List<TCollspaceTopic> topicEntries = topicDao.find(collspaceid);
		if(topicEntries==null){
			return new ArrayList<CollspaceTopicDto>();
		}
		List<CollspaceTopicDto> topicDtos=new ArrayList<CollspaceTopicDto>();
		for(TCollspaceTopic topic : topicEntries){
			CollspaceTopicDto dto=new CollspaceTopicDto();
			long count = ramarkDao.findcount(topic.getTopicid());
			dto.setCount(count);
			mapper.map(topic, dto);			
			topicDtos.add(dto);
		}		
	
		return topicDtos;		
	}
	public CollspaceRemarkDto saveRemark(CollspaceRemarkDto remark,String type) {
		if (remark == null) {
			return new CollspaceRemarkDto();
		}		
		Date now = new Date(); 
		CollspaceRemarkDto Remarkdto = new CollspaceRemarkDto();
		TCollspaceRemark remarkEntry = new TCollspaceRemark();		
		mapper.map(remark, remarkEntry);  
		if(type.equals("add")){
			remarkEntry.setCreatetime(now);			
		}		
		remarkEntry.setUpdatetime(now);
		remarkEntry = ramarkDao.save(remarkEntry);			
		mapper.map(remarkEntry, Remarkdto);  
		return Remarkdto;
	}
	
	public CollspaceTopic_RDto findonetopic(long topicid){
		TCollspaceTopic topicEntry = topicDao.findOne(topicid);
		if(topicEntry==null){
			return new CollspaceTopic_RDto();
		}
		CollspaceTopic_RDto topicDto=new CollspaceTopic_RDto();
		mapper.map(topicEntry, topicDto);	
		List<TCollspaceRemark> remarkEntries = ramarkDao.findtopic(topicid);
		List<CollspaceRemarkDto> Remarkdtos = new ArrayList<CollspaceRemarkDto>();
		for(TCollspaceRemark remark : remarkEntries){
			CollspaceRemarkDto Remarkdto = new CollspaceRemarkDto();
			mapper.map(remark, Remarkdto);	
			Remarkdtos.add(Remarkdto);			
		}	
		topicDto.setRemark(Remarkdtos);
		return topicDto;		
	}
	
	public void delRemark(long id) {
		TCollspaceRemark remarkEntry = ramarkDao.find(id);
		if (remarkEntry == null) {
			return;
		}				
		ramarkDao.delete(remarkEntry);	
	}
	
	public void delTopic(long topicid) {
		TCollspaceTopic topicEntry = topicDao.findOne(topicid);
		if (topicEntry == null) {
			return;
		}				
		List<TCollspaceRemark> remarkEntries = ramarkDao.findtopic(topicid);
		ramarkDao.delete(remarkEntries);	
		topicDao.delete(topicEntry);	
	}
	
	public Boolean applyOneCollspace(CollspaceUserDto user){
		if (user == null) {
			return false;
		}
		TCollspace collspaceEntry = collspaceDao.find(user.getCollspaceid());
		if(collspaceEntry==null){
			return false;
		}
		TCollspaceUser UserEntry = collspaceUserDao.findmemberup(user.getUserid(), user.getCollspaceid());
		if(UserEntry==null){
			TCollspaceUser UserTemp = new TCollspaceUser();
			mapper.map(user, UserTemp);
			//UserTemp.setType("0");
			collspaceUserDao.save(UserTemp);			
		}else{			
			return false;			
		}
		return true;
	}	
		
	public Boolean editUser(long id,String type){
		TCollspaceUser UserEntry = collspaceUserDao.findid(id);
		if (UserEntry == null) {
			return false;
		}
		UserEntry.setType(type);
		collspaceUserDao.save(UserEntry);
		return true;
	}
}