package com.cnnp.social.collspace.service;

import java.util.Calendar;
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
import com.cnnp.social.collspace.manager.dto.CollspaceTopicDto;
import com.cnnp.social.collspace.manager.dto.CollspaceRemarkDto;
import com.cnnp.social.collspace.manager.dto.CollspaceTopicDto;
import com.cnnp.social.collspace.manager.dto.CollspaceTopic_RDto;
import com.cnnp.social.collspace.manager.dto.CollspaceUserDto;
import com.cnnp.social.collspace.repository.entity.TCollspaceTopic;



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
	public @ResponseBody List<CollspaceUserDto> viewmember(@PathVariable("collspaceid") long collspaceid) {
		return collspaceManger.findmember(collspaceid,"1");
	}
	//
	@RequestMapping(value = "/Colladmin/{collspaceid}", method = RequestMethod.GET)
	public @ResponseBody List<CollspaceUserDto> viewadmin(@PathVariable("collspaceid") long collspaceid) {
		return collspaceManger.findmember(collspaceid,"2");
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
	
	//查询发帖信息 wzy
	@RequestMapping(value = "/Colltopic/{topicid}",method = RequestMethod.GET)
	@ResponseBody
	public List<CollspaceTopicDto> viewtopic(@PathVariable("topicid")String topicid){
		return collspaceManger.findtopiclist(topicid);
	}
	
	//保存发帖信息wzy
	@RequestMapping(value ="/Colltopic/add",method = RequestMethod.POST)
	@ResponseBody
	public CollspaceTopicDto savetopic(@RequestBody TCollspaceTopic tCollspaceTopic){
		final Calendar today=Calendar.getInstance();
		tCollspaceTopic.setCreatetime(today.getTime());
		tCollspaceTopic.setUpdatetime(today.getTime());
		return collspaceManger.savetopic(tCollspaceTopic);
	}
}