package com.velog.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.velog.web.model.dto.auth.SignUpDto;
import com.velog.web.model.dto.auth.SignUpRespDto;
import com.velog.web.service.AuthService;
import com.velog.web.service.ConfirmationTokenService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class SignRestController {
	
	private final AuthService authService;
	private final ConfirmationTokenService confirmationTokenService;
	
	@GetMapping("/email/send")
	public String sendEmail(@RequestParam String email) {
		confirmationTokenService.createEmailConfirmationToken(email);
		return "이메일 발송 완료.\n 이메일을 확인해주세요.";
	}

	
	@PostMapping("/sign-up")
	public SignUpRespDto<?> signUp(@RequestBody SignUpDto signUpDto) {
		int signUpFlag = authService.signUp(signUpDto);
		if(signUpFlag == 1) {
			//회원가입 성공
			SignUpRespDto<SignUpDto> signUpRespDto = new SignUpRespDto<SignUpDto>();
			signUpRespDto.setCode(200);
			signUpRespDto.setData(signUpDto);
			return signUpRespDto;
		}else {
			//회원가입 실패(아이디 중복)
			SignUpRespDto<String> signUpRespDto = new SignUpRespDto<String>();
			signUpRespDto.setCode(400);
			signUpRespDto.setData("이미 존재하는 아이디입니다.");
			return signUpRespDto;
		}
	}

}
