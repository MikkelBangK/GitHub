// app.js
import express from 'express';
const app = express();
import sessions from 'express-session';
import pug from 'pug';
import path from 'path';
import { fileURLToPath } from 'url';
import session from 'express-session';

const __filename = fileURLToPath(import.meta.url);

const __dirname = path.dirname(__filename);
app.set('view engine', 'pug');
app.set("views", __dirname + "/views");

app.use(sessions({ secret: 'hemmelig', saveUninitialized: true, cookie: { maxAge: 1000 * 60 * 20 }, resave: false }));
app.use(express.static(__dirname));
app.use(express.json());

//første bud, uden session
// let tilføjetPersoner = []
app.post('/tilfoej', (request, response) => {
    const { navn,adresse } = request.body;
    personer.push({navn,adresse})
    console.log(navn,adresse)
    response.render('index', {personer});
    // response.status(200).send("Succes");
});

let personer = 
[{ navn: "Nikolaj",adresse: "Jensensvej 30"},
{ navn: "Mikkel",adresse: "Larsensvej 20"},
{navn: "Emil",adresse: "Færgegården 19"}];

app.get('/index', (request, response) => {
    let tekster = request.session.tekster
    if (tekster == undefined) {
        tekster=[]
    }
    response.render('index', {personer});
});

app.listen(8000);

console.log('Lytter på port 8000 ...');