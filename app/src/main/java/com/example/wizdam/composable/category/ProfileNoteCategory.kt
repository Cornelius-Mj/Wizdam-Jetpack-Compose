package com.example.wizdam.composable.category

import com.example.wizdam.composable.category.NoteCategory.*

enum class NoteCategory(val value: String){
    MOTIVATION("Motivation"),
    DECISION("Decision"),
    KINDNESS("Kindness"),
    GRATEFUL("Grateful"),
    RELIGION("Religion"),
    MINDSET("Mindset")
}

fun getAllNoteCategories(): List<NoteCategory>{
    return listOf(MOTIVATION, DECISION, KINDNESS, GRATEFUL, RELIGION, MINDSET)
}

fun getNoteCategory(value: String): NoteCategory? {
    val map = NoteCategory.values().associateBy(NoteCategory::value)
    return map[value]
}