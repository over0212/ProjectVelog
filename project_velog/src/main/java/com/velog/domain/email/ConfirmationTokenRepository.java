package com.velog.domain.email;

import org.apache.ibatis.annotations.Mapper;

import com.velog.domain.user.User;
import com.velog.web.model.dto.email.EmailTokenDto;

@Mapper
public interface ConfirmationTokenRepository {
	
	// 확인된 토큰의 정보를 들고온다.
	public ConfirmationToken getConfirmationToken(EmailTokenDto emailTokenDto);
	
	// 토큰을 생성한다.
	public int createToken(ConfirmationToken confirmationToken);
	
	// 토큰의 아이디를 가져와서 만료가 되었다는 것을 바꿔준다.
	public int updateExpired(String confirmationTokenId);
	
	// user_mst에 있는 유저정보에서 email을 가져와 입력된 이메일과 비교한다.
	public User getUserByEmail(String email);
}
