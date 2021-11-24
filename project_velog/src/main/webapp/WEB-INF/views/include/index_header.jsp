<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="hd_index_wrap">
    <div class="index_hd">
        <div class="nav_wrap">
            <a href="#" class="nav_trending">
                <img src="img/growth-graph.png" alt=""> 트렌딩
            </a>
            <a href="/recent" class="nav_recent">
                <i class="far fa-clock"></i> 최신
                <div class="nav_underline"></div>
            </a>                
        </div>
        <div class="times_wrap">
            이번 주
            <i class="fas fa-caret-down"></i>
        </div>
        <div class="times_select_box nav_box">
            <ul>
                <li class="today"><a href="#">오늘</a></li>
                <li class="this_week" ><a href="#">이번주</a></li>
                <li class="this_month"><a href="#">이번 달</a></li>
                <li class="this_year"><a href="#">올해</a></li>
            </ul>
        </div>
    </div>
    <div class="plus_btn_wrap">
        <a href="#" class="plus_btn"><i class="fas fa-ellipsis-v"></i></a>
        <div class="plus_nav_box">
            <ul>
                <li><a href="#">공지사항</a></li>
                <li><a href="#">태그 목록</a></li>
                <li><a href="#">서비스 정책</a></li>
                <li><a href="#">Slack</a></li>
                <li class="plus_nav_contact">
                        <strong>문의</strong><br>
                        coqja2014@gmail.com
                </li>
            </ul>
        </div>
    </div>
</div>