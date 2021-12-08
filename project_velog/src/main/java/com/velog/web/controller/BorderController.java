package com.velog.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.velog.config.auth.PrincipalDetails;
import com.velog.web.service.BorderService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BorderController {
	
	private final BorderService borderService;
	
	// border-insert 페이지
	@GetMapping("/insert")
	public ModelAndView writePage() {
		ModelAndView mav = new ModelAndView("border_insert");
		return mav;
	}
	
	// border dtl page
	@GetMapping("/border/{username}/{url}")
	public ModelAndView DtlBorderIndex(@AuthenticationPrincipal PrincipalDetails principalDetails) {
		ModelAndView mav = new ModelAndView("border_dtl");
		mav.addObject("border", borderService.getDtlBorderIndex(principalDetails.getUser().getId()));
		return mav;
	}
	
	// myborder page
	@GetMapping({"/myborder/{username}", "/border/{username}"})
	public ModelAndView getBorderList(@AuthenticationPrincipal PrincipalDetails principalDetails) {
		ModelAndView mav = new ModelAndView("myborder");
		mav.addObject("borderList", borderService.getBorderList(principalDetails.getUser().getId()));
		return mav;
	}

}
