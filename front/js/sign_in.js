const email_ip = document.querySelector('.email_ip');
const si_button = document.querySelector('.si_button');

si_button.onclick = () => {
    if(email_ip.value.length != 0){
        email_check();
       if(email_check == true){
           alert('로그인 가능한 이메일입니다.');
       } else {
           alert('잘못된 이메일 형식입니다.');
       }
    } else {
        alert('이메일을 입력해주세요!');
    }
}


//이메일 정규식 체크
function email_check(email_ip){
        var regExp = /^((\w|[\-\.])+)@((\w|[\-\.])+)\.([A-Za-z]+)$/;

        if (email_ip.value.length == 0 && email_ip.value.search(regExp) == -1) {
            return false;
        }
        return true;
    }