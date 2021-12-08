package com.velog.domain.border;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BorderRepository {
	
	public int insertBorder(Border border);

}
