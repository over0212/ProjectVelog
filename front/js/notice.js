const writing = document.querySelector('.menu_writing');
const series = document.querySelector('.menu_series');
const introduction = document.querySelector('.menu_introduction');

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