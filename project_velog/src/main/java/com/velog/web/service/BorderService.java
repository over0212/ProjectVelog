package com.velog.web.service;

import org.springframework.web.multipart.MultipartFile;

public interface BorderService {
	public String imageUpload(String username, MultipartFile multipartFile);
}
