package View

import JavaView
import JavaClickListener

data class Person(val name: String, val age : Int)

val people = listOf<Person>(
    Person("Alice", 29),
    Person("Bob", 31),
    Person("Carol", 31)
)

fun hi() = println("hi-hi")

fun Person.isAdult() : Boolean = age >=18

fun main() {

   /* val adult = Person::isAdult

    val create = ::Person //ссылка на конструктор
    val max = create("Max", 23) //ссылка на функцию экземпляра класса
    val maxage = max::age

    val hello = ::hi //ссылка на функцию объявленную в классе

    run(hello)

    val personAge = Person::age // ссылка на метод класса

    var counter = 0
    people.forEach{
        counter++
    }
    println(counter)*/

//    val ageSort = {p:Person -> p.age}

//    println(people.minBy ({ p:Person -> p.age }))
//    println(people.minBy() { p:Person -> p.age })
//    println(people.minBy { p:Person -> p.age })
//    println(people.minBy { p -> p.age })
//    println(people.minBy { it.age })
//    println(people.minBy (Person::age ))
//    println(people.minBy ( ageSort ))

    val javaView = JavaView()
    javaView.setOnClickListener(object : JavaClickListener {
        override fun onClick(view: JavaView?) {
            TODO("Not yet implemented")
        }
    })

    javaView.setOnClickListener {  view -> print("hello ")}
}