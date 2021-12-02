package com.velog.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.velog.config.auth.PrincipalDetails;
import com.velog.web.model.dto.MypageDto;
import com.velog.web.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MypageController {

	private final UserService userService;

	@PatchMapping("/mypage/front/{id}")
	public String name(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable int id,
			@RequestBody MypageDto mypageDto) {

		int result = userService.updateMypage(mypageDto, id);

		if (result == 1) {
			principalDetails.getUser().setName(mypageDto.getName());
			principalDetails.getUser().setComment(mypageDto.getComment());
		}
		return Integer.toString(result);
	}

	@PatchMapping("/mypage/username/{id}")
	public String title(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable int id,
			@RequestBody MypageDto mypageDto) {

		int result = userService.updateMypageUsername(mypageDto, id);
		if (result == 1) {
			principalDetails.getUser().setUsername(mypageDto.getUsername());

		}
		return Integer.toString(result);
	}

}
