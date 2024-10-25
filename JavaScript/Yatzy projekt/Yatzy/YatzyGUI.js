import {getValues, getThrowCount, setValues, throwDice, getResults, frequency, sameValue, 
  sameValuePoints, onePairPoints, twoPairPoints, threeSamePoints, fourSamePoints, fullHousePoints, 
  smallStraightPoints, largeStraightPoints, chancePoints, yatzyPoints} from "./YatzyLogik.js"

    /*document.getElementById("YEET").addEventListener("click", rollDice);*/
   /* function rollDice() {
        const diceImages = [
            "Dice1.png",
            "Dice2.png",
            "Dice3.png",
            "Dice4.png",
            "Dice5.png",
            "Dice6.png"
        ];
        const diceSlots = document.getElementsByClassName("dice");

        for (let i = 0; i < diceSlots.length; i++) {
            const diceRandom = Math.floor(Math.random() * diceImages.length);
            const randomDiceImage = diceImages[diceRandom];
            diceSlots[i].src = randomDiceImage;
        }
    }    */
    let knap = document.querySelector("#YEET")
    // let input = document.querySelector("#throwCounter")
    let holdStatus =[false,false,false,false,false]
    
    knap.onclick = throwDiceGUI
    
    function throwDiceGUI(){
        throwDice(holdStatus)
        let terningsArea = document.querySelector("#diceContainer")
        //fjerner eksisterende terningbilleder
        // input.value = getThrowCount()
    
        for (let i = 0; i < getValues().length; i++) {
            let img  = document.querySelector(".dice"+(i+1))
            img.src = getFaceValue(getValues()[i])    
        }
    
    }

    function getFaceValue(value){
            if(value == 1){
                 return 'dice1.png'
                    }else if(value == 2){
                        console.log("dice2.PNG")
                      return 'dice2.png'
                     }else if(value == 3){
                        console.log("dice3.PNG")
                      return 'dice3.png'
                    }else if(value == 4){
                        console.log("dice4.PNG")
                      return 'dice4.png'
                    }else if(value == 5){
                        console.log("dice5.PNG")
                      return 'dice5.png'
                    }else if(value == 6){
                        console.log("dice6.PNG")
                      return 'dice6.png'
                    }
        }
    