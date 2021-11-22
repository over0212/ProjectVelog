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
    if (email_ip.value.length != 0) {
        email_check();
    } else {
        alert('이메일을 입력해주세요!');
        email_ip.focus();
    }
}

//이메일 정규식 체크
function email_check(email_check) {
    var email_txt = document.getElementsByClassName('email_ip').value;
    var regEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;

    if (regEmail.test(email_txt)) {
        alert('이메일입니다.');
        return true;
    } else{
        // alert('잘못됨');
        // return false;
    }

}

// 종료버튼
si_close.onclick = () => {
    si_container.className = "si_container inactive"
    si_container.style.display = "none";
    // si_container.className = "si_container";
}
