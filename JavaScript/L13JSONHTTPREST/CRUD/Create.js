//POST

const fetch = require('node-fetch');
let url = 'https://jsonplaceholder.typicode.com/posts';
let data = { userId: 111, id: 101, title: 'titel', body: 'tekst' };
fetch(url, {
    method: "POST",
    body: JSON.stringify(data),
    headers: { 'Content-Type': 'application/json' }
})
    .then(response => {
        if (response.status >= 400)
            throw new Error(response.status);
        else
            return response.json();
    })
    .then(resultat => console.log(`Resultat: %o`, resultat))
    .catch(fejl => console.log('Fejl: ' + fejl));