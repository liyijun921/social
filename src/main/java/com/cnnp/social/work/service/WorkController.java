package com.cnnp.social.work.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cnnp.social.work.manager.WorkManager;
import com.cnnp.social.work.manager.dto.UserlinkDto;




@RestController
@RequestMapping("/api/V1.0/work")
public class WorkController {
	@Autowired
	private WorkManager workManger;
	
	@RequestMapping(value = "/work/add", method = RequestMethod.POST)
	public void save(@RequestBody List<UserlinkDto> userlink,@RequestParam String type,@RequestParam String userid) {
		workManger.save(userlink,type,userid);
	}
	@RequestMapping(value = "/work/{userid}", method = RequestMethod.GET)
	public @ResponseBody List<UserlinkDto> view(@PathVariable("userid") String userid) {
		return workManger.findUserOrder(userid);
	}
}