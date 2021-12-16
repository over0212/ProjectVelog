$(document).ready(function(){
	
	$(".pre_title").text($('.write_title').val());
	$(".pre_title").css({display:"block"});
	
	// tag
	for(let i=0; i<$(".main_tags").size(); i++){
		var tagEl = ($(".main_tags"));
		insertTag(tagEl.eq(i).val());	
	}
	
	$(".pre_txt").html(edit($(".write_txt").val(), ''));
	
})

const update_submit = document.querySelector(".update_submit");
const username = document.querySelector("#username");
const updateForm= document.querySelector(".updateForm");

update_submit.onclick = () => {
	
	updateBorder();
}

function updateBorder(){

	if(ip_url.value.length == 0){
		alert("url이 비었습니다.");
		ip_url.focus();
	}else{
		let formData = new FormData(updateForm);

		$.ajax({
			type: "put",
			url: "/border/update/"+user_id.value,
			/* 파일 업로드 할 땐 꼭 필요한 코드(enctype, processData, contentType)*/
			enctype: "multipart/form-data", 
			data: formData,
			processData: false,
			contentType: false,
			dataType: "text",
			success: function(data){
				let updateBorder = JSON.parse(data);
				if(updateBorder == 1){
					alert('게시글이 수정되었습니다.');
					location.href = "/border/"+username.value +"/"+ip_url.value;
				} else {
					alert("게시글 등록 실패!");
				}
			},
			error: function(){
				alert("비동기 처리 오류!");
			}
		})
	}
}