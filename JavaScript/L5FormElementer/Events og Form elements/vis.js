let labelTal = document.querySelector("#tal");
labelTal.outerHTML = "<label> tal" + labelTal.outerHTML + "</label>"

let labelTid = document.querySelector("#tid");
labelTid.outerHTML = "<label> tid" + labelTid.outerHTML + "</label>"


labelTal = document.querySelector("#tal");
labelTal.onclick = klikTal;

labelTid = document.querySelector("#tid");
labelTid.onclick = klikTid;

function klikTid(){
let dato = Date();
labelTid.value = dato;
}
function klikTal(){
let tal = Math.random();
labelTal.value = tal;
}