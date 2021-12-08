package com.velog.web.service;

import com.velog.web.model.dto.mypage.MypageDto;

public interface ImgService {

	public String updateProfileImg(int id,MypageDto mypageDto); 
	public int deleteProfileImg(int id);
}
