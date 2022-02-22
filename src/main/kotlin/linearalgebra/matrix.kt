package gauss.linearalgebra

data class Matrix (
    val input: MutableList<MutableList<Double>>,
    val rows: Int = input.size,
    val columns: Int = input[0].size
) {
    override fun toString(): String {
        var matrixString = "\n"
        for(i in input.indices) {
            for(j in input[i].indices) {
                matrixString += "${input[i][j]}".padStart(6)
            }
            matrixString += "\n"
        }
        return matrixString
    }
}