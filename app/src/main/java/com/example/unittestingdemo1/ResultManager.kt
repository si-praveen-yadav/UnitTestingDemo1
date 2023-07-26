package com.example.unittestingdemo1

class ResultManager {
    fun calculatePercentage(marksObtained: Int, total: Int): Double {
        return (marksObtained.toDouble() / total)*100
    }

    fun checkResult(percentage: Int): Grade {
        return when (percentage) {
            100 -> Grade.E
            in 90..99 -> Grade.O
            in 80..89 -> Grade.A_PLUS
            in 70..79 -> Grade.A
            in 60..69 -> Grade.B_PLUS
            in 50..59 -> Grade.B
            in 40..49 -> Grade.C_PLUS
            in 30..39 -> Grade.C
            else -> Grade.F
        }
    }

    fun checkPass(grade: Grade):Boolean{
        return grade != Grade.F
    }
}

enum class Grade {
    E,O, A_PLUS, A, B_PLUS, B, C_PLUS, C, F
}
