async function post(url, objekt) {
    const respons = await fetch(url, {
        method: "POST",
        body: JSON.stringify(objekt),
        headers: {
            'Content-Type': 'application/json'
        }
    });
    if (respons.status !== 201) // Created
        throw new Error(respons.status);
    return await respons.text();
}


let clickfunction = async (id) => {
    try {
        await post("http://localhost:3000", { id });
        window.location.href = "http://localhost:3000/tilføj";
    } catch (e) {
        console.log("Fejl");
    }
}