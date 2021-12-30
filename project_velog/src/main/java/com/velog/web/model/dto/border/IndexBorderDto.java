package com.velog.web.model.dto.border;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class IndexBorderDto {
	
	private String url;
	private int id;
	private int count;
	private int like_count;
	private String username;
	private String main_title;
	private List<String> main_tags;
	private String profile_img_url;
	private String preview_img_url;
	private String preview_txt;
	private String create_date;

}
