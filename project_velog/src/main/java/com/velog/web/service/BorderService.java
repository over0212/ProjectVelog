package com.velog.web.service;

import org.springframework.web.multipart.MultipartFile;

import com.velog.web.model.dto.border.BorderDto;

public interface BorderService {
	
	public String imageUpload(int id, MultipartFile multipartFile);
	
	public int insertBorder(BorderDto borderDto);
	
}
