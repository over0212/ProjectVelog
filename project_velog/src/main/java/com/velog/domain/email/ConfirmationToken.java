package com.velog.domain.email;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class ConfirmationToken {
	
	private static final long EMAIL_TOKEN_EXPIRATION_TIME_VALUE = 5L;
	
	private String id;
	private LocalDateTime expiration_date;
	private int expired;
	private String email;
	private LocalDateTime createdate;
	private LocalDateTime updatedate;
	
	public static ConfirmationToken createEmailConfirmationToken(String receiverEmail) { // 받는이의 이메일을 가져온다.
		ConfirmationToken confirmationToken = new ConfirmationToken(); // 토큰을 생성
		confirmationToken.id = UUID.randomUUID().toString().replaceAll("-", ""); // 토큰의 아이디를 UUID로 만든다.
		confirmationToken.expiration_date = LocalDateTime.now().plusMinutes(EMAIL_TOKEN_EXPIRATION_TIME_VALUE); // 토큰의 만료시간을 5분으로 설정
		confirmationToken.email = receiverEmail; // 이메일은 받는이의 이메일
		confirmationToken.expired = 0; // 아직 만료가 되지 않은걸 설정(0은 만료가 되지 않음 / 1은 만료가 된 토큰)
		return confirmationToken; // 토큰을 리턴 해준다.
	}
}
