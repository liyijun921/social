package com.cnnp.social.collspace.manager;

import com.cnnp.social.collspace.manager.dto.CollspaceDto;
import com.cnnp.social.collspace.manager.dto.CollspaceUserDto;
import com.cnnp.social.collspace.repository.dao.CollspaceDao;
import com.cnnp.social.collspace.repository.dao.CollspaceUserDao;
import com.cnnp.social.collspace.repository.entity.TCollspace;
import com.cnnp.social.collspace.repository.entity.TCollspaceUser;


import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

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
	
	public CollspaceUserDto find(String userid){
		TCollspaceUser collspaceUserEntry = collspaceUserDao.find(userid);
		if(collspaceUserEntry==null){
			return new CollspaceUserDto();
		}
		CollspaceUserDto collspaceuserDto=new CollspaceUserDto();
		mapper.map(collspaceUserEntry, collspaceuserDto);
		
		return collspaceuserDto;
		
	}
	
}
