package day01


fun List<Int>.getSumOfWindow(size: Int) =
    asSequence().windowed(size) { it.sum() }.toList()

fun List<Int>.findIncreasingValuesCount() =
    this.zipWithNext().count { (a, b) -> a < b }