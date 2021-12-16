const main_content = document.querySelector('.main_content');
const update_btn = document.querySelector('.update_btn');

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