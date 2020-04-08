package com.hackosynth.week3.isogram

object Isogram {
    fun isIsogram(input: String): Boolean {
        val cleanInput = Regex("[^a-zA-Z]").replace(input, "").toLowerCase()
        for (char in cleanInput) {
            if (cleanInput.count { char.toString().contains(it) } >= 2) return false
        }
    return true
    }
}