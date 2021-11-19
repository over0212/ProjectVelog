const input_focus = document.querySelectorAll('.input_focus');
const signup_info = document.querySelectorAll('.signup_info');
const input_box = document.querySelectorAll('.input_box');

input_focus.focus();

input_focus[0].focus = () => {
    signup_info.style.color = 'rgb(32, 201, 151)'; 
}