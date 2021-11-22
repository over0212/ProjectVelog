// 트렌드,최신 underbar 움직이기
const trend = document.querySelector('.nav_trend');
const recent = document.querySelector('.nav_recent');
const underbar = document.querySelector('.nav_underline');

recent.onclick() = () => {
    recent.style.color = "rgb(52, 58, 64)";
    trend.style.color = "#a1a8ae"
    underbar.style.transform = "translateX(0%) ease-in 0.4s";
}
