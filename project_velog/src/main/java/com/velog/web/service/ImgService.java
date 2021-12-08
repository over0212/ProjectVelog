package com.velog.web.service;

import com.velog.domain.user.User;
import com.velog.web.model.dto.mypage.MypageDto;

public interface ImgService {

	public String updateProfileImg(MypageDto mypageDto,User user); 
	public int deleteProfileImg(User user);
}
