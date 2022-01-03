const list = document.querySelector('.list');
const series = document.querySelector('.series');
const intro = document.querySelector('.intro');
const border_ip = document.querySelector('.border_ip');
const border_search = document.querySelector('.border_search');
const search_icon = document.querySelectorAll('.search_icon');
const items = document.querySelector('.items');
const itemObjs = document.querySelectorAll('.item');
const content_write_box = document.querySelector('.content_write_box');
const content_comment_box = document.querySelector('.content_comment_box');
const user_id = document.querySelector('#id');
const border_main_imgs = document.querySelectorAll('.border_main_img');

list.onclick = () => {
	list.style.color = 'rgb(32, 201, 151)';
	list.style.borderBottom = '3px solid rgb(32, 201, 151)';
	intro.style.color = '#000000';
	intro.style.borderBottom = 'none';
	content_write_box.style.display = 'block';
	content_comment_box.style.display = 'none';
}

intro.onclick = () => {
	list.style.color = '#000000';
	list.style.borderBottom = 'none';
	intro.style.color = 'rgb(32, 201, 151)';
	intro.style.borderBottom = '3px solid rgb(32, 201, 151)';
	content_write_box.style.display = 'none';
	content_comment_box.style.display = 'block';
}


border_ip.onfocus = () => {
	border_search.style.border = '1px solid #000';
	search_icon[1].style.color = '#000';

}
border_ip.onblur = () => {
	border_search.style.border = '1px solid rgb(173, 181, 189)';
	search_icon[1].style.color = 'rgb(173, 181, 189)';
}

for(let i=0; i<border_main_imgs.length; i++){
	border_main_imgs[i].onerror = () => {
		border_main_imgs[i].style.display = 'none';	
	}
}

items.addEventListener("click", event => {
	for (let i = 0; i < itemObjs.length; i++) {
		itemObjs[i].style.color = "rgb(73, 80, 87)";
	}
	if (event.target.className == "item") {
		event.target.style.color = "rgb(32, 201, 151)";
	}
})

const socialText = document.querySelectorAll('.socials a span')
const socialIcon = document.querySelectorAll('.socials a')
const social_banner = document.querySelector('.social_banner')
const emailText = document.querySelector('.emailText')

window.onload = () => {
	for (let i = 0; i < socialIcon.length; i++) {
		if (socialText[i].textContent.length == 0) {
			socialIcon[i].style.display = 'none';
		} else {
			socialIcon[i].style.display = 'block';
		}

	}
}
emailText.style.display = 'none';

socialIcon[4].onmouseover = () => {
	emailText.style.display = 'block';
	emailText.style.display = 'flex';
}
socialIcon[4].onmouseout = () => {
	emailText.style.display = 'none';

}

const comment_write_btn = document.querySelector('.comment_write_btn');
const comment_empty_hidden = document.querySelector('.comment_empty_hidden');
const comment_write_hidden = document.querySelector('.comment_write_hidden');
const comment_save = document.querySelector('.comment_save');
const comment_write = document.querySelector('.comment_write');

comment_write_btn.onclick = () => {
	comment_empty_hidden.style.display = 'none';
	comment_write_hidden.style.display = 'block';
}

comment_save.onclick = () => {
	myBorder_introduce = comment_write.value;
	alert(myBorder_introduce);
	$.ajax({
		type: "put",
		url: "/myborder/" + user_id.value,
		data: {
			"myBorder_introduce": myBorder_introduce
		},
		dataType: "text",
		success: function (data) {
			alert('s');
		},
		error: function () {
			alert('비동기 처리 오류');
		}
	})
}

comment_write.onkeydown = () => {
	resize();
}

function resize() {
	comment_write.style.height = "1px";
	comment_write.style.height = (12 + comment_write.scrollHeight) + "px";
}
