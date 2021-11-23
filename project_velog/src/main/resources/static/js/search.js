const main_in = document.querySelector('.main_in');
const fa_search = document.querySelectorAll('.fa-search');
const search = document.querySelector('#search');
const abc = document.querySelector('.abc');


search.onfocus = () =>{
    main_in.style.border = '1px solid #000';
    fa_search[1].style.color = 'black';
}

search.onblur = () => {
    main_in.style.border = '1px solid #dde0e4';
    fa_search[1].style.color = '#dde0e4';
}