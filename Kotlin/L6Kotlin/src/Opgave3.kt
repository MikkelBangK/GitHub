

fun calc(op: (Int, Int) -> Int) = {x: Int, y: Int -> op(x, y)}

fun add(x: Int, y: Int): Int = calc {x: Int, y: Int -> x + y}(x, y)

fun subtract(x: Int, y: Int): Int = calc {x: Int, y: Int -> x - y}(x, y)

fun multiply(x: Int, y: Int): Int = calc {x: Int, y: Int -> x * y}(x, y)

fun main(){
    println("add(4,4) = ${add(4, 4)}")
    println("subtract(4,4) = ${subtract(4, 4)}")
    println("multiply(4,4) = ${multiply(4, 4)}")
}