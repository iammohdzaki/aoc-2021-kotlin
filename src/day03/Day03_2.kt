package day03

import readInput

fun main() {
    val testInput = readInput("day03", "Day03_test")
    check(getLifeSupportRating(testInput) == 230)

    val input = readInput("day03", "Day03")
    println(getLifeSupportRating(input))
}

fun getLifeSupportRating(input: List<String>): Int {
    val oxyGenRating = input.filterColumnsForCharacter { zeroes, ones ->
        if (zeroes > ones) '0' else '1'
    }

    val co2ScrubberRating = input.filterColumnsForCharacter { zeroes, ones ->
        if (zeroes > ones) '1' else '0'
    }

    return oxyGenRating.toInt(2) * co2ScrubberRating.toInt(2)
}

fun List<String>.filterColumnsForCharacter(
    desiredCharacterByFrequency: (zeroes: Int, ones: Int) -> Char
): String {
    var candidateList = this
    for (column in this.first().indices) {
        val charFrequencyByColumn = candidateList.getCharsForColumn(column)
        val zeroes = charFrequencyByColumn['0'] ?: 0
        val ones = charFrequencyByColumn['1'] ?: 0
        candidateList = candidateList.filter { it[column] == desiredCharacterByFrequency(zeroes, ones) }
        if (candidateList.size == 1) break
    }
    return candidateList.single()
}