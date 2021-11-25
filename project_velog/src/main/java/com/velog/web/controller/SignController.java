package com.velog.web.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/velog")
@RequiredArgsConstructor
public class SignController {
	
	@GetMapping("/confirm-email")
	public String sendEmail() {
		
		return "";
	}
	
	@GetMapping("/sign-up")
	public String signUpIndex() {
		return "sign_up";
	}

}
