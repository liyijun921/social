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

import com.cnnp.social.collspace.manager.dto.CollspaceDto;
import com.cnnp.social.homepage.manager.HomePageManager;
import com.cnnp.social.homepage.manager.dto.HomePageColumnDto;
import com.cnnp.social.homepage.manager.dto.HomePageFormDto;
import com.cnnp.social.homepage.manager.dto.HomePageInfoDto;
import com.cnnp.social.homepage.manager.dto.HomePageStyleDto;
import com.cnnp.social.plan.manager.PlanManager;
import com.cnnp.social.plan.manager.dto.PlanInfoDto;
import com.cnnp.social.schedule.manager.dto.ScheduleDto;


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
		return hpManger.findHomePage(userid,"0");
	}
	
	@RequestMapping(value = "/homepagecolumn", method = RequestMethod.GET)
	public @ResponseBody List<HomePageColumnDto> viewColumn(@RequestParam long hpid,@RequestParam String type) {
		return hpManger.findColumn(hpid,type);
	}
	
	@RequestMapping(value = "/homepagecolumn/add", method = RequestMethod.POST)
	public void save(@RequestBody HomePageColumnDto column) {
		hpManger.saveColumn(column); 
	}
	@RequestMapping(value = "/homepagecolumn/edit", method = RequestMethod.POST)
	public void edit(@RequestBody HomePageColumnDto column) {
		hpManger.editColumn(column); 
	}
	@RequestMapping(value = "/homepagecolumn/edittype", method = RequestMethod.GET)
	public void edittype(@RequestParam long hpid,@RequestParam long columnid,@RequestParam String type) {
		hpManger.editColumn(hpid,columnid,type); 
	}
	
	@RequestMapping(value = "/homepagefrom", method = RequestMethod.GET)
	public @ResponseBody List<HomePageFormDto> viewForm(@RequestParam long hpid) {
		return hpManger.findFrom(hpid);
	}
	
	@RequestMapping(value = "/homepagefrom/add", method = RequestMethod.POST)
	public void save(@RequestBody HomePageFormDto from) {
		hpManger.saveFrom(from); 
	}
	@RequestMapping(value = "/homepagestyle", method = RequestMethod.GET)
	public @ResponseBody List<HomePageStyleDto> viewStyle(@RequestParam long hpid) {
		return hpManger.findStyle(hpid);
	}
	@RequestMapping(value = "/homepagestyle/add", method = RequestMethod.POST)
	public void save(@RequestBody HomePageStyleDto style) {
		hpManger.saveStyle(style); 
	}
	
	//@RequestMapping(value = "/test", method = RequestMethod.GET)
	//public @ResponseBody List<HomePageFormDto> viewtest(@RequestParam long hpid) {
	//	return hpManger.findFrom(hpid);
	//}
}