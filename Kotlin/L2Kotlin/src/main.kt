fun String.lastChar(): Char {
    return this[this.length - 1]
}

val lastChar = "Kotlin".lastChar() // 'n'

fun main() {
    println(lastChar)
}