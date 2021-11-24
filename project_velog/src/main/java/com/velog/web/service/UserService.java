package com.velog.web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.velog.domain.ConfirmToken;
import com.velog.mapper.UserRepository;
import com.velog.web.model.dto.UserDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
	
	private final UserRepository userRepository;
	private final TokenService tokenService;
	
	public void confirmEmail(String token) {
		ConfirmToken confirmToken = tokenService.getConfirmToken(token);
		UserRepository userRepository = 
		
	}

}
