
const modify = document.querySelectorAll('.info_modify_box');
const info_save = document.querySelectorAll('.info_save_box');

const info_creative = document.querySelector('.top_info_creative');
const top_info = document.querySelector('.top_info');

const contents_box = document.querySelector('.contents_box');
const title_box_hidden = document.querySelectorAll('.title_box_hidden');
const inputs = document.querySelectorAll('input');

var user_info = {
	user_name : '',
	content: ''
}

modify[0].onclick = () => {
    top_info.style.display  = 'none';
    info_creative.style.display = 'block';
   
}
 // var FormData = new FormData(form);

info_save[0].onclick = () => {
    info_creative.style.display = 'none';
    top_info.style.display = 'block';
    user_info.user_name = inputs[0].value;
    user_info.content = inputs[1].value;
     user_name();
}

function user_name() {
	alert(JSON.stringify(user_info));
	
	$.ajax({
		type: "patch",
		url : "/mypage/front/7",
		data : JSON.stringify(user_info),
		contentType: "application/json;charset=UTF-8",
		dataType: "text",
		success: function(data) {
			console.log(data);
		},
		error: function() {
			alert('이름내용 또류');
		}
		
	})
}

var user_title = {
	title_creative : ''
}

modify[1].onclick = () => {
    contents_box.style.display = 'none';
    modify[1].style.display = 'none';
    title_box_hidden[0].style.display = 'block';
}

info_save[1].onclick = () => {
    modify[1].style.display = 'block';
    contents_box.style.display = 'block';
    title_box_hidden[0].style.display = 'none';
    user_title.title_creative = inputs[2].value;
    user_info_title();
}

function user_info_title() {
	
	$.ajax({
		type: "patch",
		url: "/mypage/front/7",
		data: JSON.stringify(user_title),
		contentType: "application/json;charset=UTF-8",
		dataType: "text",
		success: function(data){
			alert(data);
		},
		error: function(){
			alert('제목 또류');
		}
	})
};

modify[2].onclick = () => {  
    modify[2].style.display = 'none';
    title_box_hidden[1].style.display = 'block';
}

info_save[2].onclick = () => {
    modify[2].style.display = 'block';
    title_box_hidden[1].style.display = 'none';

}

// 스위치 온오프 기능
const switch_off = document.querySelectorAll('.switch_off');
const switch_on = document.querySelectorAll('.switch_on');
const circle = document.querySelectorAll('.circle');

switch_off[0].onclick = () => {
    switch_off[0].style.background = '#12b886';
}

switch_off[1].onclick = () => {
    switch_off[1].style.background = '#12b886';
}