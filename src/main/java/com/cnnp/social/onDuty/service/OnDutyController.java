package com.cnnp.social.onDuty.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cnnp.social.onDuty.manager.OnDutyManager;
import com.cnnp.social.onDuty.manager.dto.DutyDto;
import com.cnnp.social.onDuty.manager.dto.DutyImportDto;
import com.cnnp.social.onDuty.manager.dto.DutyStatus;
import com.cnnp.social.onDuty.manager.dto.OnDutyDto;
import com.cnnp.social.onDuty.manager.dto.UserDto;

@RestController
@RequestMapping("/api/V1.0/onduty")
public class OnDutyController {
	@Autowired
	private OnDutyManager onDutyManger;
	
	
	@RequestMapping(value = "/onduty/add", method = RequestMethod.POST)
	public DutyStatus save(@RequestBody DutyDto onDutyDto) throws ParseException {
		DutyStatus status = onDutyManger.addDuty(onDutyDto); 
		return status;
	}
	
	@RequestMapping(value = "/onduty/delete", method = RequestMethod.POST)
	public Boolean del(@RequestParam Long dutyid) {
		return onDutyManger.delDuty(dutyid); 
	}
	
	@RequestMapping(value = "/onduty/findByUser", method = RequestMethod.POST)
	public List<OnDutyDto> findByUser(@RequestBody UserDto user) {
		return onDutyManger.findByUser(user); 
	}
	
	@RequestMapping(value = "/onduty/findbyDuty", method = RequestMethod.POST)
	public List<OnDutyDto> findByDuty(@RequestBody DutyDto duty) {
		return onDutyManger.findByDuty(duty); 
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