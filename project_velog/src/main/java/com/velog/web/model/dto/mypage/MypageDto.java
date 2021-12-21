package com.velog.web.model.dto.mypage;

import org.springframework.web.multipart.MultipartFile;

import com.velog.domain.user.Mypage;
import com.velog.domain.user.User;

import lombok.Data;

@Data
public class MypageDto {
	private int id;
	private String name;
	private String comment;
    private String username;
    private String social_email;
	private String social_github;
	private String social_twitter;
	private String social_facebook;
	private String social_home;
    private MultipartFile file;
    
    public Mypage toMEntity(int id) {
    	return Mypage.builder()
    			.id(id)
   			 	.social_email(social_email)   			 
   			 	.social_github(social_github)   			 
   			 	.social_twitter(social_twitter)
   			 	.social_facebook(social_facebook)
   			 	.social_home(social_home)
   			 	.build();
    }
     
     public User toUEntity(int id) {
    	 return User.builder()
    			 .id(id)
    			 .name(name)   			 
    			 .comment(comment)   			 
    			 .username(username)
    			 .build();
     }
}
