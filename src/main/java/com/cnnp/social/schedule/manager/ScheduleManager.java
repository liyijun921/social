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
	public void saveSchedule(ScheduleDto schedule) {
		if (schedule == null) {
			return;
		}
		TSchedule scheduleEntry = new TSchedule();
		mapper.map(schedule, scheduleEntry);
		SchedulePeopleDto peopleDto = schedule.getPeople();		
		if (peopleDto != null) {			
			TSchedulePeople schedulepeopleEntry = new TSchedulePeople();
			mapper.map(peopleDto, schedulepeopleEntry);
			if (scheduleEntry.getPeople() == null) {
				scheduleEntry.setPeople(new ArrayList<TSchedulePeople>());				
			}
			scheduleEntry.getPeople().add(schedulepeopleEntry);
		}
		scheduleEntry = scheduleDao.save(scheduleEntry);		
	}
	
	
	public void saveSchedule(List<ScheduleDto> schedules) {
		if (schedules == null) {
			return;
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
	
	public List<ScheduleDto> findUserAllSchedule(String userid){
		List<TSchedulePeople> schedulepeopleEntries = schedulepeopleDao.finduserid(userid);
		if(schedulepeopleEntries==null){
			return new ArrayList<ScheduleDto>();
		}
		List<ScheduleDto> scheduleDtos=new ArrayList<ScheduleDto>();		
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
	
	public List<ScheduleDto> findUserDateSchedule(String userid,String startdate,String enddate){
		List<TSchedulePeople> schedulepeopleEntries = schedulepeopleDao.finduserid(userid);
		if(schedulepeopleEntries==null){
			return new ArrayList<ScheduleDto>();
		}
		List<ScheduleDto> scheduleDtos=new ArrayList<ScheduleDto>();		
		for(TSchedulePeople user : schedulepeopleEntries){
			SchedulePeopleDto schedulePeopleDto = new SchedulePeopleDto();
			mapper.map(user, schedulePeopleDto);
			TSchedule scheduleEntry = scheduleDao.findate(schedulePeopleDto.getScheduleId(),startdate,enddate);
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
			TSchedule scheduleEntry = scheduleDao.findate(schedulePeopleDto.getScheduleId(),startdate,enddate);
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
	
	
	public void delOneSchedule(Long id){
	
		TSchedule scheduleEntry = scheduleDao.findOne(id);
		if(scheduleEntry==null){
			return;
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
		return;
	}	
	
}