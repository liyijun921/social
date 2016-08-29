package com.cnnp.social.uplaod.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cnnp.social.uplaod.manager.UploadManager;
import com.cnnp.social.uplaod.manager.dto.UploadDto;



	
@RestController
@RequestMapping("/api/V1.0/uploadPage")
public class UploadController {
	
	@Autowired
	private UploadManager uploadManager;
	
	@RequestMapping(value = "/uploadPage/upload", method = RequestMethod.POST)
	public UploadDto upload(@RequestParam("file") MultipartFile file,@RequestParam String pathPram) throws IOException {
		return uploadManager.upload(file,pathPram);
	}
	@RequestMapping(value = "/uploadPage/download", method = RequestMethod.POST)
	public void download(@RequestParam("saveFile") String saveFile) {
		uploadManager.download(saveFile);
	}

}
