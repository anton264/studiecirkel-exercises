package com.hackosynth.week3.diamond

object Diamond {
    fun printToList(letter: Char): List<String> {
        if (letter.toUpperCase() == 'A') return listOf("A")
        var currentLetter = letter
        val originalRange = ('A'..letter).count()
        var currentRange = ('A'..letter).count() + 2
        val diamond = mutableListOf<String>()
        while (currentLetter > 'A') {
            val leadingOrTrailingSpaces = getWhiteSpace((currentLetter..letter).count() - 1)
            val middleSpaces = getWhiteSpace(('B'..currentLetter).count().times(2).minus(1))
            diamond.add(
                0,
                leadingOrTrailingSpaces +
                        currentLetter +
                        middleSpaces +
                        currentLetter +
                        leadingOrTrailingSpaces
            )
            currentLetter--
            currentRange -= 2
        }
        val firstLastLineSpaces = getWhiteSpace(originalRange - 1)
        diamond.add(0, "${firstLastLineSpaces}A${firstLastLineSpaces}")

        for (item in diamond.size.minus(2) downTo 0) {
            diamond.add(diamond[item])
        }
        return diamond
    }

    private fun getWhiteSpace(number: Int): String {
        return " ".repeat(number)
    }
}