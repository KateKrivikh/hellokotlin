package advent1

import java.io.File

fun main() {
    val numbers = File("src/advent1/file.txt")
        .readLines()
        .map(String::toInt)

    println(numbers)

    val pair = numbers.findPairOfSum(2020)
    println(pair?.let { (x, y) -> x * y })

    val triple = numbers.findTripleOfSum(2020)
    println(triple?.let { (x, y, z) -> x * y * z })
}

fun List<Int>.findTripleOfSum(sum: Int): Triple<Int, Int, Int>? =
    firstNotNullOfOrNull { x ->
        findPairOfSum(sum - x)?.let { pair ->
            Triple(x, pair.first, pair.second)
        }
    }

fun List<Int>.findPairOfSum(sum: Int): Pair<Int, Int>? {
    val complements = associateBy { sum - it }
    return firstNotNullOfOrNull { number ->
        complements[number]?.let { complement ->
            Pair(number, complement)
        }
    }
}