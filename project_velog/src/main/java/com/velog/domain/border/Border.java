package com.velog.domain.border;

import java.time.LocalDateTime;

import com.velog.web.model.dto.border.BorderListDto;
import com.velog.web.model.dto.border.BorderUpdateDto;
import com.velog.web.model.dto.border.IndexBorderDto;
import com.velog.web.model.dto.border.LikeDto;

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
	private String new_url;
	private int id;
	private int count; // 조회 수
	private int like_count; // 좋아요 수
	private int likeFlag;
	private String username;
	private String main_title;
	private String main_tags;
	private String comment;
	private String main_content;
	private String profile_img_url;
	private String preview_img_url;
	private String preview_txt;
	private LocalDateTime create_date;
	private LocalDateTime update_date;
	
	public BorderListDto toDto() {
		return BorderListDto.builder()
				.url(url)
				.id(id)
				.count(count)
				.like_count(like_count)
				.main_title(main_title)
				.username(username)
				.main_content(main_content)
				.comment(comment)
				.preview_img_url(preview_img_url)
				.profile_img_url(profile_img_url)
				.preview_txt(preview_txt)
				.build();
	}
	
	public IndexBorderDto toIndexDto() {
		return IndexBorderDto.builder()
				.url(url)
				.id(id)
				.count(count)
				.like_count(like_count)
				.main_title(main_title)
				.username(username)
				.profile_img_url(profile_img_url)
				.preview_img_url(preview_img_url)
				.preview_txt(preview_txt)
				.build();
	}
	
	public BorderUpdateDto toUpdateDto() {
		return BorderUpdateDto.builder()
				.url(url)
				.new_url(new_url)
				.id(id)
				.main_title(main_title)
				.main_content(main_content)
				.preview_img_url(preview_img_url)
				.preview_txt(preview_txt)
				.create_date(create_date)
				.build();
	}
	
	public LikeDto toLikeDto() {
		return LikeDto.builder()
				.url(url)
				.id(id)
				.build();
	}
	
}
