// write_page -------------------------------------------
const submit_btn = document.querySelector('.on_submit'); 
const write_page = document.querySelector('.write_page');
const write_title = document.querySelector('.write_title');
const write_txt = document.querySelector('.write_txt');
const write_tag = document.querySelector('.write_tag');
const ip_tags = document.querySelector('.ip_tags');
const tag = document.querySelector('.tag');
const tag_msg = document.querySelector('.tag_msg');
const pre_title = document.querySelector('.pre_title');
const pre_txt = document.querySelector('.pre_txt');
const send_page = document.querySelector('.send_page');
const tag_wrap = document.querySelector('.tag_wrap');

tag_msg.style.display = "none";
// let tags = [];

ip_tags.onkeypress = () => {
    if (window.event.keyCode == 13) {
        window.event.preventDefault();
        alert(ip_tags.value);
        var tag = document.createElement('span').appendChild(document.createTextNode(ip_tags.value));
        tag.className = "tag";
        tag_wrap.appendChild(tag);

        ip_tags.value = "";
        // tags.append(ip_tags.value);
        // console.log(tags);
        // for(let i=0; i<tags.size; i++){
            
        //     // write_tag.after(`<span class="tag">${tags[i]}</span>`);
        //     // $(".ip_tags").before(`<span class="tag">${tags[i]}</span>`);
        // }
    }
}

// $(function() {
//     if($(".ip_tags").onkeypress == 13){
//         alert($(".ip_tags").val);
//         tags.append($(".ip_tags").val());
//     }
// })

// 태그 입력창 클릭시 
ip_tags.onclick = () => {
    tag_msg.style.display = "block";
}
ip_tags.onblur = () => {
    tag_msg.style.display = "none";
}

// 미리보기창
// write_title.onkeypress = () => {
//     alert($(".write_title").val());
//     $(".pre_title").append($(".write_title").val);
// }

// 출간하기 버튼 클릭시
submit_btn.onclick = () => {
    send_page.style.display = "block";
    write_page.style.display = "none"
}

// send_page --------------------------------------------
const cancle_btn = document.querySelector('.cancle_btn');

//취소 버튼
cancle_btn.onclick = () => {
    send_page.style.display = "none";
    write_page.style.display = "block"
}