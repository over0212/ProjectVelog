// write_page -------------------------------------------
const submit_btn = document.querySelector('.on_submit'); 
const write_page = document.querySelector('.write_page');
const write_title = document.querySelector('.write_title');
const write_txt = document.querySelector('.write_txt');
const write_tag = document.querySelector('.write_tag');
const ip_tags = document.querySelector('.ip_tags');
const tag = document.querySelector('.tag');
const tag_msg = document.querySelector('.tag_msg');
const pre_title = document.querySelector('.pre_title');
const pre_txt = document.querySelector('.pre_txt');
const send_page = document.querySelector('.send_page');

tag.style.display = "none";
tag_msg.style.display = "none";

ip_tags.onkeypress = () => {
    if (window.event.keyCode == 13) {
        alert(ip_tags.value);
        write_tag.append(`<span class="tag">${ip_tags.value}</span>`);
		tag.style.display = "block";
    }
}

// 태그 입력창 클릭시 
ip_tags.onclick = () => {
    tag_msg.style.display = "block";
}
ip_tags.onblur = () => {
    tag_msg.style.display = "none";
}

// 미리보기창
write_title.onkeypress = () => {
    // alert(write_title.value);
    pre_title.appendChild(write_title.value);
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