package simpleexamples

fun main() {
    val ages = listOf(4, 34, 54, 22)
    val names = listOf("sun Danial", "mom Kate", "grandpa Sergey")

    val persons = ages.zip(names) { age, name -> Person(name, age) }

    persons.forEach { person ->
        person
            .apply {
                underage = age < 18
            }
            .also { logPerson(it) }
    }
}

fun logPerson(p: Person) {
    with(p) {
        val stringUnderage = if (underage) " (underage)" else ""
        println("$name - $age $stringUnderage")
    }
}

data class Person(var name: String = "", var age: Int = 0, var underage: Boolean = false)