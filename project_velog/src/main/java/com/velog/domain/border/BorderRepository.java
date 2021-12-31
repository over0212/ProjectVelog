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
	
	// insert like
	public int insertLike(int id, String url);
	
	// plus like
	public int plusLike(String url);
	
	// delete like
	public int deleteLike(int id, String url);
	
	// minus like
	public int minusLike(String url);
	
	// 내가 누른 좋아요인지 확인!
	public int getLikeUser(String url, int id);
	
	public int getLikeCount(String url);
	
	
}
