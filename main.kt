data class Matrix(
    val input: MutableList<MutableList<Double>>,
    val rows: Int = input.size,
    val columns: Int = input[0].size
) {
    override fun toString(): String {
        var matrixString = "\n"
        for(i in input.indices) {
            for(j in input[i].indices) {
                matrixString += " ${input[i][j]}"
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
 
    val matrix = Matrix(input)
    val matrix2 = Matrix(input2)

    val sum = matrixAddition(matrix, matrix2)
    println(sum)
}

// Matrix Operations: 
fun matrixAddition(vararg matrices: Matrix): Matrix{
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

/* MutableList würde nicht funktionieren, da es keine tiefe Kopien gibt. 
 * "column" muss selbst kopiert werden.
 */
fun createEmptyMatrix(rows: Int, columns: Int): Matrix {
    val column = List(columns) { 0.0 }
    val emptyInput = MutableList(rows) { column.toMutableList() }

    return Matrix(emptyInput)
}

fun stringToMatrix(matrixString: String, rows: Int, columns: Int) : Matrix {
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
}

// Basic Operations
fun addition(vararg numbers: Double): Double {
    return numbers.sum()
}

fun subtraction(vararg numbers: Double): Double {
    val summand = addition(numbers[0], numbers[0])
    val negativeSum = addition(*numbers)
    return addition(summand, negativeSum)
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