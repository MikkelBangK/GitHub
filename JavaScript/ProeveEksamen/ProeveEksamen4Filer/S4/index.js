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

let clickfunction = async (navn,adresse) => {
    alert("click " + navn + " " + adresse)
        try {
            await post("http://localhost:8000/tilfoej", { navn,adresse });
            window.location.href = "http://localhost:8000/index";
        } catch (e) {
            console.log(e);
        }
    }

    function addPerson() {
        // Hent værdierne fra tekstfelterne
        const navn = document.getElementById('navn').value;
        const adresse = document.getElementById('adresse').value;
      
        // Kald den nødvendige funktion med disse værdier
        clickfunction(navn, adresse);
      
        // Ryd tekstfelterne efter tilføjelse
        document.getElementById('navn').value = '';
        document.getElementById('adresse').value = '';
      }
