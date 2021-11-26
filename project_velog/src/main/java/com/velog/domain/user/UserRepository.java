package com.velog.domain.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
	
	public String userEmailCheck(User user);
	
	public int usernameCheck(User user);
	
	public int signup(User user);
	
	public User getUser(String email);
	
}
