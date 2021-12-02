// header
const login_btn = document.querySelector('.login_btn');
const go_posting_btn = document.querySelector('.go_posting_btn');
const user_nav_wrap = document.querySelector('.user_nav_wrap');
const user_btn = document.querySelector('.user_btn');
const user_nav = document.querySelector('.user_nav');
const si_container = document.querySelector('.si_container');

// 로그인 버튼 클릭 -> 로그인 창 block
login_btn.onclick = () => {
	si_container.style.display = 'block';
	si_container.className = 'si_container active';
	si_container.style.transform = 'translateY(0px)';
}

// 사용자 profile 클릭 -> 사용자메뉴 block 
user_btn.onclick = () => {
	if (user_nav.style.display == 'none') {
		user_nav.style.display = 'block';
	} else {
		user_nav.style.display = 'none';
	}
}

user_nav_wrap.onblur = () => {
	user_nav.style.display = 'none';
}

go_posting_btn.onclick = () => {
	location.href = "/insert";
}

