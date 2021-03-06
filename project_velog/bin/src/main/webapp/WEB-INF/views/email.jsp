<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <style>
        .email_wrapper{
            margin: 0 auto;
            width: 500px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            font-size: 12px;
        }
        .logo_wrap{
            width: 100%;
        }
        .warn_msg{
            font-size: 1.2em;
            border: 1px solid #fff;
            background-color: #ccc;
        }
        .register_link{
            width: 100%; height: 100%;
            background-color: lightseagreen;
        }
        .info_box{
            width: 100%;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="email_wrapper">
        <div class="logo_wrap"><a href="https://velog.io/"><img src="img/email_logo.png" alt=""></a></div>
        <div class="wran_msg">안녕하세요! 회원가입을 계속 하시려면 하단의 링크를 클릭하세요. 만약에 실수로 요청하셨거나, 본인이 요청하지 않았다면, 이 메일을 무시하세요.</div>
        <a class="register_link" href="">계속하기</a>
        <div class="info_box">
            <div>
                위 버튼을 클릭하시거나, 다음 링크를 열으세요<br>
                <a href="#">link</a>
            </div>
            <div>이 링크는 24시간동안 유효합니다.</div>
        </div>
    </div>
</body>
</html>