package simpleexamples

fun main() {
    val map = mapOf("key1" to 5)

    println(map["key1"])
    println(map["key2"])
    println(map.getValue("key1"))
    try {
        println(map.getValue("key2"))
    } catch (e: NoSuchElementException) {
        println("by \"getValue\" exception is thrown!")
    }

    val withDefault = map.withDefault { 0 }
    println(withDefault.getValue("key2"))

    println(map.getOrElse("key3") {10})
    println(map.getOrDefault("key3", 10))
}