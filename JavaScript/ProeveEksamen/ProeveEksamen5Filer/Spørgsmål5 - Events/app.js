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

app.use(sessions({ secret: 'hemmelig', 
                   saveUninitialized: true, 
                   cookie: { maxAge: 1000 * 60 * 20 }, 
                   resave: false }));

app.use(express.static(__dirname));
app.use(express.json());

// Alt ovenover er boilerplate kode

app.post('/tilfoej', (request, response) => {
    const { navn,tlf } = request.body;
    kontakter.push({navn,tlf})
    console.log(navn,tlf)
    response.render('index', {kontakter});
});

app.post('/opdater', (req, res) => {
    const { navn, tlf } = req.body;
    const kontakt = kontakter.find(k => k.navn === navn);
    if (kontakt) {
        kontakt.tlf = tlf;
    }
    res.render('index', { kontakter });
});

let kontakter =
[{ navn: "Mark",tlf: "12345678"},
{ navn: "Mikkel",tlf: "87654321"},
{navn: "Patrick",tlf: "87654321"}];

app.get('/index', (request, response) => {
    let tekster = request.session.tekster
    if (tekster == undefined) {
        tekster=[]
    }
    response.render('index', {kontakter});
});

app.listen(3000);

console.log('Lytter på port 3000 ...');