package simpleexamples

fun main() {
    val oddEven = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).partition { it % 2 == 0 }
    println("odd = ${oddEven.first}, even = ${oddEven.second}")

    val (positives, negatives) = listOf(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5).filter { it != 0 }.partition { it > 0 }
    println("positives = $positives, negatives = $negatives")
}