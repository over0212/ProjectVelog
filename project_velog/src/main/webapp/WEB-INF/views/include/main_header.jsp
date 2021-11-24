<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header>
	<div class="fixed_header">
		<div class="hd_wrap">
			<!-- 로고 -->
			<div class="hd_logo">
				<a href="index"><span class="hd_logo_txt">velog</span></a>
			</div>
			<!-- 왼쪽상단 -->
			<div class="hd_btns">
				<!-- 검색 버튼 -->
				<a href="search" class="search_btn"><i class="fas fa-search search_icon"></i></a>
				<%-- <c:choose>
					<!-- empty login_user인 경우 로그인 버튼 보이게 -->	
                	<c:when test=""> --%>
				<!-- 로그인 버튼 -->
				<button class="login_btn header_btn" type="button">로그인</button>
				 <%-- </c:when>
					<!-- login_user가 있는 경우 글입력버튼 및 user_nav 추가 -->	
                	<c:otherwise>
					<button class="go_posting_btn header_btn" type="button" style="display: none;">새 글 작성</button>
				<div class="user_nav_wrap" style="display: none;">
					<a href=""> <img src="/img/user_icon.png" alt=""> <i class="fas fa-caret-down"></i>
					</a>
					<div class="user_nav nav_box">
						<ul>
							<li class="my_page"><a href="#">내 벨로그</a></li>
							<li class="temp_post"><a href="#">임시 글</a></li>
							<li class="read_list"><a href="#">읽기 목록</a></li>
							<li class="setting"><a href="#">설정</a></li>
							<li class="logout"><a href="#">로그아웃</a></li>
						</ul>
					</div>
				</div> 
				 </c:otherwise>
                </c:choose>  --%>
			</div>
		</div>
	</div>
	<jsp:include page="sign_in.jsp"></jsp:include>
</header>
