package com.velog.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.velog.config.auth.PrincipalDetails;
import com.velog.web.service.IndexService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {

	private final IndexService indexService;

	/**
	 * TODO index(recent)로 변경할 것
	 */
	// recent
	@GetMapping({ "/", "/index" })
	public ModelAndView index(@AuthenticationPrincipal PrincipalDetails principalDetails) {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("indexList", indexService.getIndexList());
		return mav;
	}

	// today
	@GetMapping("/index/today")
	public ModelAndView todayIndex() {
		ModelAndView mav = new ModelAndView("index_today");
		mav.addObject("indexList", indexService.getTodayIndexList());
		return mav;
	}

	// this week
	@GetMapping("/index/week")
	public ModelAndView WeekIndex() {
		ModelAndView mav = new ModelAndView("index_week");
		mav.addObject("indexList", indexService.getWeekIndexList());
		return mav;
	}

	// this month
	@GetMapping("/index/month")
	public ModelAndView MonthIndex() {
		ModelAndView mav = new ModelAndView("index_month");
		mav.addObject("indexList", indexService.getMonthIndexList());
		return mav;
	}

	// this year
	@GetMapping("/index/year")
	public ModelAndView YearIndex() {
		ModelAndView mav = new ModelAndView("index_year");
		mav.addObject("indexList", indexService.getYearIndexList());
		return mav;
	}

}
