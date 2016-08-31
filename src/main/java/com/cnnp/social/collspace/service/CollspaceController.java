package com.cnnp.social.collspace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cnnp.social.collspace.manager.CollspaceManager;
import com.cnnp.social.collspace.manager.dto.CollspaceDto;
import com.cnnp.social.collspace.manager.dto.CollspaceRemarkDto;
import com.cnnp.social.collspace.manager.dto.CollspaceTopicDto;
import com.cnnp.social.collspace.manager.dto.CollspaceTopic_RDto;
import com.cnnp.social.collspace.manager.dto.CollspaceUserDto;



@RestController
@RequestMapping("/api/V1.0/collspace")
public class CollspaceController {
	@Autowired
	private CollspaceManager collspaceManger;
    //
	@RequestMapping(value = "/MyColl/{userid}", method = RequestMethod.GET)
	public @ResponseBody List<CollspaceDto> viewMycoll(@PathVariable("userid") String userid) {
		return collspaceManger.findMyColl(userid);
	}
	//
	@RequestMapping(value = "/Coll/{userid}", method = RequestMethod.GET)
	public @ResponseBody List<CollspaceDto> view(@PathVariable("userid") String userid) {
		return collspaceManger.findByFilter(userid);
	}
	//
	@RequestMapping(value = "/Collopen/{userid}", method = RequestMethod.GET)
	public @ResponseBody List<CollspaceDto> viewOpen(@PathVariable("userid") String userid) {
		return collspaceManger.findOpenColl(userid);
	}
	//
	@RequestMapping(value = "/Collmember/{collspaceid}", method = RequestMethod.GET)
	public @ResponseBody List<CollspaceUserDto> viewmember(@PathVariable("collspaceid") long collspaceid,@RequestParam String type) {
		return collspaceManger.findmember(collspaceid,type);
	}
	//
	@RequestMapping(value = "/Colladmin/{collspaceid}", method = RequestMethod.GET)
	public @ResponseBody List<CollspaceUserDto> viewadmin(@PathVariable("collspaceid") long collspaceid,@RequestParam String type) {
		return collspaceManger.findmember(collspaceid,type);
	}

	//
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void savecoll(@RequestBody CollspaceDto collspace,@RequestParam String type) {
		collspaceManger.savecoll(collspace,type); 
	}
	@RequestMapping(value = "/colldel/{collspaceid}", method = RequestMethod.GET)
	public void del(@PathVariable("collspaceid") long collspaceid) {
		collspaceManger.delOneCollspace(collspaceid);
	}
	
	@RequestMapping(value = "/collone/{collspaceid}", method = RequestMethod.GET)
	public @ResponseBody CollspaceDto viewone(@PathVariable("collspaceid") long collspaceid) {
		return collspaceManger.findoneColl(collspaceid);
	}
	
	//
	@RequestMapping(value = "/addtopic", method = RequestMethod.POST)
	public @ResponseBody CollspaceTopicDto savetopic(@RequestBody CollspaceTopicDto topic,@RequestParam String type) {
		return collspaceManger.saveTopic(topic,type); 
	}
	
	@RequestMapping(value = "/topicall/{collspaceid}", method = RequestMethod.GET)
	public @ResponseBody List<CollspaceTopicDto> viewtopicall(@PathVariable("collspaceid") long collspaceid) {
		return collspaceManger.findalltopic(collspaceid);
	}
	@RequestMapping(value = "/topicone/{topicid}", method = RequestMethod.GET)
	public @ResponseBody CollspaceTopic_RDto viewtopicone(@PathVariable("topicid") long topicid) {
		return collspaceManger.findonetopic(topicid);
	}
	
	@RequestMapping(value = "/addremark", method = RequestMethod.POST)
	public @ResponseBody CollspaceRemarkDto saveremark(@RequestBody CollspaceRemarkDto topic,@RequestParam String type) {
		return collspaceManger.saveRemark(topic,type); 
	}
	
	@RequestMapping(value = "/approvallist/{collspaceid}", method = RequestMethod.GET)
	public List<CollspaceUserDto> approvallist(@PathVariable("collspaceid") long collspaceid,@RequestParam String type) {
		return collspaceManger.findmember(collspaceid,type);
	}
	
	@RequestMapping(value = "/approvalUser/{id}", method = RequestMethod.GET)
	public Boolean approvalUser(@PathVariable("id") long id,@RequestParam String type) {
		return collspaceManger.editUser(id,type);
	}
	
	@RequestMapping(value = "/applyOneCollspace", method = RequestMethod.POST)
	public Boolean applycoll(@RequestBody CollspaceUserDto user) {
		return collspaceManger.applyOneCollspace(user); 
	}
}