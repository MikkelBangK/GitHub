// expressServer.js
const express = require('express');
const app = express();
const port = 8080

function genererLinks(filnavne) {
    let file = '';
    for (let filnavn of filnavne) {
        file += '<a href="' + filnavn + '">' + filnavn + '</a><br>\n';
    }
    return file;
}

app.all('/', (request, response) => {
    let array = [request.method, request.url];
    response.send(array);
});

app.get('/fil/:navn', (request, response) => {
    let array = [request.method, request.url, request.params.navn];
    response.send(array);
});

app.listen(port);

console.log('Lytter på port: ' + port);