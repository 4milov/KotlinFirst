package over

import over.Outer.Internal

interface Clickable {
    fun click()
}

open class RichButton : Clickable {         // open - открыт для наследования
    override fun click() {}                 // можно прооверрайдить в подклассах
//    final override fun click() {}         // нельзя прооверрайдить в подклассах
    open fun disable() {}                   // можно прооверрайдить в подклассах
    fun focus () {}                         // нет open - нельзя прооверрайдить в подклассах
}

class AnimatedButton : RichButton() {
    override fun click() {}
    override fun disable() {}
}

abstract class Animated {                   //abstract - открыт для наследования
    abstract fun animate()                  //abstract - нужно прооверрайдить в подклассах
    fun startAnimate() {}                   //нет open, но есть реализация - нельзя прооверрайдить в подклассах
    open fun stopAnim() {}                  //есть open - можно прооверрайдить
}

class Animator : Animated(){
    override fun animate() {}
//    override fun startAnimate() {}
    override fun stopAnim() {}
}

class Outer{ // внешний
    class Nested{ // вложенный
    }
    inner class Internal {
    }
}

class User(val name:String)

class Base {
    init{
        print("Base ini block")
    }
}

class User1 {
    val name : String
    constructor(name: String){
        this.name = name
    }
}
class User15 {
    val name : String

    init {
        println("init block")
    }

    constructor(name: String = "Max"){
        println("constructor")
        this.name = name
    }
}

class User2(_name : String){
    val name: String = _name
}

class Secret private constructor() {
}

data class Client(val name : String, val index : Int)
//{
//    override fun toString(): String {
//        return "name: $name, index: $index"
//    }
//
//    override fun equals(other: Any?): Boolean {
//        if(other == null || other !is Client) return false
//        return  name == other.name && index == other.index
//    }
//
//    override fun hashCode(): Int = name.hashCode()*37 + index
//
//    copy
//    component1 .. componentN
//}

fun main(){
    val misha = Client("Misha", 112112)
    val masha = Client("Misha", 112112)

    val vasya = masha.copy(name = "Vasya")

    val (name, index) = vasya
//    vasya.component1()
    println(misha == masha)
    println(misha)

    val set = hashSetOf(misha)
    println(set.contains(masha))



//    val max = User15()
//    val outer = Outer()
//    val nested = Outer.Nested()
//    val internal = outer.Internal()
}


