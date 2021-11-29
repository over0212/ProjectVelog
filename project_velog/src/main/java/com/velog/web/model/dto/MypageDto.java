package com.velog.web.model.dto;

import com.velog.domain.user.Mypage;

import lombok.Data;

@Data
public class MypageDto {
     private String username;
     private String content;
     private String usertitle;
     
     public Mypage toEntity(int id) {
    	 return Mypage.builder()
    			 .id(id)
    			 .username(username)
    			 .content(content)
    			 .user_title(usertitle)    			 
    			 .build();
     }
}
