package com.velog.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.velog.config.auth.PrincipalDetails;
import com.velog.web.model.dto.mypage.MypageDto;
import com.velog.web.service.ImgService;
import com.velog.web.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MypageController {
	
	private final UserService userService;
	private final ImgService imgService;
	
	
	@PatchMapping("/mypage/front/{id}")
	public String name(@AuthenticationPrincipal PrincipalDetails principalDetails,  @PathVariable int id,
					   @RequestBody MypageDto mypageDto) {
		int result = userService.updateMypage(mypageDto, id);
		if(result == 1) {
			principalDetails.getUser().setName(mypageDto.getName());
			principalDetails.getUser().setComment(mypageDto.getComment());
			return Integer.toString(result);
		}
		return Integer.toString(result);
	}
	
	@PatchMapping("/mypage/username/{id}")
	public String title(@PathVariable int id,
			@RequestBody MypageDto mypageDto) {
		return Integer.toString(userService.updateMypageUsername(mypageDto, id));
	}
	
	@PostMapping("/mypage/imgUpload/{id}")
		public String imgInsert(MypageDto mypageDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		      String imageFile = imgService.fileUpload(principalDetails.getUser().getUsername(),mypageDto);
		      mypageDto.setMypageImg();
		      return imageFile;
	}
}












