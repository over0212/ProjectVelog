// header
const go_posting_btn = document.querySelector('.go_posting_btn');
const user_nav_wrap = document.querySelector('.user_nav_wrap');
const user_btn = document.querySelector('.user_btn');
const user_nav = document.querySelector('.user_nav');
const login_btn = document.querySelectorAll('.login_btn');

// 로그인 버튼 클릭 -> 로그인 창 block
for (let i = 0; i < login_btn.length; i++) {
	login_btn[i].onclick = () => {
		const si_container = document.querySelector('.si_container');
		si_container.style.display = 'block';
		si_container.className = 'si_container active';
		si_container.style.transform = 'translateY(0px)';
	}

}

// 사용자 profile 클릭 -> 사용자메뉴 block 
user_nav.style.display = 'none';

/*user_btn.onclick =() => {
	if (user_nav.style.display == 'none') {
		user_nav.style.display = 'block';
	} else {
		user_nav.style.display = 'none';
	}
}*/

//화면 전체를 클릭 했을 때
window.addEventListener('click', (e) => {

	//만약 요소의 클래스에 user_btn가 포함되어있고, 요소의 클래스에 user_nav_wrap가 포함되어있고 , 요소의 태그이름이 IMG 이고 , 요소의 클래스에 fa-caret-down가 포함되어있을때
	if (e.target.classList.contains('user_btn') || e.target.classList.contains('user_nav_wrap') || e.target.classList.contains('img') || e.target.classList.contains('down')) {
		//user_nav가 none인 상태면
		if (user_nav.style.display == 'none') {
			//user_nav를 보여주고
			user_nav.style.display = 'block';
		}
		//user_nav가 보여진 상태면 
		else if (user_nav.style.display == 'block') {
			//user_nav를 숨긴다.
			user_nav.style.display = 'none';
		}
		//window를 클릭했을 때 위의 네 개의 요소가 아닐 때(위의 세개의 요소를 제외하고)
	} else {
		//user_nav를 숨긴다.
		user_nav.style.display = 'none';
	}
});

//user_nav_wrap.onblur = () => {
//	user_nav.style.display = 'none';
//}



go_posting_btn.onclick = () => {
	location.href = "/border/insert";
}

