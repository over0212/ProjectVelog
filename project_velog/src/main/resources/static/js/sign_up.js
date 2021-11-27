const su_info = document.querySelectorAll('.su_info');
const ip_box = document.querySelectorAll('.ip_box');
const su_name = document.querySelector('.su_name');
const su_email = document.querySelector('.su_email');
const su_id = document.querySelector('.su_id');
const su_comment = document.querySelector('.su_comment');
const confirm_token = document.querySelector('.confirm-token');

/* 이름 ip */
su_name.onfocus = () => {
    su_name.style.color = 'rgb(12, 166, 120)';
    su_info[0].style.color = 'rgb(12, 166, 120)';
    ip_box[0].style.borderBottom = '1px solid rgb(12, 166, 120)';
}
su_name.onblur = () => {
    su_name.style.color = 'black';
    su_info[0].style.color = 'black';
    ip_box[0].style.borderBottom = '1px solid #8a8a8a';
}

/* 아이디 ip */
su_id.onfocus = () => {
    su_id.style.color = 'rgb(12, 166, 120)';
    su_info[2].style.color = 'rgb(12, 166, 120)';
    ip_box[1].style.borderBottom = '1px solid rgb(12, 166, 120)';
}
su_id.onblur = () => {
    su_id.style.color = 'black';
    su_info[2].style.color = 'black';
    ip_box[1].style.borderBottom = '1px solid #8a8a8a';
}

/* 한 줄 소개 ip */
su_comment.onfocus = () => {
    su_comment.style.color = 'rgb(12, 166, 120)';
    su_info[3].style.color = 'rgb(12, 166, 120)';
    ip_box[2].style.borderBottom = '1px solid rgb(12, 166, 120)';
}
su_comment.onblur = () => {
    su_comment.style.color = 'black';
    su_info[3].style.color = 'black';
    ip_box[2].style.borderBottom = '1px solid #8a8a8a';
}

const inputs = document.querySelectorAll('input');
const errormsg = document.querySelectorAll('.errormsg');
// 0번 이름오류 / 1번 아이디 오류 / 2번 아이디 정규식오류 / 3번 소개 오류
const button = document.querySelectorAll('button');
// 0번 취소 버튼 / 1번 다음 버튼
const sign_next = document.querySelector('.sign_next');

function signin(signinObj){
	$.ajax({
		type: "post",
		url: "/sign-in",
		data: {
			username : signinObj.email,
			password : signinObj.token
		},
		success: function(){
			location.replace("/");
		},
		error: function(){
			alert('비동기 처리 오류!');
		}
	})
	
}

function signup(){
	let signupObj = {
		name : su_name.value,
		email : su_email.value,
		username : su_id.value,
		comment : su_comment.value,
		token : confirm_token.value
	};
	
	$.ajax({
		type: "post",
		url: "/sign-up",
		data: JSON.stringify(signupObj),
		contentType: "application/json; charset=UTF-8",
		dataType: "text",
		success: function(data){
			let signUpRespObj = JSON.parse(data);
			if(signUpRespObj.code == 200){
				alert('회원가입 완료!');
				signin(signUpRespObj.data);
			}else if(signUpRespObj.code == 400){
				alert(signUpRespObj.data);
			}
		},
		error: function(){
			alert('비동기처리 오류');
		}
	})
}

sign_next.onclick = () => {
    // append child
    if(su_name.value.length == 0) {
        errormsg[0].style.display = 'block';
        errormsg[1].style.display = 'none';
        errormsg[2].style.display = 'none';
        errormsg[3].style.display = 'none';
    } else if(su_id.value.length == 0){
        errormsg[0].style.display = 'none';
        errormsg[1].style.display = 'block';
        errormsg[2].style.display = 'none';
        errormsg[3].style.display = 'none';
    }else if(su_id.value.length != 0 && id_check(su_id.value) == false){
        errormsg[0].style.display = 'none';
        errormsg[1].style.display = 'none';
        errormsg[2].style.display = 'block';
        errormsg[3].style.display = 'none';
    }else if(su_comment.value.length == 0){
        errormsg[0].style.display = 'none';
        errormsg[1].style.display = 'none';
        errormsg[2].style.display = 'none';
        errormsg[3].style.display = 'block';
    } else if(id_check(su_id.value) == true){
        errormsg[0].style.display = 'none';
        errormsg[1].style.display = 'none';
        errormsg[2].style.display = 'none';
        errormsg[3].style.display = 'none';
        signup();
    }
}

function id_check(su_id) {
	var check_id = /^[a-z]+[a-z0-9]{3,16}$/g;
    if(check_id.test(su_id)){
        return true;
    } else {
        return false;
    }
}

function clearMsgNode(msg){
	while(msg.hasChildNodes()){
		msg.removeChild(msg.firstChild);
	}
	msg.style.display = 'none';
}
/* 아이디 리펙토링 참고 코딩
function messageService(msg, errormsg, msgFlag){
	const errorMsg = document.querySelectorAll('.errorMsg');
	const successMsg = document.querySelector('.successMsg');
	
	clearMsgNode(errorMsg[indexNumber]);
	clearMsgNode(successMsg);
	
	let msgTextNode = document.createTextNode(msgText);
	
	if(msgFlag == 0){
		errorMsg[indexNumber].appendChild(msgTextNode);
		errorMsg[indexNumber].style.display = 'block';
	}else {
		successMsg.appendChild(msgTextNode);
		successMsg.style.display = 'block';
	}*/