// let values = [5,1,2,3,4];
// let throwCount = 0;
// let holdStatus = [false, false, false, false, false]
import {addDoc, collection} from "firebase/firestore";
import firebase from "firebase/compat/app";

let playerList = [];







export async function createPlayer(navn){
    const newPlayer = {
        navn: navn,
        platerState: {
            values: [5, 1, 2, 3, 4],
            holdStatus: [false, false, false, false, false],
            throwCount: 0
        },
        resultList: {
            sameValue1: { value: 0, valgt: false },
            sameValue2: { value: 0, valgt: false },
            sameValue3: { value: 0, valgt: false },
            sameValue4: { value: 0, valgt: false },
            sameValue5: { value: 0, valgt: false },
            sameValue6: { value: 0, valgt: false },
            onePair: { value: 0, valgt: false },
            twoPair: { value: 0, valgt: false },
            threeSame: { value: 0, valgt: false },
            fourSame: { value: 0, valgt: false },
            fullHouse: { value: 0, valgt: false },
            smallStraight: { value: 0, valgt: false },
            largeStraight: { value: 0, valgt: false },
            chance: { value: 0, valgt: false },
            yatzy: { value: 0, valgt: false }
        }
    };
    // Add the new player to the player list
    playerList.push(newPlayer);
    console.log("Spiller oprettet i yatzy metode delen " + newPlayer.navn);

    try {
        // Add the new player to the Firestore database
        const docRef = await addDoc(collection(db, "Players"), newPlayer);
        console.log("Player added with ID: ", docRef.id);
    } catch (e) {
        console.error("Error adding player: ", e);
    }
    playerList.push(playerList[0]);
    console.log("Spiller oprettet i yatzy metode delen " + playerList[0].navn);

    try {
        const docRef = await addDoc(collection(db, "Players"), playerList[0]);
        console.log("Player added with ID: ", docRef.id);
    } catch (e) {
        console.error("Error adding player: ", e);
    }
}
export function getValues(playerName) {
    return getPlayerState(playerName).values
    
}
function getPlayerState(playerName) {
    let result = playerList.find((player)=>player.navn === playerName).platerState
    console.log("Player state " +result.values)
    return result
}

function setValues(values1,playerName){
   getPlayerState(playerName).values = values1;
}


export function getThrowCount(playerName){ 
    return getPlayerState(playerName).throwCount
}


export function throwDice(playerName) {
    let newValues = []; // Kopierer arrayet values
     let values = getValues(playerName)
    let holdStatus = getPlayerState(playerName).holdStatus
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

    setValues(newValues,playerName); // Opdaterer terningværdierne
    getPlayerState(playerName).throwCount++; // Tæller antallet af kast op
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

export function getResults(){
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


// export default {
//     getResults
// }