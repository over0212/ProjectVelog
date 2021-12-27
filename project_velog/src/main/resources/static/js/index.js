const trend = document.querySelector('.nav_trending');
const recent = document.querySelector('.nav_recent');
const underbar = document.querySelector('.nav_underline');
const times_wrap = document.querySelector('.times_wrap');
const plus_btn_wrap = document.querySelector('.plus_btn_wrap');
const plus_btn = document.querySelector('.plus_btn');
const time_box = document.querySelector('.times_select_box');
const plus_box = document.querySelector('.plus_nav_box');
const img_boxes = document.querySelectorAll('.img_box');
const thumnails = document.querySelectorAll('.img_box img');

// 기간별 게시글 정리 하기위한 버튼들
const today_btn = document.querySelector('.today');
const this_week_btn = document.querySelector('.this_week');
const this_month_btn = document.querySelector('.this_month');
const this_year_btn = document.querySelector('.this_year');

// 트렌드,최신 underbar 움직이기
recent.onclick = () => {
    underbar.className = "nav_underline move_right"
    recent.style.color = "rgb(52, 58, 64)";
    recent.style.font_weight = "500";
    trend.style.color = "#a1a8ae";
    trend.style.font_weight = "bold";
    underbar.className = "nav_underline";
    underbar.style.left = "0%";
    times_wrap.style.display = "none";
}

trend.onclick = () => {
    underbar.className = "nav_underline move_left";
    trend.style.color = "rgb(52, 58, 64)";
    trend.style.font_weight = "bold";
    recent.style.color = "#a1a8ae";
    recent.style.font_weight = "500";
    underbar.className = "nav_underline";
    underbar.style.left = "-100%";
    times_wrap.style.display = "flex";
}

//화면 전체를 클릭 했을 때
window.addEventListener('click', (e) => {
	
	// time_box
	if (e.target.classList.contains('times_wrap') || e.target.classList.contains('down-icon')) {
		
		if (time_box.style.display == 'none') {
			time_box.style.display = 'block';
		}
		
		else if (time_box.style.display == 'block') {
			time_box.style.display = 'none';
		}
		
	} else {
		time_box.style.display = 'none';
	}
	
	// plus_btn
	if (e.target.classList.contains('plus_btn') || e.target.classList.contains('plus_btn_wrap')) {
		
		if (plus_box.style.display == 'none') {
			plus_box.style.display = 'block';
		}
		
		else if (plus_box.style.display == 'block') {
			plus_box.style.display = 'none';
		}
		
	} else {
		plus_box.style.display = 'none';
	}
});

// img 엑박 처리
for(let i=0; i<thumnails.length; i++){
	thumnails[i].onerror = () => {
		img_boxes[i].style.display = "none";
	}
}

today_btn.onclick = () => {
	
}
