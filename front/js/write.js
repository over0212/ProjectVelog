// write_page -------------------------------------------
const submit_btn = document.querySelector('.on_submit'); 
const write_page = document.querySelector('.write_page');
const write_title = document.querySelector('.write_title');
const write_txt = document.querySelector('.write_txt');
const write_tag = document.querySelector('.write_tag');
const ip_tags = document.querySelector('.ip_tags');
const tag_msg = document.querySelector('.tag_msg');
const pre_title = document.querySelector('.pre_title');
const pre_txt = document.querySelector('.pre_txt');
const send_page = document.querySelector('.send_page');

tag_msg.style.display = "none";

ip_tags.onkeypress = () => {
    if (window.event.keyCode == 13 && ip_tags.value.length != 0) { // enter
        window.event.preventDefault();
        const tag_wrap = document.querySelector('.tag_wrap');
        var tag = document.createElement('span')
        tag.className = "tag";
        tag.appendChild(document.createTextNode(ip_tags.value));
        tag_wrap.appendChild(tag);
        ip_tags.value = "";
    }
}

ip_tags.onkeydown = () => {
    const tag_wrap = document.querySelector('.tag_wrap');
    const tag = document.querySelector('.tag');
    if(window.event.keyCode == 8 && ip_tags.value.length == 0 && tag != null){ // backspace
        tag_wrap.lastChild.remove();
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
// title
write_title.onkeyup = () => {
    pre_title.textContent = write_title.value;
}

// content
write_txt.onkeyup = () => {
    var text = write_txt.value;
    if(window.event.keyCode == 13){
        pre_txt.innerHTML += '<br/>';
    }else{
        pre_txt.innerText = text;
    }
}

write_txt.onkeydown = () => {
    if(window.event.keyCode == 9){
        write_txt.cursor();
    }
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
    write_page.style.display = "block";
}

// submit 버튼


