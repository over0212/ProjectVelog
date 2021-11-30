const temp_submit = document.querySelector('.temp_submit'); 
const write_page = document.querySelector('.write_page');
const write_title = document.querySelector('.write_title');
const write_txt = document.querySelector('.write_txt');
const write_tag = document.querySelector('.write_tag');
const ip_tags = document.querySelector('.ip_tags');
const tag_msg = document.querySelector('.tag_msg');
const pre_title = document.querySelector('.pre_title');
const pre_txt = document.querySelector('.pre_txt');
const send_page = document.querySelector('.send_page');
const h1 = document.querySelector('.h1');
const post_title = document.querySelector('.post_title');
const post_content = document.querySelector('.post_content');
const ip_url = document.querySelector('.ip_url');
const text_length = document.querySelector('.text_length');
const cancle_btn = document.querySelector('.cancle_btn');
const length_box = document.querySelector('.length_box');
const real_submit = document.querySelector('.real_submit');
// write_page -------------------------------------------
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
    // var text = write_txt.value;
    // if(window.event.keyCode == 13){
        // pre_txt.innerHTML += '<br/>';
    // }else{
    //     pre_txt.innerText = text;
    // }
    pre_txt.textContent = write_txt.value;
}

// write_txt.onkeydown = () => {
//     if(window.event.keyCode == 9){
//         write_txt.cursor();
//     }
// }

// tool bar
// h1.onclick = () => {
//     if(window.event.keyCode == 13){
//         alert('enter');
//         write_txt.style.fontSize = '1em';
//         write_txt.style.fontWeight = "300";
//     }else{
//         write_txt.style.fontSize = '2em';
//         write_txt.style.fontWeight = '700';
//     }
// }

// 출간하기 버튼 클릭시
temp_submit.onclick = () => {
    send_page.style.display = "block";

    var title = write_title.value;
    var contents = write_txt.value;

    post_title.appendChild(document.createTextNode(title));
    post_content.value = contents;
    ip_url.value = title;
    text_length.appendChild(document.createTextNode(contents.length));
}

// send_page --------------------------------------------
post_content.onkeydown = () => {
	var txt_length = post_content.value.length;
	if(txt_length > 150){
		post_content.value = post_content.value.substr(0,150);
		length_box.style.color = "red";
	}else{
		length_box.style.color = "black";
		text_length.textContent = txt_length;
	}
}

//취소 버튼
cancle_btn.onclick = () => {
    send_page.style.display = "none";
    write_page.style.display = "block";
}

// submit 버튼
real_submit.onclick() = () => {
	

}

