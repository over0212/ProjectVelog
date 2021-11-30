package com.velog.web.model.dto;

import com.velog.domain.user.Mypage;

import lombok.Data;

@Data
public class MypageDto {
	
     private String name;
     private String content;
     private String usertitle;
     
     public Mypage toEntity(int id) {
    	 return Mypage.builder()
    			 .id(id)
    			 .name(name)
    			 .content(content)
    			 .usertitle(usertitle)    			 
    			 .build();
     }
}
