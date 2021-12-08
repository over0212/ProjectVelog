package com.velog.web.service;

import java.util.List;

import com.velog.domain.border.Border;
import com.velog.web.model.dto.border.IndexBorderDto;

public interface IndexService {
	
	public List<Border> getBorderAll();
	
	public List<IndexBorderDto> getIndexList();

}
