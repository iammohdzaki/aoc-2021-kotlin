package day02

import readInput

const val FORWARD = "forward"
const val DOWN = "down"
const val UP = "up"

fun main() {
    val testInput = readInput("day02", "Day02_test")
    check(testInput.getFinalDepth() == 150)

    val input = readInput("day02", "Day02")
    println(input.getFinalDepth())
}

fun List<String>.getFinalDepth(): Int {
    var horizontal = 0
    var depth = 0

    this.map {
        val (command, unit) = it.split(" ")
        Command(command, unit.toInt())
    }.forEach {
        when (it.command) {
            FORWARD -> horizontal += it.unit
            DOWN -> depth += it.unit
            UP -> depth -= it.unit
        }
    }
    return horizontal * depth
}

data class Command(val command: String, val unit: Int)