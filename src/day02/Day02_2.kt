package day02

import readInput


fun main() {
    val testInput = readInput("day02", "Day02_test")
    check(testInput.getFinalDepthWithAim() == 900)

    val input = readInput("day02", "Day02")
    println(input.getFinalDepthWithAim())
}

fun List<String>.getFinalDepthWithAim(): Int {
    var horizontal = 0
    var depth = 0
    var aim = 0

    this.map {
        val (command, unit) = it.split(" ")
        Command(command, unit.toInt())
    }.forEach {
        when (it.command) {
            FORWARD -> {
                horizontal += it.unit
                depth += (aim * it.unit)
            }
            DOWN -> {
                aim += it.unit
            }
            UP -> {
                aim -= it.unit
            }
        }
    }
    return horizontal * depth
}