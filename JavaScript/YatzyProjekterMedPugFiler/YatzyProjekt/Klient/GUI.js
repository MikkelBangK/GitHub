import{getValues,throwDice}from"./YatzyFacade.js"

async function showValues(){
    await throwDice()
    let values = await getValues()
    let dice1 =document.getElementById("terning1") 
   
}
throwDiceGUI()

async function throwDiceGUI() {
    await throwDice()
    let terningsArea = document.querySelector("#terningArea")
    //fjerner eksisterende terningbilleder
    // input.value = getThrowCount()
    let values = await getValues()

    for (let i = 0; i < values.length; i++) {
        // if (!holdStatus[i]) {
            let img = document.querySelector("#terning" + (i + 1))
            img.src = getFaceValue(values[i])
        // }
    }

    // chosenInputField = true;
    // setValuesInput()
    // setSpecialValuesInput()

    // showValues()

    // console.log(getThrowCount())
    // if ((getThrowCount() % 3) == 0) {
    //     console.log(getThrowCount())
    //     sumTotal.value = (parseInt(sumSameValues.value) + parseInt(sumSameSpecialValues.value)) + (parseInt(bonusSameValues.value))
    //     alert("Tre kast er kastet! Vælg et felt")
    //     knap.disabled = true
    // }
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



