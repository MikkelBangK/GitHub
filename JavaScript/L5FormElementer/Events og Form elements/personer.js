let labelNavn = document.querySelector("#navn");
labelNavn.outerHTML = "<label> navn: " + labelNavn.outerHTML + "</label>"

let labelAlder = document.querySelector("#alder");
labelAlder.outerHTML = "<label> alder: " + labelAlder.outerHTML + "</label>"



let personListe = [];

let button = document.querySelector("#knap")
button.onclick = addPerson;
let navn = document.querySelector("#navn");
let alder = document.querySelector("#alder");

function addPerson(){
personListe.push = {
    navn: input.value[0],
    alder: input.value[1]
}
}