package simpleexamples

const val COUNT = 5

fun main() {
    val map: Map<Int, String> = mutableMapOf(1 to "Daniil", 2 to "Kate")
    map.forEach { e -> println("${e.key} -> ${e.value}") }

    var i = map.count()
    println(i)
    i += COUNT
    println(i)

    val long = map.filter { e -> e.value.length > COUNT }
    println(long)
    val mapped = map.map { e -> e.value + "_" + COUNT }
    println(mapped)
}