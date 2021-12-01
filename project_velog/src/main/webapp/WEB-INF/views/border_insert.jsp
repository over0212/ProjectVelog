<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal" />
</sec:authorize>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>새 글 작성</title>
<link rel="stylesheet" href="/css/reset.css">
<link rel="stylesheet" href="/css/border_insert.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<div class="write_page">
		<div class="write_wrap">
			<div class="write_left">
				<form class="write_form" action="" method="post">
					<div class="write_ip">
						<textarea class="write_title" name="border_title" placeholder="제목을 입력하세요" cols="42"></textarea>
						<div class="seperate"></div>
						<div class="write_tag">
							<span class="tag_wrap"></span><input class="ip_tags" type="text" placeholder="태그를 입력하세요">
							<div class="tag_msg">쉼표 혹은 엔터를 입력하여 태그를 등록할 수 있습니다.<br>등록된 태그를 클릭하면 삭제됩니다.</div>
						</div>
					</div>
					<div class="deco_bar">
						<button type="button" class="h1 font_size">H<span>1</span></button>
						<button type="button" class="h2 font_size">H<span>2</span></button>
						<button type="button" class="h3 font_size">H<span>3</span></button>
						<button type="button" class="h4 font_size">H<span>4</span></button>
						<div class="seper"></div>
						<button type="button" class="bold"><i class="fas fa-bold"></i></button>
						<button type="button" class="italic"><i class="fas fa-italic"></i></button>
						<button type="button" class="overline"><i class="fas fa-minus"></i></button>
						<div class="seper"></div>
						<button type="button" class="quote"><i class="fas fa-quote-right"></i></button>
						<button type="button" class="link"><i class="fas fa-link"></i></button>
						<button type="button" class="image"><i class="fas fa-image"></i></button>
						<button type="button" class="code"><i class="fas fa-code"></i></button>
					</div>
					<div class="text_box"><textarea class="write_txt" name="border_content" placeholder="당신의 이야기를 적어보세요..." cols="79"></textarea></div>
					<div class="write_footer">
						<button type="button" class="exit_btn"><i class="fas fa-arrow-left"></i> 나가기</button>
						<div class="submit_btns">
							<button type="button" class="temp_store">임시저장</button>
							<button type="button" class="temp_submit">출간하기</button>
						</div>
					</div>
					<!-- send page -->
					<div class="send_page">
						<div class="writing_send_container">
							<div class="main_body">
								<div class="left_wrap">
									<h3 class="send_h3">포스트 미리보기</h3>
									<div class="preview_contents">
										<div class="img_upload">
											<!-- 이미지 있을 떄 -->
<!-- 											<div class="img"><img src="" alt=""></div> -->
											<!-- 이미지 없을 때 -->
											<div class="img"><i class="far fa-image"></i></div>
											<button type="button" class="upload_button">썸네일 업로드</button>
										</div>
										<div class="input_box">
											<h4 class="post_title"></h4>
											<textarea class="post_content" name="preview_content"  type="text" cols="22" placeholder="당신의 포스트를 짧게 소개해보세요."></textarea>
											<div class="length_box"><span class="text_length"></span>/150</div>
										</div>
									</div>
								</div>
								<div class="seper_line"></div>
								<div class="right_wrap">
									<div class="settings_wrap">
										<div class="settings">
											<h3 class="send_h3">공개 설정</h3>
											<div class="public_btn_wrap">
												<button type="button" class="public_active"><i class="fas fa-globe-europe"></i>전체 공개</button>
												<button type="button"><i class="fas fa-lock"></i>비공개</button>
											</div>
										</div>
										<div class="settings">
											<h3 class="send_h3">URL 설정</h3>
											<div class="user_url_box"><span class="user_name">/${principal.user.username}/</span><input class="ip_url" name="border_url" type="text"></div>
										</div>
										<div class="settings">
											<h3 class="send_h3">시리즈 설정</h3>
											<button type="button" class="append_serise"><i class="fas fa-plus"></i>시리즈에 추가하기</button>
										</div>
									</div>
									<div class="submit_btns">
										<button type="button" class="cancle_btn">취소</button>
										<button type="button" class="select_btn" style="display: none;">선택하기</button>
										<button type="button" class="real_submit">출간하기</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="preview_wrap">
			<h1 class="pre_title"></h1>
			<pre class="pre_txt"></pre>
		</div>
	</div>

	<script src="https://kit.fontawesome.com/0b11c2b6d9.js" crossorigin="anonymous"></script>
	<script src="/js/border_insert.js"></script>
</body>
</html>