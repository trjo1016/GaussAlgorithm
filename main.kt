import gauss.linearalgebra.matrix.Matrix
import gauss.calculations.basic.basicOperations
import gauss.calculations.complex.matrixOperations

fun main() {
    val mo = matrixOperations()

    val input = mutableListOf(
        mutableListOf(1.0, 0.0, 0.0, 0.0, 0.0),
        mutableListOf(1.0, 0.0, 1.0, 0.0, 0.0),
    )
 
    val input2 = mutableListOf(
        mutableListOf(1.0, 2.0, 0.0, 0.0, 1.0),
        mutableListOf(1.0, 0.0, 1.0, 3.0, 0.0),
    )

    val input3 = mutableListOf(
        mutableListOf(1.0, 3.0),
        mutableListOf(-2.0, -1.0),
        mutableListOf(-1.0, -1.0),
        mutableListOf(-2.0, 0.0),
    )

    val input4 = mutableListOf(
        mutableListOf(1.0, 3.0),
        mutableListOf(-2.0, -1.0),
        mutableListOf(-1.0, -1.0),
        mutableListOf(-2.0, 0.0),
        mutableListOf(-2.0, 0.0),
    )
 
    val matrix = Matrix(input)
    val matrix2 = Matrix(input2)
    val matrix3 = Matrix(input3)
    val matrix4 = Matrix(input4)

/*     val sum = matrixSubtraction(matrix, matrix2)
    println(sum) */

    val product = mo.matrixMultiplication(matrix3, matrix, matrix4, matrix2)
    println(product)
}

/* fun stringToMatrix(matrixString: String, rows: Int, columns: Int) : Matrix {
    val input: MutableList<MutableList<Double>> = mutableListOf()

    val matrixArray = matrixString.split("\n").subList(1, 1 + rows)

    for (row in matrixArray) {
        val rowArray = row.split(" ").subList(1, 1 + columns)
        val numberArray: MutableList<Double> = mutableListOf()

        for (entry in rowArray) {
            numberArray.add(entry.toDouble())
        }
        input.add(numberArray)
    }

    return Matrix(input)
} */