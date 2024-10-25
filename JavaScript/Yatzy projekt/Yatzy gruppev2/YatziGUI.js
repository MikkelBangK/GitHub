import {
    getValues, setValues, getThrowCount, throwDice, getResults, frequency,
    sameValuePoints, sameValue, onePairPoints, twoPairPoints,
    threeSamePoints, fourSamePoints, fullHousePoints, smallStraightPoints, largeStraightPoints,
    chancePoints, yatzyPoints, setThrowCount
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
let clickableSpecialInput = document.querySelectorAll('.inputSpecial')
let chosenInputField = true;
let sumSameValues = document.querySelector("#samesAfSamesInput")
let sumSameSpecialValues = document.querySelector('#specialInputSum')
let bonusSameValues = document.querySelector('#sumBonusInput')
let clickAbleDices = document.querySelectorAll('.item')
let sumTotal = document.querySelector('#specialInputTotal')


knap.onclick = throwDiceGUI


function throwDiceGUI() {
    throwDice(holdStatus)
    let terningsArea = document.querySelector("#terningArea")
    //fjerner eksisterende terningbilleder
    // input.value = getThrowCount()

    for (let i = 0; i < getValues().length; i++) {
        if (!holdStatus[i]) {
            let img = document.querySelector("#terning" + (i + 1))
            img.src = getFaceValue(getValues()[i])
        }
    }

    chosenInputField = true;
    setValuesInput()
    setSpecialValuesInput()

    console.log(getThrowCount())
    if ((getThrowCount() % 3) == 0) {
        console.log(getThrowCount())
        sumTotal.value = (parseInt(sumSameValues.value) + parseInt(sumSameSpecialValues.value)) + (parseInt(bonusSameValues.value))
        alert("Tre kast er kastet")
        knap.disabled = true
        }
    }

function newRound(){
    knap.disabled = false
    setThrowCount(0)
    for (let i = 0; i < 5; i++){ 
    if(clickAbleDices[i].classList.contains('held')){
        handleClick(i)
    }
    resetDice()

}
}

function resetDice(){
    for (let i = 0; i < holdStatus.length; i++){ 
    let img = document.querySelector("#terning" + (i + 1))
    img.src = getFaceValueBlank()
    }
}


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


function setSpecialValuesInput() {
    console.log("Inside setSpecialValuesInput()");
    clickableSpecialInput.forEach(input => {
        console.log("Input ID:", input.id);
        if (input.id == "specialInput1") {
            console.log("Setting value for special1");
            console.log("HEJ HEJ " + getResults()[6])
            input.value = getResults()[6];
        } else if (input.id == "specialInput2") {
            console.log("Setting value for special2");
            input.value = getResults()[7];
        } else if (input.id == "specialInput3") {
            console.log("Setting value for special3");
            input.value = getResults()[8];
        } else if (input.id == "specialInput4") {
            console.log("Setting value for special4");
            input.value = getResults()[9];
        } else if (input.id == "specialInput5") {
            console.log("Setting value for special5");
            input.value = getResults()[10];
        } else if (input.id == "specialInput6") {
            console.log("Setting value for special6");
            input.value = getResults()[11];
        } else if (input.id == "specialInput7") {
            console.log("Setting value for special7");
            input.value = getResults()[12];
        } else if (input.id == "specialInput8") {
            console.log("Setting value for special8");
            input.value = getResults()[13];
        } else if (input.id == "specialInput9") {
            console.log("Setting value for special9");
            input.value = getResults()[14];
        }
    });
}






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


function getFaceValueBlank(){
    return 'Kugle blank.png'
}

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
    } else if (id == "samesInput2") {

        value = getResults()[1]
    }
    else if (id == "samesInput3") {
        value = getResults()[2]

    } else if (id == "samesInput4") {
        value = getResults()[3]


    } else if (id == "samesInput5") {
        value = getResults()[4]


    } else if (id == "samesInput6") {
        value = getResults()[5]
    }
    return value;
}



function getResultSpecialValue(id) {
    let value = 0
    if (id == "specialInput1") {
        value = getResults()[6]

    } else if (id == "specialInput2") {
        value = getResults()[7]

    } else if (id == "specialInput3") {
        value = getResults()[8]

    } else if (id == "specialInput4") {
        value = getResults()[9]

    } else if (id == "specialInput5") {
        value = getResults()[10]

    } else if (id == "specialInput6") {
        value = getResults()[11]

    } else if (id == "specialInput7") {
        value = getResults()[12]

    } else if (id == "specialInput8") {
        value = getResults()[13]

    } else if (id == "specialInput9") {
        value = getResults()[14]
    }
    return value;
}



function handleClick(index) {
    // Ændr holdningsstatus for den valgte terning
    holdStatus[index] = !holdStatus[index];
    // Tilføj eller fjern CSS-klasse for at angive, at terningen er holdt fast
    if (holdStatus[index]) {
        clickAbleDices[index].classList.add('held');
    } else {
        clickAbleDices[index].classList.remove('held');
    }
}


// clickAbleDices.forEach(dice => {
//     dice.addEventListener('click', function() {
//         if (dice.classList.contains('held')) {
//             dice.classList.remove('held'); // Fjern "holdt" klassen
//         } else {
//             dice.classList.add('held'); // Tilføj "holdt" klassen
//         }
//     });
// });



clickAbleDices.forEach((dice, index) => {
    dice.addEventListener('click', () => handleClick(index));
});


clickableInputs.forEach(input => {
    input.addEventListener('click', function () {
        if (input.classList.contains('held')) {
            let inputHolder = input.value;
            input.classList.remove('held');
            input.value = inputHolder;
        } else {
            if (chosenInputField) {
                let valueHeld = input.value;
                let bonus = 0
                let sum = parseInt(sumSameValues.value);
                input.classList.add('held');
                input.disabled = true;
                chosenInputField = false;
                sum += getResultSameValue(input.id);
                if (sum >= 63) {
                    bonus = 50
                    bonusSameValues.value = bonus.toString()
                    // sum += bonus
                }
                console.log("Dette er sum " + sum)
                sumSameValues.value = sum.toString();
                // calculateSum(valueHeld,input.id)
            }
        }
        newRound()
    });
});



clickableSpecialInput.forEach(input => {
    input.addEventListener('click', function () {
        if (input.classList.contains('held')) {
            let inputHolder = input.value;
            input.classList.remove('held');
            input.value = inputHolder;
        } else {
            if (chosenInputField) {
                let valueHeld = input.value;
                let bonus = 0
                let sum = parseInt(sumSameSpecialValues.value);
                input.classList.add('held');
                input.disabled = true;
                chosenInputField = false;

                sum += getResultSpecialValue(input.id);
                if (sum >= 63) {
                    bonus = 50
                    bonusSameValues.value = bonus.toString()
                    // sum += bonus
                }
                sumSameSpecialValues.value = sum.toString();
                // calculateSum(valueHeld,input.id)
            }
        }
        newRound()
    });
});


//nbm install moca 











