data class Matrix(
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

fun main() {
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
 
    val matrix = Matrix(input)
    val matrix2 = Matrix(input2)
    val matrix3 = Matrix(input3)

/*     val sum = matrixSubtraction(matrix, matrix2)
    println(sum) */

    val product = matrixMultiplication(matrix3, matrix)
    println(product)
}

// Matrix Operations: 
fun matrixAddition(vararg matrices: Matrix): Matrix {
    val sum = createEmptyMatrix(matrices[0].rows, matrices[0].columns)

    for(m in matrices) {
        for(i in m.input.indices) {
            for(j in m.input[i].indices) {
                sum.input[i][j] += m.input[i][j]
            }
        }
    }

    return sum
}

fun matrixSubtraction(vararg matrices: Matrix): Matrix{
    val diff = matrixAddition(matrices[0], matrices[0])

    for(m in matrices) {
        for(i in m.input.indices) {
            for(j in m.input[i].indices) {
                diff.input[i][j] += (-1.0) * m.input[i][j]
            }
        }
    }

    return diff
}

fun matrixMultiplication(m1: Matrix, m2: Matrix): Matrix {
    val product = createEmptyMatrix(m1.rows, m2.columns)

    for(i in 0..m1.rows - 1) {
        for(j in 0..m2.columns - 1) {
            for(k in 0..m1.columns - 1) {
                product.input[i][j] += m1.input[i][k] * m2.input[k][j]
            }
        }
    }

    return product
}

/* MutableList würde nicht funktionieren, da es keine tiefe Kopien gibt. 
 * "column" muss selbst kopiert werden.
 */
fun createEmptyMatrix(rows: Int, columns: Int): Matrix {
    val column = List(columns) { 0.0 }
    val emptyInput = MutableList(rows) { column.toMutableList() }

    return Matrix(emptyInput)
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

// Basic Operations
fun addition(vararg numbers: Double): Double {
    return numbers.sum()
}

fun subtraction(vararg numbers: Double): Double {
    val minuend = addition(numbers[0], numbers[0])
    val negativeSum = (-1.0)*addition(*numbers)
    return addition(minuend, negativeSum)
}

fun multiplication(vararg numbers: Double): Double {
    val numbersList = numbers.map { it }
    var product = 1.0
    for (number in numbersList) {
        product *= number
    }
    return product
}

fun division(vararg numbers: Double): Double {
    var numerator = multiplication(numbers[0], numbers[0])
    var denominator = multiplication(*numbers)
    return numerator/denominator
}

// Division with remainder
fun remainder(n: Double, m: Double) : Pair<Double, Double> {
    var divisor = 0.0
    var rest = n 
    while(rest > m) {
        rest -= m
        divisor++
    }
    return Pair(divisor, rest)
}