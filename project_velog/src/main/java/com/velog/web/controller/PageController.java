package com.velog.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.velog.config.auth.PrincipalDetails;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PageController {
	
	@GetMapping("/token-expired")
	public String tokenExpired() {
		return "token_expired";
	}
	
	// 메인 페이지
	@GetMapping({"/", "/index"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
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
	
	@GetMapping("/trending-tag")
	public ModelAndView trendingTagPage() {
		ModelAndView mav = new ModelAndView("trending_tag");
		return mav;
	}
	
	@GetMapping("/trending-name")
	public ModelAndView trendingNamePage() {
		ModelAndView mav = new ModelAndView("trending_name");
		return mav;
	}
	
	@GetMapping("/mypage/{id}")
	public String Mypage(@AuthenticationPrincipal PrincipalDetails principal) {
	    if(principal.getUsername() == null) {
	      return "redirect:index";
	    }else {
	    	return "mypage";
	    }
	}
	
	// notice 페이지
	@GetMapping("/notice")
	public ModelAndView notice(){
		ModelAndView mav = new ModelAndView("notice");
		return mav;
	}
}
