import express from 'express';
import path from 'path';
import { fileURLToPath } from 'url';
import session from 'express-session';
import pug from 'pug';

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

const app = express();

let produkter = {Produkt:[{produkt: "T-rex", pris: 2500},{produkt: "Raptor", pris: 500}, {produkt: "Nuclear warhead", pris: 1000000}, {produkt: "Havmåge", pris: 100},
    {produkt: "Duedreng", pris: 500000}, {produkt:"Slikolaj", pris: 0}, {produkt:"Cheeseburger", pris: 15}, {produkt: "1759 katte", pris: 25000}]}

app.set('view engine', 'pug');
app.set("views", path.join(__dirname, "view"));

app.use(session({ secret: 'hemmelig', saveUninitialized: true, cookie: { maxAge: 1000 * 60 * 20 }, resave: false }));
app.use(express.static(path.join(__dirname, 'files')));
app.use(express.json());

app.get('/shop', (request, response) => {
    let tekster = request.session.tekster || [];
    let valuesForTemplate = { produkter : produkter };
    response.render('shopPug', produkter);
});

app.post('/koeb', (request, response) => {
    const { id }  = request.body;
    let kurv = request.session.kurv || [];
    request.session.kurv = request.session.kurv || [];
    response.render('shopPug', { kurv: kurv });
    if (kurv == undefined) {
        kurv = []
    }
    kurv.push(id);
    request.session.kurv = kurv;
    response.send('Produktet er tilføjet til kurven');
});

app.listen(8000, () => {
    console.log('Listening on port 8000...');
});
