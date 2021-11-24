package com.velog.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/velog")
public class PageController {
	
	// 메인 페이지
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	// 검색 페이지
	@GetMapping("/search")
	public String searchPage() {
		return "search";
	}
	
	// 서비스 정책 -> 이용약관
	@GetMapping("/terms")
	public ModelAndView termsPage() {
		ModelAndView mav = new ModelAndView("terms");
		return mav;
	}
	
	// 서비스 정책 -> 개인정보처리방침
	@GetMapping("/privacy")
	public ModelAndView privacyPage() {
		ModelAndView mav = new ModelAndView("privacy");
		return mav;
	}
	
}
