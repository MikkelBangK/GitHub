

let values = [0,0,0,0,0];
let throwCount = 0;


function getValues() {
    return values
    
}
function setValues(values1){
    values = values1;
}

function getThrowCount(){ 
    return throwCount;
}

function throwDice(holdStatus) {
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





function getResults(){
    let results = []
    for (let i = 0; i <= 5; i++) {
        results[i] = sameValuePoints(i + 1);
    }
    results[6] = onePairPoints();
    results[7] = twoPairPoints();
    results[8] = threeSamePoints();
    results[9] = fourSamePoints();
    results[10] = fullHousePoints();
    results[11] = smallStraightPoints();
    results[12] = largeStraightPoints();
    results[13] = chancePoints();
    results[14] = yatzyPoints();

    return results;
}


function frequency() {
    let freq = new Array(7).fill(0);
    for (let i = 0; i < values.length; i++) {
        freq[values[i]]++;
    }
    return freq;
}
function sameValuePoints(value){
    let sum = 0;
    // checking if index i is the same as the paramenter value, then it will at the number to sum
    for (let i = 0; i < values.length; i++) {
        if (values[i] == value) {
            sum += values[i];
        }
    }
    return sum;
}

function sameValue(value){
    let count = 0;

    for (let i = 0; i < values.length; i++) {
        if (values[i] == value) {
            count++;
        }
    }

    return count;
}


function onePairPoints(){
    const freq = frequency();
    let sum = 0;
    for (let i = 0; i < freq.length; i++) {
      if (freq[i] >= 2) {
        sum = i * 2;
      }
    }
  
    return sum;
}


function twoPairPoints(){
    let freq = frequency();
    let result = 0;
    for (let i = freq.length - 1; i >= 1; i--) {
        if (result !== 0 && freq[i] >= 2) {
            return result += i * 2;
        } else if (freq[i] >= 2) {
            result = i * 2;
        }
    }
    return 0;
}

function threeSamePoints(){
    let freq = frequency();
    for (let i = 1; i <= freq.length - 1; i++) {
        if (freq[i] >= 3) {
            return i * 3;
        }
    }
    return 0;
}

function fourSamePoints(){
    let freq = frequency();
    for (let i = 1; i <= freq.length - 1; i++) {
        if (freq[i] >= 4) {
            return i * 4;
        }
    }
    return 0;
}

function fullHousePoints(){
    let freq = frequency();
let hus = 2;
let result = 0;
for (let i = freq.length - 1; i >= 1; i--) {
    if (result !== 0 && freq[i] >= hus) {
        return result += freq[i] * i;
    } else if (freq[i] >= hus) {
        result = freq[i] * i;
        if (freq[i] === 2) {
            hus = 3;
        }
    }
}
return 0;
}
function smallStraightPoints(){
    let smallStraightPoints = 0;
    let count = 0;

    for (let i = 1; i <= 5; i++) {
        if (sameValue(i) == 1) {
            count++;
        }
    }
    if(count==5){
        smallStraightPoints=15;
    }

    return smallStraightPoints;
}


function largeStraightPoints(){
    let largeStraightPoints = 0;
        let count = 0;

        for (let i = 2; i <= 6; i++) {
            if (sameValue(i) == 1) {
                count++;
            }
        }
        if(count==5){
            largeStraightPoints=20;
        }

        return largeStraightPoints;
}

function chancePoints(){
    let sum = 0;
    for (let i = 0; i < values.length; i++) {
        sum += values[i];
    }

    return sum;
}

function yatzyPoints(){
    let freq = frequency();
    for (let i = 0; i <= freq.length - 1; i++) {
        if (freq[i] === 5) {
            return 50;
        }
    }
    return 0;
}

export{getValues,setValues,getThrowCount,throwDice,getResults,frequency,
    sameValuePoints,sameValue,onePairPoints,twoPairPoints,
threeSamePoints,fourSamePoints,fullHousePoints,smallStraightPoints,largeStraightPoints,
chancePoints,yatzyPoints}
