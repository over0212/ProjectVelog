package com.velog.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.velog.config.auth.PrincipalDetails;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BorderController {
	
	// myborder 페이지
	@GetMapping("/myborder/{username}")
	public String myVelog(@AuthenticationPrincipal PrincipalDetails principal) {
		if(principal.getUsername() == null) {
	      return "redirect:index";
	    }else {
	    	principal.setWriter(principal.getUser().getUsername());
	    	return "myborder";
	    }
	}
	
	// border-insert 페이지
	@GetMapping("/insert")
	public ModelAndView writePage() {
		ModelAndView mav = new ModelAndView("border_insert");
		return mav;
	}
	

}
