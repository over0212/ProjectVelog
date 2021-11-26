package com.velog.web.service;

<<<<<<< HEAD
import com.velog.web.model.dto.SignUpDto;

public interface AuthService {
	public int signUp(SignUpDto signUpDto);
=======
public interface AuthService {
	
	// 이메일을 확인
	public int confirmEmail(String token);

>>>>>>> d9e983874a3304581c045165367c4fdc5bfda303
}
