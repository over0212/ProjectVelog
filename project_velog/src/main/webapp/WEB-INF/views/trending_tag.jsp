<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/reset.css">
    <link rel="stylesheet" href="/css/header.css">
    <link rel="stylesheet" href="/css/sign_in.css">
    <link rel="stylesheet" href="/css/trending_tag.css">
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <title>태그 (인기순) -velog</title>
</head>
<body>
    <jsp:include page="include/main_header.jsp"></jsp:include>
    
    <div class="tl_container">
        <div class="tl_box">
            
            <div class="ch_menu">
                <span class="trending_nav">
                    <a href="#" class="trending_btn">인기순</a>
                </span>
                <span class="name_nav">
                    <a href="#" class="name_btn">이름순</a>
                </span>
            </div>
			<%-- <c:forEach var="" items=""> --%>
	            <div class="tl_list">
	                <div class="list">
	                    <div class="tl_title">
	                        <a href="">
	                            <div class="tl_title_box">
	                                가나다라마바사아자차카어노온sdhkghkghjghkfkhfkhfkhfkfkhfkgjkgkj오노오노오농
	                            </div>
	                        </a>
	                        <div class="tl_explanation">Aiden Nana LeoAiden Nana LeoAiden Nana LeoAiden Nana Leo
	                            Aiden Nana LeoAiden Nana LeoAiden Nana LeoAiden Nana Leo Aiden Nana LeoAiden Nana Leo
	                        </div>
	                    </div>
	                    <div class="total_post">
	                        총 999999개의 포스트
	                    </div>
	                </div>
	            </div>			
			<%-- </c:forEach> --%>
        </div>
    </div>
    <script src="https://kit.fontawesome.com/0b11c2b6d9.js" crossorigin="anonymous"></script>
    <script src="/js/tag.js"></script>
</body>
</html>