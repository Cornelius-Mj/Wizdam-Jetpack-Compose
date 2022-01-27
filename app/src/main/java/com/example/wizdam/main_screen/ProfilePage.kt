package com.example.wizdam

import android.widget.HorizontalScrollView
import androidx.compose.foundation.ScrollState
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
//foundation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.*
import androidx.compose.foundation.relocation.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.ui.Alignment
//other file
import com.example.wizdam.composable.ExpandableCard
import com.example.wizdam.composable.category.*

@Composable
fun ProfilePage() {
    Column {
        ExpandableCard() //ditaruh di ExpendableView
        Spacer(modifier = Modifier.height(12.dp).fillMaxWidth())
        ToggleableChip() //ProfileNoteCategory buat EnumClass dan get()-nya sementara NoteCategory Chip buat UI-chipnya
        Spacer(modifier = Modifier.height(12.dp).fillMaxWidth())

    }
}

@Composable
fun ToggleableChip() {
    val scrollState = rememberScrollState()
    Box(
        Modifier
            .horizontalScroll(scrollState)
            .fillMaxWidth()
            .padding(start = 8.dp, bottom = 8.dp)
    ) {
        Row(modifier = Modifier.padding(end = 4.dp)) {
            for (category in getAllNoteCategories()) {
                NoteCategoryChip(
                    category = category.value,//enum class parameter value
                    onExecuteSearch = {

                    },
                )
            }
        }
    }
}




