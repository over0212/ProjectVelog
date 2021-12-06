package com.velog.web.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.velog.web.service.AuthService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AuthController {
	
	private final AuthService authService;
	
	@GetMapping("/confirm-email")
	public String signUpForm(Model model, @RequestParam String token) {
		Map<String, String> confirmResult = authService.confirmEmail(token);
		
		if(confirmResult.get("tokenFlag").equals("0")) {
			return "redirect:/token-expired";
		} else if (confirmResult.get("tokenFlag").equals("1")) {
			model.addAttribute("email", confirmResult.get("email"));
			model.addAttribute("token", token);
			return "sign_up";
		} else {
			model.addAttribute("username", confirmResult.get("email"));
			model.addAttribute("password", token);
			return "sign_in_post";
		}
	}

}
