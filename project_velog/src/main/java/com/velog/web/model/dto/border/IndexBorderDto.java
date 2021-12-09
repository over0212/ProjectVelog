package com.velog.web.model.dto.border;

import java.time.LocalDateTime;

import com.velog.domain.border.Border;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class IndexBorderDto {
	
	private String url;
	private int id;
	private String username;
	private String main_title;
	private String profile_img_url;
	private String preview_img_url;
	private String preview_txt;
	private LocalDateTime update_date;

}
