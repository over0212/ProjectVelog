package com.velog.web.service;

import org.springframework.stereotype.Service;

import com.velog.domain.email.ConfirmationToken;
import com.velog.domain.user.User;
import com.velog.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
	
	private ConfirmationTokenService confirmationTokenService;
	
	private UserRepository userRepository;
	
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
