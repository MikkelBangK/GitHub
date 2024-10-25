const chatUrl = 'https://beskedserver.azurewebsites.net/api/Beskeder/';
const chatRumUrl = 'https://beskedserver.azurewebsites.net/api/SoegBeskeder/'
const chatRum = 'https://beskedserver.azurewebsites.net/api/chatRum/'

async function get(url) {
    const response = await fetch(url);
    if (response.status !== 200) // OK
        throw new Error(response.status);
    return await response.json();
}
async function superGet(url) {
    try {
        let response = await get(url);
        for (let i = 0; i<response.length; i++) {
            console.log(response[i].tekst);
        }
    } catch (error) {
        console.log(error);
    }
}

console.log(superGet(chatUrl))
