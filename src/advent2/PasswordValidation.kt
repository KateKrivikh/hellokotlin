package advent2

import java.io.File

fun main() {
    val passwords = File("src/advent2/file.txt")
        .readLines()
//        .map(PasswordWithPolicy::parseUsingRegex)
        .map(PasswordWithPolicy::parse)
    passwords.forEach(::println)

    println(passwords.count { it.validatePartOne() })
    println(passwords.count { it.validatePartTwo() })
}

data class PasswordWithPolicy(
    val password: String,
    val letter: Char,
    val range: IntRange
) {
    fun validatePartOne() = password.count { it == letter } in range

    fun validatePartTwo() =
        (password[range.first - 1] == letter) xor (password[range.last - 1] == letter)

    companion object {
        private val regex = Regex("""(\d+)-(\d+) ([a-z]): ([a-z]+)""")

        fun parse(line: String) = PasswordWithPolicy(
            password = line.substringAfter(": "),
            letter = line.substringBefore(":").substringAfter(" ").single(),
            range = line.substringBefore(" ").let
            {
                val (start, end) = it.split("-")
                start.toInt()..end.toInt()
            }
        )

        fun parseUsingRegex(line: String): PasswordWithPolicy? =
            regex.matchEntire(line)
                ?.destructured
                ?.let { (start, end, letter, password) ->
                    PasswordWithPolicy(password, letter.single(), start.toInt()..end.toInt())
                }

    }
}