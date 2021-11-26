package com.velog.web.model.dto;

import com.velog.domain.user.Mypage;

import lombok.Data;

@Data
public class MypageDto {
     private String user_name;
     private String content;
     private String user_title;
     
     public Mypage toEntity(int id) {
    	 return Mypage.builder()
    			 .id(id)
    			 .user_name(user_name)
    			 .content(content)
    			 .user_title(user_title)    			 
    			 .build();
     }
}
