package com.velog.domain.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
	
	public int updatePasswordByToken(User user);
	
	public String userEmailCheck(User user);
	
	public String findById(String id);
	
	public int updateFrontName(Mypage mypage);
	
	public int updateFrontContent(Mypage mypage);
	
	public int signup(User user);
	
	public User getUser(String email);
	
	public int usernameCheck(User user);
	
}
