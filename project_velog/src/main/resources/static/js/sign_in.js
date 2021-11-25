const email_ip = document.querySelector('.email_ip');
const si_button = document.querySelector('.si_button');
const si_close = document.querySelector('.si_close i');
const si_container = document.querySelector('.si_container');

/*var userData = {
	email = '',
	username = '',
	name = '',
	password = '',
	comment = ''
}*/

si_button.onkeypress = () => {
    if (window.event.keyCode == 13) {
        window.event.preventDefault();
        onsubmit();
    }
}

si_button.onclick = () => {
	
	onsubmit();
}

// 종료버튼
si_close.onclick = () => {
    si_container.className = "si_container close_si"
    si_container.style.display = "none";
}

function onsubmit(){
    if(email_ip.value.length == 0){
        alert('이메일을 입력하세요');
        email_ip.focus();
       
    } else {
        let flag = email_check(email_ip.value);
        if(flag == true){
           $.ajax({
		type: "get",
		url: "/confirm-email",
		data: JSON.stringify(userData),
		contentType: "application/json; UTF-8",
		dataType: "text",
		success: function(data){
			userData = JSON.parse(data);
			
		    onsubmit();
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
