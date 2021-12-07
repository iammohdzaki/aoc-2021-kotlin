package day07

import readInput
import kotlin.math.abs

val input = readInput("day07", "Day07")[0].split(",").map { it.toInt() }

fun calculate(costFunction: (start: Int, end: Int) -> Int): Int {
    val min = input.minOrNull()!!
    val max = input.maxOrNull()!!
    val cost = (min..max).map { targetPosition ->
        input.sumOf { crab ->
            costFunction(crab, targetPosition)
        }
    }
    return cost.minOrNull() ?: error("No elements!")
}

fun main() {
    println(calculate { start, end ->
        abs(end - start)
    })
    println(calculate { start, end ->
        val n = abs(end - start)
        n * (n + 1) / 2
    })
}