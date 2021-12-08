package com.velog.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.velog.domain.border.Border;
import com.velog.domain.border.BorderRepository;
import com.velog.web.model.dto.border.IndexBorderDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class IndexServiceImpl implements IndexService{
	
	private final BorderRepository borderRepository;
	
	@Override
	public List<Border> getBorderAll() {
		return borderRepository.getBorderAll();
	}
	
	@Override
	public List<IndexBorderDto> getIndexList() {
		List<Border> indexBorderList = borderRepository.getBorderAll();
		List<IndexBorderDto> getIndexList = new ArrayList<IndexBorderDto>();
		
		for (Border border : indexBorderList) {
			IndexBorderDto indexBorderDto = border.toIndexDto();
			
			getIndexList.add(indexBorderDto);
		}
		
		return getIndexList;
	}

}
