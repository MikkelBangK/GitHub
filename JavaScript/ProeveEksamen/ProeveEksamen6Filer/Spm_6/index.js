// index.js
let link = "https://www.tronalddump.io/random/quote";
let linkTag = "https://www.tronalddump.io/search/quote?tag=";
let divResult = document.getElementById("result");
let quoteKnap = document.getElementById("nyeQuotes");

async function get(url) {
    const respons = await fetch(url);
    if (!respons.ok) // Check for response.ok instead of status code
        throw new Error(`HTTP error! status: ${respons.status}`);
    return await respons.json();
}

async function post(url, objekt) {
    const respons = await fetch(url, {
        method: "POST",
        body: JSON.stringify(objekt),
        headers: { 'Content-Type': 'application/json' }
    });
    if (respons.status !== 201) // Created
        throw new Error(`HTTP error! status: ${respons.status}`);
    return await respons.text();
}

async function lavIndhold() {
    try {
        const quote = await get(link);
        divResult.innerHTML += `<p onclick='lavIndholdTag("${quote.tags.join(',')}")'>${quote.value} Tags: ${quote.tags.join(', ')}</p>`;
    } catch (fejl) {
        divResult.innerHTML += `<p>Der opstod en fejl: ${fejl.message}</p>`;
    }
}

async function lavIndholdTag(tag) {
    try {
        const quotes = await get(linkTag + tag);
        quotes._embedded.quotes.forEach(e => {
            divResult.innerHTML += `<p onclick='lavIndholdTag("${e.tags.join(',')}")'>${e.value} Tags: ${e.tags.join(", ")}</p>`;
        });
    } catch (fejl) {
        divResult.innerHTML += `<p>Der opstod en fejl: ${fejl.message}</p>`;
    }
}

lavIndhold();

quoteKnap.addEventListener('click', lavIndhold);
