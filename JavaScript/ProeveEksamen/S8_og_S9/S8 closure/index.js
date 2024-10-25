function randomTal(max) {
    return function() {
        return Math.floor(Math.random() * (max + 1));
    }
}

//Hvordan closure fungerer her:
//Når randomTal kaldes, f.eks. randomTal(10), skabes en ny funktion, som returneres.
//Den returnerede funktion har adgang til max fra sin ydre funktion randomTal, 
//selv efter randomTal-funktionen er afsluttet. Denne adgang er mulig på grund af closure.
//Variablen max holdes i "closure" af den returnerede funktion, hvilket betyder, 
//at den bliver "fanget" af den indre funktion og kan bruges, når den indre funktion kaldes senere.

//Closure opstår, når en indre funktion har adgang til variabler fra sin ydre funktion.

let tilfaeldigAlder = randomTal(10);
let tilfaeldigHoejde = randomTal(180);

class Person {
    constructor(alder, hoejde) {
        this.alder = alder;
        this.hoejde = hoejde;
    }
}

function lavTilfaeldigePersoner(alderFunktion, hoejdeFunktion, antalPersoner) {
    let list = [];
    for (let i = 0; i < antalPersoner; i++) {
        let p = new Person(alderFunktion(), hoejdeFunktion());
        list.push(p);
    }
    return list;
}

let listeAfPersoner = lavTilfaeldigePersoner(tilfaeldigAlder, tilfaeldigHoejde, 20);

listeAfPersoner.forEach(element => {
    console.log("Personen er " + element.alder + " År gammel og " + element.hoejde + "cm høj");
});