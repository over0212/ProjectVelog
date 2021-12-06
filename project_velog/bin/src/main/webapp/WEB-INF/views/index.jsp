<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal"/>
</sec:authorize>
    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>velog</title>
    <link rel="stylesheet" href="/css/reset.css">
    <link rel="stylesheet" href="/css/index.css">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>

<body>
    <jsp:include page="include/main_header.jsp"></jsp:include>
    <!-- index main -->
    <div class="index_wrap">
        <!-- index header -->
        <jsp:include page="include/index_header.jsp"></jsp:include>
    	<!-- content grid -->
        <form class="contents">
            <div class="contents_wrap">
            	<%-- <c:forEach var="" items=""> --%>
	                <div class="content_wrap">
	                    <a href="#">
	                        <div class="img_box">
	                            <img src="/img/test_content.png" alt="">
	                        </div>
	                    </a>
	                    <div class="text_wrap">
	                        <a href="#">
	                            <h4 class="text_title">카카오엔터프라이즈 개발 인턴 합격 후기</h4>
	                            <p class="text_area">얼마전 중간고사가 끝나고 조금 편하게 생활을 즐기던 중, 방학 때 무언가라도 하고 싶어 인턴을 찾게 되었다.하지만 나는 현재 5학기생이고, 온라인으로 찾는 인턴은 대부분 채용 연계형 인턴이라 2022년에 졸업 예정인 사람만 지원할 수 있었다.</p>
	                        </a>
	                        <div class="text_info_box">
	                            <span class="posting_date">2021년 11월 12일</span>
	                            <span class="seperator">·</span>
	                            <span class="reply_count">0개의 댓글</span>
	                        </div>
	                    </div>
	                    <div class="writer_info">
	                        <a href="" class="user_info">
	                            <img src="" alt="" class="user_profile">
	                            <span>by <b>username</b></span>
	                        </a>
	                        <div class="likes">
	                            <i class="fas fa-heart"></i>
	                            59
	                        </div>
	                    </div>
	                </div>
            	<%-- </c:forEach> --%>
            </div>
        </form>
    </div>

    <script src="https://kit.fontawesome.com/0b11c2b6d9.js" crossorigin="anonymous"></script>
    <script src="/js/index.js"></script>
</body>
</html>