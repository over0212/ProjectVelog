package com.velog.web.service;

import java.time.LocalDateTime;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.velog.domain.email.ConfirmationToken;
import com.velog.domain.email.ConfirmationTokenRepository;
import com.velog.web.model.dto.email.EmailTokenDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ConfirmationTokenService {
	
	private final ConfirmationTokenRepository confirmationTokenRepository;
	private final EmailSenderService emailSenderService;
	
	public String createEmailConfirmationToken(String receiverEmail) {
		Assert.hasText(receiverEmail, "receiverEmail는 필수 입니다.");
		
		ConfirmationToken emailConfirmationToken = ConfirmationToken.createEmailConfirmationToken(receiverEmail);
		confirmationTokenRepository.createToken(emailConfirmationToken);
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(receiverEmail);
		mailMessage.setSubject("회원가입 이메일 인증");
		mailMessage.setText("http://localhost:8000/velog/sign-up?token=" + emailConfirmationToken.getId());
		emailSenderService.sendEmail(mailMessage);
		return emailConfirmationToken.getId();
	}
	
	public ConfirmationToken getToken(String confirmationTokenId) {
		EmailTokenDto emailTokenDto = new EmailTokenDto();
		emailTokenDto.setConfirmationTokenId(confirmationTokenId);
		emailTokenDto.setNow(LocalDateTime.now());
		emailTokenDto.setExpired(0);
		return confirmationTokenRepository.getConfirmationToken(emailTokenDto);
	}
	
	public int updateExpired(String updateExpired) {
		return confirmationTokenRepository.updateExpired(updateExpired);
	}
}
