package day01

import readInput

/**
 * ✨ Day 01
 */

fun main() {
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day01", "Day01_test")
    check(getIncMeasurementCount(testInput.map { it.toInt() }) == 7)

    val input = readInput("day01", "Day01")
    getIncMeasurementCount(input.map { it.toInt() })

}

/**
 * Returns Increasing Measurement Count
 */
fun getIncMeasurementCount(measurements: List<Int>): Int {
    var incMeasurements = 0
    var lastMeasure = -1
    for (index in measurements.indices) {
        print("${measurements[index]} : ")
        if (lastMeasure == -1) {
            lastMeasure = index
            println("(N/A - no previous measurement)")
        } else {
            val isIncreased = measurements[lastMeasure] < measurements[index]
            if (isIncreased) {
                println("(increased)")
                incMeasurements++
            } else {
                println("(decreased)")
            }
            lastMeasure = index
        }
    }
    println("Final Measure : $incMeasurements")
    return incMeasurements
}
