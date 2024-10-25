import express from 'express';
import { getValues, throwDice, getThrowCount } from "./Yatzy.js"
import path from 'path';
import { fileURLToPath } from 'url';
import cors from "cors"
import sessions from 'express-session';
import { renderFile } from 'pug';
import { join } from 'path';

const app = express();
let port = 8000
const __filename = fileURLToPath(import.meta.url);


const __dirname = path.dirname(__filename);

app.use(express.static(__dirname + '/../Klient'));

app.set('view engine', 'pug');
app.set('views', join(__dirname, '/views'));

app.use(cors())

function createPlayer(playerName) {
    return {
        playerName: playerName,
        playerState: {
            values: [0, 0, 0, 0, 0],
            holdStatus: [false, false, false, false, false],
            throwCount: 0
        },
        resultList: {
            sameValue1: { value: 0, valgt: false },
            sameValue2: { value: 0, valgt: false },
            sameValue3: { value: 0, valgt: false },
            sameValue4: { value: 0, valgt: false },
            sameValue5: { value: 0, valgt: false },
            sameValue6: { value: 0, valgt: false },
            onePair: { value: 0, valgt: false },
            twoPair: { value: 0, valgt: false },
            threeSame: { value: 0, valgt: false },
            fourSame: { value: 0, valgt: false },
            fullHouse: { value: 0, valgt: false },
            smallStraight: { value: 0, valgt: false },
            largeStraight: { value: 0, valgt: false },
            chance: { value: 0, valgt: false },
            yatzy: { value: 0, valgt: false }
        }
    };
}

function createGame(gameName, status, playerNames) {
    const spillere = {};
    playerNames.forEach((name, index) => {
        spillere[`player${index + 1}`] = createPlayer(name);
    });
    return {
        game: gameName,
        status: status,
        spillere: spillere
    };
}

function getRandomStatus() {
    const statuses = ["WAITING", "STARTED"];
    return statuses[Math.floor(Math.random() * statuses.length)];
}

function createGames(numGames, playersPerGame) {
    const rooms = {};
    for (let i = 1; i <= numGames; i++) {
        const playerNames = [];
        for (let j = 1; j <= playersPerGame; j++) {
            playerNames.push(`Player${j}`);
        }
        const status = getRandomStatus();
        rooms[`spil${i}`] = createGame(`Spil ${i}`, status, playerNames);
    }
    return { rooms: rooms };
}

// Usage example
let valuesForTemplate = createGames(100, 3);
console.log(valuesForTemplate);


app.get('/', (req, response) => response.render('startYatzy', valuesForTemplate))

app.get('/values', (request, response) => {
    let beskeder = getValues()
    response.status(200);
    response.send(beskeder);
});

app.get('/throwcount', (request, response) => {
    let besked = getThrowCount()
    response.status(200)
    response.send({ throwCount: besked })
})

app.put('/throwDice', (request, response) => {
    console.log("ok")
    throwDice()
    response.sendStatus(200)
})

app.listen(port)
console.log('Lytter på port ' + port + ' ...');