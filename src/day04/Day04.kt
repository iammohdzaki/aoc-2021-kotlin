package day04

import day04.model.BingoBoard
import readInput

/**
 * Bingo Game
 */
val input = readInput("day04", "Day04")

/**
 * Numbers Drawn
 */
val draws = input.first().split(",").map { it.toInt() }

/**
 * First Remove the first element from list of input
 * Divide list into 6 parts because 1 space will be there with each part.
 * Filter out blank list item
 * Divide the list item into further valid ints
 */
val boards = input.drop(1).chunked(6)
    .map { boardLines ->
        boardLines.filter {
            it.isNotBlank()
        }
    }.map { board ->
        board.map { row ->
            row.split("  ", " ")
                .filter { it.isNotBlank() }
                .map {
                    it.toInt()
                }
        }
    }

fun main() {
    println(draws)
    var bingoBoards = boards.map { BingoBoard.getBingoBoard(it) }

    for (currentDraw in draws) {
        for (board in bingoBoards) {
            board.markNumber(currentDraw)
            if (board.checkBoard()) {
                val sumOfUnmarkedFields = board.unMarkedValues().sum()
                println(sumOfUnmarkedFields * currentDraw)
                bingoBoards = bingoBoards - board
            }
        }
    }

    println(bingoBoards)
}