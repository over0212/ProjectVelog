package com.velog.web.service;

import com.velog.web.model.dto.mypage.MypageDto;

public interface ImgService {

	public String fileUpload(String username,MypageDto mypageDto);
	public int mypageinsert(MypageDto mypageDto);
}
