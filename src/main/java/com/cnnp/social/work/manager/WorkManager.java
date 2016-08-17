package com.cnnp.social.work.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.work.manager.dto.AdminlinkDto;
import com.cnnp.social.work.manager.dto.UserlinkDto;
import com.cnnp.social.work.repository.dao.AdminlinkDao;
import com.cnnp.social.work.repository.dao.UserlinkDao;
import com.cnnp.social.work.repository.entity.TAdminLink;
import com.cnnp.social.work.repository.entity.TUserLink;



@EnableTransactionManagement
@Component

public class WorkManager {
	@Autowired
	private AdminlinkDao adminlinkDao;
	@Autowired
	private UserlinkDao userlinkDao;
	
	private DozerBeanMapper mapper = new DozerBeanMapper();
	@Transactional
	public List<UserlinkDto> findUserOrder(String userid){
		List<TUserLink> userlinkEntries =  userlinkDao.find(userid);
		if(userlinkEntries==null){
			return new ArrayList<UserlinkDto>();
		}
		List<UserlinkDto> userlinkDtos=new ArrayList<UserlinkDto>();
		
		for(TUserLink user : userlinkEntries){
			UserlinkDto dto=new UserlinkDto();
			mapper.map(user, dto);
			TAdminLink adminlinkEntry = adminlinkDao.findOne(dto.getLinkid());
			dto.setLink(adminlinkEntry.getLink());
			dto.setIcoa(adminlinkEntry.getIcoa());
			dto.setDescription(adminlinkEntry.getDescription());
			
			userlinkDtos.add(dto);
		}		
		return userlinkDtos;		
	}
	
	public Boolean save(List<UserlinkDto> userlink,String type,String userid) {
		Boolean flg = false;
		if (userlink == null) {
			return flg;
		}
		
		long id; 
		if (userlinkDao.findid()==0){
			id=1;			
		}else{
			id = userlinkDao.findmaxid()+1;			
		}
				
		List<TUserLink> userlinkEntries = new ArrayList<TUserLink>();
		for(UserlinkDto user : userlink){
			TUserLink userEntry = new TUserLink();
			mapper.map(user, userEntry);
			userEntry.setid(id);
			userEntry.setUserid(userid);;
			userlinkEntries.add(userEntry);
			 id = id+1;
		}
		if (type.equals("edit")) {
			//List<TUserLink> deluserlinkEntries =  userlinkDao.find(userid);
			//for(TUserLink user : deluserlinkEntries){
			//	userlinkDao.delete(user.getid());
			//}
			userlinkDao.delete(userlinkDao.find(userid));
		}
		userlinkDao.save(userlinkEntries);
		flg = true;
		return flg;
	}
	public List<AdminlinkDto> findalllink(){
		List<TAdminLink> adminlinkEntries = adminlinkDao.find();
		if(adminlinkEntries==null){
			return new ArrayList<AdminlinkDto>();
		}
        List<AdminlinkDto> adminlinkDtos=new ArrayList<AdminlinkDto>();
		
		for(TAdminLink admin : adminlinkEntries){
			AdminlinkDto dto=new AdminlinkDto();
			mapper.map(admin, dto);
			adminlinkDtos.add(dto);
		}
		return adminlinkDtos;		
	}
}