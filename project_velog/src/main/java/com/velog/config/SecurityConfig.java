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
		http.authorizeRequests()
			.antMatchers("/index", "/user/**")
			.authenticated()
			.anyRequest()
			.permitAll()
		  .and()
		  .formLogin()
		  	.loginPage("/auth/sign")
		  	.loginProcessingUrl("/auth/signin") // post Controller 실행?
		  	.defaultSuccessUrl("/index") // 로그인 성공시 이동할 URL
		  .and()
		  .oauth2Login()
		  	.loginPage("/auth/signin")
		  	.userInfoEndpoint()
		  	.userService(principalOauth2UserService);
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
