// 로그인 버튼
const login_btn = document.querySelector(".login_btn");
const go_posting_btn = document.querySelector(".go_posting_btn");

login_btn.onclick = () => {
    const si_container = document.querySelector(".si_container");
    si_container.style.display = "block";
    si_container.className = "si_container active"
    si_container.style.transform = "translateY(0px)";
}

const user_nav = document.querySelector('.user_nav');
user_nav.style.display = 'none';

user_nav.onclick = () => {
	user_nav.style.display = 'block';
}

user_nav.onblur = () => {
	user_nav.style.display = 'none';
}

go_posting_btn.onclick = () => {
	location.href = "/write";
}