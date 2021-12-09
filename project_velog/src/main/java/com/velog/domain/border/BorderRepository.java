package com.velog.domain.border;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BorderRepository {
	
	public int insertBorder(Border border);
	
	public Border getDtlBorderIndex(String url);
	
	public List<Border> getBorderList(String username);
	
	// index
	public List<Border> getBorderAll();

}
