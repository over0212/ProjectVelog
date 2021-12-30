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
<title>설정 -velog</title>
<link rel="stylesheet" href="/css/reset.css">
<link rel="stylesheet" href="/css/mypage.css">
<link rel="stylesheet" href="/css/sign_out.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<div class="mp_container">
		<jsp:include page="include/main_header.jsp"></jsp:include>
		<div class="mp_main">
			<div class="mp_profile">
				<div class="mp_img">
					<form id="insert_img">
						<div class="my_img"> 
							<input type="file" name="file" id="imgFile" " onchange="img_Upload()" style="display: none"></input>
							<img class = "profileimg" src="/image/profile/${(empty principal.user.profile_img_url) ? ('user_icon.png') : (principal.user.id += '/' += principal.user.profile_img_url)}">
						</div>
						<button type="button" class="img_insert" onclick="document.all.file.click()">이미지 업로드</button>
						<button class="img_delete" type="button">이미지 제거</button>
					</form>
				</div>
				<div class="top_info">
					<h2 class="name">${principal.user.name }</h2>
					<p class="comment">${principal.user.comment }</p>
					<div class="info_modify_box">
						<button class="info_modify">수정</button>
					</div>
				</div>
				<div class="top_info_creative">
						<input type="text" class="info_name user_ip" value="${principal.user.name }">
						<input type="text" class="info_text user_ip" value="${principal.user.comment }">
					<div class="info_save_box">
						<button class="info_save">저장</button>
					</div>
				</div>
			</div>
			<div class="middle_info">
				<div class="mp_info">
					<div class="creative_info">
						<div class="velog_title">
							<h3>벨로그 제목</h3>
							<div class="contents_box">
								<p class="username">${principal.user.username }</p>
							</div>
							<div class="info_modify_box">
								<button class="info_modify">수정</button>
							</div>
							<div class="title_box_hidden">
								<div class="title_creative_box">
									<input type="text" class="title_creative user_ip" value="${principal.user.username }">
									<div class="info_save_box">
										<button class="info_save">저장</button>
									</div>
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
                                        <div class="icon"><div class="i"><i class="fas fa-envelope"></i></div><input type="text" placeholder="이메일을 입력하세요." value="${principal.email }"></div>
                                        <div class="icon"><div class="i"><i class="fab fa-github"></i></div><input type="text" placeholder="Github 계정을 입력하세요." value="${principal.github }"></div>
                                        <div class="icon"><div class="i"><i class="fab fa-twitter"></i></div><input type="text" placeholder="Twitter 계정을 입력하세요." value="${principal.twitter }"></div>
                                        <div class="icon"><div class="i"><i class="fab fa-facebook-square"></i></div><input type="text" placeholder="http://facebook.com/" value="${principal.facebook }"></div>
                                        <div class="icon"><div class="i"><i class="fas fa-home"></i></div><input type="text" placeholder="홈페이지 주소를 입력하세요." value="${principal.home }"></div>
                                    </div>
                                    <div class="info_save_box"><button class="info_save">저장</button></div>
                                </div>
                                <div class="social_box_block">
                                    <div class="social_box">
                                        <div class="social_icon"><div class="social"><i class="fas fa-envelope"></i><span class="social_text">${principal.email }</span></div></div>
                                        <div class="social_icon"><div class="social"><i class="fab fa-github"></i><span class="social_text">${principal.github }</span></div></div>
                                        <div class="social_icon"><div class="social"><i class="fab fa-twitter"></i><span class="social_text">${principal.twitter }</span></div></div>
                                        <div class="social_icon"><div class="social"><i class="fab fa-facebook-square"></i><span class="social_text">${principal.facebook }</span></div></div>
                                        <div class="social_icon"><div class="social"><i class="fas fa-home"></i><span class="social_text">${principal.home }</span></div></div>
                                    </div>
                                    <button class="social_modify">수정</button>
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
								<div class="contents">${principal.user.email }</div>
							</div>
						</div>
					</div>
					<div class="info_explanation">회원 인증 또는 시스템에서 발송하는 이메일을 수신하는
						주소입니다.</div>
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
					<div class="info_explanation">탈퇴 시 작성하신 포스트 및 댓글이 모두 삭제되며
						복구되지 않습니다.</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="include/sign_out.jsp"></jsp:include>
	<input type="hidden" id="id" value="${principal.user.id }">
	<script src="https://kit.fontawesome.com/0b11c2b6d9.js"
		crossorigin="anonymous"></script>
	<script src="/js/mypage.js"></script>
</body>
</html>