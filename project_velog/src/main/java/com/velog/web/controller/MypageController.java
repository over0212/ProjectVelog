package com.velog.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.velog.web.model.dto.MypageDto;
import com.velog.web.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MypageController {
	
	private final UserService userService;
	
	@GetMapping("/mypage/{id}")
	public String Mypage(/*@AuthenticationPrincipal PrincipalDetails principal*/) {
	    /*if(principal.getUsername() == null ) {
	      return "redirect:index";
	    }*/
		return "mypage";
	}
	
	@ResponseBody
	@PatchMapping("/mypage/front/{id}")
	public String name(@PathVariable int id,
					   @RequestBody MypageDto mypageDto) {
		
		return Integer.toString(userService.updateMypage(mypageDto, id));
	}
	
	@ResponseBody
	@PatchMapping("/mypage/front_username/{id}")
	public String title(@PathVariable int id,
			@RequestBody MypageDto mypageDto) {
		
		return Integer.toString(userService.updateMypage_Username(mypageDto, id));
	}
	

}













