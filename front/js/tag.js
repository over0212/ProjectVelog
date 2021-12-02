/* span tag */
const trending_nav = document.querySelector('.trending_nav');
const name_nav = document.querySelector('.name_nav');
/* a tag */
const trending_btn = document.querySelector('.trending_btn');
const name_btn = document.querySelector('.name_btn');

trending_btn.onclick = () => {
    name_nav.style.borderBottom = 'none';
    name_btn.style.color = '#acb1b9';
    trending_nav.style.borderBottom = '2px solid rgb(32, 201, 151)';
    trending_btn.style.color = 'rgb(32, 201, 151)';
}

name_btn.onclick = () => {
    trending_nav.style.borderBottom = 'none';
    trending_btn.style.color = '#acb1b9';
    name_nav.style.borderBottom = '2px solid rgb(32, 201, 151)';
    name_btn.style.color = 'rgb(32, 201, 151)';
}
