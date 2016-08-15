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
import com.cnnp.social.homepage.manager.dto.HomePageArticlecatDto;
import com.cnnp.social.homepage.manager.dto.HomePageColumnDto;
import com.cnnp.social.homepage.manager.dto.HomePageFormDto;
import com.cnnp.social.homepage.manager.dto.HomePageFormInAllDto;
import com.cnnp.social.homepage.manager.dto.HomePageIDNameDto;
import com.cnnp.social.homepage.manager.dto.HomePageInfoAllDto;
import com.cnnp.social.homepage.manager.dto.HomePageInfoDto;
import com.cnnp.social.homepage.manager.dto.HomePageStyleDto;
import com.cnnp.social.homepage.repository.dao.HomePageAdminDao;
import com.cnnp.social.homepage.repository.dao.HomePageArticlecatDao;
import com.cnnp.social.homepage.repository.dao.HomePageColumnDao;
import com.cnnp.social.homepage.repository.dao.HomePageFormDao;
import com.cnnp.social.homepage.repository.dao.HomePageFormInDao;
import com.cnnp.social.homepage.repository.dao.HomePageImgDao;
import com.cnnp.social.homepage.repository.dao.HomePageInfoDao;
import com.cnnp.social.homepage.repository.dao.HomePageStyleDao;
import com.cnnp.social.homepage.repository.dao.HomePageStyleOrderDao;
import com.cnnp.social.homepage.repository.entity.THomePageAdmin;
import com.cnnp.social.homepage.repository.entity.THomePageArticlecat;
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
	private HomePageArticlecatDao homepageArticlecatDao;
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
		Boolean peopleflg = true;
		for(THomePageAdmin admin : hpEntry.getAdmin()){	
			admin.setid(id);
			admin.setHpid(hpid);
			admin.setColumnid(0);
			admin.setUpdatetime(now);
			homepageadminEntries.add(admin);
			id = id+1;
			if (homepage.getCreateuserid().equals(admin.getUserid())){
				peopleflg = false;
			}
		}
		if (peopleflg){
			THomePageAdmin user = new THomePageAdmin();
			user.setid(id);
			user.setHpid(hpid);
			user.setColumnid(0);
			user.setUserid(homepage.getCreateuserid());
			user.setUsername(homepage.getCreateusername());
			user.setUpdatetime(now);
			homepageadminEntries.add(user);
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
		List<THomePageAdmin> adminEntries =  homepageAdminDao.findHPadmin(homepage.getid());
		if(adminEntries !=null){
			homepageAdminDao.delete(adminEntries);	
		}		
				
		List<THomePageAdmin> homepageadminEntries = new ArrayList<THomePageAdmin>();
		Boolean peopleflg = true;
		for(THomePageAdmin admin : hpEntry.getAdmin()){					
			admin.setUpdatetime(now);
			admin.setid(id);
			admin.setColumnid(0);
			homepageadminEntries.add(admin);
			id = id+1;
			if (homepage.getCreateuserid().equals(admin.getUserid())){
				peopleflg = false;
			}
		}
		
		if (peopleflg){
			THomePageAdmin user = new THomePageAdmin();
			user.setid(id);
			user.setHpid(homepage.getid());
			user.setColumnid(0);
			user.setUserid(homepage.getCreateuserid());
			user.setUsername(homepage.getCreateusername());
			user.setUpdatetime(now);
			homepageadminEntries.add(user);
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
			//if (homepageaEntry.getParentid()==0){
			//	homepageInfoDao.updataStatus();
			//}
			homepageaEntry.setStatus("1");			
		}
		if(type.equals("stop")){			
			homepageaEntry.setStatus("0");			
		}
		Date now = new Date();
		homepageaEntry.setUpdatetime(now);
		homepageInfoDao.save(homepageaEntry);
		return;
	}
	

	public List<HomePageInfoDto> findHomePage(String userid){
		List<THomePageAdmin> homepageadminEntries =  homepageAdminDao.findHP(userid);
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
			List<THomePageAdmin> adminEntries =  homepageAdminDao.findHPadmin(hp.getid());
			hp.setAdmin(adminEntries);
			homepageDtos.add(hp);
		}		
		return homepageDtos;		
	}

	public List<HomePageColumnDto> findColumn(long hpid){
		List<THomePageColumn> homepagecolumnEntries =  homepageColumnDao.find(hpid);
		if(homepagecolumnEntries==null){
			return new ArrayList<HomePageColumnDto>();
		}
		List<HomePageColumnDto> homepagecolumnDtos=new ArrayList<HomePageColumnDto>();
		
		for(THomePageColumn column : homepagecolumnEntries){
			HomePageColumnDto dto=new HomePageColumnDto();
			mapper.map(column, dto);
			List<THomePageAdmin> adminEntries =  homepageAdminDao.findcolumnadmin(dto.getid());
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
		Boolean peopleflg = true;
		for(THomePageAdmin admin : columnEntry.getAdmin()){			
			admin.setid(adminid);
			admin.setColumnid(columnid);
			admin.setUpdatetime(now);
			homepageadminEntries.add(admin);
			adminid = adminid+1;
			if (column.getCreateuserid().equals(admin.getUserid())){
				peopleflg = false;
			}
		}
		if (peopleflg){
			THomePageAdmin user = new THomePageAdmin();
			user.setid(adminid);
			user.setHpid(column.getHpid());
			user.setColumnid(columnid);
			user.setUserid(column.getCreateuserid());
			user.setUsername(column.getCreateusername());
			user.setUpdatetime(now);
			homepageadminEntries.add(user);
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
		List<THomePageAdmin> adminEntries =  homepageAdminDao.findcolumnadmin(column.getid());
		if(adminEntries !=null){
			homepageAdminDao.delete(adminEntries);	
		}		
		
		List<THomePageAdmin> homepageadminEntries = new ArrayList<THomePageAdmin>();
		Boolean peopleflg = true;
		for(THomePageAdmin admin : columnEntry.getAdmin()){			
			admin.setid(adminid);
			admin.setUpdatetime(now);
			homepageadminEntries.add(admin);
			adminid = adminid+1;
			if (column.getCreateuserid().equals(admin.getUserid())){
				peopleflg = false;
			}
		}
		if (peopleflg){
			THomePageAdmin user = new THomePageAdmin();
			user.setid(adminid);
			user.setHpid(column.getHpid());
			user.setColumnid(column.getid());
			user.setUserid(column.getCreateuserid());
			user.setUsername(column.getCreateusername());
			user.setUpdatetime(now);
			homepageadminEntries.add(user);
		}
		columnEntry.setAdmin(homepageadminEntries);
		homepageColumnDao.save(columnEntry);
		
		return;
	}
	
	public void editColumn(long columnid,String type) {
		THomePageColumn columnEntry =  homepageColumnDao.findone(columnid);
		if(columnEntry==null){
			return;
		}
		
		if(type.equals("del")){			
			homepageColumnDao.delete(columnEntry);	
			return;
		}
		if(type.equals("start")){			
			columnEntry.setStatus("1");			
		}
		if(type.equals("stop")){			
			columnEntry.setStatus("0");			
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
	
	public void editForm(HomePageFormDto form) {
		if (form == null) {
			return;
		}
		long forminid = homepageForminDao.findmaxid()+1;
		Date now = new Date(); 	
		form.setUpdatetime(now);
		THomePageForm formEntry = new THomePageForm();
		mapper.map(form, formEntry);
		List<THomePageFormIn> forminEntries =homepageForminDao.find(form.getid());
		if (forminEntries != null) {			
			homepageForminDao.delete(forminEntries);					
		}
		List<THomePageFormIn> homepageforminEntries = new ArrayList<THomePageFormIn>();		
		
		for(THomePageFormIn formin : formEntry.getFormin()){						
			formin.setid(forminid);
			formin.setUpdatetime(now);
			formin.setFormid(form.getid());
			homepageforminEntries.add(formin);
			forminid = forminid+1;			
		}
		formEntry.setFormin(homepageforminEntries);
		homepageFormDao.save(formEntry);		
		return;
	}
	public void delForm(long formid) {
		
		THomePageForm formEntry = homepageFormDao.findOne(formid);
		
		if (formEntry != null) {
			homepageFormDao.delete(formEntry);					
		}
				
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
		List<THomePageImg> imgEntries =  homepageimgDao.find(style.getid());
		if (imgEntries!=null){
			homepageimgDao.delete(imgEntries);
		}
		
		List<THomePageStyleOrder> orderEntries = homepagestyleorderDao.find(style.getid());
		if (orderEntries!=null){
			homepagestyleorderDao.delete(orderEntries);	
		}
		List<THomePageStyleOrder> homepagestyleorderEntries = new ArrayList<THomePageStyleOrder>();
		List<THomePageImg> homepageimgEntries = new ArrayList<THomePageImg>();
		for(THomePageStyleOrder order : styleEntry.getOrder()){			
			order.setid(orderid);
			order.setStyleid(style.getid());
			homepagestyleorderEntries.add(order);
			orderid = orderid+1;			
		}
		for(THomePageImg img : styleEntry.getImg()){			
			img.setid(imgid);
			img.setStyleid(style.getid());
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
			homepageStyleDao.delete(styleEntry);	
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
	public List<HomePageIDNameDto> findHomePageSector(){
		List<HomePageIDNameDto> homepageaidnameDtos=new ArrayList<HomePageIDNameDto>();
		List<THomePageInfo> homepageEntry = homepageInfoDao.findparentid();
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
		THomePageInfo homepageEntry = new THomePageInfo();
		if (hpid==0){
			homepageEntry = homepageInfoDao.findStartHP();
		}else{
			homepageEntry = homepageInfoDao.findOne(hpid);
		}
		
		if(homepageEntry==null){
			return new ArrayList<HomePageInfoAllDto>();
		}
		List<THomePageForm> homepagefromEntries =  homepageFormDao.find(homepageEntry.getid());
		
		for(THomePageForm Form : homepagefromEntries){
			THomePageStyleOrder homepagestyleorderEntry =  homepagestyleorderDao.findform(Form.getid());
			HomePageInfoAllDto hpDto=new HomePageInfoAllDto();
			
			
			if (homepagestyleorderEntry!=null){
				hpDto.setCARD_TOP_COLOR(Form.getTop_color());
				hpDto.setCARD_WIDTH(Form.getWidth());
				hpDto.setCARD_INDEX(homepagestyleorderEntry.getOrderid());
				List<HomePageFormInAllDto> forminall = new ArrayList<HomePageFormInAllDto>();
				
				for(THomePageFormIn Formin : Form.getFormin()){
					HomePageFormInAllDto forminone = new HomePageFormInAllDto();
					
					forminone.setCONTENT_TYPE(Formin.getContent_type());
					forminone.setMETHOD(Formin.getMethod());
					forminone.setPAYLOAD(Formin.getPayload());
					forminone.setQueryString(Formin.getQuerystring());
					forminone.setSUBCARD_INDEX(Formin.getForm_inid());
					forminone.setSUBCARD_ISMORE(Formin.getIsmore());
					forminone.setSUBCARD_MORE_URL(Formin.getMore_url());
					forminone.setSUBCARD_TYPE(Formin.getStyleid());
					forminone.setSUBCARD_ZH(Formin.getName());
					forminone.setURL(Formin.getUrl());
					forminall.add(forminone);
				}
				hpDto.setSUBCARDS(forminall);
				
				homepageallDtos.add(hpDto);
			}
			
			
		}
		
		return homepageallDtos;		
	}
	public List<HomePageArticlecatDto> findArticlecat(long parent_id){
		List<THomePageArticlecat> articlecatEntries =  homepageArticlecatDao.find(parent_id);
		if(articlecatEntries==null){
			return new ArrayList<HomePageArticlecatDto>();
		}
		List<HomePageArticlecatDto> homepagecolumnDtos=new ArrayList<HomePageArticlecatDto>();
		
		for(THomePageArticlecat column : articlecatEntries){
			HomePageArticlecatDto dto=new HomePageArticlecatDto();
			mapper.map(column, dto);
			homepagecolumnDtos.add(dto);
		}		
		return homepagecolumnDtos;		
	}
	public void saveArticlecat(HomePageArticlecatDto articlecat) {
		if (articlecat == null) {
			return;
		}		
		
		long id = homepageArticlecatDao.findmaxid()+1;		
		articlecat.setid(id);		
		articlecat.setVersion("1");
		articlecat.setSeq("1");
		articlecat.setIs_build("1");
		THomePageArticlecat articlecatEntry = new THomePageArticlecat();
		mapper.map(articlecat, articlecatEntry);
		homepageArticlecatDao.save(articlecatEntry);
		return;
	}
	public void editArticlecat(HomePageArticlecatDto articlecat) {
		if (articlecat == null) {
			return;
		}				
		THomePageArticlecat articlecatEntry = new THomePageArticlecat();
		mapper.map(articlecat, articlecatEntry);
		homepageArticlecatDao.save(articlecatEntry);
		return;
	}
	public void editArticlecat(long articlecatid,String type) {
		THomePageArticlecat articlecatEntry =  homepageArticlecatDao.findone(articlecatid);
		if(articlecatEntry==null){
			return;
		}
		
		if(type.equals("del")){			
			homepageArticlecatDao.delete(articlecatEntry);	
			return;
		}
		if(type.equals("start")){			
			articlecatEntry.setStatus("2");			
		}
		if(type.equals("stop")){			
			articlecatEntry.setStatus("0");			
		}

		homepageArticlecatDao.save(articlecatEntry);
		return;
	}
	
}