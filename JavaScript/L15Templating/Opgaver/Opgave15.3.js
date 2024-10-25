import {dirname, join} from 'path';
import {fileURLToPath} from 'url';
import express from 'express';

const port = 8080;
const __dirname = dirname(fileURLToPath(import.meta.url));
let app = express();
app.set('view engine', 'pug');
app.set('view', join(__dirname, '/'));

let url = 'https://randomuser.me/api/?nat=dk&results=100'


async function get(url) {
    const response = await fetch(url);
    if (response.status !== 200) // OK
        throw new Error(response.status);
    return await response.json();
}

async function getUsers(){
    let liste = {persons: await get(url)}
    console.log(await get(url))

    let bruger = await get(url)
    return bruger
}
getUsers().then(result => console.log(result)).catch(error => console.log(error))
app.get('/', (req, response) => response.render('Users3', {brugers: getUsers()}))

app.listen(port, () => console.log('Test running'))