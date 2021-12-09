const temp_submit = document.querySelector('.temp_submit'); 
const write_page = document.querySelector('.write_page');
const write_title = document.querySelector('.write_title');
const write_tag = document.querySelector('.write_tag');
const ip_tags = document.querySelector('.ip_tags');
const tag_msg = document.querySelector('.tag_msg');
const pre_title = document.querySelector('.pre_title');
const pre_txt = document.querySelector('.pre_txt');
const send_page = document.querySelector('.send_page');
const h1 = document.querySelector('.h1');
const post_title = document.querySelector('.post_title');
const ip_url = document.querySelector('.ip_url');
const text_length = document.querySelector('.text_length');
const cancle_btn = document.querySelector('.cancle_btn');
const length_box = document.querySelector('.length_box');
const real_submit = document.querySelector('.real_submit');
const imgFile = document.querySelector('#imgFile');
const post_content = document.querySelector('.post_content');
const form = document.querySelector('form');
let write_txt = document.querySelector('.write_txt');
// write_page -------------------------------------------
tag_msg.style.display = "none";

ip_tags.onkeypress = () => {
    if (window.event.keyCode == 13 && ip_tags.value.length != 0) { // enter
        window.event.preventDefault();
        const tag_wrap = document.querySelector('.tag_wrap');
        var tag = document.createElement('span');
        var hidden = document.createElement('input');
        hidden.setAttribute('type', 'hidden');
        hidden.name = 'tags';
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
    pre_txt.innerHTML = "";
    let lines = write_txt.value.split(/\r\n|\r|\n/);
    console.log(lines);
    for(let i=0; i<lines.length; i++){
        edit(lines[i]);
    }
}

function edit(data){
	const img = document.querySelector('img');
	console.log(pre_txt.childNodes);
    let splitdata = data.split(' ');
    let cmd = splitdata[0];
/*    if(cmd ==''){
	  cmd = '![]';
}*/
    let fortext = splitdata.slice(1, splitdata.length);
    let text = fortext.join(" ");
    if(data.length != 0){
        if(cmd == '#'){ // h1
            pre_txt.innerHTML += `<h1 class="pre_h1">${text}</h1>`;
        } else if(cmd == '##'){ // h2
            pre_txt.innerHTML += `<h2 class="pre_h2">${text}</h2>`;
        } else if(cmd == '###'){ // h3
            pre_txt.innerHTML += `<h3 class="pre_h3">${text}</h3>`;
        } else if(cmd == '####'){ // h4
            pre_txt.innerHTML += `<h4 class="pre_h4">${text}</h4>`;
        }else if(cmd == '**'){ // bold
            pre_txt.innerHTML += `<p class="pre_bold">${text}</p>`;
        }else if(cmd == '__'){ // italic
            pre_txt.innerHTML += `<p class="pre_italic">${text}</p>`;
        }else if(cmd == '~~'){ // overline
            pre_txt.innerHTML += `<p class="pre_overline">${text}</p>`;
        }else if(cmd == '>'){ //  quote
        }else if(cmd == '@@'){ // link
            console.log(link);
        }else if(cmd == '![]'){ // img
            console.log(src);
            pre_txt.innerHTML += `<div class="img" style="display:flex; justify-content:center;"><img src="/post/${src}"></img></div>`;
        }else if(cmd == '```'){ // code
        } else{
            text = data;
            pre_txt.innerHTML += `<p class="pre_text">${text}</p>`;
        }
    }else{
        pre_txt.innerHTML += '<br>';
    }
}

// toolbox 클릭 이벤트 함수
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
        write_txt.value += '\n__  ';
        write_txt.focus();
    }else if(event.target.className == "overline"){
        write_txt.value += '\n~~  ';
        write_txt.focus();
    }
}

// img tool
function imgFileLoad(){
	/*    let fileList = imgFile.files;
    let reader = new FileReader();
    // 그 다음 실행됨
    reader.onload = () => {
        src = reader.result;
        let fileName = fileList[0].name;
        src = insertImgURL(fileName, src);
    }
    // 함수 실행되면 먼저 실행됨
    reader.readAsDataURL(fileList[0]);*/
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
			edit('![] '+data);
		},
		error: function(){
			alert('비동기 처리 오류');
		}
	});
}
var src = '';

// img url wirte_txt에 삽입
function insertImgURL(src){
    src = `http://images.velog.io ${src}`;
    write_txt.value += `\n![]${src} \n`;
}


// 출간하기 버튼 클릭시
temp_submit.onclick = () => {
    send_page.style.display = "block";

    var title = write_title.value;
    var contents = write_txt.value;

    post_title.appendChild(document.createTextNode(title));
    ip_url.value = title;
    text_length.textContent = contents.length;
    
    if(text_length.value >= 150){
	    post_content.value = contents.slice(0, 149);    
    }else{
    	post_content.value = contents;
    }
}

// send_page --------------------------------------------
post_content.onkeydown = () => {
	var txt_length = post_content.value.length;
	if(txt_length > 150){
		post_content.value = post_content;
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

const username = document.querySelector('#username');
const insert_form = document.querySelector('.form');
function insertForm(){
	let formData = new Formdata(insert_form);
	
	$.ajax({
			type: 'post',
			url: '/border/insert/' + username.value,
			enctype: 'multipart/form-data',
			processData: false,
			contentType: false,
			data: formData,
			success: function(data){
				alert('게')
				location.href = ""
			},
			error: function(){
				alert('비동기 처리 오류');
			}
			
		})
	
} 

// submit 버튼
// real_submit.onclick() = () => {
		
// }

