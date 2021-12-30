package com.velog.domain.border;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.velog.domain.user.User;

@Mapper
public interface BorderRepository {
	
	public int insertBorder(Border border);
	
	public Border getDtlBorderIndex(String url);
	
	public int plusBorderCount(String url);
	
	public List<Border> getBorderList(String username);
	
	// index(recent)
	public List<Border> getBorderAll();
	
	// today
	public List<Border> getBorderToday();
	
	// this week
	public List<Border> getBorderWeek();
	
	// this month
	public List<Border> getBorderMonth();
	
	// this year
	public List<Border> getBorderYear();
	
	//search
	public List<Border> searchBorder(String keyword);

	// update
	public int updateBorder(Border border);
	
	// delete
	public int deleteBorder(String url);
	
	public int updateMyborder(User user);
	
}
