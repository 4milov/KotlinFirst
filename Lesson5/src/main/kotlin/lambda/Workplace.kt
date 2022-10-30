package lambda

data class Emp(
    val name: String,
    val age: Int,
    val position: String
)

fun main() {
    val employees = listOf(
        Emp("Max Petrov", 22, "programmer"),
        Emp("Ivan Shapovalov", 33, "analyst"),
        Emp("Semen Deznev", 55, "manager"),
        Emp("Oleg Petrov", 19, "intern"),
        Emp("Katerina Drogova", 31, "programmer"),
        Emp("Nikolay Spivakov", 23, "analyst"),
        Emp("Boris Moiseev", 48, "manager"),
        Emp("Petr Sveshnikov", 37, "programmer"),
        Emp("Maria Kasatonova", 33, "analyst"),
        Emp("Olga Filimonova", 27, "programmer")
    )

    // самый молодой
    println(employees.minBy { it.age })
//    println(employees.minBy { Emp::age })

    // количество программистов

    println(employees.count { it.position == "programmer" })

    // распечатать все имена программистов

    println(employees.filter { it.position == "programmer" }.map { it.name.substringBefore(" ") }) // ?

// средний возраст

    println(employees.map { it.age.toFloat() }.average())

// разделить на две группы - старше 40 и младше/ И найти самого старого изх молодых

    println(employees.partition { it.age > 40 }.second.maxBy(Emp::age))

// сгруппировать по профессии. распечатать профессию и количество работников в ней

//    println(employees.groupBy { it.position }.count()) //??
    println(employees.groupBy { it.position }.mapValues { it.value.count() }) //??

// вернуть в виде пары средний возраст женщин и мужчин

    val forPair = employees.partition { it.name.toCharArray().last() == 'a' }
    val woman = forPair.first.map { it.age.toFloat()}.average()
    val man = forPair.second.map { it.age.toFloat()}.average()
    println(Pair(man,woman))

// распечатать работников с самым часто встречающимся возрастом
    println(employees.groupBy { it.age }.maxBy { it.value.count() })

// пару из работников из самой большой разницей в возрасте
    println(employees.flatMap { emp -> employees.map { it -> Pair(it, emp) } }.maxBy{it.first.age - it.second.age})
}