package com.velog.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.velog.web.model.dto.SignUpDto;
import com.velog.web.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("velog")
public class SignRestController {
	
	private UserService userService;
	
	@PostMapping("/sign-up")
	public String signup(@RequestBody SignUpDto signUpDto) {
		return Integer.toString(userService.signUp(signUpDto));
	}

}
