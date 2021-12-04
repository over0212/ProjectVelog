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
        var hidden = document.createElement('input');
        hidden.setAttribute('type', 'hidden');
        hidden.value = ip_tags.value;
        hidden.className = "tag_hidden";
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
    edit(write_txt.value, '');
}

function write(data){
    if(window.event.keyCode != 13){
        const lines = document.querySelectorAll('.newLine'); // 맨 마지막의 newLine을 찾기
        let lastLine = lines[lines.length-1]; // 맨 마지막 newLine
        lastLine.innerHTML = "";
        // let newText = document.createElement('p'); // 입력되는 text.value의 최신값 찾기
        // newText.className  = "text";
        // newText.textContent = write_txt.value;
        // const texts = document.querySelectorAll('text');
        // console.log(texts[texts.length-1]);
        // lines[lines.length-1].innerHTML += texts[texts.length-1];
        lastLine.innerHTML += `<span>${write_txt.value}</span>`;
    }else{
        const lines = document.querySelectorAll('.newLine');
        lines.remove();
        pre_txt.innerHTML += `<div class="newLine"></div>`;
        lastLine.innerHTML = "";
    }

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
            text = startText + `<b>${centerText}</b>` + endText;
            text = boldTextStyle(text);
        }else{
            return text;
        }
    }
    return text;
}
//이텔릭체 적용
function italicTextStyle(text){
    let cmdItalicIndex = text.indexOf('_');

    if(cmdItalicIndex != -1){
        let italicText = text.substr(cmdItalicIndex + 1);
        let italicTextEndIndex = italicText.indexOf('_ ');
        let startText = '';
        let centerText = '';
        let endText = '';
        if(italicTextEndIndex != -1){
            startText = text.substr(0, cmdItalicIndex);
            centerText = text.substr(cmdItalicIndex + 1, italicTextEndIndex);
            endText = text.substr(cmdItalicIndex + 1 + italicTextEndIndex + 2);
            text = startText + `<i>${centerText}</i>` + endText;
            text = italicTextStyle(text);
        }else{
            return text;
        }
    }
    return text;
}
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
            text = startText + `<del>${centerText}</del>` + endText;
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
function edit(data, preText){
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
                preText += `<h1>${text}</h1>`;
            }else if(cmd == '##'){
                preText += `<h2>${text}</h2>`;
            }else if(cmd == '###'){
                preText += `<h3>${text}</h3>`;
            }else{
                preText += `<h4>${text}</h4>`;
            }
            
            data = datastr(data);
        }else if(cmd == '![]'){
            //이미지
            text = subtext(data, cmdIndex);
            data = datastr(data);
            preText += text;
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

// h1
function fontsize(){
    write_txt.value += '# ';
}

// img tool
function imgFileLoad(){
    write_txt.value = write_txt.value;
    let fileList = imgFile.files;
    let reader = new FileReader();
    
    // 그 다음 실행됨
    reader.onload = () => {
        let src = reader.result;
        let fileName = fileList[0].name;
        insertImgURL(fileName);
        pre_txt.innerHTML += `<div class="img" style="display:flex; justify-content:center;"><img src="${src}"></img></div>`;
    }
    
    // 함수 실행되면 먼저 실행됨
    reader.readAsDataURL(fileList[0]);
}
// img url wirte_txt에 삽입
function insertImgURL(fileName){
    let uuid = getUUID();
    let url = ` http://images.velog.io/images/username/post/${uuid}/${fileName}`;
    

    // mirror_line[mirror_line.length-1].innerHTML += `<span class="img_marker">!</span><span class="img_code">[]</span><span>${url}</span>`;
    write_txt.value += `\n![]${url} \n`;
    // pre_txt.innerHTML = mirror_line.innerText;
}
function getUUID() {
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
        var r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
        return v.toString(16);
    });
}

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

