<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>velog (벨로그) - velog</title>
    <link rel="stylesheet" href="/css/reset.css">
    <link rel="stylesheet" href="/css/notice.css">
</head>
<body>
    <jsp:include page="include/main_header.jsp"></jsp:include>
    <div class="notice_container">
        <div class="notice_body">
            <!-- 벨로그 로고 및 소개글 -->
            <div class="velog_introduction_box"><!--변수명 수정 필요 -->
                <div class="img_box"><img src="/img/green favicon.png" class="velog_logo" alt=""></div>
                <div class="velog_info_box">
                    <div class="velog_name"><a href="">벨로그</a></div>
                    <div class="velog_info">
                        벨로그 공식 계정입니다. 
                        공지사항 및 벨로그 프로젝트 관련 포스트를 올립니다.
                    </div>
                </div>
            </div>
            <div class="notice_info_line"></div>
                <!-- 글,시리즈,소개 선택 메뉴 (선택시 불들어오는 js구현 필요)-->
            <div class="notice_menu">
                <a href="#" class="menu_writing">글</a>
                <a href="#" class="menu_introduction">소개</a>
            </div>
            <div class="notice_main">
                <!-- 공지사항 검색기능 (input focus시 불들어오는 js구현 필요) -->
                <div class="notice_search_box">
                    <div class="notice_search">
                        <i class="fas fa-search search_icon"></i>
                        <input type="text" class="notice_ip" placeholder="검색어를 입력하세요" autofocus>
                    </div>
                </div>
                <div class="notice">
                    <!-- 공지 이미지 태그 (이미지 미첨부시에 js구현필요)-->
                    <a href="#"><img src="/img/Group 2.png" alt=""></a>
                    <!-- 공지 제목 태그 -->
                    <h2>독자들에게 후원을 받아보세요: ThankYouFor___</h2>
                    <!-- 공지 내용 태그 -->
                    <p>
                        해외의 Buy Me a Coffee와 유사한 서비스 ThankYouFor___를 소개드립니다. 
                        이 서비스는 카카오페이로 결제가 가능하며, 
                        서비스 수수료가 0% 입니다. (참고: 이 서비스는 벨로그와 관계가 없습니다.)
                    </p>
                    <!-- 공지 키워드 태그 (키워드 미등록시에 js구현필요)-->
                    <div class="notice_keyword">
                        <a href="#">도레미</a>
                        <a href="#">파솔라시</a>
                        <a href="#">도레이파솔</a>
                        <a href="#">라시도레미파</a>
                        <a href="#">솔라시도레미파</a>
                        <a href="#">솔라시도레미파솔</a>
                        <a href="#">라시도레미파솔라시</a>
                        <a href="#">도레미파솔라시도레미</a>
                    </div>
                    <!-- 공지 날짜 및 댓글수 태그 -->
                    <div class="notice_subinfo">
                        <div class="create_date">1996년 00월 00일</div>
                        ·
                        <div class="coutn_reply">99개의 댓글</d>
                    </div>
                </div>
        </div>
    </div>
    <script src="/js/notice.js"></script>
    <script src="https://kit.fontawesome.com/0b11c2b6d9.js" crossorigin="anonymous"></script>
</body>
</html>