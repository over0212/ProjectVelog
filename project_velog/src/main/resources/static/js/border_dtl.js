const main_content = document.querySelector('.main_content');
const update_btn = document.querySelector('.update_btn');
const delete_btn = document.querySelector('.delete_btn');

// detail_page
$(document).ready(function () {
	edit(main_content.value, '');
});

// update_btn
if(update_btn != null){
	update_btn.onclick = () => {
		const username = document.querySelector('#username');
		const url = document.querySelector('#url');
		location.href = '/border/update/' + username.value + '/' + url.value;

	}
}

// delete_btn
if(delete_btn != null){
	delete_btn.onclick = () => {
		const url = document.querySelector('#url');
		const username = document.querySelector('#username');
		$.ajax({
			type: "delete",
			url: "/border/delete/" + username.value + "/" + url.value,
			success: function (data) {
				alert("삭제 성공!");
				if (data == "1") {
					location.replace("/index");
				} else {
					alert("삭제 실패");
				}
			},
			error: function () {
				alert("비동기 오류");
			}
		})
	}
}

/* 좋아요 */
const like_btns = document.querySelector('.like_btns');
const off_box = document.querySelector('.off_box');
const like_off = document.querySelector('.like_off');
const on_box = document.querySelector('.on_box');
const like_on = document.querySelector('.like_on');
const like_count = document.querySelector('.like_count');
const like_count_hidden = document.querySelector('.like_count_hidden');

if(off_box != null){
	off_box.onmouseover = () => {
		off_box.style.border = '1px solid rgb(33, 37, 41)';
		like_off.style.color = 'rgb(33, 37, 41)';
	}
	off_box.onmouseout = () => {
		off_box.style.border = '1px solid rgb(134, 142, 150)';
		like_off.style.color = 'rgb(134, 142, 150)';
	}
	
	
	// 좋아요를 누름
	off_box.onclick = () => {
		
		const url = document.querySelector('#url');
		
		$.ajax({
			type : 'put',
			url : '/border/like/' + url.value,
			success: function(data){
				if(data == 0) {
					alert("로그인이 필요합니다.");
				} else if(data == 1){
					alert("좋아요 했습니다.");
					on_box.style.display = 'flex';
					off_box.style.display = 'none';
				}
			},
			error: function(){
				alert("비동기처리 오류");
			}
			
		})
	}
}

if(on_box != null){
	on_box.onmouseover = () => {
		on_box.style.background = '#38d9a9';
	}
	on_box.onmouseout = () => {
		on_box.style.background = '#20c997';
	}

	// 싫어요
	on_box.onclick = () => {
		
		
		const url = document.querySelector('#url');
		
		$.ajax({
			type : 'delete',
			url : '/border/like/' + url.value,
			success: function(data){
				if(data == 1){
					alert("좋아요가 취소되었습니다.");
					on_box.style.display = 'none';
					off_box.style.display = 'flex';
				}
			},
			error: function(){
				alert("비동기처리 오류");
			}
			
		})
	}
}




