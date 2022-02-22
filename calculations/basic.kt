package gauss.calculations.basic

class basicOperations {
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
}