package com.velog.domain.border;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Border {
	
	private String url;
	private int id;
	private String main_title;
	private String main_tags;
	private String main_content;
	private String preview_img_url;
	private String preview_txt;
	private LocalDateTime create_date;
	private LocalDateTime update_date;
	
}
