package com.velog.web.model.dto.border;

import java.time.LocalDateTime;
import java.util.List;

import com.velog.domain.border.Border;
import com.velog.domain.user.User;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BorderUpdateDto {
	
	private String url;
	private String new_url;
	private int id;
	private String main_title;
	private String[] main_tags;
	private String main_content;
	private String preview_img_url;
	private String preview_txt;
	private String myBorder_introduce;
	private LocalDateTime create_date;
	
	public Border toEntity() {
		return Border.builder()
					.url(url)
					.new_url(new_url)
					.id(id)
					.main_title(main_title)
					.main_content(main_content)
					.preview_img_url(preview_img_url)
					.preview_txt(preview_txt)
					.build();
	}
	
	public User toMyborderEntity() {
		return User.builder()
				.myBorder_introduce(myBorder_introduce)
				.build();
	}
}
