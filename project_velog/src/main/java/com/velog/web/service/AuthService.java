package com.velog.web.service;

import com.velog.web.model.dto.SignUpDto;

public interface AuthService {
	public int signUp(SignUpDto signUpDto);
}
