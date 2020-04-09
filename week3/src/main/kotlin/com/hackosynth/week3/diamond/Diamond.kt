package com.hackosynth.week3.diamond

object Diamond {
    fun printToList(letter: Char): List<String> {
        if (letter.toUpperCase() == 'A') return listOf("A")
        var modLetter = letter
        val originalrange = ('A'..letter).count()
        var range = ('A'..letter).count() + 2
        var list = mutableListOf<String>()
        var leadingSpaces = 0
        while (modLetter > 'A') {
            leadingSpaces = (modLetter..letter).count() - 1
            val middleSpaces = ('B'..modLetter).count()
            list.add(
                0,
                spaces(leadingSpaces) + modLetter + spaces(
                    middleSpaces.times(2).minus(1),
                    modLetter
                ) + modLetter + spaces(leadingSpaces)
            )
            modLetter--
            range -= 2
            leadingSpaces++
        }
        val firstLastLineSpaces = " ".repeat(originalrange - 1)
        list.add(0, "${firstLastLineSpaces}A${firstLastLineSpaces}")
        //list.add("${firstLastLineSpaces}A${firstLastLineSpaces}")
        val list2 = list
        for (item in list.size.minus(2) downTo 0) {
            list2.add(list[item])
        }
        print(list)
        return list
    }

    private fun spaces(number: Int, curChar: Char = 'Z'): String {
        return when (curChar) {
            'B' -> " "
            else -> " ".repeat(number)
        }
    }
}