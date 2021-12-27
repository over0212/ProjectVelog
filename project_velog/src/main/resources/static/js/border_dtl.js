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

const likeBtn = document.querySelector('.like_btn');
const likeBtnIcon = document.querySelector('.like_btn i');

likeBtn.onmouseover = () => {
	likeBtn.style.border = '1px solid rgb(33, 37, 41)';
	likeBtnIcon.style.color = 'rgb(33, 37, 41)';
}
likeBtn.onmouseout = () => {
	likeBtn.style.border = '1px solid rgb(173, 181, 189)';
	likeBtnIcon.style.color = 'rgb(134, 142, 150)';
}
/* 좋아요가 안되어있으면 위코드 실행 */

likeBtn.onclick = () => {
	likeBtn.style.background = '#20c997';
	likeBtn.style.border = 'none';
	likeBtnIcon.style.color = 'white';
}

/* 좋아요가 되어있으면 밑코드 실행 */
/*
likeBtn.onmouseover = () => {
	likeBtn.style.background = '#38d9a9';
}
likeBtn.onmouseout = () => {
	likeBtn.style.background = '#20c997';
}
*/















