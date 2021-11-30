package com.velog.domain.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
	
	public int updatePasswordByToken(User user);
	
	// DB와 이메일을 대조
	public String userEmailCheck(User user);
	
	// DB와 이름을 대조
	public int usernameCheck(User user);
	
	public String findById(String id);
	
	public int signup(User user);
	
	public User getUser(String email);
	
	public int updateFrontName(Mypage mypage);
	
	public int updateFrontContent(Mypage mypage);
	
	public int updateFrontTitle(Mypage mypage);
	
	public int deleteUser(int id);
	
}
