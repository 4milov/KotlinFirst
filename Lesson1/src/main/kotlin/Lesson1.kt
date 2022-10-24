import java.math.BigDecimal

val firstName : String = "Masha"
var lastname = "Ivanova"

var age = 25

const val DEBUG = true

//val first = fun1();
//const val second = fun1();
//
//    fun fun1(): Int {
//        return 5;
//    }

    fun main(arg : Array<String>){
        age = 26
//        getAge = "twenty"

        // if
        /*
        val temperature = 26
        val condition = if(temperature < -5  /*|| getAge < 4 */)
            "Cold"
        else if(temperature <5)
            "near zero"
        else
            "Hot"
*/

        //when
        val temperature = 26
        val condition = when {
            temperature < -5   -> "Cold"
            temperature < 5 -> "near zero"
            else ->  "Hot"
        }

        println("Hello, world!")

        // nullable
        var position :String? = "programmer"
        position = null
        if(position != null)
        println ("length is " + position.length)

//        println("length is " + position?.length)

        println( position?.length ?: 0)
//        println ("length is " + position!!.length)

        val obj : Any = "15"

        if(obj is String) //smart cast !is
        {
            println("len is " + obj.length)
        }

        val x: String = obj as String
//        val z: String = getAge as String // ClassCastException

        val k: String? = age as? String // save cast
        println(k)

        //строковые шаблоны
        println("name: " + firstName + " getLastname: " + lastname + " getAge: " + age)
        println("name: $firstName getLastname: $lastname getAge: ${age + 1}" )

        println("""
            one line
            two line
            three line
        """.trimIndent())

        println("""
            |SELECT * FROM USERS
            |WHERE AGE >24
            |GROUP BY NAME
        """.trimMargin())

//        fun greeting(first:String, last: String) : String
//        {
//            return "Hello, $first $last"
//        }

//        println(greeting("Masha", "Ivanova"))
//        println(greeting(last = "Ivanova", first = "Masha"))
        println(greeting(first = "Masha"  ))
//        println(greeting(first = "")) // IllegalArgumentException: Write name

        //while
        var counter = 0;
        while(counter < 10){
            println("${counter++}")
        }
        //do-while
//        do {
//            val command = readLine()
//            println("command: $command")
//        } while (command != "quit")

        val oneToFive = 1..5
        val letters   = 'a'..'z'
        val words     = "Java".."Yaml"

        if ('d' in letters){
        }
        if("Kotlin" in words){
        }

        //for
        for(letter in letters){
            println(letter)
        }

//        println(japaneseSalary(-BigDecimal.TEN, 10))

        //array

//        val array : Array<Int> = arrayOf<Int>(1, 2, 3, 4)
        val array = arrayOf(1, 2, 3, 4)
//        array = arrayOf(5)
        array[2] = 25

        val list = listOf("One", "Two", "Three") //immutable
        val mutableList = mutableListOf("One", "Two", "Thee")
        mutableList[0] = "ONE"
        mutableList.add("Four")

        //pair

        val pair = Pair("One", "Two")
        println("first: ${pair.first} second: ${pair.second}")

        val infixPair = 1 to "One"

        val map = mutableMapOf(1 to "one", 2 to "two")

        //multi declare

        for ((f,s) in map){
            println("f: $f s: $s")
        }




    }

fun japaneseSalary(base : BigDecimal = 50_000.toBigDecimal(), years: Int) : BigDecimal //= TODO("later")
//base + years * 10_000
{
    require(base > BigDecimal.ZERO) {"Base salary can't be negative"}
    return base + years.toBigDecimal() * 10_000.toBigDecimal()
}

//fun greeting(first:String, last: String = "Ivanova") = "Hello, $first $last"

fun greeting(first:String, last: String = "Ivanova") : String {
    require(!first.isBlank()) {"Write name"}
    require(!last.isBlank()) {"Write surname"}
//    requireNotNull()
//    check()
//    assert()
    return "Hello, $first $last"
}
