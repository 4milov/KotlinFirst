@file:Suppress("DEPRECATION")

package lambda

import java.util.*

data class Person(val name: String, val age: Int)

val people = listOf(
    Person("Alice", 29),
    Person("Bob", 31),
    Person("Carol", 31)
)

val list = listOf(1, 2, 3, 4, 5, 6, 7)
val nullableList: List<Int?> = listOf(1, 2, 3, null, 6, 8)

val nullableList1: List<Int?>? = listOf()

val map = mapOf(1 to "one", 2 to "two", 3 to "three")

val listOfList = listOf(
    listOf("abc", "kgb", "cia"),
    listOf("ibm", "kpmg")
)

fun main() {

    println(
        //объединение двух коллекций. Количество равно минимальному количеству объединяемых коллекций
        people.zip(list)
    )

/*    println(
        //объединить 2 листа в один
//        listOfList.flatten() //[abc, kgb, cia, ibm, kpmg]
        // map при применении .toList для каждого элемента мапит его в list
//        listOfList.flatten() .map { it.toList() } // [[a, b, c], [k, g, b], [c, i, a], [i, b, m], [k, p, m, g]]
            //каждый элемент превращается в набор элементов(List), далее воплощает в 1 большой List
//        listOfList.flatten() .flatMap { it.toList() } //[a, b, c, k, g, b, c, i, a, i, b, m, k, p, m, g]
    )*/


/*    println(

        //группировка по ключу
//        people.groupBy { it.age }

        //создать мапу по группировке выше
//        people.groupBy { it.age }.keys

        // сохраняет последний элемент каждой группы
//    people.associateBy { it.age }

        //разделение по соответствию на 2 коллекции в одном элементе (соответствует/не соответствует)
//    people.partition { it.age > 30 }
    )*/

    /*println(
        //операция умножения всех элементов list. 1 - аккумулятор
//        list.fold(1) { acc, elem -> acc * elem }
//        list.reduce{ acc, elem -> acc * elem }
    )*/

/*    println(
//        people.count { it.age == 31 } // 2
//    people.find { it.age == 31 && it.name.contains('o') }
//        people.map { it -> it.age.toFloat() }.average() //средний возраст
    )*/

/*    println(
        // any none all булеаны - содержит/не содержит/все
        people.any{ it.age == 29} // true лист содержит
//        people.none{ it.age == 30} // true лист не содержит людей с возрастом 30 лет
    )*/


    /*println(
//        map.mapValues { it.value.uppercase(Locale.getDefault()) }
//        list.map { it * it }
//        people.filter{it.age > 30}.map{it.name}
//        list.distinct() // distinctBy
//        people.maxBy { it.age }
//        people.maxBy { it.age }?.age //nullable, необходимо поставить ?
////    people.first(){it.age == 60}// NoSuchElementException
//people.firstOrNull(){it.age == 60} //null
//
////        list.filter { x: Int -> x%3==0}
////        list.filter { x -> x%3==0}
//        list.filter {it % 3 == 0}
//        nullableList.filter {x -> x !=null && x % 3 == 0}
//        nullableList1?.filter {x -> x !=null && x % 3 == 0}
//        people.filter { it.age > 30 }
    )*/

    /*  val sum : (Int, Int) -> Int = {x: Int, y: Int -> x + y}

      val some : () -> Unit = { println("hello")  }

      val result = sum(1,2)

      println(
          result::class.simpleName
      )

      //Function1
      //Function2

      sum.invoke(4,5)*/
}