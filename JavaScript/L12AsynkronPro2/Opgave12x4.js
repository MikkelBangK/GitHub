async function get(url) {
    const response = await fetch(url);
    if (response.status !== 200) // OK
        throw new Error(response.status);
    return response.text();
}

const url = 'https://www.random.org/integers/?num=1&min=1&max=6&col=1&base=10&format=plain&rnd=new';
function getNumber(){
    return get('https://www.random.org/integers/?num=1&min=1&max=6&col=1&base=10&format=plain&rnd=new');
}

function getNumbers() {
    return new Promise(async function(resolve, reject){
        let result = await fetch(url);
        let text = await result.text();
        let numbers = text.split('\n')[0];
        if (numbers === 10) {
            reject(new Error("10 is not allowed"));
        } else if (result < 7) {
            resolve(result);
        } else {
            reject(result);
        }
    });
}

function printNumbers(numbers){
    console.log(numbers);
}

function printError(error){
    console.error(error);
}

let promises = [getNumber(), getNumber(), getNumber(), getNumber()];
Promise.all(promises).then(printNumbers).catch(printError);

Promise.allSettled(promises)
    .then(showAllSettled)
    .catch(showError => console.error('Promise.allSettled failed: ' + showError));

function showAllSettled(results){
    console.log('Promise.allSettled results: ')
    for (let element of results){
        if (element.status === 'rejected'){
            console.log('Rejected: ' + element.reason);
        } else {
            console.log(element.value)
        }
    }
}