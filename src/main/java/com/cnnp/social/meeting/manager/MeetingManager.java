package com.cnnp.social.meeting.manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.dozer.DozerBeanMapper;
import org.dozer.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.meeting.manager.dto.MeetingAttachmentDto;
import com.cnnp.social.meeting.manager.dto.MeetingDto;
import com.cnnp.social.meeting.manager.dto.MeetingInputDto;
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
		private JdbcTemplate jdbcTemplate;
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
		
//		//list the all meeting of current user on 
//		public List<MeetingDto> listMeetingByDate(Long userid,String startDate,String endDate) throws ParseException{
//			// if user id is null 
//			List<MeetingDto> meetinglist = new ArrayList<MeetingDto>();
//			if(userid==null){
//				System.out.println("the user id is null");
//				return null;
//			}
//			List<TMeeting> templist = new ArrayList<TMeeting>();
//			Date startdate = sdf.parse(startDate);
//			Date enddate = sdf.parse(endDate);
//			templist = meetingDao.listMeetingByDate(userid,startdate,enddate);
//			
//			getMeetingList(meetinglist, templist);
//			return meetinglist;
//		}

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
		
	
		public MeetingStatus addMeeting(MeetingInputDto meetingDto) throws ParseException{
			MeetingStatus status = new MeetingStatus();
			//check if add new or update
			boolean isNew = false;
			if(meetingDto.getId()==null){
				isNew = true;
			}
			//check if the item had stored in DB
			List<TMeeting> templist = new ArrayList<TMeeting>();
			
			Date startdate = sdf.parse(meetingDto.getStartdate());
			Date enddate = sdf.parse(meetingDto.getEnddate());
			
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
			meeting.setId(meetingDto.getId());
			meeting.setRoomid(meetingDto.getRoomid());
			meeting.setArea(meetingDto.getArea());
			meeting.setChairman(meetingDto.getChairman());
			meeting.setContent(meetingDto.getContent());
			meeting.setDepartment(meetingDto.getDepartment());
			meeting.setOtherpeople(meetingDto.getOtherpeople());
			meeting.setScope(meetingDto.getScope());
			meeting.setReferencepeople(meetingDto.getReferencepeople());
			meeting.setTopic(meetingDto.getTopic());
			meeting.setStartdate(startdate);
			meeting.setEnddate(enddate);
			meeting.setUserid(meetingDto.getUserid());
			List<TMeetingAttachment> attachlist = new ArrayList<TMeetingAttachment>();
			for(MeetingAttachmentDto attachment : meetingDto.getAttchment()){
				TMeetingAttachment attach = new TMeetingAttachment();
				mapper.map(attachment, attach);
				attachlist.add(attach);
			}
			meeting.setAttchment(attachlist);
			
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
		
		public List<MeetingDto> getMeetingByDto(MeetingInputDto dto){
			
			List<MeetingDto> meetinglist = new ArrayList<MeetingDto>();
			StringBuffer sql = new StringBuffer("select id,roomid,topic,department,area,chairman,scope,referencepeople,otherpeople,content,userid,startdate,enddate from MEETING where 1=1 ");
			StringBuffer query = new StringBuffer();
			if(dto.getId()!=null && (!"".equals(dto.getId()))){
				sql.append(" and id=" + dto.getId());
			}
			
			if(dto.getRoomid()!=null && (!"".equals(dto.getRoomid()))){
				
				sql.append(" and roomid=" + dto.getRoomid());
			}
			
			if(dto.getUserid()!=null && (!"".equals(dto.getUserid()))){
				sql.append(" and userid=" + dto.getUserid());
			}
			
			if(dto.getTopic()!=null && (!"".equals(dto.getTopic().trim()))){
				query.append(" and topic='" +dto.getTopic() +"'");
			}
			
			if(dto.getDepartment()!=null && (!"".equals(dto.getDepartment().trim()))){
				query.append(" and department='" +dto.getDepartment() +"'");
			}
			
			if(dto.getArea()!=null && (!"".equals(dto.getArea().trim()))){
				query.append(" and area='" +dto.getArea() +"'");
			}
			
			if(dto.getChairman()!=null && (!"".equals(dto.getChairman().trim()))){
				query.append(" and chairman='" +dto.getChairman() +"'");
			}
			
			if(dto.getScope()!=null && (!"".equals(dto.getScope().trim()))){
				query.append(" and scope='" +dto.getScope() +"'");
			}
			
			if(dto.getReferencepeople()!=null && (!"".equals(dto.getReferencepeople().trim()))){
				query.append(" and referencepeople='" +dto.getReferencepeople() +"'");
			}
			
			if(dto.getOtherpeople()!=null && (!"".equals(dto.getOtherpeople().trim()))){
				query.append(" and otherpeople='" +dto.getOtherpeople() +"'");
			}
			
			if(dto.getContent()!=null && (!"".equals(dto.getContent().trim()))){
				query.append(" and content='" +dto.getContent() +"'");
			}
			
			if(dto.getStartdate()!=null && (!"".equals(dto.getStartdate().trim()))){
				query.append(" and startdate=to_date('" + dto.getStartdate()+"','yyyy-mm-dd hh24:mi:ss')");
			}
			
			if(dto.getEnddate()!=null && (!"".equals(dto.getEnddate().trim()))){
				query.append(" and enddate=to_date('" + dto.getEnddate()+"','yyyy-mm-dd hh24:mi:ss')");
			}

			sql.append(query);
			
			List<Map<String,Object>> querylist ;
			
			querylist =jdbcTemplate.queryForList(sql.toString());
			
			if(querylist==null || querylist.size()==0){
				return null;
			}
			
			for(int i=0;i<querylist.size();i++){
				MeetingDto meetingDto = new MeetingDto();
				meetingDto.setId(Long.parseLong((String) querylist.get(i).get("id")));
				meetingDto.setUserid(Long.parseLong((String) querylist.get(i).get("userid")));
				meetingDto.setRoomid(Long.parseLong((String) querylist.get(i).get("roomid")));
				meetingDto.setScope((String)querylist.get(i).get("scope"));
				
				meetingDto.setTopic((String)querylist.get(i).get("topic"));
				meetingDto.setContent((String)querylist.get(i).get("content"));
				meetingDto.setDepartment((String)querylist.get(i).get("department"));
				meetingDto.setArea((String)querylist.get(i).get("area"));
				
				meetingDto.setChairman((String)querylist.get(i).get("chairman"));
				meetingDto.setReferencepeople((String)querylist.get(i).get("referencepeople"));
				meetingDto.setOtherpeople((String)querylist.get(i).get("otherpeople"));
				meetingDto.setStartdate((Date) querylist.get(i).get("startdate"));
				meetingDto.setEnddate((Date) querylist.get(i).get("enddate"));
				
				List<MeetingAttachmentDto> attachmnetlist = new ArrayList<MeetingAttachmentDto>();
				
				List<TMeetingAttachment> tempAttachmentlist = new ArrayList<TMeetingAttachment>();
				tempAttachmentlist = meetingAttachmentDao.findByMeetingID(meetingDto.getId());
				
				for(TMeetingAttachment attach : tempAttachmentlist){
					
					MeetingAttachmentDto attachment = new MeetingAttachmentDto();
					mapper.map(attach, attachment);
					meetingDto.getAttchment().add(attachment);
					//attachmnetlist.add(attachment);
				}
				//meetingDto.setAttchment(attachmnetlist);
				meetinglist.add(meetingDto);
			}
			
			return meetinglist;
		}
	
}