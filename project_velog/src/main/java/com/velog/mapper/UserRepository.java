package com.velog.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
	
	public String userEmailCheck(String token);
	
	public String findById(String id);
	
}
