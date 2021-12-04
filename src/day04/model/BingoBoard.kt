package day04.model

data class BingoBoard(
    val fields: List<MutableList<BingoField>>
) {

    private val widthIndices = fields.first().indices
    private val heightIndices = fields.indices

    companion object {
        fun getBingoBoard(columns: List<List<Int>>): BingoBoard {
            return BingoBoard(columns.map { row ->
                row.map {
                    BingoField(it)
                }.toMutableList()
            })
        }
    }

    fun checkBoard() = checkRow() || checkColumn()

    /**
     * Marks a number on bingo board
     */
    fun markNumber(value: Int) {
        fields.flatten().find { it.value == value }?.marked = true
    }

    /**
     * Returns Currently Unmarked Values of a board
     */
    fun unMarkedValues() =
        fields.flatten().filter { !it.marked }.map { it.value }

    private fun checkRow() = fields.any { row -> row.all { it.marked } }

    private fun checkColumn(): Boolean {
        for (column in widthIndices) {
            var columnCheck = true
            for (row in heightIndices) {
                if (!fields[row][column].marked) {
                    columnCheck = false
                    continue
                }
            }
            if (columnCheck) return true
        }
        return false
    }
}

data class BingoField(val value: Int, var marked: Boolean = false)