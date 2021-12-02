package com.velog.web.model.dto.border;

import java.time.LocalDateTime;

import com.velog.domain.border.Border;

import lombok.Data;

@Data
public class BorderDto {
	
	private String url;
	private int id;
	private String main_title;
	private String main_content;
	private String origin_img_name;
	private String temp_img_name;
	private String origin_file_name;
	private String temp_file_name;
	private String preview_img_origin_name;
	private String preview_img_temp_name;
	private String preview_txt;
	private LocalDateTime create_date;
	
	public Border BoderEntity() {
		return Border.builder()
				.url(url)
				.id(id)
				.main_title(main_title)
				.main_content(main_content)
				.origin_img_name(origin_img_name)
				.temp_img_name(temp_img_name)
				.origin_file_name(origin_file_name)
				.temp_file_name(temp_file_name)
				.preview_img_origin_name(preview_img_origin_name)
				.preview_img_temp_name(preview_img_temp_name)
				.preview_txt(preview_txt)
				.create_date(create_date)
				.build();
	}
	
}
