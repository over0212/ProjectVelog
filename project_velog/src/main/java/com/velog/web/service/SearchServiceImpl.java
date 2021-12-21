package com.velog.web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.stereotype.Service;

import com.velog.domain.border.Border;
import com.velog.domain.border.BorderRepository;
import com.velog.web.model.dto.border.BorderListDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SearchServiceImpl implements SearchService {
	
	private final BorderRepository borderRepository;
	
	@Override
	public List<BorderListDto>  searchBorder(String keyword) {
		List<Border> borderList = borderRepository.searchBorder(keyword);
		List<BorderListDto> borderListDtos = new ArrayList<BorderListDto>();
		for (Border border : borderList) {
			BorderListDto borderListDto = border.toDto();
			if(border.getMain_tags() != null) {
				StringTokenizer st = new StringTokenizer(border.getMain_tags(), ",");
				List<String> tags = new ArrayList<String>();
				
				while(st.hasMoreTokens()) {
					tags.add(st.nextToken()); 
				}
				borderListDto.setMain_tags(tags);
			}
			borderListDtos.add(borderListDto);
		}

		return borderListDtos;
	}
	
}
