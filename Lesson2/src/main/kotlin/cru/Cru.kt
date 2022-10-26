package cru

enum class Cru(val level: Int) {
    CRU(80), PREMIER(90), GRAND(90);

    override fun toString() = when (this) {
        CRU -> "Base cru"
        PREMIER -> "Premier cru"
        GRAND -> "Grand cru"
    }
}
fun main(){
    println(Cru.PREMIER)
    val cru = Cru.valueOf("CRU")

    Cru.values().forEach { println(it) }
}