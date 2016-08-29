package com.cnnp.social.uplaod.manager;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartFile;

import com.cnnp.social.uplaod.manager.dto.UploadDto;


@EnableTransactionManagement
@Component
public class UploadManager {
	
	/**
	* 上传文件
	* @param file 上传的文件
	* @param pathCheck 根据参数选择不同的路径
	* @param UploadDto 返回的对象
	* @throws IOException 
	*/
	public UploadDto upload(MultipartFile file,String pathPram) throws IOException {
		
		UploadDto uploadFeed = new UploadDto();
		
		UploadSetting setting = new UploadSetting();
		
		String tempPath = "";
		
		if ("workspace".equals(pathPram)){
			tempPath = "collspace/";
		}else if ("other".equals(pathPram)){
			tempPath = "other/";
		}
		if(file==null){
			uploadFeed.setStatus("False");
			uploadFeed.setLog("the file is null");
			return uploadFeed;
		}else{
			
			try {
				Calendar calendar = Calendar.getInstance();
				UUID uuid = UUID.randomUUID();
				String directory = setting.getDirectory() + tempPath + String.valueOf(calendar.get(Calendar.YEAR))+"/";
				
				String fileName = uuid.toString()+ file.getOriginalFilename().substring(4);
				
				String path = setting.getRootPath() + directory + fileName;
				File files = new File(path);
				file.transferTo(files);
				uploadFeed.setStatus("True");
				uploadFeed.setFilePath(directory);
				uploadFeed.setFileName(fileName);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
//		fileBack = "Path: " +directory +" "+ "Name: "+file.getOriginalFilename();
		return uploadFeed;
	}
	
	

	/**
	* 下载文件
	* @param directory 下载目录
	* @param downloadFile 下载的文件
	* @param saveFile 存在本地的路径
	* @param sftp
	*/
	public void download(String saveFile) {
		try {
			} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	* 列出目录下的文件
	* @param directory 要列出的目录
	* @param 
	* @return
	* @throws SftpException
	*/
	public File[] listFiles(String filePath) {
		File files = new File(filePath);
		File[] filelist = files.listFiles();
		return filelist;
	}

}
