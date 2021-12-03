const terms = document.querySelector('.terms');
const privacy = document.querySelector('.privacy');

terms.onclick = () => {
    privacy.style.borderBottom = 'none';
    privacy.style.color = '#acb1b9';
    terms.style.borderBottom = '3px solid rgb(32, 201, 151)';
    terms.style.color = 'rgb(32, 201, 151)';
}

privacy.onclick = () => {
    terms.style.borderBottom = 'none';
    terms.style.color = '#acb1b9';
    privacy.style.borderBottom = '3px solid rgb(32, 201, 151)';
    privacy.style.color = 'rgb(32, 201, 151)';
}
