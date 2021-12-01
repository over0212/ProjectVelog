// 로그인 버튼
const login_btns = document.querySelectorAll(".login_btn");
const go_posting_btn = document.querySelector(".go_posting_btn");
const user_nav_wrap = document.querySelector('.user_nav_wrap');
const user_btn = document.querySelector('.user_btn');
const user_nav = document.querySelector('.user_nav');

for (let i = 0; i < login_btns.length; i++) {
	login_btns[i].onclick = () => {
		const si_container = document.querySelector(".si_container");
		si_container.style.display = "block";
		si_container.className = "si_container active"
		si_container.style.transform = "translateY(0px)";
	}
}

user_btn.onclick = () => {
	if (user_nav.style.display == "none") {
		user_nav.style.display = "block";
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