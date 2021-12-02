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
const imgFile = document.querySelector('#imgFile');

// write_page -------------------------------------------
tag_msg.style.display = "none";

ip_tags.onkeypress = () => {
    if (window.event.keyCode == 13 && ip_tags.value.length != 0) { // enter
        window.event.preventDefault();
        const tag_wrap = document.querySelector('.tag_wrap');
        var tag = document.createElement('span');
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
    pre_title.innerHTML = `<h1 class="pre_title">${write_title.value}</h1>`;
}

// content
const text_wrap = document.querySelector('.text_wrap');
const default_msg = document.querySelector('.default_msg');
const mirror_wrap = document.querySelector('mirror_wrap'); // mirror_wrap
const mirror_code = document.querySelector('.mirror_code');
const mirror_line = document.querySelectorAll('.mirror_line'); // appendChild span
const text_cursor =  document.querySelector('.cursor');

// content 부분 누르면 textarea로 focus
text_wrap.onclick = () => {
    write_txt.focus();
}

// 글자 입력이 들어오면 메세지 삭제
write_txt.onkeydown = () => {
    if(mirror_line[0].innerText.length != 0){
        default_msg.textContent = "";
    }else{
        default_msg.textContent = "당신의 이야기를 적어보세요...";
    }
}

write_txt.onkeyup = () => {
    if(window.event.keyCode == 13){
        let newLine = document.createElement('div');
        newLine.className = "mirror_line";
        mirror_code.appendChild(newLine);
        mirror_line[mirror_line.length-2].innerHTML += '</br>';
    }else{
        mirror_line[mirror_line.length-1].innerHTML = `<span>${write_txt.value}</span>`;
        // alert(mirror_code.innerHTML);
    }
    
    pre_txt.innerHTML += mirror_code.outerHTML;
}


// img tool
function imgFileLoad(){
    let fileList = imgFile.files;
    let reader = new FileReader();
    
    // 그 다음 실행됨
    reader.onload = () => {
        let src = reader.result;
        let fileName = fileList[0].name;
        pre_txt.innerHTML += `<div  style="display:flex; justify-content:center;"><img src="${src}"></img></div>`;
        insertImgURL(fileName);
    }
    
    // 함수 실행되면 먼저 실행됨
    reader.readAsDataURL(fileList[0]);
}
// img url wirte_txt에 삽입
function insertImgURL(fileName){
    let uuid = getUUID();
    let url = ` http://images.velog.io/images/username/post/${uuid}/${fileName}`;

    mirror_line[mirror_line.length-1].innerHTML += `<span class="img_marker">!</span><span class="img_code">[]</span><span>${url}</span>`;
    // pre_txt.innerHTML = mirror_line.innerText;
}
function getUUID() {
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
        var r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
        return v.toString(16);
    });
}

pre_txt.innerHTML = mirror_code.outerHTML;
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
// real_submit.onclick() = () => {

// }

