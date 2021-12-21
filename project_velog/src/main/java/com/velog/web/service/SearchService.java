package com.velog.web.service;

import java.util.List;

import com.velog.domain.border.Border;
import com.velog.web.model.dto.border.BorderListDto;

public interface SearchService {
	
	public List<BorderListDto> searchBorder(String keyword);

}
