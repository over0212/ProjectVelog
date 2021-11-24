package com.velog.config.oauth2.provider;

import com.velog.web.model.dto.UserDto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Oauth2UserDto {
	
	private String email;
	private String username;
	private String name;
	private String comment;
	private String password;
	private String provider;
	
	public UserDto toEntity() {
		return UserDto.builder()
				.email(email)
				.username(username)
				.name(name)
				.comment(comment)
				.password(password)
				.provider(provider)
				.build();
	}
	
}
