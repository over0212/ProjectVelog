const temp_submit = document.querySelector('.temp_submit'); 
const write_page = document.querySelector('.write_page');
const write_title = document.querySelector('.write_title');
const write_tag = document.querySelector('.write_tag');
const write_txt = document.querySelector('.write_txt');
const ip_tags = document.querySelector('.ip_tags');
const tag_msg = document.querySelector('.tag_msg');
const pre_title = document.querySelector('.pre_title');
const pre_txt = document.querySelector('.pre_txt');
const send_page = document.querySelector('.send_page');
const h1 = document.querySelector('.h1');
const post_title = document.querySelector('.post_title');
const ip_url = document.querySelector('.ip_url');
const text_length = document.querySelector('.text_length');
const post_content = document.querySelector('.post_content');
const cancle_btn = document.querySelector('.cancle_btn');
const length_box = document.querySelector('.length_box');
const real_submit = document.querySelector('.real_submit');
const imgFile = document.querySelector('#imgFile');
const img_upload = document.querySelectorAll('.img_upload');
		
// write_page -------------------------------------------
img_upload[0].style = 'display: flex';
img_upload[1].style = 'display: none';
tag_msg.style.display = "none";

ip_tags.onkeypress = () => {
    if (window.event.keyCode == 13 && ip_tags.value.length != 0) { // enter
        window.event.preventDefault();
        const tag_wrap = document.querySelector('.tag_wrap');
        var tag = document.createElement('span');
        var hidden = document.createElement('input');
        hidden.setAttribute('type', 'hidden');
        hidden.value = ip_tags.value;
        hidden.className = "tag_hidden";
        hidden.name = "tag_names";
        tag.className = "tag";
        tag.appendChild(document.createTextNode(ip_tags.value));
        // tag.appendChild(document)
        tag_wrap.appendChild(tag);
        tag_wrap.appendChild(hidden);
        ip_tags.value = "";
    }
}

ip_tags.onkeydown = () => {
    const tag_wrap = document.querySelector('.tag_wrap');
    const tag = document.querySelector('.tag');
    if(window.event.keyCode == 8 && ip_tags.value.length == 0 && tag != null){ // backspace
        tag_wrap.lastChild.remove();
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
pre_title.style.display = 'none';
write_title.onkeyup = () => {
    if (write_title.value.length != 0) {
        pre_title.style.display = 'block';
        pre_title.innerHTML = `<h1 class="pre_title">${write_title.value}</h1>`;
    } else {
        pre_title.style.display = 'none';
    }
}

// content
const text_wrap = document.querySelector('.text_wrap');

write_txt.onkeyup = () => {
    // pre_txt.innerText = write_txt.value;
    
    // write(write_txt.value);

    // 강사님이 주신 로직
    
    edit(write_txt.value, '', 0);
}

//줄바꿈 이후 데이터 추출
function datastr(data){
    let textIndex = data.indexOf('\n');
    if(textIndex == -1){
        data = '';
    }else{
        data = data.substr(textIndex + 1);
    }
    return data;
}
//볼드체 적용
function boldTextStyle(text){
    let cmdBoldIndex = text.indexOf('**');
    if(cmdBoldIndex != -1){
        let boldText = text.substr(cmdBoldIndex + 2);
        let boldTextEndIndex = boldText.indexOf('**');
        let startText = '';
        let centerText = '';
        let endText = '';
        if(boldTextEndIndex != -1){
            startText = text.substr(0, cmdBoldIndex);
            centerText = text.substr(cmdBoldIndex + 2, boldTextEndIndex);
            endText = text.substr(cmdBoldIndex + 2 + boldTextEndIndex + 2);
            text = startText + `<b class="pre_bold">${centerText}</b>` + endText;
            text = boldTextStyle(text);
        }else{
            return text;
        }
    }
    return text;
}
//이텔릭체 적용
function italicTextStyle(text){
    let cmdItalicIndex = text.indexOf('__');

    if(cmdItalicIndex != -1){
        let italicText = text.substr(cmdItalicIndex + 1);
        let italicTextEndIndex = italicText.indexOf('__ ');
        let startText = '';
        let centerText = '';
        let endText = '';
        if(italicTextEndIndex != -1){
            startText = text.substr(0, cmdItalicIndex);
            centerText = text.substr(cmdItalicIndex + 1, italicTextEndIndex);
            endText = text.substr(cmdItalicIndex + 1 + italicTextEndIndex + 2);
            text = startText + `<i class="pre_italic">${centerText}</i>` + endText;
            text = italicTextStyle(text);
        }else{
            return text;
        }
    }
    return text;
}

/*function searchImage(imageText){
	let searchIndex = imageTag.indexof('![]');
	
	if(searchIndex != -1){
		let 
	}
}*/

//취소선 적용
function lineTextStyle(text){
    let cmdLineIndex = text.indexOf('~~');
    
    if(cmdLineIndex != -1){
        let lineText = text.substr(cmdLineIndex + 2);
        let lineTextEndIndex = lineText.indexOf('~~');
        let startText = '';
        let centerText = '';
        let endText = '';
        if(lineTextEndIndex != -1){
            startText = text.substr(0, cmdLineIndex);
            centerText = text.substr(cmdLineIndex + 2, lineTextEndIndex);
            endText = text.substr(cmdLineIndex + 2 + lineTextEndIndex + 2);
            text = startText + `<del class="pre_overline">${centerText}</del>` + endText;
            text = lineTextStyle(text);
        }else{
            return text;
        }
    }
    return text;
}
//줄바꿈 전까지의 문자열 추출
function subtext(data, cmdIndex){
    let textIndex = data.indexOf('\n');
    if(textIndex == -1){
        text = data.substr(cmdIndex + 1);
    }else{
        text = data.substr(cmdIndex + 1, cmdIndex + 1 == -1 ? textIndex : textIndex - cmdIndex);
    }
    text = boldTextStyle(text);
    text = italicTextStyle(text);
    text = lineTextStyle(text);
    return text;
}
//전체 로직
function edit(data, preText, imgcnt){
	if(imgcnt == 0){
		img_upload[0].style = 'display: flex';
		img_upload[1].style = 'display: none';
	}
	
    if(data.length != 0){
        let cmdIndex = data.indexOf(' '); // 공백찾기
        let cmd = '';
        if(cmdIndex != -1){
            cmd = data.substr(0, cmdIndex); // 명령어담는 변수
        }
        let text = '';
        if(cmd == '#' || cmd == '##' || cmd == '###' || cmd == '####'){
            //h태그
            text = subtext(data, cmdIndex);
            if(cmd == '#'){
                preText += `<h1 class="pre_h1">${text}</h1>`;
            }else if(cmd == '##'){
                preText += `<h2 class="pre_h2">${text}</h2>`;
            }else if(cmd == '###'){
                preText += `<h3 class="pre_h3">${text}</h3>`;
            }else{
                preText += `<h4 class="pre_h4">${text}</h4>`;
            }
            
            data = datastr(data);
        }else if(cmd == '![]'){
            //이미지
            text = subtext(data, cmdIndex);
            data = datastr(data);
            imgcnt++;
            if(imgcnt == 1){
				img_upload[1].innerHTML = `<div class="img" style="display:flex; justify-content:center;"><img src="/image/${text}" width="100%"></img></div>`;
				img_upload[0].style = 'display: none';
				img_upload[1].style = 'display: block';
			}
            preText += `<div class="img" style="display:flex; justify-content:center;"><img src="/image/${text}"></img></div>`;
            console.log(preText);
        }else{
            //일반 텍스트
            text = subtext(data, -1);
            data = datastr(data);
            preText += text;
        }
        edit(data, preText);
    }else {
        pre_txt.innerHTML = preText;
        return;
    }
    
}

function appendTool(){
    if(event.target.className == "h1 font_size"){
        write_txt.value += '\n# ';
        write_txt.focus();
    }else if(event.target.className == "h2 font_size"){
        write_txt.value += '\n## ';
        write_txt.focus();
    }else if(event.target.className == "h3 font_size"){
        write_txt.value += '\n### ';
        write_txt.focus();
    }else if(event.target.className == "h4 font_size"){
        write_txt.value += '\n#### ';
        write_txt.focus();
    }else if(event.target.className == "bold"){
        write_txt.value += '\n** ';
        write_txt.focus();
    }else if(event.target.className == "italic"){
        write_txt.value += '\n__ ';
        write_txt.focus();
    }else if(event.target.className == "overline"){
        write_txt.value += '\n~~ ';
        write_txt.focus();
    }
}

// h1
function fontsize(){
    write_txt.value += '# ';
}

const form = document.querySelector('form');
// img tool
function imgFileLoad(){
    let formData = new FormData(form);
    
    $.ajax({
		type: "post",
		url: "/border/imgupload",
		enctype: "multipart/form-data", /* 파일 업로드 할 땐 꼭 필요한 코드(enctype, processData, contentType)*/
		data: formData,
		processData: false,
		contentType: false,
		success: function(data){
			src = data;
			write_txt.value += '![] ' + data;
			edit(write_txt.value, '', 0);
		},
		error: function(){
			alert('비동기 처리 오류');
		}
	});
}
var src = '';

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

const tag_names = document.querySelectorAll('.tag_names');
const tag_hidden = document.querySelectorAll('.tag_hidden');
const user_id = document.querySelector('#id');
// submit 버튼
real_submit.onclick = () => {
	let borderObj = {
		url : ip_url.value,
		id : user_id.value,
		main_title : write_title.value,
		main_tag : tag_hidden.values,
		main_content : write_txt.value,
		preview_txt : post_content.value
	}
	
	$.ajax({
		type: "post",
		url: "/border/insert/" + user_id.value,
		data: JSON.stringify(borderObj),
		contentType: "application/json; charset=UTF-8",
		dataType: "text",
		success: function(data){
			let insertBorder = JSON.parse(data);
			if(insertBorder == 1){
				alert('게시글이 등록되었습니다.');
				location.href = "/myborder";
			} else {
				alert("게시글 등록 실패!");
			}
		},
		error: function(){
			alert("비동기 처리 오류!");
		}
		
	})
}

















