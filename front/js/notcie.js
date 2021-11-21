const writing = document.querySelector('.menu_writing');
const series = document.querySelector('.menu_series');
const introduction = document.querySelector('.menu_introduction');

writing.onclick = () => {
    series.style.boderBottom = 'none';
    series.style.color = '#acb1b9';
    introduction.style.boderBottom = 'none';
    introduction.style.color = '#acb1b9';
    writing.style.boderBottom = '2px solid rgb(32, 201, 151)';
    writing.style.color = '#rgb(32, 201, 151)';
    
}
series.onclick = () => {
    writing.style.boderBottom = 'none';
    writing.style.color = '#acb1b9';
    introduction.style.boderBottom = 'none';
    introduction.style.color = '#acb1b9';
    series.style.boderBottom = '2px solid rgb(32, 201, 151)';
    series.style.color = '#rgb(32, 201, 151)';
    
}
introduction.onclick = () => {
    series.style.boderBottom = 'none';
    series.style.color = '#acb1b9';
    writing.style.boderBottom = 'none';
    writing.style.color = '#acb1b9';
    introduction.style.boderBottom = '2px solid rgb(32, 201, 151)';
    introduction.style.color = '#rgb(32, 201, 151)';
    
}