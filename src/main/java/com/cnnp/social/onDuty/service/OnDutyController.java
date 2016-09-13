package com.cnnp.social.onDuty.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cnnp.social.onDuty.manager.OnDutyManager;
import com.cnnp.social.onDuty.manager.dto.DutyImportDto;
import com.cnnp.social.onDuty.manager.dto.DutyStatus;
import com.cnnp.social.onDuty.manager.dto.OnDutyDto;

@RestController
@RequestMapping("/api/V1.0/onduty")
public class OnDutyController {
	@Autowired
	private OnDutyManager onDutyManger;
	
	
	@RequestMapping(value = "/onduty/add", method = RequestMethod.POST)
	public DutyStatus save(@RequestBody OnDutyDto onDutyDto,@RequestParam String startdate,@RequestParam String enddate) {
		DutyStatus status = onDutyManger.addDuty(onDutyDto,startdate,enddate); 
		return status;
	}
	
	@RequestMapping(value = "/onduty/delete", method = RequestMethod.POST)
	public Boolean del(@RequestParam Long dutyid) {
		return onDutyManger.delDuty(dutyid); 
	}
	
	@RequestMapping(value = "/onduty/findbydutyid", method = RequestMethod.POST)
	public OnDutyDto listByDutyId(@RequestBody Long dutyid) {
		return onDutyManger.listDutyByDutyId(dutyid); 
	}
	
	@RequestMapping(value = "/onduty/findbydate", method = RequestMethod.POST)
	public List<OnDutyDto> listDutyByDate(@RequestBody Long dutyid,@RequestParam String startdate,@RequestParam String enddate) {
		return onDutyManger.listDutyByDate(dutyid,startdate,enddate); 
	}
	
	@RequestMapping(value = "/onduty/findbyuser", method = RequestMethod.POST)
	public List<OnDutyDto> listDutyByUser(@RequestParam Long userid) {
		return onDutyManger.listDutyByUser(userid); 
	}
	
	@RequestMapping(value = "/onduty/findall", method = RequestMethod.POST)
	public List<OnDutyDto> listDutyAll() {
		return onDutyManger.listDutyAll(); 
	}
	
	@RequestMapping(value = "/readfile", method = RequestMethod.POST)
	public DutyStatus readFile(@RequestParam(value="uploadFile")MultipartFile file) throws Exception{    
		DutyStatus status = onDutyManger.readFile(file);
		return status;
	}
	
	@RequestMapping(value = "/importfile", method = RequestMethod.POST)
	public DutyStatus importFile(@RequestBody List<DutyImportDto> importList) throws IOException{    
		DutyStatus status = onDutyManger.importFile(importList);
		return status;
	}
	      

}