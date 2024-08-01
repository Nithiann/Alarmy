package com.nithiann.alarm.domain.model

enum class Difficulty(val value: Int, val text: String) {
    EASY(0, "Easy"),
    MEDIUM(1, "Medium"),
    HARD(2, "Hard"),
    CUSTOM(3, "Custom");

    companion object {
        fun fromValue(value: Int): Difficulty = values().first { it.value == value }
        fun fromText(text: String): Difficulty = values().first { it.text == text }
    }
}