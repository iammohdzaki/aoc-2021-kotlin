package day01

import readInput

/**
 * ✨ Day 01 - Puzzle - 2
 */
fun main() {
    val testInput = readInput("day01", "Day01_test")
    check(testInput
        .map { it.toInt() }
        .getSumOfWindow(3)
        .findIncreasingValuesCount() == 5
    )

    val input = readInput("day01", "Day01")
    val result = input
        .map { it.toInt() }
        .getSumOfWindow(3)
        .findIncreasingValuesCount()
    println(result)
}



