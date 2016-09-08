package com.cnnp.social.meeting.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cnnp.social.meeting.manager.MeetingManager;
import com.cnnp.social.meeting.manager.dto.MeetingDto;
import com.cnnp.social.meeting.manager.dto.MeetingRoomDto;
import com.cnnp.social.meeting.manager.dto.MeetingStatus;

@RestController
@RequestMapping("/api/V1.0/meeting")
public class MeetingController {
	@Autowired
	private MeetingManager meetingManager;
	
	
	@RequestMapping(value = "/meeting/addMeeting", method = RequestMethod.POST)
	public MeetingStatus addMeeting(@RequestBody MeetingDto meetingDto,@RequestParam String startdate,@RequestParam String enddate) throws ParseException {
		MeetingStatus status = meetingManager.addMeeting(meetingDto, startdate, enddate);
		return status;
	}
	
	@RequestMapping(value = "/meeting/deleteMeeting", method = RequestMethod.POST)
	public Boolean delMeeting(@RequestParam Long meetingId) {
		return meetingManager.delMeeting(meetingId); 
	}
	
	@RequestMapping(value = "/meeting/listAllMeeting", method = RequestMethod.POST)
	public List<MeetingDto> listAllMeeting(@RequestBody Long userid) {
		return meetingManager.listAllMeeting(userid); 
	}
	
	@RequestMapping(value = "/meeting/listMeetingByDate", method = RequestMethod.POST)
	public List<MeetingDto> listMeetingByDate(@RequestBody Long userid,@RequestParam String startdate,@RequestParam String enddate) throws ParseException {
		return meetingManager.listMeetingByDate(userid, startdate, enddate); 
	}
	
	@RequestMapping(value = "/meeting/addMeetingRoom", method = RequestMethod.POST)
	public MeetingStatus addMeetingRoom(@RequestBody MeetingRoomDto meetingRoomDto) {
		return meetingManager.addMeetingRoom(meetingRoomDto); 
	}
	
	@RequestMapping(value = "/meeting/delMeetingRoom", method = RequestMethod.POST)
	public Boolean delMeetingRoom(@RequestParam Long roomId) {
		return meetingManager.delMeetingRoom(roomId); 
	}
	

	@RequestMapping(value = "/meeting/listMeetingRoom", method = RequestMethod.POST)
	public List<MeetingRoomDto> listMeetingRoom() {
		return meetingManager.listMeetingRoom(); 
	}
}