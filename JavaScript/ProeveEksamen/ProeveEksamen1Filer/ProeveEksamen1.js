class Bil {
    constructor(nummerplade, vægt, mærke, hjul){
        this.nummerplade = nummerplade;
        this.vægt = vægt;
        this.mærke = mærke;
        this.hjul = hjul;
    }
}

let biler = [];

let bil1 = new Bil("aabb", 1200, "Toyota", 4);
let bil2 = new Bil("abcd", 1500, "Ford", 4);
let bil3 = new Bil("aabc", 1800, "BMW", 4);
let bil4 = new Bil("aaab", 2000, "Audi", 4);
let bil5 = new Bil("aaaa", 3500, "VW", 8);

biler.push(bil1, bil2, bil3, bil4, bil5);

console.log(biler)
console.log("")

let biler8Hjul = biler.filter(bil => bil.hjul === 8);

console.log(biler8Hjul);
console.log("")

let nummerplader = biler.map(bil => bil.nummerplade);

console.log(nummerplader);
console.log("")

let mindsteVægt = biler.reduce((acc, bil) => acc.vægt < bil.vægt ? acc : bil);

console.log(mindsteVægt);
console.log("")

let flestHjul = biler.reduce((acc, bil) => acc.hjul > bil.hjul ? acc : bil);

console.log(flestHjul);
console.log("")

let antalBilerHjul = biler.reduce((acc, bil) => {
    acc[bil.hjul] = (acc[bil.hjul] || 0) + 1;
    return acc;
}, {});
console.log(antalBilerHjul);

//map anvender en given funktion på hvert element i et array og returnerer et nyt array med resultaterne.

//filter returnerer et nyt array med alle elementer, der opfylder en betingelse.

//reduce returnerer en enkelt værdi baseret på elementerne i array'et.

//HOF er funktionel programering og handler om man vil tage en funktion som parameter eller kunne retunere
//en funktion i sine funktioner
//fx
function hof(f,g){
    return function(a,b){
        return function(x){
            return g(f(a,b),x)
        }
    }
}

// Eksempel på en funktion, der tager to tal og returnerer deres sum
function add(a, b) {
    return a + b;
}

// Eksempel på en funktion, der tager to tal og returnerer deres produkt
function multiply(a, b) {
    return a * b;
}


const func = hof(add, multiply)(2, 3); // Opretter en funktion, der bruger add og g til at håndtere sum eller produkt af 2 og 3
console.log(func(3)); // Output: 15 (2 * 3 + 3 = 15)
