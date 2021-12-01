package day01

import readInput

/**
 * ✨ Day 01 - Puzzle - 1
 */
fun main() {

    val testInput = readInput("day01", "Day01_test")
    check(testInput.map { it.toInt() }.findIncreasingValuesCount() == 7)

    val input = readInput("day01", "Day01")
    println(input.map { it.toInt() }.findIncreasingValuesCount())

}