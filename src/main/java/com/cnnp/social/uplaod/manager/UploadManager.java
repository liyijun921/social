package com.cnnp.social.uplaod.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;
import java.util.Vector;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartFile;

import com.cnnp.social.uplaod.manager.dto.UploadDto;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;


@EnableTransactionManagement
@Component
public class UploadManager {
	public String downloadFile = "upload.txt";
	public String rootPath = "/ecm/app/data/";
	public String directory = "appimages/";
	public String propertiesResource = "application.properties";
	
	
	
	
	/**
	* 上传文件
	* @param file 上传的文件
	* @param pathCheck 根据参数选择不同的路径
	* @param UploadDto 返回的对象
	* @throws IOException 
	*/
	public UploadDto upload(MultipartFile file,String pathPram) throws IOException {
		
		UploadDto uploadFeed = new UploadDto();
		
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
				directory = directory + tempPath + String.valueOf(calendar.get(Calendar.YEAR))+"/";
				
				String fileName = uuid.toString()+ file.getOriginalFilename().substring(4);
				
				String path = rootPath + directory + fileName;
				File files = new File(path);
				file.transferTo(files);
				uploadFeed.setStatus("True");
				uploadFeed.setFilePath(directory);
				uploadFeed.setFileName(fileName);
				
				// list the folder's file name 
//				File[] filelist = files.getParentFile().listFiles();
//				for(int i =0;i<filelist.length;i++){
//					String name = filelist[i].getName();
//				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
//		fileBack = "Path: " +directory +" "+ "Name: "+file.getOriginalFilename();
		return uploadFeed;
	}
	
	public Properties getProperties () throws IOException{
		Properties properties = new Properties();
		FileInputStream in = new FileInputStream(propertiesResource);
		properties.load(in);
		return properties;
	}
	
	

	/**
	* 下载文件
	* @param directory 下载目录
	* @param downloadFile 下载的文件
	* @param saveFile 存在本地的路径
	* @param sftp
	*/
	public void download(String saveFile) {
//		ChannelSftp sftp = connect(host, port, username,password);
		try {
//			sftp.cd(directory);
//			File file=new File(saveFile);
//			sftp.get(downloadFile, new FileOutputStream(file));
			} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	* 列出目录下的文件
	* @param directory 要列出的目录
	* @param sftp
	* @return
	* @throws SftpException
	*/
	public Vector listFiles(String directory, ChannelSftp sftp) throws SftpException{
		return sftp.ls(directory);
	}

//	public static void main(String[] args) {
//	testMain sf = new testMain(); 
//	String host = "10.15.251.119";
//	int port = 22;
//	String username = "admin";
//	String password = "Password12";
//	String directory = "/ecm/app/";
//	String uploadFile = "C:\\test\\test.csv";
////	String downloadFile = "upload.txt";
////	String saveFile = "D:\\tmp\\download.txt";
////	String deleteFile = "delete.txt";
//	ChannelSftp sftp=sf.connect(host, port, username, password);
//	
//	sf.upload(directory, uploadFile, sftp);
////	sf.download(directory, downloadFile, saveFile, sftp);
////	sf.delete(directory, deleteFile, sftp);
//	try{
//	sftp.cd(directory);
//	sftp.mkdir("ss");
//	System.out.println("finished");
//	}catch(Exception e){
//	e.printStackTrace();
//	} 
//	} 
}
