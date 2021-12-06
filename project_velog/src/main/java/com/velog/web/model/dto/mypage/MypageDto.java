package com.velog.web.model.dto.mypage;

import org.springframework.web.multipart.MultipartFile;

import com.velog.domain.user.User;

import lombok.Data;

@Data
public class MypageDto {
	private int id;
	private String name;
	private String comment;
    private String username;
    private MultipartFile mypageImg;
     
     public User toEntity(int id) {
    	 return User.builder()
    			 .id(id)
    			 .name(name)   			 
    			 .comment(comment)   			 
    			 .username(username)
    			 .build();
     }
}
