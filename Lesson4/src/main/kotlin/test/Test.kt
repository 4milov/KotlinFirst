package test

data class RationalNumber(val numerator: Int, val denominator: Int)

fun Int.r() : RationalNumber = RationalNumber(this, 1)
fun Pair<Int,Int>.r() : RationalNumber = RationalNumber(first, second)

fun String?.isEmptyOrNull() : Boolean = this?.isEmpty() ?: true

//fun Int.sm(other : Int) : Int = this + other
infix fun Int.sm(other : Int) : Int = this + other

operator fun RationalNumber.plus(other: RationalNumber) : RationalNumber =
    RationalNumber(numerator * other.denominator + denominator * other.numerator,denominator*other.denominator)

operator fun RationalNumber.times(other: RationalNumber) : RationalNumber =
    RationalNumber(numerator * other.numerator, denominator * other.denominator)

operator fun RationalNumber.unaryMinus() : RationalNumber = RationalNumber(-numerator, -denominator )





open class Base

class Child : Base()

fun Base.hello() : String = "hello base"
fun Child.hello() : String = "hello child"

fun main()
{
    val r1 = RationalNumber(1,2)
    val r2 = RationalNumber(3,4)
    val r3 = r1.unaryMinus()
    val r4 = r2.unaryMinus()

    println(r4 + r3)
    println(r4 * r3)

//    val child : Base = Child()
//    println(child.hello())

//    println(25.sm(15))
//    println(25 sm 15)

//    println(32.r())
//    println((25 to 45).r())

//    println("".isEmptyOrNull()) //true
//    println(null.isEmptyOrNull()) //true
//    println("hello".isEmptyOrNull()) //false
}