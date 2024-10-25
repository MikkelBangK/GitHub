import kotlin.math.abs
import kotlin.math.sign

class Rational(private var numerator: Int, private var denominator: Int) {
    init {
        require(denominator != 0) { "Denominator cannot be zero" }
        normalize()
    }


        private fun gcd(a: Int, b: Int): Int {
            var x = a
            var y = b
            while (y != 0) {
                val temp = y
                y = x % y
                x = temp
            }
            return abs(x)
        }

        private fun normalize() {
            val gcd = gcd(numerator, denominator)
            numerator /= gcd
            denominator /= gcd
            if (denominator < 0) {
                numerator *= -1
                denominator *= -1
            }
        }

        operator fun plus(other: Rational): Rational {
            val newNumerator = numerator * other.denominator + other.numerator * denominator
            val newDenominator = denominator * other.denominator
            return Rational(newNumerator, newDenominator)
        }

        operator fun minus(other: Rational): Rational {
            val newNumerator = numerator * other.denominator - other.numerator * denominator
            val newDenominator = denominator * other.denominator
            return Rational(newNumerator, newDenominator)
        }

        operator fun times(other: Rational): Rational {
            val newNumerator = numerator * other.numerator
            val newDenominator = denominator * other.denominator
            return Rational(newNumerator, newDenominator)
        }

        operator fun div(other: Rational): Rational {
            val newNumerator = numerator * other.denominator
            val newDenominator = denominator * other.numerator
            return Rational(newNumerator, newDenominator)
        }

        operator fun unaryMinus(): Rational {
            return Rational(-numerator, denominator)
        }

        operator fun compareTo(other: Rational): Int {
            val diff = numerator.toLong() * other.denominator - other.numerator.toLong() * denominator
            return diff.sign.toInt()
        }

        override fun toString(): String {
            return "$numerator/${denominator}"
        }

}


        fun String.toRational(): Rational {
            val parts = this.split("/")
            return if (parts.size == 1) {
                Rational(parts[0].toInt(), 1)
            } else {
                Rational(parts[0].toInt(), parts[1].toInt())
            }
        }

        infix fun Int.divBy(denominator: Int): Rational {
            return Rational(this, denominator)
        }
    fun main() {
        println((-2 divBy 4).toString() == "-1/2")
        println((2 divBy 1).toString() == "2")
        println("117/1098".toRational().toString() == "13/122")
        println("1/2".toRational() - "1/3".toRational() == "1/6".toRational())
        println("1/2".toRational() + "1/3".toRational() == "5/6".toRational())
        println(-(1 divBy 2) == (-1 divBy 2))
        println((1 divBy 2) * (1 divBy 3) == "1/6".toRational())
        println((1 divBy 2) / (1 divBy 4) == "2".toRational())
        println((1 divBy 2) < (2 divBy 3))
       // val rationalRange = (1 divBy 3)..(2 divBy 3)
       // println((1 divBy 2) in rationalRange)

    }



