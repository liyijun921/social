package com.cnnp.social.homepage.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cnnp.social.homepage.manager.HomePageManager;
import com.cnnp.social.homepage.manager.dto.HomePageArticlecatDto;
import com.cnnp.social.homepage.manager.dto.HomePageColumnDto;
import com.cnnp.social.homepage.manager.dto.HomePageFormDto;
import com.cnnp.social.homepage.manager.dto.HomePageIDNameDto;
import com.cnnp.social.homepage.manager.dto.HomePageInfoAllDto;
import com.cnnp.social.homepage.manager.dto.HomePageInfoDto;
import com.cnnp.social.homepage.manager.dto.HomePageStyleDto;



@RestController
@RequestMapping("/api/V1.0/homepage")
public class HomePageController {
	@Autowired
	private HomePageManager hpManger;
	
	@RequestMapping(value = "/homepage/add", method = RequestMethod.POST)
	public void save(@RequestBody HomePageInfoDto hp) {
		hpManger.saveHomePage(hp); 
	}
	@RequestMapping(value = "/homepage/edit", method = RequestMethod.POST)
	public void edit(@RequestBody HomePageInfoDto hp) {
		hpManger.editHomePage(hp); 
	}
	@RequestMapping(value = "/homepage/edittype", method = RequestMethod.GET)
	public void edittype(@RequestParam long hpid,@RequestParam String type) {
		hpManger.editHomePage(hpid,type); 
	}
	@RequestMapping(value = "/homepage/{userid}", method = RequestMethod.GET)
	public @ResponseBody List<HomePageInfoDto> view(@PathVariable("userid") String userid) {
		return hpManger.findHomePage(userid);
	}
	
	@RequestMapping(value = "/homepagecolumn", method = RequestMethod.GET)
	public @ResponseBody List<HomePageArticlecatDto> viewColumn(@RequestParam long hpid) {
		return hpManger.findArticlecat(hpid);
	}
	
	@RequestMapping(value = "/homepagecolumn/add", method = RequestMethod.POST)
	public void save(@RequestBody HomePageArticlecatDto column) {
		hpManger.saveArticlecat(column); 
	}
	@RequestMapping(value = "/homepagecolumn/edit", method = RequestMethod.POST)
	public void columnedit(@RequestBody HomePageArticlecatDto column) {
		hpManger.editArticlecat(column); 
	}
	@RequestMapping(value = "/homepagecolumn/edittype", method = RequestMethod.GET)
	public void editcolumntype(@RequestParam long columnid,@RequestParam String type) {
		hpManger.editColumn(columnid,type); 
	}
	
	@RequestMapping(value = "/homepageform", method = RequestMethod.GET)
	public @ResponseBody List<HomePageFormDto> viewForm(@RequestParam long hpid) {
		return hpManger.findForm(hpid);
	}
	@RequestMapping(value = "/homepageform/edit", method = RequestMethod.POST)
	public void editForm(@RequestBody HomePageFormDto form) {
		hpManger.editForm(form);
	}
	@RequestMapping(value = "/homepageform/add", method = RequestMethod.POST)
	public void save(@RequestBody HomePageFormDto form) {
		hpManger.saveForm(form); 
	}
	@RequestMapping(value = "/homepageform/del", method = RequestMethod.GET)
	public void del(@RequestParam long formid) {
		hpManger.delForm(formid); 
	}
	@RequestMapping(value = "/homepagestyle/{hpid}", method = RequestMethod.GET)
	public @ResponseBody List<HomePageStyleDto> viewStyle(@PathVariable("hpid") long hpid) {
		return hpManger.findStyle(hpid);
	}
	@RequestMapping(value = "/homepagestyle/add", method = RequestMethod.POST)
	public void save(@RequestBody HomePageStyleDto style) {
		hpManger.saveStyle(style); 
	}
	@RequestMapping(value = "/homepagestyle/edit", method = RequestMethod.POST)
	public void styleedit(@RequestBody HomePageStyleDto style) {
		hpManger.editHomePageStyle(style); 
	}
	@RequestMapping(value = "/homepagestyle/edittype", method = RequestMethod.GET)
	public void editstyletype(@RequestParam long styleid,@RequestParam String type) {
		hpManger.editHomePageStyle(styleid,type); 
	}
	//@RequestMapping(value = "/test", method = RequestMethod.GET)
	//public @ResponseBody List<HomePageFormDto> viewtest(@RequestParam long hpid) {
	//	return hpManger.findFrom(hpid);
	//}
	@RequestMapping(value = "/{hpid}", method = RequestMethod.GET)
	public @ResponseBody List<HomePageInfoAllDto> viewHpall(@PathVariable("hpid") long hpid) {
		return hpManger.findHomePageAll(hpid);
	}
	@RequestMapping(value = "/sector", method = RequestMethod.GET)
	public @ResponseBody List<HomePageIDNameDto> viewFormall() {
		return hpManger.findHomePageSector();
	}
	
	
	@RequestMapping(value = "test/{hpid}", method = RequestMethod.GET)
	public @ResponseBody List<HomePageArticlecatDto> test(@PathVariable("hpid") long hpid) {
		return hpManger.findArticlecat(hpid);
	}
}