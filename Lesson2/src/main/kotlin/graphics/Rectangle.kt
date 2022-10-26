package graphics

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() = height == width

    val area : Int
        get() = height * width

    var depth: Int = 0

    var depth2: Int = 0
    set(value) {
        println("Old value $field new value $value")
        field = value
    }
}
fun main(){
    println(
        Rectangle(12,13).area
    )
    println(
        Rectangle(9,9).isSquare
    )

    val r = Rectangle(12,20)
    r.depth = 12
    r.depth2 = 13

}