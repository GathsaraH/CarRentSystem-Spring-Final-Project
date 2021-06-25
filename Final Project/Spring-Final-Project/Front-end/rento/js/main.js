'use strict';

//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
//Show me the booodddyyyy!!!!

function showBody() {
    setTimeout(() => {
        //show it
        document.body.style.opacity = 1;
    //grow it
    document.getElementById("panel3").style.animation = `blubb 1.75s ease-out`;
}, 100);
}
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

let panels = document.querySelectorAll(".panels");

panels.forEach(ea => {
    ea.addEventListener("click", ev => {
        let curTar = ev.currentTarget;

panels.forEach(ea => ea.style.flex = 1);
curTar.style.flex = 3;

document.querySelectorAll(`p.top`).forEach(p => p.style.marginTop = `-10vh`);
document.querySelectorAll(`p.mid`).forEach(p => p.style.transform = `scale(1)`);
document.querySelectorAll(`p.bot`).forEach(p => p.style.marginBottom = `-10vh`);
curTar.querySelectorAll(`p`).forEach((p, i) => {
    if (i === 0) {
    p.style.marginTop = `20vh`
} else if (i === 1) {
    p.style.transform = `scale(1.2)`
} else if (i === 2) {
    p.style.marginBottom = `20vh`
}
});
});
});


let current = 1; //keeps track of the current div
let height = 50; //the height of the roles div
let numberDivs = $('.roles').children().length; //the number of children of the roles div
let first = $('.roles div:nth-child(1)'); //the first div nested in roles div
setInterval(function() {
    console.log("come")
    let number = current * -height;
    first.css('margin-top', number + 'px');
    if (current === numberDivs) {
        first.css('margin-top', '0px');
        current = 1;
    } else current++;
}, 2000);


$('#exampleModal').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget) // Button that triggered the modal
    var recipient = button.data('whatever') // Extract info from data-* attributes
    // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
    // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
    var modal = $(this)
    modal.find('.modal-title').text('New message to ' + recipient)
    modal.find('.modal-body input').val(recipient)
});


//car card


$('.carousel').carousel();
