// opgave11.1.js
const userUrl = 'https://jsonplaceholder.typicode.com/users';
// const userUrl = 'https://jsonplaceholder.typicode.com/users/10';
// const userUrl = 'https://jsonplaceholder.typicode.com/users';

async function get(url) {
    const respons = await fetch(url);
    if (respons.status !== 200) // OK
        throw new Error(respons.status);
    return await respons.json();
}

/* uden async */
function showResultThen(result){
    for (let p of result){
        console.log(p.name)
    }
}

let p = get(userUrl)
p.then(showResultThen)

/* med async */
async function showResult(){
    let result = await get(userUrl)
    for (let person of result){
        console.log(person.name)
    }
}

showResult()
