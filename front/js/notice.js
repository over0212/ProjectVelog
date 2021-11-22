const writing = document.querySelector('.menu_writing');
const series = document.querySelector('.menu_series');
const introduction = document.querySelector('.menu_introduction');
const notice_ip = document.querySelector('.notice_ip');

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
const notice_search = document.querySelector('.notice_search');
const search_icon = document.querySelectorAll('.search_icon');

notice_ip.onfocus = () => {
    notice_search.style.border = '1px solid #000'
    search_icon[1].style.color = '#000'
    
}
notice_ip.onblur = () => {
    notice_search.style.border = '1px solid rgb(173, 181, 189)';
    search_icon[1].style.color = 'rgb(173, 181, 189)'
    
}

