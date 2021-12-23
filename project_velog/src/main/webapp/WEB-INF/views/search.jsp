<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal" />
</sec:authorize>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>search</title>
<link rel="stylesheet" href="/css/reset.css">
<link rel="stylesheet" href="/css/search.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<!-- header -->
	<jsp:include page="include/main_header.jsp"></jsp:include>

	<!-- 검색창 -->
	<main id="main">
		<div class="main_in">
				<div class="search_icons">
					<i class="fas fa-search search_icon"></i>
				</div>
				<input type="search" class="keyword" name="" id="search" placeholder="검색어를 입력하세요" autofocus>
		</div>
	</main>

	<div id="search_body">
			<p class="s_count">
				총 <b>123개</b>의 포스트를 찾았습니다.
			</p>
		<%-- <div id="search_list">
			<section id="s_form">
				<div class="s_user_info">
					<a href="" class="s_user_img"><img src="" alt=""></a>
					<a href="" class="s_user_username"></a>
				</div>
				<div class="s_border">
					<a href="" class="s_border_img"><img src="" alt=""></a>
					<a href="" class="s_border_title"><h2></h2></a>
					<p class="s_txt"></p>
				</div>
				<div class="s_tag_list">
					<a href="#"></a>
				</div>
				<div class="sub_info">
					<span class="s_date"></span>
				</div>
			</section>
		</div> --%>
	</div>


	<script src="https://kit.fontawesome.com/0b11c2b6d9.js" crossorigin="anonymous"></script>
	<script src="/js/search.js"></script>
</body>
</html>