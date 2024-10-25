package kotlintest

fun main() {
    //Opgave 1.1
    /* Skriv 3 udgaver af en funktion, som returnerer summen af tallene 1..n : en iterativ funktion,
       en almindelig rekursiv funktion og en tail rekursiv funktion. */
    println("Opgave1.1:")
    println(sumIterativ(5))
    println(sumRekursiv(5))
    println(sumTail(5))
    println("")
    //---------------------------------------------------------
    //Opgave 1.2
    /*Skriv 3 udgaver af fakultet-funktionen (fak(n) = n!): en iterativ funktion, en almindelig
      rekursiv funktion og en tail rekursiv funktion.*/
    println("Opgave 1.2")
    println(fakIterativ(5))
    println(fakRekursiv(5))
    println(fakTail(5))
    println("")
    //---------------------------------------------------------
    //Opgave 1.3
    /*Skriv 3 udgaver af fibonacci-funktionen (fib(n) = fib(n-1)+fib(n-2)): en iterativ funktion, en
      almindelig rekursiv funktion og en tail rekursiv funktion.*/
    println("Opgave 1.3")
    println(fibonacciIterativ(9))
    println(fibonacciRec(9))
    println(fibonacciTail(9))
    println("\n")
    //---------------------------------------------------------
    //Opgave 1.4
    /*Skriv en iterativ og en tail rekursiv metode, der returnerer, om elementerne i en liste er
      stigende.*/
    println("Opgave 1.4")
    val numbers = listOf(1, 2, 3, 4, 5, 6)
    val numbers1 = listOf(6, 5, 4, 3, 2, 1)
    println("\n")
    //---------------------------------------------------------
}
fun sumIterativ(n: Int): Int {
    var sum = 0
    for (i in 0..n) {
        sum += i
    }
    return sum
}
fun sumRekursiv(n: Int): Int {
    var sum = 0
    if (n > 0) {
        sum = n + sumRekursiv(n - 1)
    }
    return sum
}
fun sumTail(n: Int): Int {
    return sumTailRec( n, 0)
}

tailrec fun sumTailRec(n: Int, acc: Int): Int {
    return if (n == 0) {
        acc
    } else {
        sumTailRec(n - 1, acc + n)
    }
}
fun fakIterativ(n: Int): Int {
    var sum = 1
    for (i in 1..n) {
        sum *= i
    }
    return sum
}
fun fakRekursiv(n: Int): Int {
    var sum = 1
    if (n > 0) {
        sum = n * fakRekursiv(n - 1)
    }
    return sum
}
fun fakTail(n: Int): Int {
    return fakRekursivTail(n, 1)
}
tailrec fun fakRekursivTail(n: Int, acc: Int): Int {
    return if(n == 0) {
        acc;
    } else {
        fakRekursivTail(n - 1, acc * n)
    }
}
fun fibonacciIterativ(n: Int): Int {
    var a = 0
    var b = 1
    var c = 0
    for (i in 2..n) {
        c = a + b
        a = b
        b = c
    }
    return c
}
fun fibonacciRec(n: Int): Int {
    return if (n == 0) {
        0
    } else if (n == 1) {
        1
    } else {
        fibonacciRec(n - 1) + fibonacciRec(n - 2)
    }
}
fun fibonacciTail(n: Int): Int {
    return fibonacciTailRec(n)
}
fun fibonacciTailRec(n: Int, a: Int = 0, b: Int = 1): Int {
    return if (n == 0) {
        a
    } else {
        fibonacciTailRec(n - 1, b, a + b)
    }
}
fun iterateList(list: List<Int>, action: (Int) -> Unit) {
    for (i in list) {
        action(i)
    }
}
fun recList(list: List<Int>): Boolean {
    return listTailRec(list)
}
fun listTailRec(list: List<Int>): Boolean {
    return if (list.isEmpty()) {
        false
    } else {
        listTailRec(list.drop(1))
    }
}