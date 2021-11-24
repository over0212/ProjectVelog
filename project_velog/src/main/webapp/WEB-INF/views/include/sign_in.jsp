<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="si_container">
    <div class="si_warp">
        <!-- 로그인 창 -->
        <div class="si_box">
       	    <!-- 왼쪽 area -->
            <div class="si_img">
                <img src="img/login.svg" alt="login-img">
                <span>환영합니다!</span>
            </div>
            <!-- 오른쪽 area -->
            <div class="si_block">
                <div class="login_si_api">
                    <!-- 종료버튼 -->
                    <div class="si_close"><i class="fas fa-times"></i></div>
                    <!-- 로그인 부분 -->
                    <div class="si_input">
                        <h2>로그인</h2>
                        <h4>이메일로 로그인</h4>
                        <form action="" class="si_form">
                            <!-- 로그인 input -->
                            <input type="text" class="email_ip" name="email" placeholder="이메일을 입력하세요">
                            <!-- 로그인 버튼 -->
                            <button type ="button" class="si_button">로그인</button>
                        </form>
                        <!-- 소셜 로그인 -->
                        <div class="social_login">
                            <h4>소셜 계정으로 로그인</h4>
                            <div class="social_btns">
                                <!-- api의 로그인 버튼 및 이미지 -->
                                <div class="btn"><i class="fab fa-google"></i></div>
                                <div class="btn"><i class="fab fa-google"></i></div>
                                <div class="btn"><i class="fab fa-google"></i></div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 회원가입 요청 -->
                <div class="si_su_info">
                    <span class="su_question">아직 회원이 아니신가요?</span>
                    <a href=""><span class="su_link">회원가입</span></a>
                </div>
        	</div>
        </div>
    </div>
</div>

<script src="https://kit.fontawesome.com/7e652321d1.js" crossorigin="anonymous"></script>
<script src="js/sign_in.js"></script>