package com.velog.domain.border;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BorderRepository {
	
	public int insertBorder(Border border);
	
	public Border getDtlBorderIndex(int id);
	
	public List<Border> getBorderList(int id);
	
	// index
	public List<Border> getBorderAll();

}
