async function post(url, objekt) {
    const respons = await fetch(url, {
        method: "POST",
        body: JSON.stringify(objekt),
        headers: {
            'Content-Type': 'application/json'
        }
    });
    if (respons.status !== 200) // Created
        throw new Error(respons.status);
    return await respons.text();
}

let clickfunction = async (navn, tlf) => {
    try {
        await post("/tilfoej", { navn, tlf });
        window.location.href = "/index";
    } catch (e) {
        console.log(e);
    }
}

function addKontakt() {
    // Hent værdierne fra tekstfelterne
    const navn = document.getElementById('navn').value;
    const tlf = document.getElementById('tlf').value;

    // Kald den nødvendige funktion med disse værdier
    clickfunction(navn, tlf);

    // Ryd tekstfelterne efter tilføjelse
    document.getElementById('navn').value = '';
    document.getElementById('tlf').value = '';
}

let updateKontakt = async (navn, tlf) => {
    const nytTlf = prompt("Indtast nyt telefonnummer for " + navn, tlf);
    if (nytTlf) {
        try {
            await post("/opdater", { navn, tlf: nytTlf });
            window.location.href = "/index";
        } catch (e) {
            console.log(e);
        }
    }
}

