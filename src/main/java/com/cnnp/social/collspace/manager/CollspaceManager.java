package com.cnnp.social.collspace.manager;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.collspace.manager.dto.CollspaceUserDto;
import com.cnnp.social.collspace.repository.dao.CollspaceDao;
import com.cnnp.social.collspace.repository.dao.CollspaceUserDao;
import com.cnnp.social.collspace.repository.entity.TCollspaceUser;

@EnableTransactionManagement
@Component

public class CollspaceManager {
	@Autowired
	private CollspaceDao collspaceDao;
	@Autowired
	private CollspaceUserDao collspaceUserDao;


	private DozerBeanMapper mapper = new DozerBeanMapper();
	
	@Transactional

	/**
	 *
	 * @param id
	 * @return
     */
	
	public List<CollspaceUserDto> findByFilter(String userid){
		List<TCollspaceUser> collspaceUserEntries = collspaceUserDao.find(userid);
		if(collspaceUserEntries==null){
			return new ArrayList<CollspaceUserDto>();
		}
		List<CollspaceUserDto> collspaceuserDtos=new ArrayList<CollspaceUserDto>();
		for(TCollspaceUser user : collspaceUserEntries){
			CollspaceUserDto dto=new CollspaceUserDto();
			mapper.map(user, dto);
			collspaceuserDtos.add(dto);
		}
		
		return collspaceuserDtos;
		
	}
	
}
