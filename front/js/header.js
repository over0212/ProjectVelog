// 로그인 버튼
const login_btn = document.querySelector(".login_btn");

login_btn.onclick = () => {
    const si_container = document.querySelector(".si_container");
    si_container.style.display = "block";
    si_container.className = "si_container active"
    si_container.style.transform = "translateY(0px)";
}