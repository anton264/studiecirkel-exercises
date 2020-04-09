package com.hackosynth.week3.naturalnumber

import java.lang.RuntimeException


enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

object NaturalNumber {
    fun classify(naturalNumber: Int): Classification {
        if (naturalNumber < 1) throw RuntimeException("$naturalNumber is not a valid number")
        val list = mutableListOf<Int>()
        for (number in 1 until naturalNumber.minus(1)) {
            if (naturalNumber % number == 0) list.add(number)
        }
        return when {
            list.sum() == naturalNumber -> Classification.PERFECT
            list.sum() > naturalNumber -> Classification.ABUNDANT
            list.sum() < naturalNumber -> Classification.DEFICIENT
            else -> error("Ett fel är trasigt")

        }
    }
}