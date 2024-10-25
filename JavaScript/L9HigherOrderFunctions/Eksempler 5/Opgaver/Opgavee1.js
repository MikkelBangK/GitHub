let personer = [
    {
        navn: "Slikolaj",
        alder: 27,
        nummer: 12341234,
        id: 0
    },
    {
        navn: "Benjamin",
        alder: 25,
        nummer: 12341233,
        id: 1
    },
    {
        navn: "Emil",
        alder: 32,
        nummer: 42042069,
        id: 2
    },
    {
        navn: "Big måge",
        alder: 69,
        nummer: 42069,
        id: 3
    }
]


console.log(personer.find((element => 
element.nummer == "42069"
    )))


console.log(personer.reduce((acc, element) => element.alder > acc ? acc : element.alder,Infinity))

personer.sort((a, b) => a.navn.localeCompare(b.navn))
let str = ""
personer.forEach(element => str += element.navn += ", ")
console.log(str)


const result = personer.filter(person => person.alder < 30)
.map(person => ({navn: person.navn, nummer: person.nummer}))

result.forEach(person => console.log(person))


