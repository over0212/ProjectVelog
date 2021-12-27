package com.velog.web.service;

import java.util.List;

import com.velog.domain.border.Border;
import com.velog.web.model.dto.border.IndexBorderDto;

public interface IndexService {
	
	// index 데이터를 가지고 오기 위한 데이터
	public List<Border> getBorderAll();
	
	// index recent
	public List<IndexBorderDto> getIndexList();
	
	// index today
	public List<IndexBorderDto> getTodayIndexList();
	
	// index week
	public List<IndexBorderDto> getWeekIndexList();
	
	// index month
	public List<IndexBorderDto> getMonthIndexList();
	
	// index year
	public List<IndexBorderDto> getYearIndexList();

}
