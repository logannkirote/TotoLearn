
package com.example.totolearn

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class SplashActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val sound1 = MediaPlayer.create(this, R.raw.totokids)
        val sound2 = MediaPlayer.create(this, R.raw.toddler)


        sound1.start()
        sound1.setOnCompletionListener { mp1 ->
            mp1.release()
            sound2.start()
            sound2.setOnCompletionListener { mp2 ->
                mp2.release()

                lifecycleScope.launch {
                    startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                    finish()
                }
            }
        }


        setContent {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFFFF176)),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    // App Icon
                    Image(
                        painter = painterResource(id = R.drawable.icon2),
                        contentDescription = "App Icon",
                        modifier = Modifier.size(200.dp)
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "TotoLearn",
                        fontSize = 36.sp,
                        color = Color(0xFF1565C0)
                    )
                }
            }
        }
    }
}