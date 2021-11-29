package com.velog.web.service;


import java.util.HashMap;
import java.util.Map;

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
		int signUpFlag = 0;
		
		User user = signUpDto.toEntity();
		int usernameCheckResult = userRepository.usernameCheck(user);
		
		if(usernameCheckResult == 0) {
			// 회원가입 가능
			user.setPassword(new BCryptPasswordEncoder().encode(signUpDto.getToken()));
			signUpFlag = userRepository.signup(user);
		}
		
		return signUpFlag;
	}
	
	@Override
	public Map<String, String> confirmEmail(String token) {
		ConfirmationToken confirmationToken = confirmationTokenService.getToken(token);
		
		Map<String, String> confirmResult = new HashMap<String, String>();
		
		// 토큰 만료 페이지 (리턴 0 을 해줌)
		if(confirmationToken == null) {
			confirmationTokenService.updateExpired(token);
			confirmResult.put("tokenFlag", "0");
			
		}else {
			User user = confirmationTokenService.getUser(confirmationToken.getEmail());
			confirmResult.put("email", confirmationToken.getEmail()); //토큰 발행한 email 담아줌
			
			if(user == null) {
				confirmResult.put("tokenFlag", "1");
				//이미 회원가입이 된 상태 (리턴 2를 해준다)
				
			}else {
				user.setPassword(new BCryptPasswordEncoder().encode(token));
				userRepository.updatePasswordByToken(user);
				confirmResult.put("tokenFlag", "2");
			}
		}
		//회원가입 안된 상태 (리턴 1을 해준다)
		confirmationTokenService.updateExpired(token);
		
		return confirmResult;
	}

}
