package operators

import test.RationalNumber
import test.sm

data class Point(val x: Int, val y: Int){
     operator fun plus(other:Point) : Point{
         return Point(x+other.x, y+other.y)
     }
 }

class Rect(val ul : Point, val lr : Point)

operator fun Rect.contains(p: Point) : Boolean{
    return p.x in ul.x .. lr.x && p.y in ul.y .. lr.y
}

fun String.barbWire(other : String) : String {
    if((this == "Hedgehog" && other == "Snake") || (this == "Snake" && other == "Hedgehog")) return "BarbWire"
    else return this.plus(other)
}

class Hedgehog {
    fun whoAmI() = println("I'm a Hedgehog")
}

class Snake {
    fun whoAmI() = println("I'm a Snake")
}

class BarbWire {
    fun whoAmI() = println("I'm a BarbWire")
}

operator fun Hedgehog.plus(snake: Snake) : BarbWire = BarbWire()

fun Int.r() : RationalNumber = RationalNumber(this, 1)

val lazyValue : String by lazy { //верхнеуровневое поле объявленное в классе
    println("Инициализация")
    "Hello" //кешированное значение
}

class LateInit {
    val name : String = "Misha"
    lateinit var late : String

    fun init() {
        late = "Initialized"
    }
}

fun main(){

    var lateInit = LateInit()
//    lateInit.late //UnitializedPropertyAccessException
    lateInit.init()
    println(lateInit.late)

//    println(lazyValue)
//    println(lazyValue)
//
//    println("Hedgehog".barbWire("Snake"))
//
//    val hedgehog = Hedgehog()
//    val snake = Snake()
//
//    (hedgehog + snake).whoAmI()
//
//    val point1 = Point(3,3)
//    val point2 = Point(5,5)
//
//    println(point1 + point2)
//
//    val rect = Rect(Point(4,4), Point(20,10))
//
//    println(point1 in rect)
//    println(point2 in rect)
}