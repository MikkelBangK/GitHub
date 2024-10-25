const express = require('express');
const {json} = require("express");
const app = express();
const port = 8080
let beskeder = [{id: "1", besked: "yeehaw", rum: "rum1"}, {id: "2", besked: "nyan", rum: "rum2"}]
"use strict"

app.get('/beskeder', (request, response) => {
    response.status(200)
    let array = [request.method, request.url];
    response.send(beskeder);
});

app.get('/beskeder/:rum', (request, response) => {
    response.status(200)
    let list = [];
    for (let besked of beskeder){
        console.log(besked)
        if (besked.rum === request.params.rum){
            list.push(besked)
        }
    }
    response.send(list)
});

app.get('/rum', (request, response) => {
    let rumList = [];
    for (let rum of beskeder) {
        console.log(rum)
        for (let i = 0; i < beskeder.length; i++) {
            if (rumList.length > 0){
                if (!rumList.includes(beskeder[i].rum)){
                    rumList.push(beskeder[i].rum);
                }
            } else {
                rumList.push(beskeder[i].rum)
            }
        }
    }
    response.send(rumList)
});


app.post('/beskeder', (request, response) => {
    response.status(201).send(request.body); // Created
    console.log(request.body.navn);
});


app.listen(port);

console.log('Lytter på port: ' + port);