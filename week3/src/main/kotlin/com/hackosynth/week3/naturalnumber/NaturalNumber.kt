package com.hackosynth.week3.naturalnumber

import java.lang.RuntimeException


enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

object NaturalNumber {
    fun classify(naturalNumber: Int): Classification {
        if (naturalNumber < 1) throw RuntimeException("$naturalNumber is not a valid number")
        val sumOfDivisors =  (1 until naturalNumber).filter { naturalNumber % it == 0 }.sum()

        //This "oldschool" solution is twice as fast as the one above, why?
        /*
        val list = mutableListOf<Int>()
        for (number in 1 until naturalNumber.minus(1)) {
            if (naturalNumber % number == 0) list.add(number)
        }
        val sumOfDivisors = list.sum()
        */


        return when {
            sumOfDivisors == naturalNumber -> Classification.PERFECT
            sumOfDivisors > naturalNumber -> Classification.ABUNDANT
            sumOfDivisors < naturalNumber -> Classification.DEFICIENT
            else -> error("Ett fel är trasigt")

        }
    }
}