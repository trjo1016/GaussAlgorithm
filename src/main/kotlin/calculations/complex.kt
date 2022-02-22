package gauss.calculations

import gauss.linearalgebra.Matrix

class matrixOperations {
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
    
    fun matrixSubtraction(vararg matrices: Matrix): Matrix {
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
    
    fun matrixMultiplication(vararg matrices: Matrix): Matrix {
        val matrixList = matrices.map { it }
        var product = createNeutralMatrix(matrices[0].rows)
    
        for(matrix in matrixList) {
            println(product)
            product = mMult(product, matrix)
        }
    
        return product
    }
    
    private fun mMult(m1: Matrix, m2: Matrix): Matrix {
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
    
    fun createNeutralMatrix(size: Int): Matrix {
        val matrix = createEmptyMatrix(size, size)
    
        for(k in 0..size - 1) {
            matrix.input[k][k] = 1.0
        }
    
        return matrix
    }
}