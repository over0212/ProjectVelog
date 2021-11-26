package com.velog.domain.user;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Mypage {
	private int id;
	private String user_name;
	private String content;
	private String user_title;

}
