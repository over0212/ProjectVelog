package com.velog.domain.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
	
	public int usernameCheck(UserDto user); // 아이디중복확인
	public int signup(UserDto user); // 회원가입 insert
	public UserDto getUser(String username);
	
}
