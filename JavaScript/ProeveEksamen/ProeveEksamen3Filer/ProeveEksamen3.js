// Lav en funktion gaetTalISyttenTabel, der returnerer en promise.
//     Denne promise skal efter en tilfældig varighed på mellem 1 og 3 sekunder beregne et tilfældigt tal mellem 0
// og 2000
// Hvis 17 går op i tallet resolves med dette tal, ellers rejectes.
//     Lav en funktion proevTreGange, der kalder gaetTalISyttenTabel tre gange. Hvis en af dem resolves
// returneres dette tal, ellers rejectes.
//     Generaliser funktionen til at tage antal gange som parameter i stedet for at være hardcoded til tre,
//     Redegør for Promise.


function gaetTalISyttenTabel() {
    return new Promise((resolve, reject) => {
        const delay = Math.floor(Math.random() * 2000) + 1000;
        setTimeout(() => {
            const tal = Math.floor(Math.random() * 2000);
        })
    })
}