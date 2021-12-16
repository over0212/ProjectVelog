<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <title>게시글</title>
    <link rel="stylesheet" href="/css/reset.css">
    <link rel="stylesheet" href="/css/border_dtl.css">
    <link rel="stylesheet" href="/css/border_insert.css">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
  <jsp:include page="include/main_header.jsp"></jsp:include>
    <main id="main">
        <div id="dtl_container">
            <!-- 헤더부분 -->
            <section id="dtl_head">
                <div class="dtl_title">
                    <h1>${border.main_title }</h1>
                </div>
                <div class="dtl_nav">
                    <div class="dtl_info">
                        <a href="/border/${border.username }">${border.username }</a>
                        <span class="dtl_point">·</span>
                        <span class="dtl_date">${border.create_date }</span>
                    </div>
                    <div class="dtl_btn">
                    <c:if test="${(border.username) == (principal.user.username) }">
                    	<input id="username" type="hidden" value="${principal.user.username}">
                    	<input id="url" type="hidden" value="${border.url }">
                        <button type="button" class="update_btn">수정</button>
                        <button type="button" class="delete_btn">삭제</button>
                    </c:if>
                    </div>
                </div>
            </section>
    
            <!-- 메인 컨텐츠 부분 -->
            <section class="dtl_body">
                <input class="main_content" type="hidden" value="${border.main_content }">
                <div class="pre_txt"></div>
            </section>
    
            <!-- 하단 프로필 부분 -->
            <section id="footer">
                <a href="/border/${border.username }">
                <img src="/image/profile/${(empty border.profile_img_url) ? ('user_icon.png') : (border.id += '/' += border.profile_img_url)}" alt="" width="180px" height="180px"></a>
                <div class="user_info">
                    <a href="/border/${border.username }" class="dtl_writer">${border.username }</a>
                    <span class="dtl_comment">${border.comment }</span>
                </div>
            </section>
        </div>
    </main>
    <script type="text/javascript" src="/js/border_dtl.js"></script>
    <script type="text/javascript" src="/js/write.js"></script>
</body>
</html>