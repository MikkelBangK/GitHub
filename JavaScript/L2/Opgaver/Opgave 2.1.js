// Programmer nedenstående funktioner, hvor array indeholder nogle tal:
// max(array): returnerer det største element i arrayet.
// contains(array, element): returnerer true hvis elementet findes i arrayet, ellers false
// sum(array): returnerer summen af elementerne i arrayet.
arr = [1, 2, 3, 4, 5, 1, 19, 19, 12, 200]
function max() {
    let current = 0
    for (let b of arr){
        if (current < b){
            current = b
        }
    }
    return current
}
console.log(max(arr))

function contains(a) { 
    for (let b of arr){
        if ( b == a){
            return true;
        } else {
            return false;
        }
    }
}
console.log(contains(15))
console.log(contains(200))

function sum(a){
    total = 0;
    for (let b of arr){
        total += b
    }
    return total;
}
console.log(sum(arr))