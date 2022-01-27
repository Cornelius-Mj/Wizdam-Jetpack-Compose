package com.example.wizdam.composable

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.icons.filled.Draw
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wizdam.R



@Composable
fun ExpandableCard(
) {
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        elevation = 8.dp,
        onClick = {
            expandedState = !expandedState
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFFEFF1FF))
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (expandedState) {
                ProfileSection()
            }
            Row(horizontalArrangement = Arrangement.Center,
                modifier =  Modifier.fillMaxWidth().height(30.dp)
               ) {
                IconButton(
                    modifier = Modifier
                        .height(20.dp)
                        .weight(1f)
                        .alpha(ContentAlpha.medium)
                        .rotate(rotationState),
                    onClick = {
                        expandedState = !expandedState
                    }) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropUp,
                        contentDescription = "Drop-Down Arrow"
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileSection(
   //Nanti pasang parameter nama, email, image, dan angka detail
) {
    Column(
        modifier = Modifier
            .background(color = Color(0xFFEFF1FF)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier.padding(all = 12.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.profilepic),
                contentDescription = "profile_pic", modifier = Modifier
                    .clip(CircleShape)
                    .size(80.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column() {
                Text(text = "Vincent Lius", fontSize = 20.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Serif)
                Text(text = "v.cornelius28@gmail.com", fontStyle = FontStyle.Italic)
            }
            Spacer(modifier = Modifier.width(12.dp))
            Button(
                onClick = { /*TODO*/ },
                contentPadding = PaddingValues(12.dp),
                modifier = Modifier
                    .width(45.dp)
                    .height(45.dp)
            ) {
                Icon(Icons.Filled.Draw , contentDescription = "profile_edit")
            }
        }
        Row(horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("11", fontWeight = FontWeight.Bold, color = Color(0xFF20134F))
                Text("Group")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("206", fontWeight = FontWeight.Bold, color = Color(0xFF20134F))
                Text("Post")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("58", fontWeight = FontWeight.Bold, color = Color(0xFF20134F))
                Text("Following")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("15", fontWeight = FontWeight.Bold, color = Color(0xFF20134F))
                Text("Follower")
            }
        }
    }
}




