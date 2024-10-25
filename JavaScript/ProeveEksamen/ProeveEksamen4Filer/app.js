import express from 'express';
import path from 'path';
import { fileURLToPath } from 'url';
import session from 'express-session';
import pug from 'pug';

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

const app = express();
const port = 3000

app.set('view engine', 'pug');
app.set("views", path.join(__dirname, "views"));



app.get('/', (req, res) => {
    res.render('index', { personer });
});
let personer = [];

app.post('/tilføj', (req, res) => {
    const { navn, adresse } = req.body;
    if (navn && adresse) {
        personer.push({ navn, adresse });
    }
    res.redirect('/');
});

app.listen(port, () => {
    console.log('Listening on' + port);
});