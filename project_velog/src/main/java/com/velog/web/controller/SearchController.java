package com.velog.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.velog.web.model.dto.border.BorderListDto;
import com.velog.web.service.SearchService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class SearchController {
	
	private final SearchService searchService;
	
	@GetMapping("/search/{keyword}")
	public Object searchIndex(@PathVariable String keyword) { 
		List<BorderListDto> searchListDto = searchService.searchBorder(keyword);
		System.out.println(searchListDto);
		Map<String, List<BorderListDto>> map = new HashMap<String, List<BorderListDto>>();
		map.put("borderList", searchListDto);
		return map;
	}

}
