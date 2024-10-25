//FETCH

const fetch = require('node-fetch');
let url = 'https://jsonplaceholder.typicode.com/posts';
fetch(url)
    .then(response => {
        if (response.status >= 400)
            throw new Error(response.status);
        else
            return response.json();
    })
    .then(resultat => console.log(`Resultat: %o`, resultat))
    .catch(fejl => console.log('Fejl: ' + fejl));



//Get async

const fetch = require('node-fetch');
let url = 'https://jsonplaceholder.typicode.com/posts';
async function main() {
    try {
        let resultat = await fetch(url)
            .then(response => {
                if (response.status >= 400)
                    throw new Error(response.status);
                else
                    return response.json();
            });
        console.log(`Resultat: %o`, resultat);
    } catch (fejl) {
        console.log('Fejl: ' + fejl);
    }
}
main();