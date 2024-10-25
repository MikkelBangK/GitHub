let url ="http://jsonplaceholder.typicode.com/users"


//Hjælpemetode til fetch
async function get(url) {
    const respons = await fetch(url);
    if (respons.status !== 200) // OK
        throw new Error(respons.status);
    return await respons.json();
}

//Metode 1 til at udskrive et fetch
let p = get(url)
p.then(showResultThen)

function showResultThen(result){
    for (let p of result){
        console.log(p.name)
    }
}

//Metode 2 til at udskrive et fetch
async function showResult(){
    let result = await get(url)
    for (let person of result){
        console.log(person.name)
    }
}

showResult()

//Dette viser at fetch metoderne er bagud og denne console.log når at blive udført først.
console.log("slut på programmet")


//Metode uden brug af async

// let p = fetch(url)
// console.log("her er p:" + p)
// p.then(showNumbers)

// function showNumbers(respons){

//     console.log("her er response.status: " + respons.status)
//     let jsonpromise = respons.json()
//     jsonpromise.then(showJson)
    
// }

// function showJson(json){
//    for(let person of json){
//     console.log(person.name)
//    }
// }