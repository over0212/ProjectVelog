const email_ip = document.querySelector('.email_ip');
const si_button = document.querySelector('.si_button');
const si_close = document.querySelector('.si_close i');
const si_container = document.querySelector('.si_container');

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
            const si_form = document.querySelector('.si_form');
            si_form.submit();
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
