import express from 'express';
import path from 'path';
import { fileURLToPath } from 'url';
import session from 'express-session';

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

const app = express();
const port = 3000;

app.set('view engine', 'pug');
app.set("views", path.join(__dirname, "views"));
app.use(session({ secret: 'hemmelig', saveUninitialized: true, cookie: { maxAge: 1000 * 60 * 20 }, resave: false }));
app.use(express.urlencoded({ extended: true }));

let kontakter =
    [{navn: 'Slikolaj', telefonnummer: '12345678'},
     {navn: 'Banjomin', telefonnummer: '87654321'},
        {navn: 'Emil', telefonnummer: '12348765'}];


app.get('/', (req, res) => {
    res.render('index', { kontakter });
});

app.post('/add', (req, res) => {
    const { navn, telefonnummer } = req.body;
    if (navn && telefonnummer) {
        kontakter.push({ navn, telefonnummer });
    }
    res.redirect('/');
});

app.put('/add', (req, res) => {
    const { navn, telefonnummer } = req.body;
    const kontakt = kontakter.find(kontakt => kontakt.navn === navn)
    if (kontakt) {
        kontakter.telefonnummer = telefonnummer;
    }
    res.redirect('/');
});

app.listen(port, () => {
    console.log('Lytter på port ' + port);
});

async function post(url, objekt) {
    const respons = await fetch(url, {
        method: "POST",
        body: JSON.stringify(objekt),
        headers: {
            'Content-Type': 'application/json'
        }
    });
    if (respons.status !== 201) // Created
        throw new Error(respons.status);
    return await respons.text();
}


let clickfunction = async (id) => {
    try {
        await post("http://localhost:3000", { id });
        window.location.href = "http://localhost:3000/add";
    } catch (e) {
        console.log("Fejl");
    }
}

async function get(url) {
    const respons = await fetch(url);
    if (respons.status !== 200) // OK
        throw new Error(respons.status);
    return await respons.json();
}
async function changeNumber() {
    let id = document.getElementById("id").value;
    let telefonnummer = document.getElementById("telefonnummer").value;
    try {
        await post("http://localhost:3000/tilføj", { id, telefonnummer });
    } catch (e) {
        console.log("Fejl");
    }
}