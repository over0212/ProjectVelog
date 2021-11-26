package com.velog.web.service;

import org.springframework.stereotype.Service;

<<<<<<< HEAD
import com.velog.domain.ConfirmToken;
import com.velog.domain.user.UserDto;
import com.velog.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;
=======
import com.velog.web.model.dto.SignUpDto;
>>>>>>> d9e983874a3304581c045165367c4fdc5bfda303

@Service
public interface UserService {

	public int signUp(SignUpDto signUpDto);
	

}
