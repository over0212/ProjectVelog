<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

			<sec:authorize access="isAuthenticated()">
				<sec:authentication property="principal" var="principal" />
			</sec:authorize>

			<!DOCTYPE html>
			<html lang="ko">

			<head>
				<meta charset="UTF-8">
				<meta http-equiv="X-UA-Compatible" content="IE=edge">
				<meta name="viewport" content="width=device-width, initial-scale=1.0">
				<title>my velog</title>
				<link rel="stylesheet" href="/css/reset.css">
				<link rel="stylesheet" href="/css/header.css">
				<link rel="stylesheet" href="/css/myborder.css">
				<script src="http://code.jquery.com/jquery-latest.min.js"></script>
			</head>

			<body>
				<!-- border header -->
				<header>
					<div class="fixed_header">
						<div class="hd_wrap">
							<div class="hd_logo border_hd_logo">
								<a href="/" class="border_logo_img"><img class="border_hd_icon"
										src="/img/black_favicon.png" alt=""></a> <a href="#" class="hd_logo_a"><span
										class="border_logo_txt">${borderList[0].username}.log</span></a>
							</div>
							<div class="hd_btns">
								<button class="search_btn">
									<i class="fas fa-search search_icon"></i>
								</button>
								<c:choose>
									<c:when test="${empty principal.user }">
										<button class="login_btn header_btn" type="button"
											onclick="login()">로그인</button>
									</c:when>
									<c:otherwise>
										<button class="go_posting_btn header_btn" type="button">새
											글 작성</button>
										<div class="user_nav_wrap">
											<button class="user_btn" type="button">
												<img src="/image/profile/${(empty principal.user.profile_img_url) ? ('user_icon.png') : (principal.user.id += '/' += principal.user.profile_img_url)}"
													alt=""> <i class="fas fa-caret-down"></i>
											</button>
											<div class="user_nav">
												<ul>
													<li class="my_page"><a
															href="/border/myborder/${principal.user.username}">내 벨로그</a>
													</li>
													<li class="setting"><a href="/mypage/${principal.user.id}">설정</a>
													</li>
													<li class="logout"><a href="logout">로그아웃</a></li>
												</ul>
											</div>
										</div>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>
				</header>
				<!-- border list -->
				<div class="bl_container">
					<div class="bl_info_wrap">
						<div class="img_wrap">
							<img class="user_img"
								src="/image/profile/${(empty borderList[0].profile_img_url) ? ('user_icon.png') : (borderList[0].id += '/' += borderList[0].profile_img_url)}"
								alt="">
						</div>
						<div class="user_info">
							<h2 class="user_name">${borderList[0].username}</h2>
							<p class="user_comment">${borderList[0].comment}</p>
						</div>
					</div>
					<div class="seper_line"></div>
					<div class="social_banner">
						<ul class="socials">
							<a href="#"><i class="fab fa-github"><span>${principal.github }</span></i></a>
							<a href="#"><i class="fab fa-twitter"><span>${principal.twitter }</span></i></a>
							<a href="#"><i class="fab fa-facebook-square"><span>${principal.facebook }</span></i></a>
							<a href="#"><i class="fas fa-home"><span>${principal.home }</span></i></a>
							<a href="#"><i class="fas fa-envelope"><span>${principal.email }</span></i></a>
							<div class="emailText">${principal.email }</div>
						</ul>
					</div>
					<div class="border_nav">
						<a class="list">글</a> <a class="intro">소개</a>
					</div>
					<div class="content_write_box">
						<div class="bl_wrap">
							<div class="border_search_box">
								<div class="border_search">
									<i class="fas fa-search search_icon"></i> <input type="text" class="border_ip"
										placeholder="검색어를 입력하세요" autofocus>
								</div>
							</div>
							<c:forEach var="border_list" items="${borderList }">
								<div class="border_list">
									<a href="/border/${border_list.username }/${border_list.url }"
										class="to_detail"><img class="border_main_img"
											src="/image/${border_list.preview_img_url }" alt="" width="180px"
											height="180px"></a> <a
										href="/border/${border_list.username }/${border_list.url }" class="to_detail">
										<h2 class="border_title">${border_list.main_title}</h2>
									</a>
									<p class="border_pre_content">${border_list.preview_txt }</p>
									<div class="border_keyword">
										<c:forEach var="tag_list" items="${border_list.main_tags }">
											<a href="#">${tag_list }</a>
										</c:forEach>
									</div>
									<!-- 공지 날짜 및 댓글수 태그 -->
									<div class="border_subinfo">
										<span class="create_date">${border_list.create_date }</span> · <span
											class="count_reply">조회수 ${border_list.count }</span>
									</div>
								</div>
							</c:forEach>
						</div>
						<div class="border_control">
							<div class="tag_list">태그 목록</div>
							<ul class="items">
								<li><a href="#" class="item">전체보기</a><span>(1)</span></li>
								<li><a href="#" class="item">벨로그</a><span>(1)</span></li>
								<li><a href="#" class="item">벨로그</a><span>(1)</span></li>
							</ul>
						</div>
					</div>
					<div class="content_comment_box" style="display: none">
						<div class="comment_empty_hidden">
							<div class="comment_empty">
								<img src="/img/comment.svg" alt=""> <span class="empty_text">소개가
									작성되지 않았습니다.</span>
								<button type="button" class="comment_write_btn">소개 글 작성하기</button>
							</div>
						</div>
						<div class="comment_write_hidden" style="display: none;">
							<div class="comment_write_box">
								<button type="button" class="comment_save">저장하기</button>
							</div>
							<textarea class="comment_write" name="comment"
								placeholder="당신은 어떤 사람인가요? 당신의 대해서 알려주세요."></textarea>
							<p></p>
						</div>
					</div>
				</div>
			</body>
			<script src="https://kit.fontawesome.com/0b11c2b6d9.js" crossorigin="anonymous"></script>
			<script src="/js/header.js"></script>
			<script src="/js/myborder.js"></script>

			</html>