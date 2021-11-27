// write_page -------------------------------------------
const submit_btn = document.querySelector('.on_submit'); 
const write_page = document.querySelector('.write_wrap');
const ip_tags = document.querySelector('.ip_tags');
const tag_msg = document.querySelector('.tag_msg');
const send_page = document.querySelector('.send_page');

send_page.style.display = "none";
tag_msg.style.display = "none";

// 태그 입력창 클릭시 
ip_tags.onclick = () => {
    tag_msg.style.display = "block";
}


// 출간하기 버튼 클릭시
submit_btn.onclick = () => {
    write_page.style.display = "none";
    send_page.style.display = "block";
}

// send_page --------------------------------------------
const cancle_btn = document.querySelector('.cancle_btn');

//취소 버튼
cancle_btn.onclick = () => {
    send_page.style.display = "none";
    write_page.style.display = "block";
}
