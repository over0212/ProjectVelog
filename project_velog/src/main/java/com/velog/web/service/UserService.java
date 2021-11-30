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
	private final ConfirmationTokenService confirmationTokenService;
	
	public void confirmEmail(String token) {
		confirmationTokenService.getToken(token);
	}
	
	@Transactional
	public int updateMypage(MypageDto mypageDto, int id) {
		int completeCount = 0;
		
		Mypage mypage = mypageDto.toEntity(id);
		completeCount += userRepository.updateFrontName(mypage);
		completeCount += userRepository.updateFrontContent(mypage);
		
		return completeCount;
	}
	
	@Transactional
	public int updateMypageTitle(MypageDto mypageDto, int id) {
		int completeCount = 0;
		
		Mypage mypage = mypageDto.toEntity(id);
		completeCount += userRepository.updateFrontTitle(mypage);
		
		return completeCount;
	}
	
	public int deleteUser(int id) {
		int deleteFlag = userRepository.deleteUser(id);
		return deleteFlag;
	}

}
