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
	
	private String email;
	private String username;
	private String name;
	private String comment;
	private String password;
	private String provider;
	private LocalDateTime create_date;
	private LocalDateTime update_date;
	
}
