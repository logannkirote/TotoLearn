
package com.example.totolearn

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.layout.ContentScale
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class WelcomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WelcomeScreen()
        }

        lifecycleScope.launch {
            delay(5000)
            startActivity(Intent(this@WelcomeActivity, MainActivity::class.java))
            finish()
        }
    }
}

@Composable
fun WelcomeScreen() {

    val context = androidx.compose.ui.platform.LocalContext.current
    var displayedText by remember { mutableStateOf("") }
    val fullText = "TOTOLEARN"

    LaunchedEffect(Unit) {

        for (letter in fullText) {
            displayedText += letter
            delay(250)
        }

        val nameSound = MediaPlayer.create(context, R.raw.totolearn)
        nameSound.start()
        nameSound.setOnCompletionListener { mp1 ->
            mp1.release()

            val laughSound = MediaPlayer.create(context, R.raw.toddler)
            laughSound.start()
            laughSound.setOnCompletionListener { mp2 ->
                mp2.release()
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {


        Image(
            painter = painterResource(id = R.drawable.background2),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )


        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = displayedText,
                fontSize = 48.sp,
                color = Color.Blue
            )
        }
    }
}