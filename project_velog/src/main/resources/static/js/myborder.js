const list = document.querySelector('.list');
const series = document.querySelector('.series');
const intro = document.querySelector('.intro');
const border_ip = document.querySelector('.border_ip');
const border_search = document.querySelector('.border_search');
const search_icon = document.querySelectorAll('.search_icon');
const items = document.querySelector('.items');
const itemObjs = document.querySelectorAll('.item');

list.onclick = () => {
	list.style.color = 'rgb(32, 201, 151)';
	list.style.borderBottom = '3px solid rgb(32, 201, 151)';
	series.style.color = '#000000';
	series.style.borderBottom = 'none';
	intro.style.color = '#000000';
	intro.style.borderBottom = 'none';
}

series.onclick = () => {
	list.style.color = '#000000';
	list.style.borderBottom = 'none';
	intro.style.color = '#000000';
	intro.style.borderBottom = 'none';
	series.style.color = 'rgb(32, 201, 151)';
	series.style.borderBottom = '3px solid rgb(32, 201, 151)';
}

intro.onclick = () => {
	list.style.color = '#000000';
	list.style.borderBottom = 'none';
	series.style.color = '#000000';
	series.style.borderBottom = 'none';
	intro.style.color = 'rgb(32, 201, 151)';
	intro.style.borderBottom = '3px solid rgb(32, 201, 151)';
}


border_ip.onfocus = () => {
	border_search.style.border = '1px solid #000';
	search_icon[1].style.color = '#000';

}
border_ip.onblur = () => {
	border_search.style.border = '1px solid rgb(173, 181, 189)';
	search_icon[1].style.color = 'rgb(173, 181, 189)';
}

items.addEventListener("click", event => {
	for (let i = 0; i < itemObjs.length; i++) {
		itemObjs[i].style.color = "rgb(73, 80, 87)";
	}
	if (event.target.className == "item") {
		event.target.style.color = "rgb(32, 201, 151)";
	}
})

const socialText = document.querySelectorAll('.social a span')
const socialIcon = document.querySelectorAll('.social a')
const social_banner = document.querySelector('.social_banner')

window.onload = () => {
	for (let i = 0; i < 5; i++) {
		if (socialText[i].textContent.length != 0){
			social_banner.style.display = 'block';
			socialIcon[i].style.display = 'block';
			socialIcon[i].style.display = 'flex';			
		}else {
			socialIcon[i].style.display = 'none';		
			
		}
	
	}
}






















