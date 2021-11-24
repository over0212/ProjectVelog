// 로그인 버튼
const login_btn = document.querySelector(".login_btn");

login_btn.onclick = () => {
    const si_container = document.querySelector(".si_container");
    si_container.style.display = "block";
    si_container.className = "si_container active"
    si_container.style.transform = "translateY(0px)";
}

const tag_li = document.querySelectorAll('li');

tag_li.onclick = () => {
    
}

// const a = document.querySelectorAll('.items li a');
// console.log(a);
// const items =document.querySelector('.items');
//   items.addEventListener('click', (e) => {
     
//   for(el of a){
//     while(el.classList.contains('color')){
//         el.classList.remove('color');
//     }
//    }
//    if(e.target.tagName == 'A'){
//         e.target.classList.add('color');
//     }
//  });

 