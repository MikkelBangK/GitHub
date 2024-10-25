package kotlintest

fun main(){
    /*
    Kod funktionen repeatAction() med parametrene times: Int og initial: Int og increment: Int og
    action(), som er en funktion, der tager en Int som parameter og ikke returnerer noget.

    Metoden skal sørge for at action() udføres times gange. Parameteren til action() skal starte
    med værdien af initial og ved hver gentagelse øges med increment.

    Hint: Se på Kotlin funktionen repeat(), men først efter at du har forsøgt selv.
     */
repeatAction(5, 0, 2) { println("Value: $it") }

}

fun repeatAction(times: Int, initial: Int, increment: Int, action: (Int) -> Unit){
    var value = initial
    repeat(times) {
        action(value)
        value += increment
    }
}