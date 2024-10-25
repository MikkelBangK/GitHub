function clock(){
    let date = new Date();
    let clock = document.querySelector("#clock");
    clock.innerHTML = date.getTime() - dateNow.getTime();
}

let clockId = null;
function start() {
    if(clockId == null){
        dateNow = new Date();
        clockId = setInterval(clock, 1);
        clock();
    }
}

function stop() {
    clearInterval(clockId);
    clockId = null;
}