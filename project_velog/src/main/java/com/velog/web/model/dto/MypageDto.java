package com.velog.web.model.dto;

import com.velog.domain.user.User;

import lombok.Data;

@Data
public class MypageDto {
	private String name;
	private String comment;
     private String username;
     
     public User toEntity(int id) {
    	 return User.builder()
    			 .id(id)
    			 .name(name)   			 
    			 .comment(comment)   			 
    			 .username(username)
    			 .build();
     }
}
