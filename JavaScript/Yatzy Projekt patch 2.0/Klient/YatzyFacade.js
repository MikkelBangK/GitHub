
const url1 ="http://localhost:8000/values"
const url2 ="http://localhost:8000/throwDice"
const url3 ="http://localhost:8000/throwcount"

//Hjælpe funktioner
async function get(url) { // dette er hjælpe funktionen
    const respons = await fetch(url);
    if (respons.status !== 200) // OK
         throw new Error(respons.status);
    return await respons.json();     }

    


    async function put(url, objekt) {
        const respons = await fetch(url, {
            method: "PUT",
            body: JSON.stringify(objekt),
            headers: { 'Content-Type': 'application/json' }

        });
        console.log(respons)
        if (respons.status !== 200) // OK muligvis forkert med 200 afhængig af hvad server sender tilbage
            throw new Error(respons.status);
        return await respons.json();
    }






export async function getValues() {
    try {
        let respons = await get(url1); //kalder hjælpe funktion et promise
        console.log(respons +" HEJ")
        return respons
    }

    catch (fejl) {
        console.log(fejl);
    }
}



export async function getThrowCount(){
    try {
        let respons = await get(url3); //kalder hjælpe funktion et promise
        console.log(respons +" HEJ2")
        return respons.ThrowCount
    }

    catch (fejl) {
        console.log(fejl);
    }
    
}
export async function throwDice() {
    try {
        let respons = await put(url2);
        console.log(respons);
        return respons;
    } catch (fejl) {
        console.log(fejl);
    }
}


        

    
        
          
        
      
 