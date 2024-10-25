import { dirname } from 'path';
import { fileURLToPath } from 'url';

const port = 8080;

const __dirname = dirname(fileURLToPath(import.meta.url));

import express from 'express';
let app = express();

import { join } from 'path';

app.set('view engine', 'pug');
app.set('view', join(__dirname, '/'));

let users = {persons: [{name: 'Måge', alder: 28}, {name: 'Laks', alder: 29}, {name: 'fisk', alder: 30}]}
let user = {username: 'yungmåge', nemesis: 'pigeon', alder: 29}


app.get('/', (req, response) => response.render('Users2', users))


app.listen(port);

console.log('Lytter på port: ' + port);