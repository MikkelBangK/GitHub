
function getNumber(){
    return Math.floor(Math.random() * 11);
}

function getNumbers() {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            // Assuming `getNumber()` is a defined function, otherwise, replace it with your desired logic.
            let result = getNumber();

            if (result === 10) {
                reject(new Error("10 is not allowed"));
            } else if (result < 7) {
                resolve(result);
            } else {
                reject(result);
            }
        }, 0);
    });
}

function printNumbers(numbers){
    console.log(numbers);
}

function printError(error){
    console.error(error);
}

Promise.all([getNumbers(), getNumbers(), getNumbers(), getNumbers()]).then(printNumbers).catch(printError);
let promises = [getNumbers(), getNumbers(), getNumbers(), getNumbers()];
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