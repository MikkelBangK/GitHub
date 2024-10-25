







async function getUsers(nat, result){
    if (result >= 10 && result <= 100){}
    let url = 'https://randomuser.me/api/?nat=' + nat + "&results=" + result
    let liste = {persons: await get(url)}
    console.log(await get(url))

    let bruger = await get(url)
    return bruger
}