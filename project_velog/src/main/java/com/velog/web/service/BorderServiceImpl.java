package com.velog.web.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BorderServiceImpl implements BorderService{
	
	@Value("${file.path}")
	private String filePath;
	
	@Override
	public String imageUpload(String username, MultipartFile multipartFile) {
		String imageFileName = multipartFile.getOriginalFilename();
		String userFolder = username + "/post/" + UUID.randomUUID().toString().replaceAll("-", "");
		String imageFilePath = filePath + userFolder;
		File file = new File(imageFilePath, imageFileName);
		if(!file.exists()) {
			file.mkdirs();
		}
		try {
			multipartFile.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userFolder + "/" + imageFileName;
	}
}
