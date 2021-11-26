package com.velog.domain.user;

import org.apache.ibatis.annotations.Mapper;

import com.velog.web.model.dto.SignUpDto;

@Mapper
public interface UserRepository {
	
	public String userEmailCheck(User userDto);
	
	public int signUp(SignUpDto signUpDto);
	
	public User getUser(String email);
	
}
