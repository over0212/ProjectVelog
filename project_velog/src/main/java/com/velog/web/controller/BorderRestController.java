package com.velog.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.velog.config.auth.PrincipalDetails;
import com.velog.domain.user.Mypage;
import com.velog.web.model.dto.border.BorderDto;
import com.velog.web.model.dto.border.BorderUpdateDto;
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
	public ModelAndView borderInsert(BorderDto borderDto) { // form-data 를 받음
		ModelAndView mav = new ModelAndView("border_dtl");
		//int insertFlag =  borderService.insertBorder(borderDto);
		mav.addObject("insertBorder", borderService.insertBorder(borderDto));
		return mav;
	}
	
	@PutMapping("/update/{id}")
	public String borderUpdate(BorderUpdateDto borderUpdateDto) {
		int updateFlag = 0;
		updateFlag = borderService.updateBorder(borderUpdateDto);
		return Integer.toString(updateFlag);
	}
	
	@DeleteMapping("/delete/{username}/{url}")
	public String deleteBorder(Model model, @PathVariable String url, @PathVariable String username) {
		int result = borderService.deleteBorder(url);
		return Integer.toString(result);
	}
	
	@PutMapping("/like/{url}")
	public String insertLike(@PathVariable String url, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		int result = 0;
		if(principalDetails != null) {	
			result = borderService.insertLike(principalDetails.getUser().getId(),url);
		}
		return Integer.toString(result);
	}
	
	@DeleteMapping("/like/{url}")
	public String deleteLike(@PathVariable String url, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		int result = 0;
		if(principalDetails != null) {
			result = borderService.deleteLike(principalDetails.getUser().getId() ,url);
		}
		return Integer.toString(result);
	}
	
	
}












