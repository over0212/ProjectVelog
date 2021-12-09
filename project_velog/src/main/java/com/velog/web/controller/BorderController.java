package com.velog.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.velog.config.auth.PrincipalDetails;
import com.velog.web.service.BorderService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/border")
public class BorderController {
	
	private final BorderService borderService;
	
	// border-insert (게시글 작성 페이지)
	@GetMapping("/insert")
	public ModelAndView writePage() {
		ModelAndView mav = new ModelAndView("border_insert");
		return mav;
	}
	
	// border dtl page(작성된 게시글 확인 페이지)
	@GetMapping("/{username}/{url}")
	public ModelAndView DtlBorderIndex(Model model, @PathVariable String url) {
		ModelAndView mav = new ModelAndView("border_dtl");
		mav.addObject("border", borderService.getDtlBorderIndex(url));
		return mav;
	}
	
	// myborder page (회원정보 페이지)
	@GetMapping({"/myborder/{username}", "/{username}"})
	public ModelAndView getBorderList(@PathVariable String username) {
		ModelAndView mav = new ModelAndView("myborder");
		mav.addObject("borderList", borderService.getBorderList(username));
		return mav;
	}

}
