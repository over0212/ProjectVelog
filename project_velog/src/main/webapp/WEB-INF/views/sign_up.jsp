<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입 -velog</title>
    <link rel="stylesheet" href="/css/reset.css">
    <link rel="stylesheet" href="/css/sign_up.css">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>

<body>
    <div class="container">
        <div class="su_warp">
            <!-- welcome -->
            <h1>환영합니다!</h1>
            <!-- 텍스트 -->
            <span class="su_txt">
                기본 회원 정보를 등록해주세요.
            </span>
            <!-- 회원가입 정보입력 -->
            <div class="ip_group">
                <div class="ip_block">
                    <div class="su_info">이름</div>
                    <div class="ip_name_box ip_box">
                        <input type="text" class="su_name" placeholder="이름을 입력하세요">
                    </div>
                </div>
                <div class="ip_block">
                    <div class="su_info">이메일</div>
                    <div class="ip_email_box">
                        <input type="text" class="su_email" value="${email }" placeholder="이메일" readonly>
                        <div><i class="fas fa-lock"></i></div>
                    </div>
                </div>
                <div class="ip_block">
                    <div class="su_info">아이디</div>
                    <div class="ip_id_box ip_box">
                        <input type="text" class="su_id" placeholder="아이디를 입력하세요">
                    </div>
                </div>
                <div class="ip_block">
                    <div class="su_info">한 줄 소개</div>
                    <div class="ip_comment_box ip_box">
                        <input type="text" class="su_comment" placeholder="당신을 한 줄로 소개해보세요">
                    </div>
                </div>
            </div>
            <div class="su_group">
                <div class="msg">
                    <span class="errormsg">이름을 입력해주세요</span>
                    <span class="errormsg">아이디를 입력해주세요</span>
                    <span class="errormsg">아이디는 3~16자의 알파벳,숫자,혹은 - _ 으로 이루어져야 합니다.</span>
                    <span class="errormsg">당신을 간단하게 소개해주세요</span>
                </div>
                <div class="su_button">
                    <div class="sign_cancel"><button>취소</button></div>
                    <div class="sign_next"><button>다음</button></div>
                </div>
            </div>
        </div>
    </div>
    <input type="hidden" class="confirm-token" value="${token }">
    <script src="https://kit.fontawesome.com/7e652321d1.js" crossorigin="anonymous"></script>
    <script src="/js/sign_up.js"></script>
</body>
</html>