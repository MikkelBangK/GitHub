const url = "https://www.tronalddump.io/random/quote";

document.addEventListener('DOMContentLoaded', () => {
    const quotesDiv = document.getElementById('quotes');
    const newQuotesButton = document.getElementById('new-quotes-button');

    async function getQuote() {
        const response = await fetch(url);
        if (response.status !== 200)
            throw new Error(response.status);
        return await response.json();
    }

    async function fetchThreeQuotes() {
        try {
            const promises = [getQuote(), getQuote(), getQuote()];
            const quotes = await Promise.all(promises);
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

    newQuotesButton.addEventListener('click', fetchThreeQuotes);

    fetchThreeQuotes();
});


// En Promise i JavaScript er et objekt, der repræsenterer den fremtidige afslutning (eller fiasko) af en asynkron operation. Promises har tre tilstande:
//
//     Pending: Initial tilstand, hverken fulfilled eller rejected.
//     Fulfilled: Operationen blev afsluttet succesfuldt.
//     Rejected: Operationen fejlede.
//
//     Promises håndteres ved hjælp af .then() for fulfilled tilstand og .catch() for rejected tilstand.
//
//     En funktion markeret med async returnerer altid en Promise, og await bruges til at vente på Promise-objekter.
