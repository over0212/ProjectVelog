package com.velog.domain;

import java.time.LocalDateTime;

import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ConfirmToken {
	
	// 토큰의 만료시간
	private static final long EMAIL_TOKEN_EXPIRATION_TIME_VALUE = 5L;
	
	@Id
	@Size(max = 36)
	// 토큰의 값
	private String id;
	
	// 만료 시간
	private LocalDateTime expiration_date;
	
	// 만료 여부
	private boolean expired;
	
	// user의 값
	private String userId;
	
	// 생성 시간
	private LocalDateTime create_date;
	
	// 마지막 변경시간
	private LocalDateTime update_date;
	
	/*
	 * 이메일 인증 토큰을 생성
	 * @param -> userId
	 */
	// Entity 객체
	public static ConfirmToken createEmailConfirmToken(String userId) {
		ConfirmToken confirmToken = new ConfirmToken();
		// 토큰의 만료시간을 5분으로 설정
		confirmToken.expiration_date = LocalDateTime.now().plusMinutes(EMAIL_TOKEN_EXPIRATION_TIME_VALUE);
		confirmToken.userId = userId;
		confirmToken.expired = false; // 만료가 되지 않게 초기 설정
		return confirmToken;
	}
	
	// 토큰을 사용했을 때로 인한 만료가 되었다는 것을 설정
	public void useToken() {
		expired = true;
	}
}
