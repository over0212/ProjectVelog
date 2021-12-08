package com.velog.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.velog.config.auth.PrincipalDetails;
import com.velog.web.model.dto.border.BorderDto;
import com.velog.web.service.BorderService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/border")
public class BorderRestController {

	private final BorderService borderService;

	@PostMapping("/imgupload")
	public String imgUpload(MultipartFile file, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		String imageFile = borderService.imageUpload(principalDetails.getUser().getId() , file);
		return imageFile;
	}

	@PostMapping("/insert/{id}")
	public String borderInsert(BorderDto borderDto) { // form-data 를 받음
		int insertFlag =  borderService.insertBorder(borderDto);
		return Integer.toString(insertFlag);
	}
}
