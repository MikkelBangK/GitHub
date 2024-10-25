//url jeg anvender til at hente quotes
const queut1Url = 'https://www.tronalddump.io/random/quote';

// get hjælpemetode
async function get(url) {
    const respons = await fetch(url);
    if (respons.status !== 200) // OK
        throw new Error(respons.status);
    return await respons.json();
}

//function til at hente og genere mine tre quotes
async function main(url) {
    let quotes = []
    try {
        let quote1 = await get(url);
        let quote2 = await get(url);
        let quote3 = await get(url);
        quotes.push(quote1)
        quotes.push(quote2)
        quotes.push(quote3)
        var result = await Promise.all(quotes)
        console.log(result)
        return result
    } catch (fejl) {
        console.log(fejl);
    }
}

let body = document.body;
let tabel = "";

//Metode til at vise mine tre quotes og tilføjer alt html til min body
async function run() {
    tabel = "<table style='border-collapse: collapse;'><tr style='border: 2px solid blue;'><th>Quotes</th><th>Tags</th></tr>";
    quotes = await main(queut1Url);
    console.log(quotes)
    for (let i = 0; i < quotes.length; i++) {
        tabel += '<tr><td style="border: 2px solid blue;">' +
        quotes[i].value + '</td>' + '<td style="border: 2px solid blue;">' + quotes[i].tags +
        '</td></tr>'
    }
    tabel += '</table><button id =knap onclick="run()">Få tre nye</buttom>';
    body.innerHTML = tabel
}

//Metoden bliver kaldt en gang ved start.
run();