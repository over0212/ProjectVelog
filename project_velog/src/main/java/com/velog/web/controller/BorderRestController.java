package com.velog.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.velog.web.model.dto.border.BorderDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/border")
public class BorderRestController {
	
	@PostMapping("/insert/{username}/")
	public String borderInsert(BorderDto borderInsertDto) { // form-data 를 받음
		
		return "";
	}
}
