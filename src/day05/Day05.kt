package day05

import day05.entity.LineSegment
import day05.entity.Point
import readInput

val input = readInput("day05", "Day05")

val lineSegments = input.map {
    val (p1, p2) = it.split("->")
    val (x1, y1) = p1.split(",")
    val (x2, y2) = p2.split(",")
    LineSegment(
        Point(x1.trim().toInt(), y1.trim().toInt()),
        Point(x2.trim().toInt(), y2.trim().toInt())
    )
}

fun main() {
    getPuzzleOne()
    getPuzzleTwo()
}

fun getPuzzleOne() {
    val filtered = lineSegments.filter { it.from.x == it.to.x || it.from.y == it.to.y }
    println(countIntersections(filtered))
}

fun getPuzzleTwo() {
    println(countIntersections(lineSegments))
}

fun countIntersections(segments: List<LineSegment>): Int {
    val interCount = mutableMapOf<Point, Int>()
    for (ventLine in segments) {
        for (point in ventLine.getPoints()) {
            interCount[point] = (interCount[point] ?: 0) + 1
        }
    }
    //printDiagram(interCount)
    return interCount.filter { it.value >= 2 }.count()
}

fun printDiagram(map: Map<Point, Int>) {
    val diagram = Array(10) {
        Array(10) {
            "."
        }
    }
    for ((k, v) in map) {
        diagram[k.y][k.x] = v.toString()
    }
    println(diagram.joinToString("\n") {
        it.joinToString("")
    })
}