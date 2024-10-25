// opgave13.1.js
const earthquakeUrl =  'https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/4.5_week.geojson';
let table = document.getElementById('table')

async function get(url) {
    const response = await fetch(url);
    if (response.status !== 200) // OK
        throw new Error(response.status);
    return await response.json();
}

async function main(earthquakeUrl) {
    try {
        let response = await get(earthquakeUrl);
        console.log(response);
        for (let i = 0;i<response.length;i++) {
            console.log(response);
        }
    } catch (error) {
        console.log(error);
    }
}

let list = get(earthquakeUrl)
    .then(result => getList(result))
    .catch(error => console.log(error))

function getList(result){
    for (Element of result.features){
        if (Element.properties.mag >= 5) {
            table.innerHTML += "<td>" + Element.properties.place + "</td> <td>" + Element.properties.mag + "</td> <td>" + Element.properties.time + "</td>"
        }
    }
}


