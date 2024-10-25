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
        results[i] = this.sameValuePoints(i + 1);
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

    let counter = [7];

    for (let i = 0; i < counter.length; i++) {
        counter[values[i]]++;
    }
    return counter;
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
    let highestValue = 0;
        let secondHighestValue = 0;


        let pairs = false;

        letcounter = [7];

        for (let i = 0; i < values.length; i++) {
            counter[values[i]]++;
        }

        for (let i = 0; i < counter.length; i++) {
            if (counter[i] >= 2 && !pairs){
                highestValue = i * 2;
                pairs = true;
            }
            if (counter[i] >= 2 && pairs){

                secondHighestValue = i * 2;

                if (secondHighestValue > highestValue){
                    let container = highestValue;
                    highestValue = secondHighestValue;
                    secondHighestValue = container;
                }

            }
        }
        if (pairs) {
            return highestValue;
        }

        return 0;
}


function twoPairPoints(){
    let counter = int[7]; // 7 as im counting dice face from 1-6

        for (let i = 0; i < values.length; i++) {
            counter[values[i]]++;
        }

        let numPairs = 0;
        let sum = 0;
        for (let i = 0; i < counter.length; i++) {
            if (counter[i] >= 2) {
                numPairs++;
                sum += i * 2;
            }

        }

        if (numPairs > 1) {
            return sum;
        }

        return 0;
}

function threeSamePoints(){
    let threeSameValues = false;
    let counter = [7];

    let sum = 0;

    for (let i = 0; i < values.length; i++) {
        counter[values[i]]++;
    }
    for (let i = 0; i < counter.length; i++) {
        if (counter[i] >= 3) {
            threeSameValues = true;
            sum = i * 3;
        }
    }
    if (threeSameValues == true) {
        return sum;
    }

    return 0;
}

function fourSamePoints(){
    let fourSameValues = false;
    let counter = [7];

    let sum = 0;

    for (let i = 0; i < values.length; i++) {
        counter[values[i]]++;
    }
    for (let i = 0; i < counter.length; i++) {
        if (counter[i] >= 4) {
            fourSameValues = true;
            sum = i * 4;
        }
    }
    if (fourSameValues == true) {
        return sum;
    }

    return 0;
}

function fullHousePoints(){
    let counter = [7]; // counter array to count occurence of every value

        let threeFaceValue = false;
        let twoFaceValue = false;

        // counting occurence. Value 1 on index 1 ...
        for (let i = 0; i < values.length; i++) {
            counter[values[i]]++; // i = 0, values[0] = value, counter[value] + 1
        }

        // checking if any index is the value 3
        for (let i = 0; i < counter.length; i++) {
            if (counter[i] == 3) {
                threeFaceValue = true;
            }
            // checking if any index has the value of 2
            if (counter[i] == 2) {
                twoFaceValue = true;
            }

        }

        // if there are index containing both 3 and 2, then return sum of values array
        if (threeFaceValue == true && twoFaceValue == true){
            return IntStream.of(values).sum();
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
    for (let i = 1; i < values.length; i++) {
        if (values[0] != values[i]){
            return 0;
        }
    }
    return 50;
}
export {getValues, getThrowCount, setValues, throwDice, getResults, frequency, sameValue, 
    sameValuePoints, onePairPoints, twoPairPoints, threeSamePoints, fourSamePoints, fullHousePoints, 
    smallStraightPoints, largeStraightPoints, chancePoints, yatzyPoints}