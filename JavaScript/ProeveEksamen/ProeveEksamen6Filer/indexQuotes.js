const url = "https://www.tronalddump.io/random/quote";
const url2 = "https://www.tronalddump.io/search/quote?tag="

document.addEventListener('DOMContentLoaded', () => {
    const quotesDiv = document.getElementById('quote');
    const newQuotesButton = document.getElementById('new-quotes-button');

    async function getQuote() {
        const response = await fetch(url);
        if (response.status !== 200)
            throw new Error(response.status);
        return await response.json();
    }
    async function get(){
        const respons = await fetch(url2);
        if(respons.status !== 200)
            throw new Error(respons.status);
        return await respons.json();
    }

    async function fetchQuote() {
        try {
            const quotes = [];
            const promises = getQuote();
            quotes.push(await promises);
            quotesDiv.innerHTML = "";
            quotes.forEach(quote => {
                const quoteDiv = document.createElement('div');
                quoteDiv.className = 'quote';
                quoteDiv.innerHTML = `<p>${quote.value}</p><p><strong>Tag:</strong> ${quote.tags.join(', ')}</p>`;
                quotesDiv.appendChild(quoteDiv);
            });
        } catch (error) {
            quotesDiv.innerHTML = '<div class="error">Der er sket en fejl. Prøv venligst igen senere.</div>';
        }
    }

    newQuotesButton.addEventListener('click', fetchQuote);

    fetchQuote();
});
async function getQuoteByTag(tag){
    try {
        const response = await fetch(url2 + tag);
        const tagQuotes = await
        if (response.status !== 200)
            throw new Error(response.status);
    } catch (error) {
        console.log('Der er sket en fejl. Prøv venligst igen senere.');
    }
}


// En Promise i JavaScript er et objekt, der repræsenterer den fremtidige afslutning (eller fiasko) af en asynkron operation. Promises har tre tilstande:
//
//     Pending: Initial tilstand, hverken fulfilled eller rejected.
//     Fulfilled: Operationen blev afsluttet succesfuldt.
//     Rejected: Operationen fejlede.
//
//     Promises håndteres ved hjælp af .then() for fulfilled tilstand og .catch() for rejected tilstand.
//
//     En funktion markeret med async returnerer altid en Promise, og await bruges til at vente på Promise-objekter.
