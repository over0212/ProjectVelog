package com.velog.domain.user;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
	
	private int id;
	private String email;
	private String password;
	private String username;
	private String name;
	private String comment;
	private String profile_img_url;
	private String provider;
	private LocalDateTime create_date;
	private LocalDateTime update_date;
}
