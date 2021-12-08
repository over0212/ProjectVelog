package com.velog.web.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.velog.domain.border.Border;
import com.velog.web.model.dto.border.BorderDto;
import com.velog.web.model.dto.border.BorderListDto;

public interface BorderService {
	
	public String imageUpload(int id, MultipartFile multipartFile);
	
	public int insertBorder(BorderDto borderDto);
	
	public Border getDtlBorderIndex(int id);
	
	public List<BorderListDto> getBorderList(int id);
	
}
