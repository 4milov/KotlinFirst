package calc

//fun Any.print() : String = when {
//    this is Int -> "Int: $this"
//    this is String -> "String: $this"
//    else -> "Don't know: $this"
//}

fun Any.print(): String = when (this) {
    is Int -> "Int: $this"
    is String -> "String: $this"
    else -> "Don't know: $this"
}

//фибоначчи

fun fib(number: Int): Int {
    var ret = 1
    var prev = 1
    var counter = 0
    while (counter++ < number) {
        var temp = ret
        ret += prev
        prev = temp
    }
    return ret
}

//fun sum(list : List<Int>) : Int { //convert parameter to receiver
fun List<Int>.sum(): Int {
    var ret = 0
    for (i in this) {
        ret += i
    }
    return ret
}

fun isValidId(string: String): Boolean {
    return string.matches("""[a-zA-Z0-9]\w{3,}""".toRegex())
}

interface Animal {
    fun say() = println("hi!")
}

class Goat : Animal {
    override fun say() {
        println("bee")
    }
}

class Cow : Animal {
    override fun say() {
        println("muu")
    }
}

class Dog : Animal {
    override fun say() {
        println("bark")
    }
}

sealed class Expr
class Num(val value: Int) : Expr()
class Sum(val left: Expr, val right: Expr) : Expr()
class Mult(val left: Expr, val right: Expr) : Expr()

fun eval(e: Expr): Int {
    return when (e) {
        is Num -> e.value
        is Sum -> eval(e.left) + eval(e.right)
        is Mult -> eval(e.left) * eval(e.right)
//        else -> throw java.lang.IllegalArgumentException("Unknown expr")
    }
}

//функция расширения
fun StringBuilder.lastCharOf(): Char = get(length - 1)

//св-во расширения
var StringBuilder.lastCharOf: Char
    get() = get(length - 1)
    set(value) = setCharAt(length - 1, value)


fun main() {

    var b = StringBuilder("hello")

    println(b.lastCharOf)
    b.lastCharOf = '!'
    println(b)

//    println(eval(Sum(Num(2), Num(3))))
//    println(eval(Mult(Num(2), Num(3))))
//    println(eval(Sum(Num(2),Mult(Num(2), Num(3)))))


//    val farm = listOf(Goat(), Cow(), Dog())
//    for(animal in farm){
//        animal.say()
//    }

//    println(isValidId("test"))
//    println(isValidId(""))
//    println(isValidId("13"))
//    println(isValidId("abc 123"))
//    println(isValidId("_abc"))


//    println(fib(10))

//    println("123".print())
//    println(123.print())
//    println(12.3f.print())
//
//
//    val long: Long = 212
//
//    val int: Int = long.toInt()
//
//    val int1: Int = "123".toInt()
}