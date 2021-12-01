package com.velog.config.auth;

//import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.velog.domain.user.User;

import lombok.Data;

@Data
public class PrincipalDetails implements UserDetails, OAuth2User{

	private static final long serialVersionUID = 1L;
	
	private User user;
	private Map<String, Object> attributes;
	
	// 일반로그인
	public PrincipalDetails(User user) {
		this.user = user;
	}
	
	// Oauth2 로그인
	public PrincipalDetails(User user, Map<String, Object> attributes) {
		this.user = user;
		this.attributes = attributes;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}

	// 계정 만료 - true
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	// 계정 lock - true
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	// 1년 이상 계정을 사용하지 않으면 휴면계정
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	// 계쩡을 임시탈퇴
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	// 구글 정보를 service에서 받아오고, 그걸 principaldetail에 저장되고 session에 또 저장
	@Override
	public Map<String, Object> getAttributes(){
		return attributes;
	}
	
	@Override
	public String getName() {
		return (String)attributes.get("name");
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}
	
}
