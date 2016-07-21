package com.cnnp.social.schedule.manager;



import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.cnnp.social.schedule.manager.dto.ScheduleDto;
import com.cnnp.social.schedule.manager.dto.SchedulePeopleDto;
import com.cnnp.social.schedule.manager.dto.ScheduleUserIDDto;
import com.cnnp.social.schedule.repository.dao.ScheduleDao;
import com.cnnp.social.schedule.repository.dao.SchedulePeopleDao;

import com.cnnp.social.schedule.repository.entity.TSchedule;
import com.cnnp.social.schedule.repository.entity.TSchedulePeople;

@EnableTransactionManagement
@Component

public class ScheduleManager {
	@Autowired
	private ScheduleDao scheduleDao;
	@Autowired
	private SchedulePeopleDao schedulepeopleDao;
	
	private DozerBeanMapper mapper = new DozerBeanMapper();
	
	
	@Transactional
	public List<SchedulePeopleDto> saveSchedule(List<ScheduleDto> schedules,String startdate,String enddate) {
		if (schedules == null) {
			return new ArrayList<SchedulePeopleDto>();
		}
        long scheduleid = 0;		
		if (schedules.get(0).getid() == null) {	
			scheduleid = scheduleDao.findmaxid() +1;
			for(ScheduleDto scheduledto : schedules){			
				scheduledto.setid(scheduleid);
				scheduledto.getPeople().setScheduleId(scheduleid);
				scheduledto.getPeople().setid(scheduleid);
			}
		}
	    List<SchedulePeopleDto> resultsDtos=new ArrayList<SchedulePeopleDto>();	
	    List<TSchedule> scheduletemps = scheduleDao.finddate(startdate, enddate);
		Boolean peopleflg = false;
	    if (scheduletemps != null) {
	    	for(TSchedule scheduletemp1 : scheduletemps){
	    	    for(ScheduleDto scheduletemp : schedules){
	    	    	
	    	    	System.out.println("scheduletemp1.getid()=" + scheduletemp1.getid());  
	    	    	System.out.println("scheduletemp.getid()=" + scheduletemp.getid()); 
	    	    	if (scheduletemp1.getid() != scheduletemp.getid()) {
	    	    		TSchedulePeople people = schedulepeopleDao.finduseridone(scheduletemp1.getid(),scheduletemp.getPeople().getUserid());
		 	    		if (people != null) {
		 	    			Boolean flg = true;		 	    			 
		 	    			for(SchedulePeopleDto resultsDto : resultsDtos){	 
		 	    				if (resultsDto.getUserid().equals(people.getUserid())) {
		 	    					flg = false;
		 	    				}
		 	    			}
		 	    			
		 	    			if (flg) {	
		 	    				SchedulePeopleDto dto=new SchedulePeopleDto();				
			 				    mapper.map(scheduletemp.getPeople(), dto);
			 	    			resultsDtos.add(dto);
			 	    			peopleflg = true;
		 	    			}		 	    			
		 	    		}
	    	    	}	 	    		
	 		    }	 	    	
	 	    }
	    }
	    if (peopleflg) {	
	    	return resultsDtos;
	    }
	    
		List<TSchedulePeople> peoples = schedulepeopleDao.find(schedules.get(0).getid());
		if (peoples != null) {			
			//schedulepeopleDao.deleteid(schedules.get(0).getid());
			for(TSchedulePeople people : peoples){
				SchedulePeopleDto dto=new SchedulePeopleDto();				
			    mapper.map(people, dto);
			    schedulepeopleDao.delete(dto.getid());   			   
			}	
		}
		List<TSchedulePeople> peoplesEntry = new  ArrayList<TSchedulePeople>();
		TSchedule scheduleEntry = new TSchedule();
		for(ScheduleDto scheduledto : schedules){		
			mapper.map(scheduledto, scheduleEntry);
			SchedulePeopleDto peopleDto = scheduledto.getPeople();		
			if (peopleDto != null) {			
				TSchedulePeople schedulepeopleEntry = new TSchedulePeople();
				mapper.map(peopleDto, schedulepeopleEntry);
				if (scheduleEntry.getPeople() == null) {
					scheduleEntry.setPeople(new ArrayList<TSchedulePeople>());				
				}
				peoplesEntry.add(schedulepeopleEntry);
				scheduleEntry.getPeople().addAll(peoplesEntry);
			}		
					
		}
		scheduleDao.save(scheduleEntry);
	    return resultsDtos;
	}
	
	
	public void saveSchedule(List<ScheduleDto> schedules) {
		if (schedules == null) {
			return;
		}
		long scheduleid = 0;
		
		if (schedules.get(0).getid() == null) {	
			scheduleid = scheduleDao.findmaxid() +1;
			for(ScheduleDto scheduledto : schedules){			
				scheduledto.setid(scheduleid);
				scheduledto.getPeople().setScheduleId(scheduleid);
			}
		}
		List<TSchedulePeople> peoples = schedulepeopleDao.find(schedules.get(0).getid());
		if (peoples != null) {			
			for(TSchedulePeople people : peoples){
				SchedulePeopleDto dto=new SchedulePeopleDto();				
			    mapper.map(people, dto);
			    schedulepeopleDao.delete(dto.getid());   			   
			}	
		}
		
		List<TSchedulePeople> peoplesEntry = new  ArrayList<TSchedulePeople>();
		TSchedule scheduleEntry = new TSchedule();
		for(ScheduleDto scheduledto : schedules){			
			mapper.map(scheduledto, scheduleEntry);
			SchedulePeopleDto peopleDto = scheduledto.getPeople();		
			if (peopleDto != null) {			
				TSchedulePeople schedulepeopleEntry = new TSchedulePeople();
				mapper.map(peopleDto, schedulepeopleEntry);
				if (scheduleEntry.getPeople() == null) {
					scheduleEntry.setPeople(new ArrayList<TSchedulePeople>());				
				}
				
				peoplesEntry.add(schedulepeopleEntry);
				scheduleEntry.getPeople().addAll(peoplesEntry);
			}			
		}
		scheduleDao.save(scheduleEntry);
		return;
	}
	
	public List<ScheduleDto> findSchedulepeoples(Long id){
		TSchedule scheduleEntry = scheduleDao.findOne(id);
		if(scheduleEntry==null){
			return new ArrayList<ScheduleDto>();
		}
		List<ScheduleDto> scheduleDtos=new ArrayList<ScheduleDto>();
		List<TSchedulePeople> peoples = schedulepeopleDao.find(scheduleEntry.getid());
		if (peoples == null || peoples.size() < 1) {
			return scheduleDtos;
		}
		for(TSchedulePeople people : peoples){
			SchedulePeopleDto dto=new SchedulePeopleDto();
			ScheduleDto scheduledto=new ScheduleDto();
			mapper.map(scheduleEntry, scheduledto);
		    mapper.map(people, dto);
		    scheduledto.setPeople(dto);		   
		    scheduleDtos.add(scheduledto);
		}
		return scheduleDtos;		
	}
	
	public List<ScheduleDto> findUserAllSchedule(List<ScheduleUserIDDto> users){	
		List<ScheduleDto> scheduleDtos=new ArrayList<ScheduleDto>();	
		for(ScheduleUserIDDto userdto : users){			
			List<TSchedulePeople> schedulepeopleEntries = schedulepeopleDao.finduserid(userdto.getUserid());
	
			for(TSchedulePeople user : schedulepeopleEntries){
				SchedulePeopleDto schedulePeopleDto = new SchedulePeopleDto();
				mapper.map(user, schedulePeopleDto);
				TSchedule scheduleEntry = scheduleDao.findOne(schedulePeopleDto.getScheduleId());
				ScheduleDto scheduledto=new ScheduleDto();
				mapper.map(scheduleEntry, scheduledto);
				scheduledto.setPeople(schedulePeopleDto);
				scheduleDtos.add(scheduledto);					
			}		
			
		}
		
		return scheduleDtos;			
	}
	public List<ScheduleDto> findUserAllSchedule(String userid){	
		List<ScheduleDto> scheduleDtos=new ArrayList<ScheduleDto>();				
			List<TSchedulePeople> schedulepeopleEntries = schedulepeopleDao.finduserid(userid);
	
			for(TSchedulePeople user : schedulepeopleEntries){
				SchedulePeopleDto schedulePeopleDto = new SchedulePeopleDto();
				mapper.map(user, schedulePeopleDto);
				TSchedule scheduleEntry = scheduleDao.findOne(schedulePeopleDto.getScheduleId());
				ScheduleDto scheduledto=new ScheduleDto();
				mapper.map(scheduleEntry, scheduledto);
				scheduledto.setPeople(schedulePeopleDto);
				scheduleDtos.add(scheduledto);					
			}		
			
		return scheduleDtos;			
	}
	public List<ScheduleDto> findUserDateSchedule(List<ScheduleUserIDDto> userids,String startdate,String enddate){
		List<ScheduleDto> scheduleDtos=new ArrayList<ScheduleDto>();
		for(ScheduleUserIDDto userid : userids){
			List<TSchedulePeople> schedulepeopleEntries = schedulepeopleDao.finduserid(userid.getUserid());
			for(TSchedulePeople user : schedulepeopleEntries){
				SchedulePeopleDto schedulePeopleDto = new SchedulePeopleDto();
				mapper.map(user, schedulePeopleDto);
				TSchedule scheduleEntry = scheduleDao.finddate(schedulePeopleDto.getScheduleId(),startdate,enddate);
				if(scheduleEntry!=null){
					ScheduleDto scheduledto=new ScheduleDto();
					mapper.map(scheduleEntry, scheduledto);
					scheduledto.setPeople(schedulePeopleDto);
					scheduleDtos.add(scheduledto);	
				}							
			}		
		}		
		return scheduleDtos;			
	}
	public List<ScheduleDto> findUserDateSchedule(String userid,String startdate,String enddate){
		List<ScheduleDto> scheduleDtos=new ArrayList<ScheduleDto>();
			List<TSchedulePeople> schedulepeopleEntries = schedulepeopleDao.finduserid(userid);
			for(TSchedulePeople user : schedulepeopleEntries){
				SchedulePeopleDto schedulePeopleDto = new SchedulePeopleDto();
				mapper.map(user, schedulePeopleDto);
				TSchedule scheduleEntry = scheduleDao.finddate(schedulePeopleDto.getScheduleId(),startdate,enddate);
				if(scheduleEntry!=null){
					ScheduleDto scheduledto=new ScheduleDto();
					mapper.map(scheduleEntry, scheduledto);
					scheduledto.setPeople(schedulePeopleDto);
					scheduleDtos.add(scheduledto);	
				}							
			}		
				
		return scheduleDtos;			
	}
	public List<ScheduleDto> findCompanySchedule(String companyid,String peopletype,String startdate,String enddate){
		List<TSchedulePeople> schedulepeopleEntries = schedulepeopleDao.findcompany(companyid, peopletype);
		if(schedulepeopleEntries==null){
			return new ArrayList<ScheduleDto>();
		}
		List<ScheduleDto> scheduleDtos=new ArrayList<ScheduleDto>();
		
		for(TSchedulePeople user : schedulepeopleEntries){
			SchedulePeopleDto schedulePeopleDto = new SchedulePeopleDto();
			mapper.map(user, schedulePeopleDto);
			TSchedule scheduleEntry = scheduleDao.finddate(schedulePeopleDto.getScheduleId(),startdate,enddate);
			if(scheduleEntry!=null){
				ScheduleDto scheduledto=new ScheduleDto();
				mapper.map(scheduleEntry, scheduledto);
				scheduledto.setPeople(schedulePeopleDto);
				scheduleDtos.add(scheduledto);
			}
		}		
		return scheduleDtos;			
	}
	
	public ScheduleDto findPeopleOneSchedule(Long id,String userid){
		TSchedule scheduleEntry = scheduleDao.findOne(id);
		if(scheduleEntry==null){
			return new ScheduleDto();
		}
		
		ScheduleDto scheduledto=new ScheduleDto();
		mapper.map(scheduleEntry, scheduledto);
		TSchedulePeople people = schedulepeopleDao.finduseridone(id, userid);
		if (people == null) {
			return new ScheduleDto();
		}
		SchedulePeopleDto schedulePeopleDto = new SchedulePeopleDto();
		mapper.map(people, schedulePeopleDto);
		scheduledto.setPeople(schedulePeopleDto);		
		return scheduledto;		
	}
	
	public List<SchedulePeopleDto> findCompanyPeoples(String companyid,String peopletype,String startdate,String enddate){
		List<TSchedulePeople> schedulepeopleEntries = schedulepeopleDao.findcompany(companyid, peopletype);
		if(schedulepeopleEntries==null){
			return new ArrayList<SchedulePeopleDto>();
		}
		List<SchedulePeopleDto> schedulePeopleDtos=new ArrayList<SchedulePeopleDto>();
		for(TSchedulePeople user : schedulepeopleEntries){
			SchedulePeopleDto schedulePeopleDto = new SchedulePeopleDto();
			mapper.map(user, schedulePeopleDto);
			TSchedule scheduleEntry = scheduleDao.finddate(schedulePeopleDto.getScheduleId(),startdate,enddate);
			if(scheduleEntry!=null){				
				schedulePeopleDtos.add(schedulePeopleDto);
			}
		}		
		return schedulePeopleDtos;			
	}
	
	
	public List<SchedulePeopleDto> findCompanyPeoples(String companyid,String collid,String type){
		List<TSchedulePeople> schedulepeopleEntries = new ArrayList<TSchedulePeople>();
		List<SchedulePeopleDto> schedulePeopleDtos=new ArrayList<SchedulePeopleDto>();
		if(type.equals("0")){
			 schedulepeopleEntries = schedulepeopleDao.findcompanyuser(companyid, "1");			
		}		
		if(type.equals("1")){
			 schedulepeopleEntries = schedulepeopleDao.findcompanyuser(companyid);
		}
		if(type.equals("2")){			
			schedulepeopleEntries = schedulepeopleDao.findcolluser(collid);
		}		
		if(schedulepeopleEntries==null){
			return new ArrayList<SchedulePeopleDto>();
		}
		for(TSchedulePeople user : schedulepeopleEntries){
			SchedulePeopleDto schedulePeopleDto = new SchedulePeopleDto();
			mapper.map(user, schedulePeopleDto);									
			schedulePeopleDtos.add(schedulePeopleDto);					
		}	
		return schedulePeopleDtos;
	}
	
	public Boolean delOneSchedule(Long id){
	
		TSchedule scheduleEntry = scheduleDao.findOne(id);
		if(scheduleEntry==null){
			return false;
		}
		
		List<TSchedulePeople> peoples = schedulepeopleDao.find(id);
		if (peoples != null ) {	
			for(TSchedulePeople people : peoples){
				SchedulePeopleDto dto=new SchedulePeopleDto();				
			    mapper.map(people, dto);
			    schedulepeopleDao.delete(dto.getid());   			   
			}			
		}		
		scheduleDao.delete(id);
		return true;
	}	
	
	public List<ScheduleDto> findCompanySchedules(String userid,String companyid,String collid,String type,String startdate,String enddate){
		
		List<TSchedulePeople> schedulepeopleEntries = new ArrayList<TSchedulePeople>();
		List<ScheduleDto> scheduleDtos=new ArrayList<ScheduleDto>();
		if(type.equals("0")){
			 schedulepeopleEntries = schedulepeopleDao.findcompany(companyid, "1");
			 if(schedulepeopleEntries==null){
					return new ArrayList<ScheduleDto>();
				}
		}		
		if(type.equals("1")){
			 schedulepeopleEntries = schedulepeopleDao.findcompany(companyid);
			 if(schedulepeopleEntries==null){
					return new ArrayList<ScheduleDto>();
				}
		}
		if(type.equals("2")){			
			List<TSchedule> scheduleEntry = scheduleDao.findcolldate(collid,startdate,enddate);
			 if(scheduleEntry==null){
				return new ArrayList<ScheduleDto>();
			 }	
			 for(TSchedule schedule : scheduleEntry){
				 List<TSchedulePeople> peoples = schedulepeopleDao.find(schedule.getid());
				 if (peoples == null || peoples.size() < 1) {
						return scheduleDtos;
					}
					for(TSchedulePeople people : peoples){
						SchedulePeopleDto dto=new SchedulePeopleDto();
						ScheduleDto scheduledto=new ScheduleDto();
						mapper.map(schedule, scheduledto);
					    mapper.map(people, dto);
					    scheduledto.setPeople(dto);		   
					    scheduleDtos.add(scheduledto);
					}
			 }
			//List<ScheduleDto> scheduleDtos=new ArrayList<ScheduleDto>();					
			return scheduleDtos;			 
		}		
		for(TSchedulePeople user : schedulepeopleEntries){
			SchedulePeopleDto schedulePeopleDto = new SchedulePeopleDto();
			mapper.map(user, schedulePeopleDto);
			TSchedule scheduleEntry = new TSchedule();
			scheduleEntry = scheduleDao.finddate(schedulePeopleDto.getScheduleId(),startdate,enddate);		
			if(scheduleEntry!=null){
				ScheduleDto scheduledto=new ScheduleDto();
				mapper.map(scheduleEntry, scheduledto);
				scheduledto.setPeople(schedulePeopleDto);
				scheduleDtos.add(scheduledto);
			}
		}		
		return scheduleDtos;			
	}	
}