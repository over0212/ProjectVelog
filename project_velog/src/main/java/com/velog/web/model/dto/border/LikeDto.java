package com.velog.web.model.dto.border;

import com.velog.domain.border.Border;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LikeDto {
	
	private int id;
	private String url;
	
	public Border toEntity() {
		return Border.builder()
				.id(id)
				.url(url)
				.build();
	}

}
