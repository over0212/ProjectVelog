package com.velog.config.oauth2;

import java.util.Map;
import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.velog.config.auth.PrincipalDetails;
import com.velog.config.oauth2.provider.Oauth2UserDto;
import com.velog.domain.user.User;
import com.velog.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
	
	private final UserRepository userRepository;
	
	public OAuth2User loadUser(OAuth2UserRequest userRequest) {
		System.out.println(userRequest.getClientRegistration()); // 로그인한 사용자 정보 가져오기
		System.out.println(userRequest.getAccessToken()); // 접근 토큰 가져오기
		System.out.println(super.loadUser(userRequest).getAttributes()); // 사이트에 저장된 사용자 정보 -> 이걸로 로그인 정보 활용할 것, 어느 사이트에서 접근한 건지도 가져올 것!
		
		OAuth2User oAuth2User = super.loadUser(userRequest); // user 정보 담은 Oauth2User 객체 생성
		Map<String, Object> attributes = oAuth2User.getAttributes(); // super.loadUser(userRequest)에서 출력한 정보를 map형태로 담음(key입력하면 정보 가져올 수 있다.)
		
		String email = "";
		String username = "";
		
		// 정보 가공시키기
		String provider = userRequest.getClientRegistration().getRegistrationId(); // 접근 사이트 가져오기
		if(provider.equals("google")) {
			email = (String)attributes.get("email");
			System.out.println(email);
			username = email.substring(0, email.lastIndexOf("@"));
		}else if(provider.equals("naver")) {
			attributes = (Map<String, Object>)attributes.get("response");
			email = (String)attributes.get("email");
			username = email.substring(0, email.lastIndexOf("@"));
		}else if(provider.equals("github")) {
			username = (String) attributes.get("login");
			if(attributes.get("email") == null) {
				email = username + "@github.com";
			}else {
				email = (String) attributes.get("email");
			}
		}
		
		// 처음 로그인하면 우리 회원으로 insert
		// UserRepository 필요! (상단에 선언)
		// user 객체 생성해서 username 담아주기
		User userEntity = userRepository.getUser(email);
		if(userEntity == null) {
			// 처음 로그인시 -> DB에 insert
			Oauth2UserDto oauth2UserDto = Oauth2UserDto.builder()
												.username(username)
												.password(new BCryptPasswordEncoder().encode(UUID.randomUUID().toString())) // 패스워드 입시발급
												.email(email)
												.name((String)attributes.get("name"))
												.provider(provider)
												.build();
			// userEntity 에 담아주기
			userEntity = oauth2UserDto.toEntity();
			userRepository.signup(userEntity);
		}
		
		// 이미 회원가입 되어있는 provider 계정은 userEntity가 들어와있으니 넣어주기만 하면 끝
		return new PrincipalDetails(userEntity, attributes);
	}
	
	
}
