/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
const hamburger=document.querySelector('.header__hamburger');
const navLinks=document.querySelector('.header__nav-links');
const links=document.querySelectorAll('.header__nav-links li');
hamburger.addEventListener("click", () => {
    navLinks.classList.toggle("open");
}
);

