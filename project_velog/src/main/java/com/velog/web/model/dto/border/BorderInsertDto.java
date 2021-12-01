package com.velog.web.model.dto.border;

import lombok.Data;

@Data
public class BorderInsertDto {
	
	// 태그 어떻게 가져올지 고민!
	private String border_title;
	private String border_content;
	private String preview_content;
	private String border_url;
}
