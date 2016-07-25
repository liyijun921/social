package com.cnnp.social.homepage.manager;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.collspace.manager.dto.CollspaceDto;
import com.cnnp.social.collspace.manager.dto.CollspaceUserDto;
import com.cnnp.social.collspace.repository.entity.TCollspace;
import com.cnnp.social.collspace.repository.entity.TCollspaceUser;
import com.cnnp.social.homepage.manager.dto.HomePageAdminDto;
import com.cnnp.social.homepage.manager.dto.HomePageColumnDto;
import com.cnnp.social.homepage.manager.dto.HomePageFormDto;
import com.cnnp.social.homepage.manager.dto.HomePageInfoDto;
import com.cnnp.social.homepage.manager.dto.HomePageStyleDto;
import com.cnnp.social.homepage.repository.dao.HomePageAdminDao;
import com.cnnp.social.homepage.repository.dao.HomePageColumnDao;
import com.cnnp.social.homepage.repository.dao.HomePageFormDao;
import com.cnnp.social.homepage.repository.dao.HomePageFormInDao;
import com.cnnp.social.homepage.repository.dao.HomePageInfoDao;
import com.cnnp.social.homepage.repository.dao.HomePageStyleDao;
import com.cnnp.social.homepage.repository.entity.THomePageAdmin;
import com.cnnp.social.homepage.repository.entity.THomePageColumn;
import com.cnnp.social.homepage.repository.entity.THomePageForm;
import com.cnnp.social.homepage.repository.entity.THomePageFormIn;
import com.cnnp.social.homepage.repository.entity.THomePageInfo;
import com.cnnp.social.homepage.repository.entity.THomePageStyle;
import com.cnnp.social.plan.manager.dto.PlanInfoDto;
import com.cnnp.social.plan.manager.dto.PlanmodifyInfoDto;
import com.cnnp.social.plan.manager.dto.PlantaskInfoDto;
import com.cnnp.social.plan.repository.dao.PlanInfoDao;
import com.cnnp.social.plan.repository.dao.PlanmodifyInfoDao;
import com.cnnp.social.plan.repository.dao.PlantaskInfoDao;
import com.cnnp.social.plan.repository.entity.TPlanInfo;
import com.cnnp.social.plan.repository.entity.TPlanmodifyInfo;
import com.cnnp.social.plan.repository.entity.TPlantaskInfo;
import com.cnnp.social.schedule.manager.dto.ScheduleDto;
import com.cnnp.social.schedule.manager.dto.SchedulePeopleDto;
import com.cnnp.social.schedule.repository.entity.TSchedule;
import com.cnnp.social.schedule.repository.entity.TSchedulePeople;


@EnableTransactionManagement
@Component

public class HomePageManager {
	@Autowired
	private HomePageInfoDao homepageInfoDao;
	@Autowired
	private HomePageAdminDao homepageAdminDao;
	@Autowired
	private HomePageColumnDao homepageColumnDao;
	@Autowired
	private HomePageFormDao homepageFormDao;
	@Autowired
	private HomePageFormInDao homepageForminDao;
	@Autowired
	private HomePageStyleDao homepageStyleDao;
	
	private DozerBeanMapper mapper = new DozerBeanMapper();
	
	@Transactional
	public void saveHomePage(HomePageInfoDto homepage) {
		if (homepage == null) {
			return;
		}
		long hpid = homepageInfoDao.findmaxid()+1;
		long id = homepageAdminDao.findmaxid();
		homepage.setid(hpid);
		
		THomePageInfo hpEntry = new THomePageInfo();
		mapper.map(homepage, hpEntry);
		List<THomePageAdmin> homepageadminEntries = new ArrayList<THomePageAdmin>();
		int i=1;
		for(THomePageAdmin admin : hpEntry.getAdmin()){					
		    id = id+i;
			admin.setid(id);
			admin.setHpid(hpid);
			homepageadminEntries.add(admin);
			i++;	
		}
		hpEntry.setAdmin(homepageadminEntries);
		homepageInfoDao.save(hpEntry);
		//homepageAdminDao.save(homepageadminEntries);
		return;
	}
	public void editHomePage(HomePageInfoDto homepage) {
		if (homepage == null) {
			return;
		}
		long id = homepageAdminDao.findmaxid()+1;
		THomePageInfo hpEntry = new THomePageInfo();
		mapper.map(homepage, hpEntry);
		for(THomePageAdmin admin : hpEntry.getAdmin()){	
			homepageAdminDao.delete(admin.getid());	
		}		
		List<THomePageAdmin> homepageadminEntries = new ArrayList<THomePageAdmin>();
		int i=1;
		for(THomePageAdmin admin : hpEntry.getAdmin()){					
		    id = id+i;
			admin.setid(id);
			homepageadminEntries.add(admin);
			i++;	
		}
		hpEntry.setAdmin(homepageadminEntries);
		homepageInfoDao.save(hpEntry);
		return;
	}
	
	public void editHomePage(long hpid,String type) {
		THomePageInfo homepageaEntry =  homepageInfoDao.findOne(hpid);
		if(homepageaEntry==null){
			return;
		}
		if(type.equals("del")){			
			homepageInfoDao.delete(hpid);	
			return;
		}
		if(type.equals("start")){			
			homepageaEntry.setStatus("0");			
		}
		if(type.equals("stop")){			
			homepageaEntry.setStatus("1");			
		}
		homepageInfoDao.save(homepageaEntry);
		return;
	}
	
	/**
	 * 我管理的空间
	 * @param userid
	 * @return
     */
	//我管理的空间
	public List<HomePageInfoDto> findHomePage(String userid,String type){
		List<THomePageAdmin> homepageadminEntries =  homepageAdminDao.find(userid);
		if(homepageadminEntries==null){
			return new ArrayList<HomePageInfoDto>();
		}
		List<HomePageInfoDto> homepageDtos=new ArrayList<HomePageInfoDto>();
		
		for(THomePageAdmin user : homepageadminEntries){
			HomePageAdminDto dto=new HomePageAdminDto();
			mapper.map(user, dto);
			THomePageInfo homepageEntries = homepageInfoDao.findOne(dto.getHpid());
			HomePageInfoDto hp=new HomePageInfoDto();
			mapper.map(homepageEntries, hp);
			List<THomePageAdmin> adminEntries =  homepageAdminDao.findadmin(hp.getid(),type);
			hp.setAdmin(adminEntries);
			homepageDtos.add(hp);
		}		
		return homepageDtos;		
	}
	
	public List<HomePageColumnDto> findColumn(long hpid,String type){
		List<THomePageColumn> homepagecolumnEntries =  homepageColumnDao.find(hpid);
		if(homepagecolumnEntries==null){
			return new ArrayList<HomePageColumnDto>();
		}
		List<HomePageColumnDto> homepagecolumnDtos=new ArrayList<HomePageColumnDto>();
		
		for(THomePageColumn column : homepagecolumnEntries){
			HomePageColumnDto dto=new HomePageColumnDto();
			mapper.map(column, dto);
			List<THomePageAdmin> adminEntries =  homepageAdminDao.findadmin(hpid,dto.getid(),type);
			dto.setAdmin(adminEntries);
			homepagecolumnDtos.add(dto);
		}		
		return homepagecolumnDtos;		
	}
	
	public void saveColumn(HomePageColumnDto column) {
		if (column == null) {
			return;
		}
		long adminid = homepageAdminDao.findmaxid()+1;
		long columnid = homepageColumnDao.findmaxid()+1;
		column.setid(columnid);
		
		THomePageColumn columnEntry = new THomePageColumn();
		mapper.map(column, columnEntry);
		List<THomePageAdmin> homepageadminEntries = new ArrayList<THomePageAdmin>();
		int i=1;
		for(THomePageAdmin admin : columnEntry.getAdmin()){			
			admin.setid(adminid);
			admin.setColumnid(columnid);;
			homepageadminEntries.add(admin);
			adminid = adminid+i;
			i++;	
		}
		columnEntry.setAdmin(homepageadminEntries);	
		
		
		homepageColumnDao.save(columnEntry);
		//homepageAdminDao.save(homepageadminEntries);
		return;
	}
	public void editColumn(HomePageColumnDto column) {
		if (column == null) {
			return;
		}
		long adminid = homepageAdminDao.findmaxid()+1;
		THomePageColumn columnEntry = new THomePageColumn();
		mapper.map(column, columnEntry);
		for(THomePageAdmin admin : column.getAdmin()){	
			homepageAdminDao.delete(admin.getid());	
		}
		List<THomePageAdmin> homepageadminEntries = new ArrayList<THomePageAdmin>();
		int i=1;
		for(THomePageAdmin admin : columnEntry.getAdmin()){			
			admin.setid(adminid);
			homepageadminEntries.add(admin);
			adminid = adminid+i;
			i++;	
		}
		columnEntry.setAdmin(homepageadminEntries);
		homepageColumnDao.save(columnEntry);
		//homepageAdminDao.save(homepageadminEntries);
		return;
	}
	
	public void editColumn(long hpid,long columnid,String type) {
		THomePageColumn columnEntry =  homepageColumnDao.findone(columnid);
		if(columnEntry==null){
			return;
		}
		if(type.equals("del")){			
			homepageColumnDao.delete(columnid);	
			return;
		}
		if(type.equals("start")){			
			columnEntry.setStatus("0");			
		}
		if(type.equals("stop")){			
			columnEntry.setStatus("1");			
		}
		homepageColumnDao.save(columnEntry);
		return;
	}
	
	
	public List<HomePageFormDto> findFrom(long hpid){
		List<THomePageForm> homepagefromEntries =  homepageFormDao.find(hpid);
		if(homepagefromEntries==null){
			return new ArrayList<HomePageFormDto>();
		}
		List<HomePageFormDto> homepagefromDtos=new ArrayList<HomePageFormDto>();
		
		for(THomePageForm Form : homepagefromEntries){
			HomePageFormDto dto=new HomePageFormDto();
			mapper.map(Form, dto);	
			List<THomePageFormIn> homepagefrominEntries =  homepageForminDao.find(dto.getid());
			dto.setFormin(homepagefrominEntries);		
			homepagefromDtos.add(dto);
		}		
		return homepagefromDtos;		
	}
	
	public void saveFrom(HomePageFormDto from) {
		if (from == null) {
			return;
		}
		long fromid = homepageFormDao.findmaxid()+1;		
		from.setid(fromid);		
		THomePageForm fromEntry = new THomePageForm();
		mapper.map(from, fromEntry);	
		homepageFormDao.save(fromEntry);		
		return;
	}
	
	public List<HomePageStyleDto> findStyle(long hpid){
		List<THomePageStyle> homepagestyleEntries =  homepageStyleDao.find(hpid);
		if(homepagestyleEntries==null){
			return new ArrayList<HomePageStyleDto>();
		}
		List<HomePageStyleDto> homepagestyleDtos=new ArrayList<HomePageStyleDto>();
		
		for(THomePageStyle Style : homepagestyleEntries){
			HomePageStyleDto dto=new HomePageStyleDto();
			mapper.map(Style, dto);	
			homepagestyleDtos.add(dto);
		}		
		return homepagestyleDtos;		
	}
	
	public void saveStyle(HomePageStyleDto style) {
		if (style == null) {
			return;
		}
		long styleid = homepageStyleDao.findmaxid()+1;
		
		style.setid(styleid);
		
		THomePageStyle styleEntry = new THomePageStyle();
		mapper.map(style, styleEntry);
	
		homepageStyleDao.save(styleEntry);
		
		return;
	}
}