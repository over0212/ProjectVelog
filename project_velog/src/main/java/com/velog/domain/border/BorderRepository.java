package com.velog.domain.border;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.velog.web.model.dto.border.BorderDto;
import com.velog.web.model.dto.border.BorderUpdateDto;

@Mapper
public interface BorderRepository {
	
	public int insertBorder(Border border);
	
	public Border getDtlBorderIndex(String url);
	
	public List<Border> getBorderList(String username);
	
	// index
	public List<Border> getBorderAll();
	
	//search
	public List<Border> searchBorder(String keyword);

	// update
	public int updateBorder(Border border);
	
	// delete
	public int deleteBorder(String url);
	
}
