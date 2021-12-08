package com.velog.web.model.dto.border;

import java.time.LocalDateTime;

import com.velog.domain.border.Border;

import lombok.Data;

@Data
public class IndexBorderDto {
	
	private String url;
	private int id;
	private String main_title;
	private String preview_img_url;
	private String preview_txt;
	private LocalDateTime create_date;
	
	public Border IndexBorderEntity() {
		return Border.builder()
				.url(url)
				.id(id)
				.main_title(main_title)
				.preview_img_url(preview_img_url)
				.preview_txt(preview_txt)
				.create_date(create_date)
				.build();
	}

}
