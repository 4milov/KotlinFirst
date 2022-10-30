package calculator

class Calculator(private var result: Int = 0) {
    fun get() = result
    fun add(other: Int): Unit {
        result += other
    }

    fun mul(other: Int): Unit {
        result *= other
    }

    fun sub(other: Int): Unit {
        result -= other
    }

    //    fun div(other: Int) = get() / other
    fun div(other: Int): Unit {
        assert(other != 0) { "Division by zero" }
        result /= other
    }
}

fun main() {
    val calc = Calculator(12)
    calc.add(2)
    println(calc.get())
    calc.mul(2)
    println(calc.get())
    calc.sub(2)
    println(calc.get())
    calc.div(2)
    println(calc.get())

}
