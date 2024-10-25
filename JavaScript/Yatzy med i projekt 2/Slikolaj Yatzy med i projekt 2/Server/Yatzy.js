let values = [5,1,2,3,4];
let throwCount = 0;
let holdStatus = [false, false, false, false, false]

export function getValues() {
    return values

}


function setValues(values1){
    values = values1;
}


export function getThrowCount(){
    return throwCount;
}


export function throwDice() {
    let newValues = []; // Kopierer arrayet values

    for(let j = 0; j < values.length; j++){
        newValues[j] = values[j];
    }

    for (let i = 0; i < newValues.length; i++) {
        // Hvis terningen skal holdes, spring kastet over
        if (holdStatus[i]) {
            continue;
        }
        newValues[i] = Math.floor(Math.random() * 6) + 1; // Genererer et tilfældigt tal mellem 1 og 6
    }

    setValues(newValues); // Opdaterer terningværdierne
    throwCount++; // Tæller antallet af kast op
}