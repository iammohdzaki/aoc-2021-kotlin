package day03

import readInput

fun main() {
    val testInput = readInput("day03", "Day03_test")
    check(getPowerConsumption(testInput) == 198)

    val input = readInput("day03", "Day03")
    println(getPowerConsumption(input))
}

fun getPowerConsumption(input: List<String>): Int {
    val indicesCount = input.first().indices
    val charFrequencyByColumn = indicesCount.map {
        input.getCharsForColumn(it)
    }
    println(charFrequencyByColumn)
    val gammaRate = charFrequencyByColumn.joinToString("") { frequencyMap ->
        frequencyMap.maxByOrNull {
            it.value
        }!!.key.toString()
    }
    println("GAMMA Binary : $gammaRate | Decimal : ${gammaRate.toInt(2)}")
    val epsilonRate = gammaRate.invertBinaryString()
    println("Epsilon Binary : $epsilonRate | Decimal : ${epsilonRate.toInt(2)}")
    return (gammaRate.toInt(2) * epsilonRate.toInt(2))
}

fun List<String>.getCharsForColumn(column: Int): Map<Char, Int> =
    this.groupingBy {
        it[column]
    }.eachCount()

fun String.invertBinaryString() = this.map { if (it == '0') '1' else '0' }.joinToString("")

