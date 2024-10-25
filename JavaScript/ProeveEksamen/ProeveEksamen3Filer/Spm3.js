function gaetTalISyttenTabel(nr){
    return new Promise(function (resolve, reject) {
        const delay = Math.floor(Math.random() * 3000) + 1000;
        setTimeout(() => {
            let tal = Math.trunc(Math.random() * 2001);
            if (tal % 17 === 0) resolve(`${nr} OK!. Tallet ${tal} går op i 17!`);
            else reject(`${nr} Ikke OK. Tallet ${tal} går ikke op i 17!`);
        }, delay);    
        console.log('Delay: ' + delay/1000 + ' sekunder')
    });
}

//gaetTalISyttenTabel(1)
  //      .then(resultat => console.log('Resultat: ' + resultat))
    //    .catch(fejl => console.log('Fejl/exception: ' + fejl));


function proevNGange(antalForsøg) {
    let arr = []
    for(let i = 0; i<antalForsøg; i++)
    {
        arr.push(gaetTalISyttenTabel(i))
    }
    return Promise.any(arr);
}
    
        
proevNGange(100)
    .then(resultat => console.log('Resultat: ' + resultat))
    .catch(fejl => console.log('Fejl/exception: ' + fejl));
    
    console.log('gaetTalISyttenTabel');
    