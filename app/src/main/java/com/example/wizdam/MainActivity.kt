package com.example.wizdam

import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFEFF1FF))) {
                com.example.wizdam.Navigation()
            }
        }
    }
}

@Composable
fun Navigation() {
    val navCtrl = rememberNavController()
    NavHost(navController = navCtrl, startDestination = "splash_screen") {
        composable("splash_screen") {
            SplashScreen(navController = navCtrl)
        }
        composable("main_screen") {
            // changed to MainScreen() with start the ProfilePage()
            MainScreen()
        }
    }
}
@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.3f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        delay(2000L)
        //untuk navigate setelah delay
        navController.navigate("main_screen")
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.wizdam),
            contentDescription = "Logo", modifier = Modifier.fillMaxSize()
        )
    }

}



