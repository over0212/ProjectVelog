package com.velog.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.velog.web.service.AuthService;
import com.velog.web.service.ConfirmationTokenService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/velog")
public class AuthController {
	
	private final ConfirmationTokenService confirmationTokenService;
	
	private final AuthService authService;
	
	@GetMapping("/email/send")
	public String sendEmail(@RequestParam String email) {
		confirmationTokenService.createEmailConfirmationToken(email);
		return "index";
	}
	
	@GetMapping("/confirm-email")
	public String viewConfirmEmail(@RequestParam String token) {
		System.out.println(token);
		authService.confirmEmail(token);
		return "";
		
	}

}
