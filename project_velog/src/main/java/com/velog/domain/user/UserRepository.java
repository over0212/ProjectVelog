package com.velog.domain.user;

import org.apache.ibatis.annotations.Mapper;

import com.velog.web.model.dto.UserDto;

@Mapper
public interface UserRepository {
	
	public String userEmailCheck(UserDto userDto);
	
	public String findById(String id);
	
	public int updateFrontName(Mypage mypage);
	
	public int updateFrontContent(Mypage mypage);
	
}
