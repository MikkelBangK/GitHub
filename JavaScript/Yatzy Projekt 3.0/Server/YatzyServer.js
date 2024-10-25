//Firebase
import { initializeApp } from "firebase/app";
import { getFirestore, collection, getDocs, doc, deleteDoc, addDoc, getDoc, query, where } from 'firebase/firestore'
import firebase from 'firebase/compat/app';
import 'firebase/compat/firestore';

import express, {request, response} from 'express';
import{getValues,throwDice,getThrowCount,createPlayer    } from "./Yatzy.js"
// import Yatzyyy from "./Yatzy.js"
import path from 'path';
import { fileURLToPath } from 'url';
import cors from "cors"
import sessions from 'express-session';
const app = express();
let port = 8000
const __filename = fileURLToPath(import.meta.url);
// Yatzyyy.getResults

const __dirname = path.dirname(__filename);
app.use(express.json());


const firebaseConfig = {
    apiKey: "AIzaSyAysQWxiY66G075pO3hu881ZlpNDInnxjM",
    authDomain: "yatzy-a24f3.firebaseapp.com",
    projectId: "yatzy-a24f3",
    storageBucket: "yatzy-a24f3.appspot.com",
    messagingSenderId: "313684367824",
    appId: "1:313684367824:web:17516868d1acc782f341d5",
    measurementId: "G-ZK1PYJGMS4"
};

// Initialize Firebase
const app2 = initializeApp(firebaseConfig);
firebase.initializeApp(firebaseConfig)
export const db = getFirestore(app2);
const playerRef = collection(db, "Players")


app.use(sessions({ secret: 'hemmelig', saveUninitialized: true,
 cookie: { maxAge: 1000 * 60 * 20 }, resave: false }));

app.use(express.static(__dirname + '/../Klient'));

//Cors 
// app.use((req, res, next) => {
//     // spørg klaus om det her
//     res.header('Access-Control-Allow-Origin', '*')
//     res.header('Access-Control-Allow-Methods','PUT')
//     res.header('Access-Control-Allow-Headers','content-type')
//     next()
// })


app.use(cors())

// app.post('/opretPlayer',(request,response)=>{
//     console.log("Spiller oprettet: " + request.body.playerName)
//     createPlayer(request.body.playerName)
//     response.sendStatus(200)
// })

app.post('/opret', async (request, response) => {
    const playerName = request.body.playerName;
    if (!playerName) {
        return response.status(400).send('Player name is required');
    }
    console.log("Spiller oprettet: " + playerName);
    try {
        await createPlayer(playerName);
        response.sendStatus(200);
    } catch (error) {
        console.error("Error creating player: ", error);
        response.status(500).send('Failed to create player');
    }
});

app.get('/values/:playerName', (request, response) => {
    console.log("playerName server " + request.params.playerName)
    let beskeder = getValues(request.params.playerName)
    response.status(200);
    response.send(beskeder);
});

app.get('/throwcount/:playerName',(request,response)=>{
    let besked = getThrowCount(request.params.playerName)
    console.log(getThrowCount(request.params.playerName))
    response.status(200)
    response.send({ThrowCount:besked})
})


app.put('/throwDice',(request,response)=>{
    console.log("throwDice " + request.body.playerName)
    throwDice(request.body.playerName)
    response.sendStatus(200)
})

async function fetchFieldValues() {
    try {
        const querySnapshot = await getDocs(playerRef);
        querySnapshot.forEach((doc) => {
            const spillerNavn = doc.data().Navn;
            console.log(spillerNavn);
            return spillerNavn
        });
    } catch (error) {
        console.error("Error fetching documents: ", error);
    }
}

async function getPlayers(){
    let playerCol = collection(db, 'Players');
    let players = await getDocs(playerCol)

    let playerList = players.docs.map(doc => {
        let data = doc.data();
        data.docID = doc.id;
        return data;
    })
    return playerList;
}

// app.get('/players', async (request, response)=> {
//     const players = await getPlayers();
//     response.render('', {spiller: players});
// })

app.get('/players', async (request, response)=> {
    let besked = fetchFieldValues()
    response.status(200)
    response.send(besked)
});




app.listen(port)
console.log('Lytter på port ' + port + ' ...');