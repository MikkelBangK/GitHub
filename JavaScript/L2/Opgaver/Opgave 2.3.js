

function compare(s1, s2){
if ( s1 < s2){
    return -1;
} else if (s1 == s2) {
    return 0;
} else {
    return 1;
}
}
let string1 = "makrel"
let string2 = "laks"
let string3 = "abcd"
console.log(compare(string1, string2))
console.log(compare(string3, string3))
console.log(compare(string2, string1))

function compareLen(s1, s2){
    if ( s1.length < s2.length){
        return -1;
    } else if (s1.length == s2.length) {
        return 0;
    } else {
        return 1;
    }
}
console.log(compareLen(string1, string2))
console.log(compareLen(string3, string3))
console.log(compareLen(string2, string1))

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
let string11 = "MAKREL"
let string22 = "LAKS"
let string33 = "mågeofhav"
let string333 = "MÅGEofHAV"

console.log(compareIgnoreCase(string11, string22))
console.log(compareIgnoreCase(string33, string333))
console.log(compareIgnoreCase(string11, string333))

