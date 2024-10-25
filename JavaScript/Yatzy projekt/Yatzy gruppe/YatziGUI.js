import {
    getValues, setValues, getThrowCount, throwDice, getResults, frequency,
    sameValuePoints, sameValue, onePairPoints, twoPairPoints,
    threeSamePoints, fourSamePoints, fullHousePoints, smallStraightPoints, largeStraightPoints,
    chancePoints, yatzyPoints
} from "./YatziLogik.js";

// Hent alle elementer med klassen "tegning"
var tegninger = document.querySelectorAll('.tegning');

// Tilføj en event listener til hvert element
tegninger.forEach(function (tegning) {
    tegning.addEventListener('mouseover', function () {
        // Ændr størrelsen på elementet, når musen holder over det
        tegning.style.transform = 'scale(1.9)';
    });

    tegning.addEventListener('mouseout', function () {
        // Gendan størrelsen på elementet, når musen fjernes
        tegning.style.transform = 'scale(1)';
    });
});

let knap = document.querySelector("button")
// let input = document.querySelector("#throwCounter")
let holdStatus = [false, false, false, false, false]

// let clickAbleInputs = document.querySelectorAll('.input')

let clickableInputs = document.querySelectorAll('.input');
let clickAbleSpecialInputs = document.querySelectorAll('.inputSpecial')
let chosenInputField = true;
let sumSameValues = document.querySelector("#samesAfSamesInput")
let bonusSameValues = document


knap.onclick = throwDiceGUI


function throwDiceGUI() {

    throwDice(holdStatus)
    let terningsArea = document.querySelector("#terningArea")
    //fjerner eksisterende terningbilleder
    // input.value = getThrowCount()

    for (let i = 0; i < getValues().length; i++) {
        console.log("#terning" + (i + 1))
        let img = document.querySelector("#terning" + (i + 1))
        console.log("img.src:" + img.src)
        img.src = getFaceValue(getValues()[i])
        console.log("img.src:" + img.src)
    }
    chosenInputField = true;
    setValuesInput();
    setSpecialInput();

    console.log(getThrowCount())
    if (getThrowCount() % 3 == 0) {
        console.log(getThrowCount())

        alert("Tre kast er kastet")

    }




}

// Logikken for samesValue i inputfelterne
function setValuesInput() {
    clickableInputs.forEach(input => {
        if (input.id == "samesInput1") {
            if (input.disabled == false) {
                input.value = getResults()[0].toString()
            }
        } else if (input.id == "samesInput2") {
            if (input.disabled == false) {
                input.value = getResults()[1].toString()
            }
        }
        else if (input.id == "samesInput3") {
            if (input.disabled == false) {
                input.value = getResults()[2].toString()
            }

        } else if (input.id == "samesInput4") {
            if (input.disabled == false) {
                input.value = getResults()[3].toString()
            }

        } else if (input.id == "samesInput5") {
            if (input.disabled == false) {
                input.value = getResults()[4].toString()
            }

        } else if (input.id == "samesInput6") {
            if (input.disabled == false) {
                input.value = getResults()[5].toString()
            }

        }

    })

}

function setSpecialInput() {
    clickAbleSpecialInputs.forEach(inputSpecial => {
        if (inputSpecial.id == "specialInput1") {
            if (inputSpecial.disabled == false) {
                inputSpecial.value = getResults()[6].toString()
            }
        } else if (inputSpecial.id == "specialInput2") {
            if (inputSpecial.disabled == false) {
                inputSpecial.value = getResults()[7].toString()
            }
        }
        else if (inputSpecial.id == "specialInput3") {
            if (inputSpecial.disabled == false) {
                inputSpecial.value = getResults()[8].toString()
            }

        } else if (inputSpecial.id == "specialInput4") {
            if (inputSpecial.disabled == false) {
                inputSpecial.value = getResults()[9].toString()
            }

        } else if (inputSpecial.id == "specialInput5") {
            if (inputSpecial.disabled == false) {
                inputSpecial.value = getResults()[10].toString()
            }

        } else if (inputSpecial.id == "specialInput6") {
            if (inputSpecial.disabled == false) {
                inputSpecial.value = getResults()[11].toString()
            }

        } else if (inputSpecial.id == "specialInput7") {
            if (inputSpecial.disabled == false) {
                inputSpecial.value = getResults()[12].toString()
            }

        } else if (inputSpecial.id == "specialInput8") {
            if (inputSpecial.disabled == false) {
                inputSpecial.value = getResults()[13].toString()
            }

        } else if (inputSpecial.id == "specialInput9") {
            if (inputSpecial.disabled == false) {
                inputSpecial.value = getResults()[14].toString()
            }
        }
    })

}

clickAbleSpecialInputs.forEach(inputSpecial => {
    inputSpecial.addEventListener('click', function () {
        if (inputSpecial.classList.contains('held')) {
            let inputHolder = inputSpecial.value;
            inputSpecial.classList.remove('held');
            inputSpecial.value = inputHolder;
        } else {
            if (chosenInputField) {
                let valueHeld = inputSpecial.value;
                let sum = parseInt(sumSameValues.value);
                inputSpecial.classList.add('held');
                inputSpecial.disabled = true;
                chosenInputField = false;
                sum += getResultSameValue(inputSpecial.id);
                sumSameValues.value = sum.toString();
                // calculateSum(valueHeld,input.id)
            }
        }
    });
});


// function calculateSum(value){
//     let sum = parseInt(sumSameValues.value)
//     let bonus = 0
//      sum += parseInt(value)
//      if(sum  >= 63){
//        bonus = 50

//     }

//     sum += bonus
//     sumSameValues.value = sum.toString()


// }

// Logikken for, hvilket billede tegningen skal vise
function getFaceValue(value) {
    if (value == 1) {
        return 'Kugle 1 50_50.png'
    } else if (value == 2) {
        console.log("terning2.PNG")
        return 'Kugle 2 50_50.png'
    } else if (value == 3) {
        console.log("terning3.PNG")
        return 'Kugle 3 50_50.png'
    } else if (value == 4) {
        console.log("terning3.PNG")
        return 'Kugle 4 50_50.png'
    } else if (value == 5) {
        console.log("terning3.PNG")
        return 'Kugle 5 50_50.png'
    } else if (value == 6) {
        console.log("terning3.PNG")
        return 'Kugle 6 50_50.png'
    }
}


function getResultSameValue(id) {
    let value = 0
    if (id == "samesInput1") {
        value = getResults()[0]
    } 
    else if (id == "samesInput2") {
        value = getResults()[1]

    } 
    else if (id == "samesInput3") {
        value = getResults()[2]

    } 
    else if (id == "samesInput4") {
        value = getResults()[3]

    } 
    else if (id == "samesInput5") {
        value = getResults()[4]

    } 
    else if (id == "samesInput6") {
        value = getResults()[5]

    }
    return value;
}



clickableInputs.forEach(input => {
    input.addEventListener('click', function () {
        if (input.classList.contains('held')) {
            let inputHolder = input.value;
            input.classList.remove('held');
            input.value = inputHolder;
        } else {
            if (chosenInputField) {
                let valueHeld = input.value;
                let sum = parseInt(sumSameValues.value);
                input.classList.add('held');
                input.disabled = true;
                chosenInputField = false;
                sum += getResultSameValue(input.id);
                sumSameValues.value = sum.toString();
                // calculateSum(valueHeld,input.id)
            }
        }
    });
});

//nbm install moca 











