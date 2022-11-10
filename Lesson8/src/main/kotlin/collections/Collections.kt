package collections

import collections.Result


//1
//class Box<T : Any> (t: T){
class Box<T>(t: T) {
    var value = t
}

fun <T> List<T>.getByNumbers(vararg args: Int): List<T> {

    val result = mutableListOf<T>()
    for (i in args) {
        result.add(this[i])
    }
    return result
}

//2
class Bitmap
class Result<T : Any>(val result: T?, val t: Throwable?)

//4
inline fun <reified T> isA(any: Any) : Boolean = any is T


fun main() {

    //4
    println(
        isA<String>("Sr")
    )

    //3
//    val listOfNumber : List<Number> = listOf(1,2,3,4)
//    val listOfNumber : List<Number> = mutableListOf(1,2,3,4)
    //out - будем использовать val только для чтения
    val mutableListOfNumber : MutableList<out Number> = mutableListOf<Int >(1,2,3,4)

    //in - будем использовать val только для записи, создает наследование, в примере ниже, Number от in Int
    val listOfInt : MutableList<in Int> = mutableListOf<Number>(1.222, 2.344)
    listOfInt.add(234)
    println(listOfInt)

    //смысл - если есть класс, который производит что-то, то с помощью out можно все безопасно считать
    //Класс, который потребляет что-то (либо ф-я принимает параметр), с помощью in - мы сможем передать экземпляры in, так и экземпляр порожденных/производных от этого других классов






    //2
    val bitmap = Bitmap()
    val result = Result(bitmap, null)

    val throwable = Throwable("Error")
    val error = Result<Bitmap>(null, throwable)



//1
    val intBox = Box(1)
    val numberBox: Box<Number> = Box(2.33)
//    val nullBox: Box<Number> = Box(null)
    val nullBox = Box(null)


    val list = listOf(1, 2, 3, 4)

//    list[2] = 12
    val mutableList = mutableListOf(1, 2, 3, 4)
    mutableList.add(44)

    val list2 = listOf(1, 2, 3, 4) // ArrayList LinkedList

    println(list == list2) //true

//    val set = setOf("one", "two", "three") // LinkedHashSet - default, HashSet, SortedSet
    val set = setOf<String>("one", "two", "three") // LinkedHashSet - default, HashSet, SortedSet

    val map = mapOf(1 to "One", 2 to "two") // LinkedHashMap - default, HashMap, SortedMap


}