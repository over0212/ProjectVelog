package com.velog.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.velog.domain.user.UserDto;
import com.velog.domain.user.UserRepository;
import com.velog.web.model.dto.SignUpDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private final UserRepository userRepository;

	@Override
	public int signUp(SignUpDto signUpDto) {
		UserDto user = signUpDto.toEntity();
		int usernameCheckResult = userRepository.usernameCheck(user);
		if(usernameCheckResult == 1) {
			// 이미 존재하는 username
			return 2;
		}else {
			// 회원가입 가능
			user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
			int signUpResult = userRepository.signup(user);
			return signUpResult;
		}
	}

}
