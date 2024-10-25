import express from 'express';
import{getValues,throwDice,getThrowCount    } from "./Yatzy.js"
import path from 'path';
import { fileURLToPath } from 'url';
import cors from "cors"
import sessions from 'express-session';
const app = express();
let port = 8000
const __filename = fileURLToPath(import.meta.url);


const __dirname = path.dirname(__filename);
// app.use(express.json());

app.use(express.static(__dirname + '/../Klient'));

app.use(cors())

app.get('/values', (request, response) => {
    let beskeder = getValues()
    response.status(200);
    response.send(beskeder);
});

app.get('/throwcount',(request,response)=>{
    let besked = getThrowCount()
    console.log(getThrowCount())
    response.status(200)
    response.send({ThrowCount:besked})
})

app.put('/throwDice',(request,response)=>{
    console.log("ok")
    throwDice()
    response.sendStatus(200)
})

app.listen(port)
console.log('Lytter på port ' + port + ' ...');