package com.velog.web.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.velog.config.auth.PrincipalDetails;
import com.velog.domain.border.Border;
import com.velog.web.model.dto.border.BorderDto;
import com.velog.web.model.dto.border.BorderListDto;
import com.velog.web.model.dto.border.BorderUpdateDto;

public interface BorderService {
	
	public String imageUpload(int id, MultipartFile multipartFile);
	
	public int insertBorder(BorderDto borderDto);
	
	public Border getDtlBorderIndex(String url, PrincipalDetails principalDetails);
	
	public void plusBorderCount(String count);
	
	public List<BorderListDto> getBorderList(String username);
	
	public int updateBorder(BorderUpdateDto borderUpdateDto);
	
	public int deleteBorder(String url);
	
	public int updateMyborder(PrincipalDetails principalDetails,BorderUpdateDto borderUpdateDto);
}
