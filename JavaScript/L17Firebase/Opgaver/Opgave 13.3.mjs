import express from 'express';
const app = express();

const port = 8000;
let beskeder = [{ afsender: "Ole", tekst: "Min første besked", chatrum: "rum1", nummer: "1" }, { afsender: "Ib", tekst: "Hallo, er der nogen?", chatrum: "rum2", nummer: "2" }];
let chatRum = [{ navn: "rum1" }, { navn: "rum2" }];

// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
import { getFirestore, collection, getDocs, doc, deleteDoc, addDoc, getDoc, query, where } from 'firebase/firestore'

// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
    apiKey: "AIzaSyCgzFgSvW1yaJ5v4WeKcBFCoG5sZkrX9EQ",
    authDomain: "chat-5fb0c.firebaseapp.com",
    projectId: "chat-5fb0c",
    storageBucket: "chat-5fb0c.appspot.com",
    messagingSenderId: "767805589586",
    appId: "1:767805589586:web:fea8c05334867f1b94378b",
    measurementId: "G-S5QDW1XJPB"
};

// Initialize Firebase
const appFirestore = initializeApp(firebaseConfig);
const db = getFirestore(appFirestore);


//Tillad cors requests
app.use(function (req, res, next) {
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
    next();
});
app.use(express.json());

// app.get('/beskeder', async (request, response) => {
//     const beskeder = await getBeskeder();
//     response.render('index', {besked: beskeder});
// })
//
// app.get('/chatrum', async (request, response) => {
//     const chatrum = await getChatrum();
//     response.render('index', {rum: chatrum});
// })

app.get('/beskeder', async (request, response) => {
    let beskeder = await getBeskeder();
    response.status(200);
    response.send(beskeder);
});

app.get('/chatrum', async (request, response) => {
    let chatrum = await getChatrum();
    response.status(200);
    response.send(chatrum);
});

app.post('/beskeder', (request, response) => {
    console.log(request.body);
    //løkke, der finder største id i beskeder
    // sæt størsteid + 1 på besked
    beskeder.push(request.body);
    response.status(201);
    response.send("Added");
});

async function addBesked(besked) {
    addDoc(collection(db, 'Chatrum'), besked);
}

async function getBeskeder() {
    let beskedCol = collection(db, 'beskeder');
    let beskeder = await getDocs(beskedCol);

    let beskedListe = beskeder.docs.map(doc => {
        let data = doc.data();
        data.docID = doc.id;
        return data;
    })
    return beskedListe;
}

async function getChatrum() {
    let chatrumCol = collection(db, 'chatrum');
    let chatrum = await getDocs(chatrumCol);

    let chatrumListe = chatrum.docs.map(doc => {
        let data = doc.data();
        data.docID = doc.id;
        return data;
    })
    return chatrumListe;
}


app.listen(port);

console.log('Lytter på port ' + port + ' ...');