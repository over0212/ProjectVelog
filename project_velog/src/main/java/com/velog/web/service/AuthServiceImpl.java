package com.velog.web.service;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.velog.domain.email.ConfirmationToken;
import com.velog.domain.user.User;
import com.velog.domain.user.UserRepository;
import com.velog.web.model.dto.auth.SignUpDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
	
	private final UserRepository userRepository;
	
	private final ConfirmationTokenService confirmationTokenService;

	@Override
	public int signUp(SignUpDto signUpDto) {
		User user = signUpDto.toEntity();
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
	
	@Override
	public int confirmEmail(String token) {
		ConfirmationToken confirmationToken = confirmationTokenService.getToken(token);
		int tokenFlag = 0;
		if(confirmationToken == null) {
			// 토큰 만료 페이지 생성
			
		}
		User user = userRepository.getUser(confirmationToken.getEmail());
		if(user == null) {
			//회원가입 안된 상태
			
			
		}else {
			//이미 회원가입이 된 상태
			
		}
		confirmationTokenService.updateExpired(token);
		return tokenFlag;
	}

}
