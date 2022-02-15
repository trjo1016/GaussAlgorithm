data class Matrix(
    val input: List<List<Double>>,
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
    val input = listOf(
       listOf(1.0, 0.0, 0.0, 0.0, 0.0),
       listOf(0.0, 1.0, 0.0, 0.0, 0.0),
       listOf(0.0, 0.0, 1.0, 0.0, 0.0),
       listOf(0.0, 0.0, 0.0, 1.0, 0.0),
       listOf(0.0, 0.0, 0.0, 0.0, 1.0), 
    )

    val input2 = listOf(
       listOf(1.0, 2.0, 0.0, 0.0, 1.0),
       listOf(1.0, 1.0, 2.0, 2.0, 0.0),
       listOf(4.0, 3.0, 0.0, 2.0, 2.0),
       listOf(3.0, 2.0, 1.0, 1.0, 2.0),
       listOf(2.0, 4.0, 3.0, 2.0, 3.0), 
    )

    val matrix = Matrix(input)
    println("Recently made: \n$matrix")
}

// Matrix Operations
fun stringToMatrix(matrixString: String, rows: Int, columns: Int) : Matrix {
    val input: MutableList<List<Double>> = mutableListOf()

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