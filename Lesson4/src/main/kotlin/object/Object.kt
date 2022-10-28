package `object`

// object

object Singleton {
    var name: String = "Dima"
    fun hello() = println("hello")
}

class Outer {
    private constructor()
    // используется для реализации статики в классе
    // можно добавлять классу расширяющие его функции
    // создавать экземпляры, если конструктор приватный
    companion object {
        fun hello() {
            println("hello from CO")
        }

        fun get(): Outer = Outer()
    }
}

interface ClickListener {
    fun click()
}

class View {
    fun setOnClicListener(listener: ClickListener){
        //
    }
}


fun main() {
//создание анонимного внутреннего класса
    val listener: ClickListener = object : ClickListener{
        override fun click() {
            TODO("Not yet implemented")
        }
    }
    val view = View()

        //добавили анонимный внутренний класс
    view.setOnClicListener(listener)
        //либо создаем каждый раз новый анонимный класс
    view.setOnClicListener(object : ClickListener {
        override fun click() {
            TODO("Not yet implemented")
        }
    })

//    val outer = Outer() // private constructor
//    val outer = Outer.get()
//    Outer.hello()

//    println(Singleton.name)
//    Singleton.hello()
}