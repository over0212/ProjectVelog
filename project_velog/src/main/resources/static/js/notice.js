const writing = document.querySelector('.menu_writing');
const series = document.querySelector('.menu_series');
const introduction = document.querySelector('.menu_introduction');
const notice_ip = document.querySelector('.notice_ip');
const notice_search = document.querySelector('.notice_search');
const search_icon = document.querySelectorAll('.search_icon');
const items =document.querySelector('.items');
const itemObjs =document.querySelectorAll('.item');

writing.onclick = () => {
    writing.style.color = 'rgb(32, 201, 151)';
    writing.style.borderBottom = '2px solid rgb(32, 201, 151)';
    series.style.color = '#000000';
    series.style.borderBottom = 'none';
    introduction.style.color = '#000000';
    introduction.style.borderBottom = 'none';
}

series.onclick = () => {
    writing.style.color = '#000000';
    writing.style.borderBottom = 'none';
    introduction.style.color = '#000000';
    introduction.style.borderBottom = 'none';
    series.style.color = 'rgb(32, 201, 151)';    
    series.style.borderBottom = '2px solid rgb(32, 201, 151)';
}

introduction.onclick = () => {
    writing.style.color = '#000000';
    writing.style.borderBottom = 'none';
    series.style.color = '#000000';
    series.style.borderBottom = 'none';
    introduction.style.color = 'rgb(32, 201, 151)';    
    introduction.style.borderBottom = '2px solid rgb(32, 201, 151)';
}


notice_ip.onfocus = () => {
    notice_search.style.border = '1px solid #000';
    search_icon[1].style.color = '#000';
    
}
notice_ip.onblur = () => {
    notice_search.style.border = '1px solid rgb(173, 181, 189)';
    search_icon[1].style.color = 'rgb(173, 181, 189)';
}

//  var items = document.getElementsByClassName('items');
//  var atags = items[0].getElementsByTagName('a');

// //  atags.onclick = () => {
// //      atags.changeColor(atags);
// //  }

//  function changeColor(atags){
//     for(let i = 0; i < atags.size(); i++){
//         // atags[i].addEventListener('onclick', () => {
//         //     atags[i].style.color = 'rgb(32, 201, 151)';
            
//         // });
        
//         // atags[i].addEventListener('onblur', () => {
//         //     atags[i].style.color = '#000000';
//         // });

//         atags.value[i].onclick = () => {
//             atags[i].style.color = 'rgb(32, 201, 151)';
//         };
//         // atags[i].onblur = () => {
//         //     atags[i].style.color = '#000';
//         // };
        
//     };
//  }

// tag_li.onclick = () => {
    
// }

// const aTag = document.querySelectorAll('.items li a');

// const items =document.querySelector('.items');
//   items.addEventListener('click', (e) => {
//      console.log(e);
//   for(atags of a){
//     while(el.classList.contains('color--green')){
//         el.classList.remove('color--green');
//     }
//    }
//    if(e.target.tagName == 'A'){
//         e.target.classList.add('color--green');
//     }
//  });

items.addEventListener("click", event => {
    for(let i=0; i<itemObjs.length; i++){
            itemObjs[i].style.color = "rgb(73, 80, 87)";
    }
    if(event.target.className == "item"){
        event.target.style.color = "rgb(32, 201, 151)";
    }
}) 