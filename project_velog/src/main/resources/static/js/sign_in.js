const email_ip = document.querySelector('.email_ip');
const si_button = document.querySelector('.si_button');
const si_close = document.querySelector('.si_close i');
const si_container = document.querySelector('.si_container');
si_button.onkeypress = () => {
    if (window.event.keyCode == 13) {
        window.event.preventDefault();
        sendLink();
    }
}

si_button.onclick = () => {
	sendLink();
}

// 종료버튼
si_close.onclick = () => {
    si_container.className = "si_container close_si"
    si_container.style.display = "none";
}

function sendLink(){
	// 아무것도 입력이 안되었을 때
    if(email_ip.value.length == 0){
        alert('이메일을 입력하세요');
        email_ip.focus();
       
       // 입력이 되었다면 링크를 이메일 정규식이 실행
    } else {
        let flag = email_check(email_ip.value);
        // 정규식으로 인해 이메일 형식이 맞으면 비동기 실행
        if(flag == true){
	           $.ajax({
				type: "get",
				url: "/email/send",
				data: {
					"email" : email_ip.value
				},
				dataType: "text",
				success: function(data){
					alert(data);
				},
				error: function(){
					alert('비동기 처리 오류!');
				}
			})
        } else{
            alert('잘못된 이메일 형식입니다.');
            email_ip.focus();
        }
    }
}

//이메일 정규식 체크
function email_check(email_ip) {
    var check_email = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
    if(check_email.test(email_ip)) {
        return true;
    } else{
        return false;
    }
}

const su_link = document.querySelector('.su_link');
const text_c = document.querySelectorAll('.text_c');

var changeFlag = 0;

su_link.onclick = () => {
    if(changeFlag == 0){
        text_c[0].textContent = '회원가입';
        text_c[1].textContent = '이메일로 회원가입';
        text_c[2].textContent = '회원가입';
        text_c[3].textContent = '소셜 계정으로 회원가입';
        text_c[4].textContent = '계정이 이미 있으신가요?';
        text_c[5].textContent = '로그인';
        changeFlag = 1;
    } else {
        text_c[0].textContent = '로그인';
        text_c[1].textContent = '이메일로 로그인';
        text_c[2].textContent = '로그인';
        text_c[3].textContent = '소셜 계정으로 로그인';
        text_c[4].textContent = '아직 회원이 아니신가요?';
        text_c[5].textContent = '회원가입';
        changeFlag = 0;
    }
}
