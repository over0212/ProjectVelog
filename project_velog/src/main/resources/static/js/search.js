const main_in = document.querySelector('.main_in');
const fa_search = document.querySelectorAll('.fa-search');
const search = document.querySelector('#search');
const search_body = document.querySelector('#search_body');
const keyword = document.querySelector('.keyword');

// 처음에 display를 none으로 감춰준다.
search_body.style.display = 'none';

search.onfocus = () =>{
    main_in.style.border = '1px solid #000';
    fa_search[1].style.color = 'black';
}

search.onblur = () => {
    main_in.style.border = '1px solid #dde0e4';
    fa_search[1].style.color = '#dde0e4';
}

search.onkeyup = () =>{
	if(search.value.length == 0){
		search_body.style.display = 'none';
	}
	$.ajax({
		type: "get",
		url: "/search/" + keyword.value,
		contentType: "application/json; charset=UTF-8",
		dataType: "text",
		success: function(data){
			
			if(data != null){
			
			let search_list = JSON.parse(data);	
			search_body.style.display = 'flex';
			search_body.innerHTML = "";
					
					let date = search_list[i].update_date;
					let formatDate = date.subString(0, 10);
				for(let i = 0; i < search_list.length; i++){
					search_body.innerHTML += `
					<div id="search_list">		
						<section id="s_form">
							<div class="s_user_info">
								<a href="/border/${search_list[i].username}" class="s_user_img">
									<img src="/image/profile/${search_list[i].profile_img_url}">
								</a>
								<a href="/border/${search_list[i].username}" class="s_user_username">${search_list[i].username}</a>
							</div>
							<div class="s_border">
								<a href="/border/${search_list[i].username}/${search_list[i].url}" class="s_border_img">
								<img src=/image/${search_list[i].preview_img_url}
								</a>
								<a href="/border/${search_list[i].username}/${search_list[i].url}" class="s_border_title">
								<h2>${search_list[i].main_title}</h2>
								</a>
								<p class="s_txt">${search_list[i].preview_txt}</p>
							</div>
							<div class="s_tag_list">
							</div>
							<div class="sub_info">
								<span class="s_date">${formatDate}</span>
							</div>
						</section>
					</div>`;
					
					
					
					// 해당 태그의 배열을 변수에 대입
					let list = search_list[i].main_tags;
					// 태그의 배열을 for문을 통해 innerHTML에 입력
					for(let j = 0; j < list.size; j++){
						const s_tag_lists = document.querySelectorAll('.s_tag_list');
						let last_list = s_tag_lists[s_tag_lists.length - 1];
						last_list.innerHTML += `<a href="#">${list[j]}</a>`;
					}
				} // end of for
			} // end of if
		}, // end of success
		error: function(){
			alert("비동기 처리 오류!");
		}
	});
	
}

