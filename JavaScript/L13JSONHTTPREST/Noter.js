//JSON

//JSON.parse(JSON) returnerer et JavaScript objekt svarende til JSON
//tekststrengen
//JSON.stringify(objekt) serialiserer et JavaScript objekt til en JSON
//tekststreng


let json = '{"x":1,"a":[true, null, "test"]}';
let objekt = JSON.parse(json);
console.log('%o', objekt);
// => { x: 1, a: [ true, null, 'test', [length]: 3 ] }
objekt = {x: 1, m: function(){}, a: [true, undefined, 'test']};
json = JSON.stringify(objekt);
console.log(json); // => {"x":1,"a":[true,null,"test"]}

