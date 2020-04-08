package com.hackosynth.week3.isogram

object Isogram {
    fun isIsogram(input: String): Boolean {
        val cleanInput = Regex("[^a-zA-Z]").replace(input, "").toLowerCase()
        val countChar = cleanInput.groupingBy { it }.eachCount().values
        countChar.map { if (it != 1) return false }  //cant shorten return, why?
        return true
    }
}