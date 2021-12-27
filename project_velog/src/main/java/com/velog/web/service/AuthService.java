package com.velog.web.service;

import java.util.Map;

import com.velog.web.model.dto.auth.SignUpDto;

public interface AuthService {
	
	// 이메일로 날아간 토큰을 확인
	public Map<String, String> confirmEmail(String token);
	
	public int signUp(SignUpDto signUpDto);
}
