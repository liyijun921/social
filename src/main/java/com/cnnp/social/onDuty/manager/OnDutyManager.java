package com.cnnp.social.onDuty.manager;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cnnp.social.onDuty.manager.dto.DutyImportDto;
import com.cnnp.social.onDuty.manager.dto.DutyStatus;
import com.cnnp.social.onDuty.manager.dto.DutyUserDto;
import com.cnnp.social.onDuty.manager.dto.OnDutyDto;
import com.cnnp.social.onDuty.repository.dao.OnDutyDao;
import com.cnnp.social.onDuty.repository.dao.OnDutyImportDao;
import com.cnnp.social.onDuty.repository.dao.OnDutyUserDao;
import com.cnnp.social.onDuty.repository.entity.TDuty;
import com.cnnp.social.onDuty.repository.entity.TDutyImport;
import com.cnnp.social.onDuty.repository.entity.TDutyUser;



@EnableTransactionManagement
@Component

public class OnDutyManager {
	@Autowired
	private OnDutyDao  onDutyDao;
	
	@Autowired
	private OnDutyImportDao  onDutyImportDao;
	
	@Autowired
	private OnDutyUserDao  onDutyUserDao;
	private DozerBeanMapper mapper = new DozerBeanMapper();
	
	private Workbook wb;  
    private Sheet sheet;  
    private Row row;  
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Transactional
	public DutyStatus addDuty(OnDutyDto onDutyDto,String starDate,String endDate){
		DutyStatus status = new DutyStatus();
		if(onDutyDto==null){
			status.setStauts("False");
			status.setLog("the object is null");
			return status;
		}
		long dutyId = 0;
		TDuty onDuty = new TDuty();
		//if the first add duty, will set a new id. else use the duty form's id.
		if(onDutyDto.getId() == null){
			if(onDutyDao.countDuty()==0){
				dutyId = 1;
			}else{
				dutyId = onDutyDao.findmaxid() +1;
			}
			onDutyDto.setId(dutyId);
		}
		// has records on the dutyuser
		List<DutyUserDto> userlist = checkUser(onDutyDto, starDate, endDate);
		if(userlist.size()==0){
			status.setStauts("False");
			status.setLog("user had added before");
			return status;
		}
		onDutyDto.setUser(userlist);
		for(int i=0;i<onDutyDto.getUser().size();i++){
			
			onDutyDto.getUser().get(i).setDutyid(onDutyDto.getId());
		}
		
		//check if there are old duty or not, if has will delete the record first and add it later.
		if(delDuty(onDutyDto)){
			System.out.println("the conference records which id is  " + onDutyDto.getId() + " are deleted");
		};
		
		mapper.map(onDutyDto,onDuty);
		onDutyDao.save(onDuty);
		status.setStauts("True");
		return status;
	}

	private List<DutyUserDto> checkUser(OnDutyDto onDutyDto, String starDate, String endDate) {
		List<DutyUserDto> userlist = new ArrayList<DutyUserDto>();
		for(DutyUserDto tempUser : onDutyDto.getUser()){
			TDutyUser user = new TDutyUser();
			mapper.map(tempUser, user);
			List<TDutyUser> tempList = onDutyUserDao.finduser(user.getUserid(), starDate, endDate);
			if(tempList.size()==0){
				userlist.add(tempUser);
			}
		}
		return userlist;
	}
	
	public Boolean delDuty(OnDutyDto onDutyDto){
		TDuty dutyItem = onDutyDao.findOne(onDutyDto.getId());
		if(dutyItem==null){
			return false;
		}
		onDutyDao.delete(onDutyDto.getId());
		return true;
	}
	
	
	public List<OnDutyDto> listDutyAll(){
		List<OnDutyDto> dutyDtoList = new ArrayList<OnDutyDto>();
		
		List<TDuty> dutyList = new ArrayList<TDuty>();
		dutyList = (List<TDuty>) onDutyDao.findAll();
		for(TDuty tempDuty : dutyList){
			OnDutyDto onDutyDto = new OnDutyDto();
			mapper.map(tempDuty,onDutyDto);
			dutyDtoList.add(onDutyDto);
		}
		return dutyDtoList;
	}
	
	public List<OnDutyDto> listDutyByUser(DutyUserDto dutyUser){
		// if user id is null 
		if(dutyUser.getUserid()==null||"".equals(dutyUser.getUserid())){
			System.out.println("the user id is null");
			return null;
		}
		
		
		List<OnDutyDto> dutyList = new ArrayList<OnDutyDto>();
		TDutyUser user = new TDutyUser();
		List<TDutyUser> dutyUserlist = new ArrayList<TDutyUser>();
		mapper.map(dutyUser,user);
		// get user list
		dutyUserlist = onDutyUserDao.findByUserId(user.getUserid());
		if(dutyUserlist.size()==0){
			System.out.println("the user id has not recorded");
			return null;
		}else{
			for(TDutyUser tempUser : dutyUserlist){
				OnDutyDto onDutyDto = new OnDutyDto();
				// get duty by duty id
				TDuty duty = onDutyDao.findOne(tempUser.getDutyid());
				if(duty==null){
					System.out.println("duty is null");
					return null;
				}
				dutyUserlist.clear();
				dutyUserlist.add(user);
				duty.setUser(dutyUserlist);
				mapper.map(duty, onDutyDto);
				dutyList.add(onDutyDto);
			}
		}
		return dutyList;
	}
	
	public List<OnDutyDto> listDutyByDate(Long userid,String startdate,String enddate ){
		
		if("".equals(startdate)||(startdate==null)){
			System.out.println("the start date is null");
			return null;
		}
		if("".equals(enddate)||(enddate==null)){
			System.out.println("the end date is null");
			return null;
		}
		if( "".equals(userid)||userid==null){
			System.out.println("user id is null");
			return null;
		}
		
		
		List<OnDutyDto> dutyDtoList = new ArrayList<OnDutyDto>();
		
		List<DutyUserDto> dutyUserDtoList = new ArrayList<DutyUserDto>();
		
		List<TDutyUser> dutyUserlist = new ArrayList<TDutyUser>();
		
		//TODO get user list
		dutyUserlist =  onDutyUserDao.finduser(userid,startdate,enddate);
		
		// get the duty list by duty id
		for(TDutyUser tempDutyUser : dutyUserlist){
			DutyUserDto dutyUser = new DutyUserDto();
			mapper.map(tempDutyUser, dutyUser);
			TDuty duty = onDutyDao.findOne(dutyUser.getDutyid());
			
			OnDutyDto dutyDto = new OnDutyDto();
			mapper.map(duty, dutyDto);
			dutyUserDtoList.add(dutyUser);
			dutyDto.setUser(dutyUserDtoList);
			dutyDtoList.add(dutyDto);
										
		}
		return dutyDtoList;
	}
	
	
	public OnDutyDto listDutyByDutyId(Long dutyID){
		OnDutyDto duty = new OnDutyDto();
		
		TDuty tempDuty = onDutyDao.findOne(dutyID);
		
		if(tempDuty == null){
			return duty;
		}
		
		List<DutyUserDto> userList = new ArrayList<DutyUserDto>();
		
		List<TDutyUser> tempUserlist = new ArrayList<TDutyUser>();
		
		DutyUserDto user = new DutyUserDto();
		
		tempUserlist = onDutyUserDao.findByDutyId(dutyID);
		
		for(TDutyUser tempUser : tempUserlist){
			mapper.map(tempUser, user);
			userList.add(user);
		}
		mapper.map(tempDuty, duty);
		duty.setUser(userList);
		return duty;
	}
	
	public DutyStatus importDutyInfoToDB(){
		DutyStatus status = new DutyStatus();
		
		List<TDutyImport> tempDutyList = new ArrayList<TDutyImport>();
		// read temp table 
		tempDutyList = (List<TDutyImport>) onDutyImportDao.findAll();
		
		List<DutyImportDto> userlist = new ArrayList<DutyImportDto>();
		
		List<DutyImportDto> unImportList = new ArrayList<DutyImportDto>();
		
		//check if there are reduplicate items on DB
		for(TDutyImport tempDuty : tempDutyList){
			DutyImportDto duty = new DutyImportDto();
			mapper.map(tempDuty, duty);
			List<TDutyUser> dutyUserList = new ArrayList<TDutyUser>();
			dutyUserList = onDutyUserDao.finduser(tempDuty.getUserid(), tempDuty.getStartdate(), tempDuty.getEnddate());
			if(dutyUserList.size()==0){
				userlist.add(duty);
			}else{
				unImportList.add(duty);
			}
		}
		if(userlist.size()==0){
			status.setStauts("False");
			status.setLog("import items were all imported to DB!");
			if(unImportList.size()>0){
				status.setUnImportList(unImportList);
			}
			onDutyImportDao.deleteAll();
			return status;
		}
		
		// add items to DB
		long dutyId = 0;
		for(DutyImportDto dutyItem : userlist){
			try {
				if(onDutyDao.countDuty()==0){
					dutyId = 1;
				}else{
					dutyId = onDutyDao.findmaxid() +1;
				}
				Date startDate = sdf.parse(dutyItem.getStartdate());
				Date endDate = sdf.parse(dutyItem.getEnddate());
				TDutyUser tUser = new TDutyUser();
				TDuty tDuty = new TDuty();
				List<TDutyUser> userList = new ArrayList<TDutyUser>();
				String companyId = (dutyItem.getCompanyid()==null||"".equals(dutyItem.getCompanyid().trim()))?"":dutyItem.getCompanyid().trim();
				String description = (dutyItem.getDescription()==null||"".equals(dutyItem.getDescription().trim()))?"":dutyItem.getDescription().trim();
				String responsibleDepartment = (dutyItem.getResponsibledepartment()==null||"".equals(dutyItem.getResponsibledepartment().trim()))?"":dutyItem.getResponsibledepartment().trim();
				String userName = (dutyItem.getUsername()==null||"".equals(dutyItem.getUsername().trim()))?"":dutyItem.getUsername().trim();
				tDuty.setCompanyid(companyId);
				tDuty.setDescription(description);
				tDuty.setResponsibledepartment(responsibleDepartment);
				tDuty.setUsername(userName);
				tDuty.setUserid(dutyItem.getUserid());
				tDuty.setStartdate(startDate);
				tDuty.setEnddate(endDate);
				tDuty.setId(dutyId);
				tUser.setDutyid(dutyId);
				tUser.setUserid(dutyItem.getUserid());
				tUser.setUsername(userName);
				tUser.setCompanyid(companyId);
				tUser.setDescription(description);
				tUser.setStartdate(startDate);
				tUser.setEnddate(endDate);
				userList.add(tUser);
				tDuty.setUser( userList);
				// add record to duty table 
				onDutyDao.save(tDuty);
				// remove the item of temp table
//				onDutyImportDao.deleteItem(dutyItem.getUserid(),dutyItem.getStartdate(),dutyItem.getEnddate());
				
			} catch (ParseException e) {
				e.printStackTrace();
			}	
		}
		status.setStauts("Ture");
		status.setUnImportList(unImportList);
		onDutyImportDao.deleteAll();
		return status;
	}
	
	public DutyStatus readFile(MultipartFile file) throws Exception {
		
		DutyStatus status = new DutyStatus();
		
		List<DutyImportDto> dutyList = new ArrayList<DutyImportDto>();
		
		//check if the file is exist
		if(file.isEmpty()||file ==null){
			status.setStauts("False");
			status.setLog("the file is null");
			return status;
		}
		
		//check if the file is xls or xlsx
		String name  = file.getOriginalFilename();
		int beginIndex = name.indexOf(".");
		int endIndex = name.length();
		String suffix = name.substring(beginIndex,endIndex);
		if(!".xls".equals(suffix)&&!".xlsx".equals(suffix)){
			status.setStauts("False");
			status.setLog("the file is not excel");
			return status;
		}
		//read xls or xlsx
		dutyList = readExcel(file,suffix);
		
		// update the status
		status.setStauts("True");
		status.setImportList(dutyList);
		
		return status;
	}
	
	public DutyStatus importFile(List<DutyImportDto> importList){
		//save the return list to temp table
		DutyStatus status = new DutyStatus();
		try{
			for (DutyImportDto dutyItem : importList){
				TDutyImport item = new TDutyImport();
				mapper.map(dutyItem, item);
				onDutyImportDao.save(item);
			}
			// check the item if can save to DB, if save it or return the mismatch list
			status = importDutyInfoToDB();
			return status;
		}catch (Exception e){
			status.setStauts("False");
			onDutyImportDao.deleteAll();
		}
		return status;
	}

	public List<DutyImportDto> readExcel(MultipartFile file,String suffix) throws Exception{
		List<DutyImportDto> contentList = new ArrayList<DutyImportDto>();
		try {
			InputStream is = file.getInputStream();
			if(".xls".equals(suffix)){  
                wb = new HSSFWorkbook(is);  
            }else if(".xlsx".equals(suffix)){  
                wb = new XSSFWorkbook(is);  
            }
			contentList = readExcelContent(wb);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contentList;
	}
	
	public List<DutyImportDto> readExcelContent(Workbook wb) throws Exception{  
		List<DutyImportDto> contentList = new ArrayList<DutyImportDto>();
		DutyImportDto contentDto = new DutyImportDto();  
        sheet = wb.getSheetAt(0);
        // get all rows 
        int rowNum = sheet.getLastRowNum();
        // get the content, title is the first row 
        for (int i = 1; i <= rowNum; i++) {  
            row = sheet.getRow(i);  
            contentDto.setUserid((long) row.getCell(0).getNumericCellValue());
            contentDto.setUsername(row.getCell(1).getStringCellValue());
            contentDto.setResponsibledepartment(row.getCell(2).toString());
            contentDto.setCompanyid(row.getCell(3).toString());
            contentDto.setStartdate(row.getCell(4).toString());
            contentDto.setEnddate(row.getCell(5).toString());
            contentDto.setDescription(row.getCell(6).getStringCellValue());
            contentList.add(contentDto);
        }  
        return contentList;  
    }
}