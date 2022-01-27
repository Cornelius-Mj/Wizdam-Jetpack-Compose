package com.example.wizdam

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ButtonColors
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Filter1
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Sort
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NotificationPage() {
    Surface(
        color = Color(0xFFEFF1FF),
        modifier = Modifier.fillMaxSize()
    ) {
        Column (
            modifier = Modifier
                .padding(24.dp),
        ) {
            Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()) {
                Text("Notification", fontSize = 32.sp, fontWeight = FontWeight.Bold,
                    color = Color(0xFF20134F))
                Row() {
                    IconButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(Icons.Filled.Sort, contentDescription = "FilterNotif",
                            modifier = Modifier.size(30.dp))
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(color = Color(0xFF20134F))
                    ) {
                        Icon(Icons.Filled.Search , contentDescription = "searchNotif",
                            modifier = Modifier.size(35.dp), tint = Color.White)
                    }

                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.ArrowBack , contentDescription = "backNotif", modifier = Modifier.size(35.dp))
                }
                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEA4360)),
                    onClick = { /*TODO*/ },
                    shape = CircleShape,
                ) {
                    Text(
                        text = "Mark As All Read",
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(1.dp)
                    )
                }
            }
        }

    }

}

@Preview
@Composable
fun PreviewNotification() {
    NotificationPage()
}


