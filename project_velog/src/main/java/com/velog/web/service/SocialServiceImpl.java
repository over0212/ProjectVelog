package com.velog.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velog.domain.user.Mypage;
import com.velog.domain.user.User;
import com.velog.domain.user.UserRepository;
import com.velog.web.model.dto.mypage.MypageDto;

@Service
public class SocialServiceImpl implements SocialService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public int updateSocial(MypageDto mypageDto, int id) {
		Mypage mypage = mypageDto.toMEntity(id);
		
		int result = userRepository.updateSocial(mypage);
		
		if (mypageDto.getSocial_email() != "") {
			return result;
		} else if (mypageDto.getSocial_github() != "") {
			return result;
		} else if (mypageDto.getSocial_twitter() != "") {
			return result;
		} else if (mypageDto.getSocial_facebook() != "") {
			return result;
		} else if (mypageDto.getSocial_home() != "") {
			return result;
		} else {
			return 0;
		}
	}
}
