import express from 'express';
import path from 'path';
import { fileURLToPath } from 'url';

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

const app = express();
const port = 3000;

let varer = {Vare: [{varenavn: "bord", antal: 3}]}

function tilfoejVare() {
    try {
        let varenavn = document.querySelector("varenavn").value
        let antal = document.querySelector("antal").value
        table.innerHTML = table.innerHTML + "<tr><td>varenavn</td></tr>"
    } catch (e){

    }
}

app.listen(port)
console.log('lytter på port 8080 ...')