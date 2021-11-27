package com.velog.web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.velog.domain.user.Mypage;
import com.velog.domain.user.UserRepository;
import com.velog.web.model.dto.MypageDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
	
	private final UserRepository userRepository;
	private final TokenService tokenService;
	
	public void confirmEmail(String token) {
//		ConfirmToken confirmToken = tokenService.getConfirmToken(token);
//		UserRepository userRepository = 
		
	}
	
	@Transactional
	public int updateMypage(MypageDto mypageDto, int id) {
		int completeCount = 0;
		
		Mypage mypage = mypageDto.toEntity(id);
		completeCount += userRepository.updateFrontName(mypage);
		completeCount += userRepository.updateFrontContent(mypage);
		
		return completeCount;
	}

}
