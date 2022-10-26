package strings

//fun String.lastCharOf() : Char = this.get(this.length - 1)
fun String.lastCharOf(): Char = get(length - 1)
fun List<Int>.firstElement(): Int = get(0)
fun String.allMatchesOf(pattern: String): List<String> {
    val ret = mutableListOf<String>()
    val found = pattern.toRegex().findAll(this)
    for (result in found) {
        ret.add(result.value)
    }
    return ret
}


fun main() {
    println("Java".lastCharOf())
    println(listOf(1, 2, 3).firstElement())
    val html = "<html><head>hello</head><h1>heading></h1><p>Greet!<be></html>"
    val regexp = """<[^>/]+>"""
    html.allMatchesOf(regexp).forEach{println(it)}
}