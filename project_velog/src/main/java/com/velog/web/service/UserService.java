package com.velog.web.service;

import org.springframework.stereotype.Service;

import com.velog.web.model.dto.auth.SignUpDto;

@Service
public interface UserService {

	public int signUp(SignUpDto signUpDto);

}
