<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="sce" uri="http://www.springframework.org/security/tags" %>
<sce:authorize access="isAuthenticated()">
	<sce:authentication property="principal" var="principal"/>
</sce:authorize>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>설정 -velog</title>
    <link rel="stylesheet" href="/css/reset.css">
    <link rel="stylesheet" href="/css/header.css">
    <link rel="stylesheet" href="/css/mypage.css">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
    <div class="mp_container">
        <header>
            <div class="fixed_header">
                <div class="hd_wrap">
                    <div class="hd_logo"><a href="#"><span class="hd_logo_txt">velog</span></a></div>
                    <div class="hd_btns">
                        <button class="search_btn"><i class="fas fa-search search_icon"></i></button>
                        <button class="login_btn" type="button">로그인</button>
                        <button class="go_posting_btn header_btn" type="button" style="display: none;">새 글 작성</button>
                        <div class="user_nav_wrap" style="display: none;">
                            <a href="">
                                <img src="img/user_icon.png" alt="">
                                <i class="fas fa-caret-down"></i>
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
                    </div>
                </div>
            </div>
        </header>
        <div class="mp_main">
            <div class="mp_profile">
                <div class="mp_img">
                    <div class="my_img"><img src="/img/user_icon.png" alt=""></div>
                    <button class="img_insert">이미지 업로드</button>
                    <button class="img_delete">이미지 제거</button>
                </div>
                <div class="top_info">
                    <h2 class= "name">${principal.name }</h2>
                    <p>${principal.txt }</p>
                    <div class="info_modify_box">
                        <button class="info_modify">수정</button>
                    </div>
                </div>
                <div class="top_info_creative">
                    <input type="text" class="info_name">
                    <input type="text" class="info_text">
                    <div class="info_save_box"><button class="info_save">저장</button></div>
                </div>
            </div>
            <div class="middle_info">
                <div class="mp_info">
                    <div class="creative_info">
                        <div class="velog_title">
                            <h3>벨로그 제목</h3>
                            <div class="contents_box">
                                <div class="contents">${principal.username }</div>
                            </div>
                            <div class="info_modify_box">
                                <button class="info_modify">수정</button>
                            </div>
                            
                            <div class="title_box_hidden">
                                <div class="title_creative_box">
                                    <input type="text" class="title_creative">
                                    <div class="info_save_box"><button class="info_save">저장</button></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="info_explanation">개인 페이지의 좌측 상단에 나타나는 페이지 제목입니다.</div>
                </div>
                <div class="mp_info">
                    <div class="creative_info">
                        <div class="velog_title">
                            <h3>소셜 정보</h3>
                            <div class="info_modify_box">
                                <button class="info_modify">정보 추가</button>
                            </div>
                            <div class="title_box_hidden">
                                <div class="icon_box_block">
                                    <div class="icon_box">
                                        <div class="icon"><div class="i"><i class="fas fa-envelope"></i></div><input type="text" placeholder="이메일을 입력하세요."></div>
                                        <div class="icon"><div class="i"><i class="fab fa-github"></i></div><input type="text" placeholder="Github 계정을 입력하세요."></div>
                                        <div class="icon"><div class="i"><i class="fab fa-twitter"></i></div><input type="text" placeholder="Twitter 계정을 입력하세요."></div>
                                        <div class="icon"><div class="i"><i class="fab fa-facebook-square"></i></div><input type="text" placeholder="http://facebook.com/"></div>
                                        <div class="icon"><div class="i"><i class="fas fa-home"></i></div><input type="text" placeholder="홈페이지 주소를 입력하세요."></div>
                                    </div>
                                    <div class="info_save_box"><button class="info_save">저장</button></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="info_explanation">포스트 및 블로그에서 보여지는 프로필에 공개되는 소셜 정보입니다.</div>
                </div>
                <div class="mp_info">
                    <div class="creative_info">
                        <div class="velog_title">
                            <h3>이메일 주소</h3>
                            <div class="contents_box">
                                <div class="contents">(이메일 고정)</div>
                            </div>
                        </div>
                    </div>
                    <div class="info_explanation">회원 인증 또는 시스템에서 발송하는 이메일을 수신하는 주소입니다.</div>
                </div>
                <div class="mp_info">
                    <div class="creative_info_comments">
                        <div class="velog_title">
                            <h3>이메일 수신 설정</h3>
                        </div>
                        <div class="info_switch_box">

                            <div class="info_switch">
                                <span>댓글 알림</span>
                                <div class="switch_off">
                                    <div class="switch_on">
                                        <div class="circle"></div>
                                    </div>
                                </div>
                            </div>

                            <div class="info_switch">
                                <span>벨로그 업데이트 소식</span>
                                <div class="switch_off">
                                    <div class="switch_on">
                                        <div class="circle"></div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="mp_info">
                    <div class="creative_info_out">
                        <h3>회원 탈퇴</h3>
                        <button class="info_out">회원 탈퇴</button>
                    </div>
                    <div class="info_explanation">탈퇴 시 작성하신 포스트 및 댓글이 모두 삭제되며 복구되지 않습니다.</div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://kit.fontawesome.com/0b11c2b6d9.js" crossorigin="anonymous"></script>
    <script src="/js/mypage.js"></script>
</body>
</html>