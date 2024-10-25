import{getValues}from"./YatzyFacade.js"

async function showValues(){
    let values = await getValues()
    let dice1 =document.getElementById("terning1") 
    dice1.value = values[0]





}


showValues()