package com.velog.domain.border;

import org.apache.ibatis.annotations.Mapper;

import com.velog.web.model.dto.border.BorderDto;

@Mapper
public interface BorderRepository {
	
	public int insertBorder(BorderDto borderDto);

}
