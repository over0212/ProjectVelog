package com.velog.model.dto;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ConfirmToken {
	
	// 토큰의 값
	@Id
	
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
	private LocalDateTime last_change_date;

	
}
