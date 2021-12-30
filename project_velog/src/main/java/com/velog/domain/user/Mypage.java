package com.velog.domain.user;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Mypage {
	
	private int id;
	private String social_email;
	private String social_github;
	private String social_twitter;
	private String social_facebook;
	private String social_home;
	private LocalDateTime create_date;
	private LocalDateTime update_date;

}
