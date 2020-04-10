package com.hackosynth.week3.diamond

object Diamond {
    fun printToList(letter: Char): List<String> {
        if (letter.toUpperCase() == 'A') return listOf("A")
        var currentLetter = letter
        val diamond = mutableListOf<String>()
        while (currentLetter > 'A') {
            val leadingOrTrailingSpaces = getWhiteSpaces((currentLetter..letter).count() - 1)
            val middleSpaces = getWhiteSpaces(('B'..currentLetter).count().times(2).minus(1))
            diamond.add(
                0,
                leadingOrTrailingSpaces +
                        currentLetter +
                        middleSpaces +
                        currentLetter +
                        leadingOrTrailingSpaces
            )
            currentLetter--
        }
        val firstLastLineSpaces = getWhiteSpaces(('A'..letter).count() - 1)
        diamond.add(0, "${firstLastLineSpaces}A${firstLastLineSpaces}")

        for (item in diamond.size.minus(2) downTo 0) {
            diamond.add(diamond[item])
        }
        return diamond
    }

    private fun getWhiteSpaces(whiteSpaces: Int): String {
        return " ".repeat(whiteSpaces)
    }
}