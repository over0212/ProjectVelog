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
            	<c:forEach var="indexList" items="${indexList }">
	                <div class="content_wrap">
	                    <a href="/border/${indexList.username }/${indexList.url }">
	                        <div class="img_box">
	                            <img src="/image/${indexList.preview_img_url }" alt="">
	                        </div>
	                    </a>
	                    <div class="text_wrap">
	                        <a href="/border/${indexList.username }/${indexList.url }">
	                            <h4 class="text_title">${indexList.main_title }</h4>
	                            <p class="text_area">${indexList.preview_txt }</p>
	                        </a>
	                        <div class="text_info_box">
	                            <span class="posting_date">${indexList.update_date }</span>
	                            <span class="seperator">·</span>
	                            <span class="reply_count">0개의 댓글</span>
	                        </div>
	                    </div>
	                    <div class="writer_info">
	                        <a href="" class="user_info">
	                            <img src="/image/profile/${(empty indexList.profile_img_url)? ('user_icon.png'):(indexList.id += '/' += indexList.profile_img_url)}" alt="" class="user_profile">
	                            <span>by <strong class=writer_name>${indexList.username }</strong></span>
	                        </a>
	                        <div class="likes">
	                            <i class="fas fa-heart"></i>
	                            <span>0</span>
	                        </div>
	                    </div>
	                </div>
            	</c:forEach>
            </div>
        </form>
    </div>

    <script src="https://kit.fontawesome.com/0b11c2b6d9.js" crossorigin="anonymous"></script>
    <script src="/js/index.js"></script>
</body>
</html>