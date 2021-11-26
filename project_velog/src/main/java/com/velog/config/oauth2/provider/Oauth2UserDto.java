package com.velog.config.oauth2.provider;

import javax.validation.constraints.NotBlank;

<<<<<<< HEAD
import com.velog.domain.user.UserDto;
=======
import com.velog.domain.user.User;
>>>>>>> d9e983874a3304581c045165367c4fdc5bfda303

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Oauth2UserDto {
	
	private int id;
	private String email;
	@NotBlank
	private String username;
	@NotBlank
	private String name;
	@NotBlank
	private String comment;
	private String password;
	private String provider;
	
<<<<<<< HEAD
	public UserDto toEntity() {
		return UserDto.builder()
				.id(id)
=======
	public User toEntity() {
		return User.builder()
>>>>>>> d9e983874a3304581c045165367c4fdc5bfda303
				.email(email)
				.username(username)
				.name(name)
				.comment(comment)
				.password(password)
				.provider(provider)
				.build();
	}
	
}
