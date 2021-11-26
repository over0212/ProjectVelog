package com.velog.web.service;

import com.velog.web.model.dto.auth.SignUpDto;

public interface AuthService {
	
	// 이메일로 날아간 토큰을 확인
	public int confirmEmail(String token);
	
	public int signUp(SignUpDto signUpDto);

}
