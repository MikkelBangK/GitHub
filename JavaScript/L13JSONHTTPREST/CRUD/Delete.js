//DELETE

const fetch = require('node-fetch');
let url = 'https://jsonplaceholder.typicode.com/posts/11';
fetch(url, {
    method: "DELETE",
})
    .then(response => {
        if (response.status >= 400)
            throw new Error(response.status);
        else
            return response.json();
    })
    .then(resultat => console.log(`Resultat: %o`, resultat))
    .catch(fejl => console.log('Fejl: ' + fejl));