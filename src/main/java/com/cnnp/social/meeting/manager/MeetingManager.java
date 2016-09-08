package com.cnnp.social.meeting.manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.meeting.manager.dto.MeetingDto;
import com.cnnp.social.meeting.manager.dto.MeetingRoomDto;
import com.cnnp.social.meeting.manager.dto.MeetingStatus;
import com.cnnp.social.meeting.repository.dao.MeetingAttachmentDao;
import com.cnnp.social.meeting.repository.dao.MeetingDao;
import com.cnnp.social.meeting.repository.dao.MeetingRoomDao;
import com.cnnp.social.meeting.repository.entity.TMeeting;
import com.cnnp.social.meeting.repository.entity.TMeetingAttachment;
import com.cnnp.social.meeting.repository.entity.TMeetingRoom;




@EnableTransactionManagement
@Component

public class MeetingManager {
		@Autowired
		private MeetingDao  meetingDao;
		
		@Autowired
		private MeetingAttachmentDao  meetingAttachmentDao;
		
		@Autowired
		private MeetingRoomDao  meetingRoomDao;
		private DozerBeanMapper mapper = new DozerBeanMapper();
		
		private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		@Transactional
		public MeetingStatus addMeetingRoom(MeetingRoomDto meetingRoomDto){
			MeetingStatus status = new MeetingStatus();
			TMeetingRoom tmeetingroom = new TMeetingRoom();
			mapper.map(meetingRoomDto, tmeetingroom);
			meetingRoomDao.save(tmeetingroom); // add new meeting room or update
			status.setStauts("True");
			return status;
		}
	
		public Boolean delMeetingRoom(Long roomId){
			TMeetingRoom roomItem = meetingRoomDao.findOne(roomId);
			if(roomItem==null){
				return false;
			}
			meetingRoomDao.delete(roomId);
			return true;
		}
		
		
		public List<MeetingRoomDto> listMeetingRoom(){
			List<MeetingRoomDto> roomList = new ArrayList<MeetingRoomDto>();
			
			List<TMeetingRoom> roomDaoList = new ArrayList<TMeetingRoom>();
			roomDaoList = (List<TMeetingRoom>) meetingRoomDao.findAll();
			if(roomDaoList.size()>0){
				for(TMeetingRoom tempRoom : roomDaoList){
					MeetingRoomDto roomDto = new MeetingRoomDto();
					mapper.map(tempRoom,roomDto);
					roomList.add(roomDto);
				}
			}
			return roomList;
		}
	
		//TODO meeting 
		//list the all meeting of current user
		public List<MeetingDto> listAllMeeting(Long userid){
			// if user id is null 
			List<MeetingDto> meetinglist = new ArrayList<MeetingDto>();
			if(userid==null){
				System.out.println("the user id is null");
				return null;
			}
			List<TMeeting> templist = new ArrayList<TMeeting>();
			templist = meetingDao.listMeeting(userid);
			
			getMeetingList(meetinglist, templist);
			return meetinglist;
		}
		
		//list the all meeting of current user on 
		public List<MeetingDto> listMeetingByDate(Long userid,String startDate,String endDate) throws ParseException{
			// if user id is null 
			List<MeetingDto> meetinglist = new ArrayList<MeetingDto>();
			if(userid==null){
				System.out.println("the user id is null");
				return null;
			}
			List<TMeeting> templist = new ArrayList<TMeeting>();
			Date startdate = sdf.parse(startDate);
			Date enddate = sdf.parse(endDate);
			templist = meetingDao.listMeetingByDate(userid,startdate,enddate);
			
			getMeetingList(meetinglist, templist);
			return meetinglist;
		}

		/**
		 * @param meetinglist
		 * @param templist
		 * @throws MappingException
		 */
		private void getMeetingList(List<MeetingDto> meetinglist, List<TMeeting> templist) throws MappingException {
			if(templist.size()>0){
				for(TMeeting meeting : templist){
					MeetingDto meetingDto = new MeetingDto();
					
					List<TMeetingAttachment> tempAttachmentlist = new ArrayList<TMeetingAttachment>();
					tempAttachmentlist = meetingAttachmentDao.findByMeetingID(meeting.getId());
					if(tempAttachmentlist.size()>0){
						meeting.setAttchment(tempAttachmentlist);
					}
					mapper.map(meeting, meetingDto);
					meetinglist.add(meetingDto);
				}
			}
		}
		
	
		public MeetingStatus addMeeting(MeetingDto meetingDto,String startDate,String endDate) throws ParseException{
			MeetingStatus status = new MeetingStatus();
			//check if add new or update
			boolean isNew = false;
			if(meetingDto.getId()==null){
				isNew = true;
			}
			//check if the item had stored in DB
			List<TMeeting> templist = new ArrayList<TMeeting>();
			
			Date startdate = sdf.parse(startDate);
			Date enddate = sdf.parse(endDate);
			
			if(isNew){
				templist = meetingDao.listMeetingByDate(meetingDto.getUserid(),startdate,enddate);
				if (templist.size()>0){
					status.setStauts("failed");
					status.setLog("the meeting had recorded on DB");
					return status;
				}
			}
			
			
			//add to DB
			if(isNew){
				if(meetingDao.countMeeting()==0){
					meetingDto.setId((long) 1); 
				}else{
					meetingDto.setId(meetingDao.findmaxid()+1);
				}
			}
			// remove attachmenet
			if(meetingDto.getAttchment().size()>0){
				for(int i=0;i<meetingDto.getAttchment().size();i++){
					List<TMeetingAttachment> attachment = meetingAttachmentDao.findByMeetingID(meetingDto.getId());
					if (attachment != null) {					
						meetingAttachmentDao.delete(attachment);   
					}
				}
			}
			
			
			TMeeting meeting = new TMeeting();
			mapper.map(meetingDto, meeting);
			List<TMeetingAttachment> attachmentlist = new ArrayList<TMeetingAttachment>();
			attachmentlist = meeting.getAttchment();
			
			if(attachmentlist.size()>0){
				for(int i=0;i<attachmentlist.size();i++){
					meeting.getAttchment().get(i).setMeetingid(meeting.getId());
				}
			}
			meetingDao.save(meeting);
			status.setStauts("True");
			return status;
		}
	
		public Boolean delMeeting(Long id){
			TMeeting meetingItem = meetingDao.findOne(id);
			if(meetingItem==null){
				return false;
			}
			meetingDao.delete(id);
			return true;
		}
	
}