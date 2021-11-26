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
			.antMatchers("/user/**")
			.authenticated()
			.anyRequest()
			.permitAll()
		  .and()
			.formLogin()
			.loginPage("login")
			.loginProcessingUrl("/sign-in")
			.defaultSuccessUrl("/")
		  .and()
		  .oauth2Login()
		  	.loginPage("login")
		  	.loginProcessingUrl("/auth/sign-in")
		  	.defaultSuccessUrl("/")
		  	.userInfoEndpoint()
		  	.userService(principalOauth2UserService);
	}
	
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
			
		
	}

}
