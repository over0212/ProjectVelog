package com.velog.domain.border;

import java.time.LocalDateTime;

import com.velog.web.model.dto.border.BorderListDto;
import com.velog.web.model.dto.border.IndexBorderDto;

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
	
	public BorderListDto toDto() {
		return BorderListDto.builder()
				.url(url)
				.id(id)
				.main_title(main_title)
				.main_content(main_content)
				.preview_img_url(preview_img_url)
				.preview_txt(preview_txt)
				.create_date(create_date)
				.build();
	}
	
	public IndexBorderDto toIndexDto() {
		return IndexBorderDto.builder()
				.url(url)
				.id(id)
				.main_title(main_title)
				.preview_img_url(preview_img_url)
				.preview_txt(preview_txt)
				.update_date(update_date)
				.build();
	}

}
