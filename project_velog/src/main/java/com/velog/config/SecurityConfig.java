package com.velog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.velog.config.oauth2.PrincipalOauth2UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration // IOC 등록
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final PrincipalOauth2UserService principalOauth2UserService;

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests() // 사용자의 인증객체
				.antMatchers("/mypage/**", "/myborder/**", "/border/insert/**", "/border/update/**").authenticated() // 인증이 필요하다
				.anyRequest() // antMatchers 외에 모든 요청
				.permitAll() // 요청이 없어도 된다(모든권한 부여)
				.and()
				.logout() // 로그아웃
				.logoutUrl("/logout") // 
				.logoutSuccessUrl("/")
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				.and()
				.formLogin() // 로그인 페이지 커스텀
				.loginPage("/login") // get 요청
				.loginProcessingUrl("/sign-in") // post controller 따로 만들 필요없음 (security가 자동 처리)
				.defaultSuccessUrl("/") // 로그인 성공시 이동할 URL
				.and()
				.oauth2Login() // Oauth2 로그인 페이지 커스텀
				.loginPage("/login") // get 요청

				.userInfoEndpoint()
				/*
				 * 1. 코드 받아옴 (인증) 2. 에세스 토큰 (권한) 3. 사용자 프로필 정보 가져옴 4. 그 정보를 토대로 회원가입 자동으로 insert
				 * 
				 * oauth2 client를 쓰게되면 데이터를 한번에 받아옴
				 */
				.userService(principalOauth2UserService) // 로그인 성공시 이동
				.and()
				.defaultSuccessUrl("/");
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
