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
<<<<<<< HEAD:project_velog/src/main/java/com/velog/domain/user/UserDto.java
public class UserDto {
	private int id;
=======
public class User {
	
>>>>>>> d9e983874a3304581c045165367c4fdc5bfda303:project_velog/src/main/java/com/velog/domain/user/User.java
	private String email;
	private String username;
	private String name;
	private String comment;
	private String password;
	private String provider;
	private LocalDateTime create_date;
	private LocalDateTime update_date;
	
}
