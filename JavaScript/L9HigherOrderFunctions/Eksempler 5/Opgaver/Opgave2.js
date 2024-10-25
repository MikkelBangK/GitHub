function compareSort(compare){
    return function(list){
        return list.sort(compare)
    }
}
function compareLen(s1, s2){
    if ( s1.length < s2.length){
        return -1;
    } else if (s1.length == s2.length) {
        return 0;
    } else {
        return 1;
    }
}
function compareIgnoreCase(s1, s2){
    let ss1 = s1.toUpperCase();
    let ss2 = s2.toUpperCase();
    if ( ss1 < ss2){
        return -1;
    } else if (ss1 == ss2) {
        return 0;
    } else {
        return 1;
    } 
}

let list = ["Måge", "Slikolaj", "Yung gun", "Benjamin", "Emil", "SpadeSkovlsenMongobongo"]
let lengthSort = compareSort(compareLen)
let ignoreCase = compareSort(compareIgnoreCase)
console.log(lengthSort(list))
console.log(ignoreCase(list))