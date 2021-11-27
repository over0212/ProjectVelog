package com.velog.web.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.velog.domain.email.ConfirmationToken;
import com.velog.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TokenService {
	
	private final EmailSenderService EmailSenderService;
	private final UserRepository userRepository;
	
	// 이메일 인증에 대한 토큰을 만들어 보내기 위한 메소드
	public String createEmailConfirmToken(String userId, String receiverEmail) {
		
		Assert.hasText(userId, "userId 는 필수 입니다.");
		Assert.hasText(receiverEmail, "receiverEmail은 필수 입니다.");
		
		ConfirmationToken emailConfirmToken = ConfirmationToken.createEmailConfirmationToken(userId);
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(receiverEmail);
		mailMessage.setSubject("이메일 인증");
		mailMessage.setText("http://localhost:8000/velog/confirm-email?token=" + emailConfirmToken.getId());
		EmailSenderService.sendEmail(mailMessage);
		System.out.println(mailMessage);
		return emailConfirmToken.getId();
	}

}
