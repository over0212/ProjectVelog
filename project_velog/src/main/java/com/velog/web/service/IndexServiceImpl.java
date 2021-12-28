package com.velog.web.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.velog.domain.border.Border;
import com.velog.domain.border.BorderRepository;
import com.velog.web.model.dto.border.BorderListDto;
import com.velog.web.model.dto.border.IndexBorderDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class IndexServiceImpl implements IndexService {

	private final BorderRepository borderRepository;

	@Override
	public List<Border> getBorderAll() {
		return borderRepository.getBorderAll();
	}

	// recent(최신 글)
	@Override
	public List<IndexBorderDto> getIndexList() {
		List<Border> indexBorderList = borderRepository.getBorderAll();
		List<IndexBorderDto> getIndexList = new ArrayList<IndexBorderDto>();

		for (Border border : indexBorderList) {
			IndexBorderDto indexBorderDto = border.toIndexDto();

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
			indexBorderDto.setCreate_date(dateFormat.format(Timestamp.valueOf(border.getCreate_date())));
			
			getIndexList.add(indexBorderDto);
		}

		return getIndexList;
	}

	// today
	@Override
	public List<IndexBorderDto> getTodayIndexList() {
		List<Border> getIndexBorderAll = borderRepository.getBorderToday();
		List<IndexBorderDto> getIndexBorderToday = new ArrayList<IndexBorderDto>();

		for (Border border : getIndexBorderAll) {
			IndexBorderDto indexBorderDto = border.toIndexDto();

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
			indexBorderDto.setCreate_date(dateFormat.format(Timestamp.valueOf(border.getCreate_date())));
			
			getIndexBorderToday.add(indexBorderDto);
		}
		return getIndexBorderToday;
	}
	
	// week
	@Override
	public List<IndexBorderDto> getWeekIndexList() {
		List<Border> getIndexBorderAll = borderRepository.getBorderWeek();
		List<IndexBorderDto> getIndexBorderWeek = new ArrayList<IndexBorderDto>();
		
		for (Border border : getIndexBorderAll) {
			IndexBorderDto indexBorderDto = border.toIndexDto();
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
			indexBorderDto.setCreate_date(dateFormat.format(Timestamp.valueOf(border.getCreate_date())));
			
			getIndexBorderWeek.add(indexBorderDto);
		}
		return getIndexBorderWeek;
	}
	
	// month
	@Override
	public List<IndexBorderDto> getMonthIndexList() {
		List<Border> getIndexBorderAll = borderRepository.getBorderMonth();
		List<IndexBorderDto> getIndexBorderMonth = new ArrayList<IndexBorderDto>();
		
		for (Border border : getIndexBorderAll) {
			IndexBorderDto indexBorderDto = border.toIndexDto();
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
			indexBorderDto.setCreate_date(dateFormat.format(Timestamp.valueOf(border.getCreate_date())));
			
			getIndexBorderMonth.add(indexBorderDto);
		}
		return getIndexBorderMonth;
	}
	
	// year
	@Override
	public List<IndexBorderDto> getYearIndexList() {
		List<Border> getIndexBorderAll = borderRepository.getBorderYear();
		List<IndexBorderDto> getIndexBorderYear = new ArrayList<IndexBorderDto>();
		
		for (Border border : getIndexBorderAll) {
			IndexBorderDto indexBorderDto = border.toIndexDto();
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
			indexBorderDto.setCreate_date(dateFormat.format(Timestamp.valueOf(border.getCreate_date())));
			
			getIndexBorderYear.add(indexBorderDto);
		}
		return getIndexBorderYear;
	}

}
