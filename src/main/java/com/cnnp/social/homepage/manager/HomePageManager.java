package com.cnnp.social.homepage.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import com.cnnp.social.homepage.manager.dto.HomePageAdminDto;
import com.cnnp.social.homepage.manager.dto.HomePageColumnDto;
import com.cnnp.social.homepage.manager.dto.HomePageFormDto;
import com.cnnp.social.homepage.manager.dto.HomePageFormInAllDto;
import com.cnnp.social.homepage.manager.dto.HomePageIDNameDto;
import com.cnnp.social.homepage.manager.dto.HomePageInfoAllDto;
import com.cnnp.social.homepage.manager.dto.HomePageInfoDto;
import com.cnnp.social.homepage.manager.dto.HomePageStyleDto;
import com.cnnp.social.homepage.repository.dao.HomePageAdminDao;
import com.cnnp.social.homepage.repository.dao.HomePageColumnDao;
import com.cnnp.social.homepage.repository.dao.HomePageFormDao;
import com.cnnp.social.homepage.repository.dao.HomePageFormInDao;
import com.cnnp.social.homepage.repository.dao.HomePageImgDao;
import com.cnnp.social.homepage.repository.dao.HomePageInfoDao;
import com.cnnp.social.homepage.repository.dao.HomePageStyleDao;
import com.cnnp.social.homepage.repository.dao.HomePageStyleOrderDao;
import com.cnnp.social.homepage.repository.entity.THomePageAdmin;
import com.cnnp.social.homepage.repository.entity.THomePageColumn;
import com.cnnp.social.homepage.repository.entity.THomePageForm;
import com.cnnp.social.homepage.repository.entity.THomePageFormIn;
import com.cnnp.social.homepage.repository.entity.THomePageImg;
import com.cnnp.social.homepage.repository.entity.THomePageInfo;
import com.cnnp.social.homepage.repository.entity.THomePageStyle;
import com.cnnp.social.homepage.repository.entity.THomePageStyleOrder;



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
	@Autowired
	private HomePageImgDao homepageimgDao;
	@Autowired
	private HomePageStyleOrderDao homepagestyleorderDao;
	
	private DozerBeanMapper mapper = new DozerBeanMapper();
	
	@Transactional
	public void saveHomePage(HomePageInfoDto homepage) {
		if (homepage == null) {
			return;
		}
		long hpid = homepageInfoDao.findmaxid()+1;
		long id = homepageAdminDao.findmaxid()+1;
		Date now = new Date(); 
		homepage.setid(hpid);
		homepage.setUpdatetime(now);
		THomePageInfo hpEntry = new THomePageInfo();
		mapper.map(homepage, hpEntry);
		List<THomePageAdmin> homepageadminEntries = new ArrayList<THomePageAdmin>();
		for(THomePageAdmin admin : hpEntry.getAdmin()){	
			admin.setid(id);
			admin.setHpid(hpid);
			admin.setUpdatetime(now);
			homepageadminEntries.add(admin);
			 id = id+1;
		}
		hpEntry.setAdmin(homepageadminEntries);
		homepageInfoDao.save(hpEntry);
		return;
	}
	public void editHomePage(HomePageInfoDto homepage) {
		if (homepage == null) {
			return;
		}
		long id = homepageAdminDao.findmaxid()+1;
		Date now = new Date();
		homepage.setUpdatetime(now);
		THomePageInfo hpEntry = new THomePageInfo();
		mapper.map(homepage, hpEntry);
		for(THomePageAdmin admin : hpEntry.getAdmin()){	
			homepageAdminDao.delete(admin.getid());	
		}		
		List<THomePageAdmin> homepageadminEntries = new ArrayList<THomePageAdmin>();
		for(THomePageAdmin admin : hpEntry.getAdmin()){					
			admin.setUpdatetime(now);
			admin.setid(id);
			homepageadminEntries.add(admin);
			id = id+1;
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
		Date now = new Date();
		homepageaEntry.setUpdatetime(now);
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
		Date now = new Date(); 
		column.setid(columnid);
		column.setUpdatetime(now);
		THomePageColumn columnEntry = new THomePageColumn();
		mapper.map(column, columnEntry);
		List<THomePageAdmin> homepageadminEntries = new ArrayList<THomePageAdmin>();
		for(THomePageAdmin admin : columnEntry.getAdmin()){			
			admin.setid(adminid);
			admin.setColumnid(columnid);
			admin.setUpdatetime(now);
			homepageadminEntries.add(admin);
			adminid = adminid+1;
		}
		columnEntry.setAdmin(homepageadminEntries);	
		homepageColumnDao.save(columnEntry);
		return;
	}
	public void editColumn(HomePageColumnDto column) {
		if (column == null) {
			return;
		}
		long adminid = homepageAdminDao.findmaxid()+1;
		Date now = new Date();
		column.setUpdatetime(now);
		THomePageColumn columnEntry = new THomePageColumn();
		mapper.map(column, columnEntry);
		for(THomePageAdmin admin : column.getAdmin()){	
			homepageAdminDao.delete(admin.getid());	
		}
		List<THomePageAdmin> homepageadminEntries = new ArrayList<THomePageAdmin>();
		
		for(THomePageAdmin admin : columnEntry.getAdmin()){			
			admin.setid(adminid);
			admin.setUpdatetime(now);
			homepageadminEntries.add(admin);
			adminid = adminid+1;
			
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
		Date now = new Date(); 
		columnEntry.setUpdatetime(now);
		homepageColumnDao.save(columnEntry);
		return;
	}
	
	
	public List<HomePageFormDto> findForm(long hpid){
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
	
	public void saveForm(HomePageFormDto form) {
		if (form == null) {
			return;
		}
		long formid = homepageFormDao.findmaxid()+1;
		long forminid = homepageForminDao.findmaxid()+1;
		Date now = new Date(); 
		form.setid(formid);		
		form.setUpdatetime(now);
		THomePageForm formEntry = new THomePageForm();
		mapper.map(form, formEntry);	
		List<THomePageFormIn> homepageforminEntries = new ArrayList<THomePageFormIn>();

		for(THomePageFormIn formin : formEntry.getFormin()){			
			formin.setFormid(formid);
			formin.setid(forminid);
			formin.setUpdatetime(now);
			homepageforminEntries.add(formin);
			forminid = forminid+1;
			
		}
		formEntry.setFormin(homepageforminEntries);
		homepageFormDao.save(formEntry);		
		return;
	}
	
	public List<HomePageStyleDto> findStyle(long hpid){
		List<THomePageStyle> homepagestyleEntries =  homepageStyleDao.find(hpid);
		if(homepagestyleEntries==null){
			return new ArrayList<HomePageStyleDto>();
		}
		List<HomePageStyleDto> homepagestyleDtos=new ArrayList<HomePageStyleDto>();
		
		for(THomePageStyle Style : homepagestyleEntries){
			List<THomePageStyleOrder> homepagestyleorderEntries =  homepagestyleorderDao.find(Style.getid());
			List<THomePageImg> homepageimgEntries =  homepageimgDao.find(Style.getid());
			Style.setOrder(homepagestyleorderEntries);
			Style.setImg(homepageimgEntries);
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
		long imgid = homepageimgDao.findmaxid()+1;
		long orderid = homepagestyleorderDao.findmaxid()+1;
		Date now = new Date(); 
		style.setid(styleid);	
		style.setUpdatetime(now);
		THomePageStyle styleEntry = new THomePageStyle();
		mapper.map(style, styleEntry);
		List<THomePageStyleOrder> homepagestyleorderEntries = new ArrayList<THomePageStyleOrder>();
		List<THomePageImg> homepageimgEntries = new ArrayList<THomePageImg>();
		for(THomePageStyleOrder order : styleEntry.getOrder()){			
			order.setid(orderid);
			order.setStyleid(styleid);			
			homepagestyleorderEntries.add(order);
			orderid = orderid+1;			
		}
		for(THomePageImg img : styleEntry.getImg()){			
			img.setid(imgid);
			img.setStyleid(styleid);
			img.setUpdatetime(now);
			homepageimgEntries.add(img);
			imgid = imgid+1;			
		}
		homepageStyleDao.save(styleEntry);		
		return;
	}
	public void editHomePageStyle(HomePageStyleDto style) {
		if (style == null) {
			return;
		}
		long imgid = homepageimgDao.findmaxid()+1;
		long orderid = homepagestyleorderDao.findmaxid()+1;
		Date now = new Date();
		style.setUpdatetime(now);
		THomePageStyle styleEntry = new THomePageStyle();
		mapper.map(style, styleEntry);
		for(THomePageImg img : style.getImg()){	
			homepageimgDao.delete(img.getid());	
		}
		for(THomePageStyleOrder order : style.getOrder()){	
			homepagestyleorderDao.delete(order.getid());	
		}
		List<THomePageStyleOrder> homepagestyleorderEntries = new ArrayList<THomePageStyleOrder>();
		List<THomePageImg> homepageimgEntries = new ArrayList<THomePageImg>();
		for(THomePageStyleOrder order : styleEntry.getOrder()){			
			order.setid(orderid);	
			homepagestyleorderEntries.add(order);
			orderid = orderid+1;			
		}
		for(THomePageImg img : styleEntry.getImg()){			
			img.setid(imgid);
			img.setUpdatetime(now);
			homepageimgEntries.add(img);
			imgid = imgid+1;			
		}
		styleEntry.setImg(homepageimgEntries);
		styleEntry.setOrder(homepagestyleorderEntries);
		homepageStyleDao.save(styleEntry);
		return;
	}
	
	public void editHomePageStyle(long styleid,String type) {
		THomePageStyle styleEntry =  homepageStyleDao.findOne(styleid);
		if(styleEntry==null){
			return;
		}
		
		if(type.equals("del")){			
			homepageStyleDao.delete(styleid);	
			return;
		}
		if(type.equals("start")){			
			styleEntry.setStatus("0");			
		}
		if(type.equals("stop")){			
			styleEntry.setStatus("1");			
		}
		Date now = new Date();
		styleEntry.setUpdatetime(now);
		homepageStyleDao.save(styleEntry);
		return;
	}
	public List<HomePageIDNameDto> findHomePageSector(long hpid){
		List<HomePageIDNameDto> homepageaidnameDtos=new ArrayList<HomePageIDNameDto>();
		List<THomePageInfo> homepageEntry = homepageInfoDao.findparentid(hpid);
		if(homepageEntry==null){
			return new ArrayList<HomePageIDNameDto>();
		}
		for(THomePageInfo hp : homepageEntry){
			HomePageIDNameDto iddto=new HomePageIDNameDto();
			iddto.setid(hp.getid());
			iddto.setName(hp.getName());
			iddto.setHptype(hp.getHptype());
			homepageaidnameDtos.add(iddto);
		}
		return homepageaidnameDtos;		
	}
	
	public List<HomePageInfoAllDto> findHomePageAll(long hpid){
		List<HomePageInfoAllDto> homepageallDtos=new ArrayList<HomePageInfoAllDto>();
		THomePageInfo homepageEntry = homepageInfoDao.findOne(hpid);
		if(homepageEntry==null){
			return new ArrayList<HomePageInfoAllDto>();
		}
		
		
		List<THomePageForm> homepagefromEntries =  homepageFormDao.find(hpid);
		
		for(THomePageForm Form : homepagefromEntries){
			HomePageInfoAllDto hpDto=new HomePageInfoAllDto();
			hpDto.setCARD_TOP_COLOR(Form.getTop_color());
			hpDto.setCARD_WIDTH(Form.getWidth());
			hpDto.setCARD_INDEX(homepagestyleorderDao.findform(Form.getid()).getOrderid());
			List<HomePageFormInAllDto> forminall = new ArrayList<HomePageFormInAllDto>();
					
			for(THomePageFormIn Formin : Form.getFormin()){
				HomePageFormInAllDto forminone = new HomePageFormInAllDto();
				
				forminone.setCONTENT_TYPE("application/json");
				forminone.setMETHOD("get");
				forminone.setPAYLOAD("");
				forminone.setQueryString("&apikey=e71982d5401b488da4acef8827c41845");
				forminone.setSUBCARD_INDEX(Formin.getForm_inid());
				forminone.setSUBCARD_ISMORE(Formin.getIsmore());
				forminone.setSUBCARD_MORE_URL(Formin.getMore_url());
				forminone.setSUBCARD_TYPE(Formin.getColumnid());
				forminone.setSUBCARD_ZH(Formin.getName());
				forminone.setURL(Formin.getUrl());
				forminall.add(forminone);
			}
			hpDto.setSUBCARDS(forminall);
			
			homepageallDtos.add(hpDto);
		}
		
		return homepageallDtos;		
	}
	
}