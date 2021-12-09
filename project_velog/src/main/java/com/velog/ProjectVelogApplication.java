package com.velog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ProjectVelogApplication extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ProjectVelogApplication.class);
	} // war를 실행하기 위해선 외부의 톰캣이 실행될 때 이 클래스를 실행하라는 뜻을 의미

	public static void main(String[] args) {
		SpringApplication.run(ProjectVelogApplication.class, args);
	}

}
