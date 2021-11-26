package com.velog.web.service;

public interface AuthService {
	
	// 이메일을 확인
	public int confirmEmail(String token);

}
