const su_info = document.querySelectorAll('.su_info');
const ip_box = document.querySelectorAll('.ip_box');
const su_name = document.querySelector('.su_name');
const su_id = document.querySelector('.su_id');
const su_comment = document.querySelector('.su_comment');
const inputs = document.querySelectorAll('input');
const errormsg = document.querySelector('.errormsg');

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

function isId(asValue) {
	var regExp = /^[a-z]+[a-z0-9]{3,20}$/g;

	return regExp.test(asValue);
}
