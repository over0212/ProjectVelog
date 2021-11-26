package com.velog.web.model.dto;

import com.velog.domain.user.UserDto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SignUpDto {
	
	private String email;
	private String name;
	private String username;
	private String comment;
	
}
