const main_content = document.querySelector('.main_content');
const update_btn = document.querySelector('.update_btn');
const delete_btn = document.querySelector('.delete_btn');

// detail_page
$(document).ready(function(){
	edit(main_content.value,'');
});

// update_btn
update_btn.onclick = () => {
	const username = document.querySelector('#username');
	const url = document.querySelector('#url');
	location.href = '/border/update/' + username.value + '/' + url.value;
}

// delete_btn
delete_btn.onclick = () => {
	const url = document.querySelector('#url');
	const username = document.querySelector('#username');
	$.ajax({
		type: "delete",
		url: "/border/delete/" + username.value +"/"+ url.value,
		success: function(data){
			alert("삭제 성공!");
			if(data == "1"){
				location.replace("/index");
			}else{
				alert("삭제 실패");
			}
		},
		error: function(){
			alert("비동기 오류");
		}
	})
}
const like_btns = document.querySelector('.like_btns');
const off_box = document.querySelector('.off_box');
const like_off = document.querySelector('.like_off');

const on_box = document.querySelector('.on_box');
const like_on = document.querySelector('.like_on');

like_btns.onclick = () => {
	like_btns.style.display ='none';
}
/*
like_btns.onmouseover = () => {
	off_box.style.border ='rgb(33, 37, 41)';
	like_off.style.color ='rgb(33, 37, 41)';
	on_box.style.border ='rgb(33, 37, 41)';
}
like_btns.onmouseout = () => {
	off_box.style.border ='rgb(173, 181, 189)';
	like_off.style.color ='rgb(173, 181, 189)';
	on_box.style.border ='rgb(33, 37, 41)';
}

like_btns.onclick = () => {
	off_box.style.display = 'none';
	on_box.style.display = 'block';
	on_box.style.display = 'flex';
	
}

*/




