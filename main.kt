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
    val list = listOf("1", "2", "3")
    val listOfLists = mutableListOf(
        list.toMutableList(),
        list.toMutableList(),
        list.toMutableList()
    )

    println(listOfLists)

    val firstList = listOfLists[0]
    firstList[0] = "Hello"

    println(listOfLists)


    val sum = createEmptyInput(5, 5)
    println(sum)

    val firstRow = sum[0]
    firstRow[0] = 1.0
    println(sum)
}

// Matrix Operations: 
fun matrixAddition(vararg matrices: Matrix) {
    val emptyInput = createEmptyInput(matrices[0].columns, matrices[0].rows)
    val sum = createEmptyMatrix(emptyInput)
    println(sum)

    for(m in matrices) {
        println("Matrix used:\n $m")
        for(i in m.input.indices) {
            for(j in m.input[i].indices) {
                sum.input[i][j] += m.input[i][j]
            }
        }
        println(sum)
    }
}

fun createEmptyInput(rows: Int, columns: Int): MutableList<MutableList<Double>> {
    val column = MutableList(columns) { 0.0 }
    val emptyInput = MutableList(rows) { column }

    return emptyInput
}

fun createEmptyMatrix(emptyInput: MutableList<MutableList<Double>>): Matrix {
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