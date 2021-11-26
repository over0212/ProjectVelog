package com.velog.domain.user;

import org.apache.ibatis.annotations.Mapper;

<<<<<<< HEAD
@Mapper
public interface UserRepository {
	
	public int usernameCheck(UserDto user); // 아이디중복확인
	public int signup(UserDto user); // 회원가입 insert
	public UserDto getUser(String username);
=======
import com.velog.web.model.dto.SignUpDto;

@Mapper
public interface UserRepository {
	
	public String userEmailCheck(User userDto);
	
	public int signUp(SignUpDto signUpDto);
	
	public User getUser(String email);
>>>>>>> d9e983874a3304581c045165367c4fdc5bfda303
	
}
