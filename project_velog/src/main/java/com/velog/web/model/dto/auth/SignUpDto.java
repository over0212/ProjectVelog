package com.velog.web.model.dto.auth;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.velog.domain.user.UserDto;

import lombok.Data;

@Data
public class SignUpDto {
	@Size(min=2, max=20)
	@NotBlank
	private int id;
	@NotBlank
	private String email;
	@NotBlank
	private String username;
	@NotBlank
	private String name;
	@NotBlank
	private String password;
	@NotBlank
	private String provider;
	
	public UserDto toEntity() {
		return UserDto.builder()
					.id(id)
					.email(email)
					.username(username)
					.password(password)
					.name(name)
					.provider(provider)
					.build();
	}
}
