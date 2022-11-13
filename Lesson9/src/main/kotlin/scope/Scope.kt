package scope

class Scope {
}

//2
class Window {
    var width: Int = 0
    var height: Int = 0
    var isVisible: Boolean = false
}

fun main() {

//2 Настройка объекта и выполнение кода с этим объектом
    val map = mutableMapOf(1 to Window())

    val window1 =
        map[2]?.run {
            width = 100
            isVisible = true
            this
        }
//3 сгруппировать вызовы функций объекта

    val builder = StringBuilder()

    with(builder) {
        for(letter in 'a'..'z')
            append(letter)
    }

    println(builder) //abcdefghijklmnopqrstuvwxyz

//4 настройка объекта

    builder.apply {
        append("123")
    }
        .toString()

    builder.append("123").toString()

//5 Выполнить лямбду на ненулевом объекте

        var myString : String? = "123"

    myString?.let {
        println(it.length)
    }



//1 Сайд эффекты
    val string = "String"

    val another =
        string.also {
            val hello = "hello"
            println("$it has a length of ${it.length}") // String has a length of 6
        }

    listOf(
        "one",
        "two",
        "three"
    ).also { println("$it has a length of ${it.size}") } //[one, two, three] has a length of 3

    listOf("one", "two", "three")
        .filter { it.length > 3 }
        .also { println("$it has a length of ${it.size}") } //[three] has a length of 1



    run { println("hello!") } //hello!


}