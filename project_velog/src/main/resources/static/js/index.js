const trend = document.querySelector('.nav_trending');
const recent = document.querySelector('.nav_recent');
const underbar = document.querySelector('.nav_underline');
const times_wrap = document.querySelector('.times_wrap');
const plus_btn = document.querySelector('.plus_btn');
const time_box = document.querySelector('.times_select_box');
const plus_box = document.querySelector('.plus_nav_box');

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

times_wrap.onclick = () => {
    if(time_box.style.display == "none"){
        time_box.style.display = "block";
    }else{
        time_box.style.display = "none";
    }
}

times_wrap.onblur = () => {
	time_box.style.display = "none";
}

plus_btn.onclick = () => {
    if(plus_box.style.display == "none"){
        plus_box.style.display = "block";
    }else{
        plus_box.style.display = "none";
    }
}

plus_btn.onblur = () => {
	plus_box.style.display = "none";
}



