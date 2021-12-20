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
	$.ajax({
		type: "delete",
		url: "/border/delete/" + url.value,
		success: function(){
			alert("삭제 성공!");
		},
		error: function(){
			alert("삭제 실패!");
		}
	})
}