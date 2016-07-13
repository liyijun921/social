package com.cnnp.social.collspace.manager;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.collspace.manager.dto.CollspaceDto;
import com.cnnp.social.collspace.manager.dto.CollspaceTopicDto;
import com.cnnp.social.collspace.manager.dto.CollspaceUserDto;
import com.cnnp.social.collspace.repository.dao.CollspaceDao;
import com.cnnp.social.collspace.repository.dao.CollspaceRamarkDao;
import com.cnnp.social.collspace.repository.dao.CollspaceTopicDao;
import com.cnnp.social.collspace.repository.dao.CollspaceUserDao;
import com.cnnp.social.collspace.repository.entity.TCollspace;
import com.cnnp.social.collspace.repository.entity.TCollspaceTopic;
import com.cnnp.social.collspace.repository.entity.TCollspaceUser;


@EnableTransactionManagement
@Component

public class CollspaceManager {
	@Autowired
	private CollspaceDao collspaceDao;
	@Autowired
	private CollspaceUserDao collspaceUserDao;
	@Autowired
	private CollspaceTopicDao collspaceTopicDao;
	@Autowired
	private CollspaceRamarkDao collspaceRamarkDao;


	private DozerBeanMapper mapper = new DozerBeanMapper();
	
	@Transactional

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
	public List<CollspaceUserDto> findmember(String collspaceid, String type){
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
	public void findmemberup(String collspaceid,String userid, String type){
		TCollspaceUser collspaceUserEntry = collspaceUserDao.findmemberup(userid, collspaceid);					
		if(collspaceUserEntry==null){
			return;
		}
		CollspaceUserDto dto=new CollspaceUserDto();
		mapper.map(collspaceUserEntry, dto);
		collspaceUserEntry.setType(type);
		collspaceUserEntry = collspaceUserDao.save(collspaceUserEntry);
	}
	@Transactional
	public void savecoll(CollspaceDto collspace) {
		if (collspace == null) {
			return;
		}
		// 保存空间主表333
		TCollspace collspaceEntry = new TCollspace();
		mapper.map(collspace, collspaceEntry);
		collspaceEntry = collspaceDao.save(collspaceEntry);		

	}
	/**
	 * //查询发帖信息 wzy
	 * @param topicid
	 * @return
	 */
	public List<CollspaceTopicDto> findtopiclist(String topicid){
		List<CollspaceTopicDto> collspaceTopicDtos =new ArrayList<CollspaceTopicDto>();
		List<TCollspaceTopic> topiclist = collspaceTopicDao.findtopiclist(topicid);
		
		for (TCollspaceTopic topiclists : topiclist) {
			long backnum = collspaceRamarkDao.countbacknum(topiclists.getCollspaceid());
			
			CollspaceTopicDto collspaceTopicDto = new CollspaceTopicDto();
			collspaceTopicDto.setBacknum(backnum);
			mapper.map(topiclists, collspaceTopicDto);
			collspaceTopicDtos.add(collspaceTopicDto);
		}
		return collspaceTopicDtos;
	}
	
	@Transactional
	public CollspaceTopicDto savetopic(TCollspaceTopic tCollspaceTopic){
		CollspaceTopicDto collspaceTopicDto = new CollspaceTopicDto();
		tCollspaceTopic =collspaceTopicDao.save(tCollspaceTopic);
		mapper.map(tCollspaceTopic, collspaceTopicDto);
		return collspaceTopicDto;
	}
}