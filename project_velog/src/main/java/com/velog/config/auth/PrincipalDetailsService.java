package com.velog.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.velog.domain.user.User;
import com.velog.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

// loadUser메소드가 return되면 @AuthenticiationPrincipal 어노체이션을 사용할 수 있게 만들어 준다.
// @AuthenticationPrincipal 세션정보를 담는 공간

@RequiredArgsConstructor
@Service
public class PrincipalDetailsService implements UserDetailsService {
	
	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		User user = userRepository.getUser(username);
		if(user == null) {
			return null;
		}else {
			UserDetails principalDetails = new PrincipalDetails(user);
			System.out.println(user);
			return principalDetails;
		}
	}
	
}
