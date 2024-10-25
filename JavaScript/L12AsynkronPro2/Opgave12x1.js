function clock(){
    let date = new Date();
    let clock = document.querySelector("#clock");
    clock.innerHTML = date.toLocaleTimeString();
}

let clockId = null;
function start() {
    if(clockId == null){
        clockId = setInterval(clock, 1000);
        clock();
    }
}

function stop() {
    clearInterval(clockId);
    clockId = null;
}