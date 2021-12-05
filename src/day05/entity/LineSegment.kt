package day05.entity

data class LineSegment(val from: Point, val to: Point) {
    override fun toString() = "($from,$to)"

    private fun canonical(): LineSegment {
        if (from.x < to.x) return this // Left to right
        if (from.x == to.x && from.y < to.y) return this // Top to bottom
        return LineSegment(to, from)
    }

    fun getPoints(): List<Point> = with(canonical()) {
        if (from.x == to.x) { // vertical line
            return (from.y..to.y).map { Point(from.x, it) }
        }
        if (from.y == to.y) { // horizontal line
            return (from.x..to.x).map { Point(it, from.y) }
        }
        // diagonal line
        val dx = to.x - from.x
        val dy = to.y - from.y
        val direction = when {
            dy > 0 -> 1
            dy < 0 -> -1
            else -> 0
        }
        return (0..dx).map { delta ->
            Point(from.x + delta, from.y + direction * delta)
        }
    }
}

data class Point(val x: Int, val y: Int)
