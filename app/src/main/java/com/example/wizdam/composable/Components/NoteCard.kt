package com.example.wizdam.composable.Components


import android.media.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NoteCard(
    note : Note, //di Component.Note.dataClass
    //onClick: () -> Unit,
){
    Card(
        modifier = Modifier
            .padding(
                vertical = 6.dp,
                horizontal = 10.dp
            )
            .fillMaxWidth()
            //.clickable(onClick = onClick),
        ,
        backgroundColor = Color(0xFFEFF1FF),
        elevation = 8.dp,
    ) {
        Column(
        ) {
            note.title?.let {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = it,
                        fontWeight = FontWeight.Bold
                    )
                    note.dateAdded?.let {
                        Text(text = it,
                        color = Color.Gray)
                    }
                }
                note.description?.let {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp),
                        text = it,
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
        }


    }

}

@Preview
@Composable
fun PreviewNoteCard() {
    var Desc = "Whenever you want to give up, remember that problem will keep coming and if you ain't getting your shit together you will suffer repercussion in the future and it will be so heavy you're going to beaten down by it.\n" +
            "You don't get to choose not to drink the poison, you can only choose which poison you want to drink, so get your shit together and start lifting up your spirit. " +
            "Because if a probability of having to be forced to drink a poison doesn't motivate you enough? I don't know if there's other thing able to accomplish it"
    NoteCard(note = Note(id = 1, title = "When life get's tiring and shitty", dateAdded = "Jan 2022", description = Desc))
}