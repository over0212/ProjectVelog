// write_page -------------------------------------------
const submit_btn = document.querySelector('.on_submit'); 
const write_page = document.querySelector('.write_page');
const ip_tags = document.querySelector('.ip_tags');
const tag = document.querySelectorAll('.tag');
const tag_msg = document.querySelector('.tag_msg');
const send_page = document.querySelector('.send_page');

tag.style.display = "none";
tag_msg.style.display = "none";

// 태그
let tags = [];

// 태그 입력 후 엔터 누르면 
ip_tags.onkeypress = () => {
	if (window.event.keyCode == 13) {
		tag.appendChild(ip_tags.value);
		tag.style.display = "block";
    }
}
ip_tags.onclick = () => {
    tag_msg.style.display = "block";
}
ip_tags.onblur = () => {
    tag_msg.style.display = "none";
}

// 출간하기 버튼 클릭시
submit_btn.onclick = () => {
    send_page.style.display = "block";
    write_page.style.display = "none"
}

// send_page --------------------------------------------
const cancle_btn = document.querySelector('.cancle_btn');

//취소 버튼
cancle_btn.onclick = () => {
    send_page.style.display = "none";
    write_page.style.display = "block"
}