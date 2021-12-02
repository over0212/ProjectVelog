package com.velog.domain.user;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Mypage {
	
	private int id;
	private String name;
	private String comment;
	private String nickname;

}
