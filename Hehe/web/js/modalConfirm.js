
// Get the modal
var modal = document.getElementById("modalConfirm");

// Get the button that opens the modal
var btn__Open = document.getElementById("submitbtn");

// Get the <span> element that closes the modal
var btn__Close = document.getElementById("modal-content__close");
var btnOpen1 = document.getElementById("open");
var modalcontent = document.getElementsByClassName("modal-content");

// When the user clicks the button, open the modal
function nextTopic (form_id) {
    modal.style.display = "block";
    var form = document.getElementById(form_id);
    form.submit();
}
function currentTopic() {
    modal.style.display = "none";
}
//      btnOpen1.onclick=function(){
//        modal.style.backgroundColor="green";
//        modal.style.display="block";
//      }
// When the user clicks anywhere outside of the modal, close it


   