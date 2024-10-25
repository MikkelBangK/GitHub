
fun then1(f: (Int) -> Double, g: (Double) -> Double): (Int) -> Double = {x -> g(f(x))}
fun ((Int) -> Double).then2(f: (Int) -> Double): (Int) -> Double {}
fun then()
//    fun compose(f: (Double) -> Double, g: (Int) -> Double): (Int) -> Double = { x -> f(g(x)) }


fun main(){
    val f1: (Int) -> Double = { 2.0 * it }
    val f2: (Double) -> Double = { it * it }
    println((1..10).map(then1(f1, f2)))
    println((1..10).map(f1.then2(f2)))
    println((1..10).map(f1 then f2))
// [4.0, 16.0, 36.0, 64.0, 100.0, 144.0, 196.0, 256.0, 324.0, 400.0]
}