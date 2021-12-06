package com.velog.web.model.dto.auth;

import com.velog.domain.user.User;

import lombok.Data;

@Data
public class SignUpDto {

	private String email;
	private String username;
	private String name;
	private String comment;
	private String token;
	
	public User toEntity() {
		return User.builder()
					.email(email)
					.username(username)
					.name(name)
					.comment(comment)
					.build();
	}
}
