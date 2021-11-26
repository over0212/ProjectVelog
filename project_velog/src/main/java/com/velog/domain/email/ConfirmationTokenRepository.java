package com.velog.domain.email;

import org.apache.ibatis.annotations.Mapper;

import com.velog.domain.user.User;
import com.velog.web.model.dto.email.EmailTokenDto;

@Mapper
public interface ConfirmationTokenRepository {
	
	public ConfirmationToken getConfirmationToken(EmailTokenDto emailTokenDto);
	
	public int createToken(ConfirmationToken confirmationToken);
	
	public int updateExpired(String confirmationTokenId);
	
	public User getUserByEmail(String email);
}
