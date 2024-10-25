function compareSort(compare){
    let sort = function(list){
    if(list.length === 0) throw Error('No data');
    let type = typeof list[0];
    if (type !== 'number' && type !== 'string') throw Error ('Wrong type');
    if (!list.every( e => typeof e === type)) throw Error ('Not same type');
    if (type === 'number')
    return list.reduce((a, e) => a>e?a:e);
    else // type == 'String'
     return list.sort(compare)
    }
        return sort
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
let idiotliste = ["Måge", "1234", 12]
let lengthSort = compareSort(compareLen)
let ignoreCase = compareSort(compareIgnoreCase)
console.log(lengthSort(list))
console.log(ignoreCase(list))

//test
console.log(lengthSort(idiotliste))
console.log(ignoreCase(idiotliste))