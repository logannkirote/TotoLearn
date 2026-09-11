@file:OptIn(com.google.accompanist.permissions.ExperimentalPermissionsApi::class)
package com.example.totolearn

import android.os. Bundle
import androidx . activity . ComponentActivity
import androidx . activity . compose . setContent
import androidx . activity . enableEdgeToEdge
import androidx . compose . foundation . layout . *
import androidx . compose . material3 . *
import androidx . compose . runtime . Composable
import androidx . compose . ui . Alignment
import androidx . compose . ui . Modifier
import androidx . compose . ui . graphics . Color
import androidx . compose . ui . text . font . FontWeight
import androidx . compose . ui . unit . dp
import androidx . compose . ui . unit . sp
import androidx . navigation . NavController
import androidx . navigation . compose . NavHost
import androidx . navigation . compose . composable
import androidx . navigation . compose . rememberNavController
import androidx.compose.runtime.*
import androidx.compose.animation.AnimatedVisibility
import android.speech.tts.TextToSpeech
import java.util.Locale
import android.content.Intent
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import android.media.MediaPlayer
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.os.Handler
import android.os.Looper
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.clickable
import androidx.compose.ui.text.style.TextAlign

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "start") {

                composable("start") {
                    StartScreen(navController)
                }

                composable("activities") {
                    ActivityScreen(navController)
                }

                composable("MathQuiz") {
                    MathQuiz(navController)
                }

                composable("vocabularyGame") {
                    VocabularyGameScreen(navController)
                }
                composable("activitiesSwahili") {
                    ActivityScreenSwahili(navController)
                }
                composable("Hesabu") {
                    HesabuScreen(navController)
                }
                composable("Maneno") {
                    ManenoScreen(navController)
                }
                composable("progress") {
                    ProgressScreen(navController)
                }
                composable("practiceEnglish") {
                    PracticeEnglishScreen(navController)
                }

                composable("practiceSwahili") {
                    PracticeSwahiliScreen(navController)
                }
                composable("mathProgress") {
                    MathProgressScreen(navController)
                }

                composable("hesabuProgress") {
                    HesabuProgressScreen(navController)
                }

            }
        }
    }
}

@Composable
fun StartScreen(navController: NavController) {

    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.background),
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
                text = "Choose an Activity/ Chagua shughuli",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1565C0)
            )

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = { navController.navigate("activities") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF7043)),
                modifier = Modifier.height(60.dp).width(220.dp)
            ) {
                Text("Start Learning", fontSize = 20.sp, color = Color.White)
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { navController.navigate("activitiesSwahili") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF81C784)),
                modifier = Modifier.height(60.dp).width(220.dp)
            ) {
                Text("Anza Kusoma", fontSize = 20.sp, color = Color.White)
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                navController.navigate("progress")
            }) {
                Text("Child Progress")
            }

        }
    }
}

@Composable
fun ActivityScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Select Game",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1565C0)
            )
            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = { navController.navigate("MathQuiz") },
                modifier = Modifier.height(60.dp).width(220.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF64B5F6))
            ) {
                Text("Numbers Game", fontSize = 18.sp, color = Color.White)
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { navController.navigate("vocabularyGame") },
                modifier = Modifier.height(60.dp).width(220.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF7043))
            ) {
                Text("Vocabulary Game", fontSize = 18.sp, color = Color.White)
            }
        }
    }
}
@Composable
fun ActivityScreenSwahili(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {


        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Chagua Mchezo",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2E7D32)
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = { navController.navigate("Hesabu") },
                modifier = Modifier.height(60.dp).width(220.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF64B5F6))
            ) {
                Text("Hesabu", fontSize = 18.sp, color = Color.White)
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { navController.navigate("Maneno") },
                modifier = Modifier.height(60.dp).width(220.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF7043))
            ) {
                Text("Maneno", fontSize = 18.sp, color = Color.White)
            }
        }
    }
}



@Composable
fun MathQuiz(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.background3),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        val numbers = (1..10).toList()
        val numberWords = listOf(
            "one","two","three","four","five",
            "six","seven","eight","nine","ten"
        )

        val numberImages = listOf(
            R.drawable.num_1, R.drawable.num_2, R.drawable.num_3, R.drawable.num_4, R.drawable.num_5,
            R.drawable.num_6, R.drawable.num_7, R.drawable.num_8, R.drawable.num_9, R.drawable.num_10
        )

        var currentIndex by remember { mutableIntStateOf(0) }
        var feedback by remember { mutableStateOf("") }
        var score by remember { mutableIntStateOf(0) }
        var stars by remember { mutableIntStateOf(0) }
        var showConfetti by remember { mutableStateOf(false) }

        fun moveNext() {
            if (currentIndex < numbers.size - 1) {
                currentIndex++
            } else {
                currentIndex = numbers.size
            }
        }

        val context = LocalContext.current
        val progressManager = remember { ProgressManager(context) }

        var tts by remember { mutableStateOf<TextToSpeech?>(null) }
        LaunchedEffect(Unit) {
            tts = TextToSpeech(context) { status ->
                if (status == TextToSpeech.SUCCESS) tts?.language = Locale.US
            }
        }
        if (currentIndex >= numbers.size) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,

            ) {
                Text("🎉 Great Job!", fontSize = 40.sp,
                    color = Color.Blue, textAlign = TextAlign.Center)
                Text("You finished all!",fontSize = 50.sp,
                    color = Color.Blue, textAlign = TextAlign.Center)

                Button(onClick = { navController.popBackStack() }) {
                    Text("Back")
                }
            }
            return
        }



        DisposableEffect(Unit) {
            onDispose { tts?.stop(); tts?.shutdown() }
        }

        val correctSound = remember { MediaPlayer.create(context, R.raw.yaaay) }
        val wrongSound = remember { MediaPlayer.create(context, R.raw.tryagain) }

        val speechRecognizer = remember { SpeechRecognizer.createSpeechRecognizer(context) }
        val speechIntent = remember {
            Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
                putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
                putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-US")
            }
        }

        speechRecognizer.setRecognitionListener(object : RecognitionListener {
            override fun onReadyForSpeech(params: Bundle?) {}
            override fun onBeginningOfSpeech() {}
            override fun onRmsChanged(rmsdB: Float) {}
            override fun onBufferReceived(buffer: ByteArray?) {}
            override fun onEndOfSpeech() {}
            override fun onPartialResults(partialResults: Bundle?) {}
            override fun onEvent(eventType: Int, params: Bundle?) {}

            override fun onError(error: Int) {
                feedback = "Try Again ❌"
                wrongSound.start()
                progressManager.saveWrongNumber(currentIndex)
                Handler(Looper.getMainLooper()).postDelayed({
                    moveNext()
                    feedback = ""
                }, 1000)
            }

            override fun onResults(results: Bundle?) {
                val spokenText = results
                    ?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                    ?.firstOrNull()
                    ?.lowercase()
                    ?.trim()

                if (spokenText != null && spokenText.contains(numberWords[currentIndex])) {
                    feedback = "Correct! 🎉"
                    showConfetti = true
                    correctSound.start()
                    progressManager.saveCorrectAnswer()
                    score = progressManager.getScore()
                    if (score % 5 == 0) {
                        stars++
                        progressManager.saveStar()
                    }


                } else {
                    feedback = "Try Again ❌"
                    wrongSound.start()
                    progressManager.saveWrongNumber(currentIndex)

                }
                Handler(Looper.getMainLooper()).postDelayed({
                    showConfetti = false
                    moveNext()
                    feedback = ""

                }, 1200)
            }
        })

        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text("Progress: ${currentIndex + 1} / ${numbers.size}", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(10.dp))

            Image(painter = painterResource(id = numberImages[currentIndex]),
                contentDescription = numberWords[currentIndex],
                modifier = Modifier.size(150.dp))

            Spacer(modifier = Modifier.height(20.dp))
            Text(numberWords[currentIndex].uppercase(), fontSize = 100.sp,
                fontWeight = FontWeight.Bold, color = Color(0xFF1565C0))
            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = { tts?.speak(numberWords[currentIndex], TextToSpeech.QUEUE_FLUSH, null, null) },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF64B5F6)),
                modifier = Modifier.height(60.dp).width(220.dp)) {
                Text("🔊 Hear Number", fontSize = 18.sp, color = Color.White)
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = { feedback = ""; speechRecognizer.startListening(speechIntent) }) {
                Text("Tap & Say Number")
            }

            Spacer(modifier = Modifier.height(20.dp))

            AnimatedVisibility(visible = feedback.isNotEmpty()) {
                Text(feedback, fontSize = 28.sp, color = if (feedback.contains("Correct")) Color.Green else Color.Red)
            }

            AnimatedVisibility(visible = showConfetti) {
                Text("🎉🎊", fontSize = 50.sp)
            }

            Spacer(modifier = Modifier.height(20.dp))
            Text("Score: $score", fontSize = 22.sp)
            Spacer(modifier = Modifier.height(30.dp))
            Text("Stars: $stars ⭐", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFFC107))
            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = { navController.popBackStack() }) { Text("Back") }
        }

    }
}


@Composable
fun VocabularyGameScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {

        Image(painter = painterResource(id = R.drawable.background3),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize())

        val words = listOf("apple", "ball", "cat", "dog", "egg", "fish", "goat", "hat", "ice", "jug",
            "kite", "lion", "monkey", "nest", "orange", "pig", "queen", "rabbit", "sun", "tree",
            "umbrella", "van", "water", "xylophone", "yoghurt", "zebra")
        val wordImages = listOf(
            R.drawable.apple, R.drawable.ball, R.drawable.cat, R.drawable.dog, R.drawable.egg, R.drawable.fish,
            R.drawable.goat, R.drawable.hat, R.drawable.ice, R.drawable.jug, R.drawable.kite, R.drawable.lion,
            R.drawable.monkey, R.drawable.nest, R.drawable.orange, R.drawable.pig, R.drawable.queen,
            R.drawable.rabbit, R.drawable.sun, R.drawable.tree, R.drawable.umbrella, R.drawable.van,
            R.drawable.water, R.drawable.xylophone, R.drawable.yoghurt, R.drawable.zebra
        )
        val wordSoundsVoc = listOf(
            R.raw.apple, R.raw.ball, R.raw.cat, R.raw.dog, R.raw.egg, R.raw.fish, R.raw.goat, R.raw.hat,
            R.raw.ice, R.raw.jug, R.raw.kite, R.raw.lion, R.raw.monkey, R.raw.nest, R.raw.orange, R.raw.pig,
            R.raw.queen, R.raw.rabbit, R.raw.sun, R.raw.tree, R.raw.umbrella, R.raw.van, R.raw.water,
            R.raw.xylophone, R.raw.yoghurt, R.raw.zebra
        )

        var currentIndex by remember { mutableIntStateOf(0) }
        var feedback by remember { mutableStateOf("") }
        var score by remember { mutableIntStateOf(0) }
        var stars by remember { mutableIntStateOf(0) }
        var showConfetti by remember { mutableStateOf(false) }
        fun moveNext() {
            if (currentIndex < words.size - 1) {
                currentIndex++
            } else {
                currentIndex = words.size
            }
        }

        val context = LocalContext.current
        val progressManager = remember { ProgressManager(context) }
        if (currentIndex >= words.size) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("🎉 Great Job!", fontSize = 40.sp,
                    color = Color.Blue, textAlign = TextAlign.Center)
                Text("You finished all!", fontSize = 50.sp,
                    color = Color.Blue, textAlign = TextAlign.Center)

                Button(onClick = { navController.popBackStack() }) {
                    Text("Back")
                }
            }
            return
        }
        var mediaPlayer by remember { mutableStateOf<MediaPlayer?>(null) }
        val correctSound = remember { MediaPlayer.create(context, R.raw.yaaay) }
        val wrongSound = remember { MediaPlayer.create(context, R.raw.tryagain) }

        val speechRecognizer = remember { SpeechRecognizer.createSpeechRecognizer(context) }
        val speechIntent = remember {
            Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
                putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
                putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-US")
            }
        }


        speechRecognizer.setRecognitionListener(object : RecognitionListener {
            override fun onReadyForSpeech(params: Bundle?) {}
            override fun onBeginningOfSpeech() {}
            override fun onRmsChanged(rmsdB: Float) {}
            override fun onBufferReceived(buffer: ByteArray?) {}
            override fun onEndOfSpeech() {}
            override fun onPartialResults(partialResults: Bundle?) {}
            override fun onEvent(eventType: Int, params: Bundle?) {}

            override fun onError(error: Int) {
                feedback = "Try Again ❌"
                wrongSound.start()
                progressManager.saveWrongEnglish(currentIndex)
                Handler(Looper.getMainLooper()).postDelayed({
                    moveNext()
                    feedback = ""
                }, 1000)
            }

            override fun onResults(results: Bundle?) {
                val spokenText = results
                    ?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                    ?.firstOrNull()
                    ?.lowercase()
                    ?.trim()
                val expectedWord = words[currentIndex]
                if (spokenText != null && spokenText.contains(expectedWord)) {
                    feedback = "Good Job 🎉"
                    showConfetti = true
                    correctSound.start()
                    progressManager.saveCorrectAnswer()
                    score = progressManager.getScore()
                    if (score % 5 == 0) {
                        stars++
                        progressManager.saveStar()
                    }

                } else {
                    feedback = "Try Again ❌"
                    wrongSound.start()
                    progressManager.saveWrongEnglish(currentIndex)
                }
                Handler(Looper.getMainLooper()).postDelayed({
                    showConfetti = false
                    moveNext()
                    feedback = ""

                }, 1200)

            }
        })

        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text("Progress: ${currentIndex + 1} / ${words.size}", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(10.dp))

            Image(painter = painterResource(id = wordImages[currentIndex]),
                contentDescription = words[currentIndex],
                modifier = Modifier.size(150.dp))

            Spacer(modifier = Modifier.height(20.dp))
            Text(words[currentIndex].uppercase(), fontSize = 60.sp, fontWeight = FontWeight.Bold,
                color = Color(0xFF1565C0))
            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    try {
                        mediaPlayer?.stop()
                        mediaPlayer?.release()
                        mediaPlayer = null
                        mediaPlayer = MediaPlayer.create(context, wordSoundsVoc[currentIndex])
                        mediaPlayer?.start()
                        mediaPlayer?.setOnCompletionListener {
                            it.release()
                            mediaPlayer = null
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF64B5F6)),
                modifier = Modifier.height(60.dp).width(220.dp)
            ) {
                Text("🔊 Hear Word", fontSize = 18.sp, color = Color.White)
            }
            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = { feedback = ""; speechRecognizer.startListening(speechIntent) }) {
                Text("Tap & Say Word")
            }

            Spacer(modifier = Modifier.height(20.dp))
            AnimatedVisibility(visible = feedback.isNotEmpty()) {
                Text(feedback, fontSize = 28.sp, color = if (feedback.contains("Good"))
                    Color.Green else Color.Red)
            }
            AnimatedVisibility(visible = showConfetti) { Text("🎉🎊", fontSize = 50.sp) }

            Spacer(modifier = Modifier.height(20.dp))
            Text("Score: $score", fontSize = 22.sp)
            Spacer(modifier = Modifier.height(30.dp))
            Text("Stars: $stars ⭐", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFFC107))
            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = { navController.popBackStack() }) { Text("Back") }
        }

    }
}
@Composable
fun HesabuScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {

        Image(painter = painterResource(id = R.drawable.background3),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize())

        val nambari = listOf("moja", "mbili", "tatu", "nne", "tano",
            "sita", "saba", "nane", "tisa", "kumi")
        val nambariPicha = listOf(
            R.drawable.num_1, R.drawable.num_2, R.drawable.num_3, R.drawable.num_4, R.drawable.num_5,
            R.drawable.num_6, R.drawable.num_7, R.drawable.num_8, R.drawable.num_9, R.drawable.num_10
            )
        val nambariSauti = listOf(
            R.raw.moja, R.raw.mbili, R.raw.tatu, R.raw.nne, R.raw.tano, R.raw.sita, R.raw.saba,
            R.raw.nane, R.raw.tisa, R.raw.kumi)

        var currentIndex by remember { mutableIntStateOf(0) }
        var feedback by remember { mutableStateOf("") }
        var score by remember { mutableIntStateOf(0) }
        var stars by remember { mutableIntStateOf(0) }
        var showConfetti by remember { mutableStateOf(false) }
        fun moveNext() {
            if (currentIndex < nambari.size - 1) {
                currentIndex++
            } else {
                currentIndex = nambari.size
            }
        }

        val context = LocalContext.current
        val progressManager = remember { ProgressManager(context) }
        if (currentIndex >= nambari.size) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center

            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("🎉 Hongera!", fontSize = 40.sp,
                        color = Color.Blue, textAlign = TextAlign.Center)
                    Text("Umekamilisha nambari zote!!!", fontSize = 50.sp,
                        color = Color.Blue, textAlign = TextAlign.Center)

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(onClick = { navController.popBackStack() }) {
                        Text("Rudi")
                    }
                }
            }
            return
        }
        var mediaPlayer by remember { mutableStateOf<MediaPlayer?>(null) }
        val correctSound = remember { MediaPlayer.create(context, R.raw.yaaay) }
        val wrongSound = remember { MediaPlayer.create(context, R.raw.wrong) }

        val speechRecognizer = remember { SpeechRecognizer.createSpeechRecognizer(context) }
        val speechIntent = remember {
            Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
                putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
                putExtra(RecognizerIntent.EXTRA_LANGUAGE, "sw")
            }
        }

        speechRecognizer.setRecognitionListener(object : RecognitionListener {
            override fun onReadyForSpeech(params: Bundle?) {}
            override fun onBeginningOfSpeech() {}
            override fun onRmsChanged(rmsdB: Float) {}
            override fun onBufferReceived(buffer: ByteArray?) {}
            override fun onEndOfSpeech() {}
            override fun onPartialResults(partialResults: Bundle?) {}
            override fun onEvent(eventType: Int, params: Bundle?) {}

            override fun onError(error: Int) {
                feedback = "Jaribu tena ❌"
                wrongSound.start()
                progressManager.saveWrongHesabu(currentIndex)

                Handler(Looper.getMainLooper()).postDelayed({
                    moveNext()
                    feedback = ""
                }, 1000)
            }

            override fun onResults(results: Bundle?) {
                val spokenText = results
                    ?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                    ?.firstOrNull()
                    ?.lowercase()
                    ?.trim()
                val expectedWord = nambari[currentIndex]
                if (spokenText != null && spokenText.contains(expectedWord)) {
                    feedback = "Sahihi! 🎉"
                    showConfetti = true
                    correctSound.start()

                    progressManager.saveCorrectAnswer()
                    score = progressManager.getScore()
                    if (score % 5 == 0) {
                        stars++
                        progressManager.saveStar()
                    }

                } else {
                    feedback = "Jaribu tena ❌"
                    wrongSound.start()
                    progressManager.saveWrongHesabu(currentIndex)
                }
                Handler(Looper.getMainLooper()).postDelayed({
                    moveNext()
                    showConfetti = false
                    feedback = ""
                }, 1200)
            }
        })

        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text("Maendeleo: ${currentIndex + 1} / ${nambari.size}", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(10.dp))

            Image(painter = painterResource(id = nambariPicha[currentIndex]),
                contentDescription = nambari[currentIndex],
                modifier = Modifier.size(150.dp))

            Spacer(modifier = Modifier.height(20.dp))
            Text(nambari[currentIndex].uppercase(), fontSize = 60.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1565C0))
            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    try {
                        mediaPlayer?.stop()
                        mediaPlayer?.release()
                        mediaPlayer = null
                        mediaPlayer = MediaPlayer.create(context, nambariSauti[currentIndex])
                        mediaPlayer?.start()
                        mediaPlayer?.setOnCompletionListener {
                            it.release()
                            mediaPlayer = null
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF64B5F6)),
                modifier = Modifier.height(60.dp).width(220.dp)
            ) {
                Text("🔊 Skia Nambari", fontSize = 18.sp, color = Color.White)
            }

            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { feedback = ""; speechRecognizer.startListening(speechIntent) }) {
                Text("Gusa na Sema Nambari")
            }

            Spacer(modifier = Modifier.height(20.dp))
            AnimatedVisibility(visible = feedback.isNotEmpty()) {
                Text(feedback, fontSize = 28.sp, color = if (feedback.contains("Sahihi")) Color.Green else Color.Red)
            }
            AnimatedVisibility(visible = showConfetti) { Text("🎉🎊", fontSize = 50.sp) }

            Spacer(modifier = Modifier.height(20.dp))
            Text("Alama: $score", fontSize = 22.sp)
            Spacer(modifier = Modifier.height(30.dp))
            Text("Nyota: $stars ⭐", fontSize = 24.sp, fontWeight = FontWeight.Bold,
                color = Color(0xFFFFC107))
            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = { navController.popBackStack() }) { Text("Rudi") }
        }

    }
}


@Composable
fun ManenoScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {

        Image(painter = painterResource(id = R.drawable.background3),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize())

        val maneno = listOf("anga", "baba", "chura", "dawa", "embe", "furaha", "gari", "harusi",
            "imba", "jua", "kitabu", "lala", "mbwa", "nyota", "ofisi", "paka", "rafiki",
            "samaki", "tufaha", "ua", "vaa", "watoto", "yai", "zabibu")
        val manenoPicha = listOf(
            R.drawable.anga, R.drawable.baba, R.drawable.chura, R.drawable.dawa, R.drawable.embe,
            R.drawable.furaha, R.drawable.car, R.drawable.harusi, R.drawable.imba, R.drawable.sun,
            R.drawable.book, R.drawable.lala, R.drawable.dog, R.drawable.nyota, R.drawable.ofisi,
            R.drawable.cat, R.drawable.rafiki, R.drawable.fish, R.drawable.apple, R.drawable.ua,
            R.drawable.vaa, R.drawable.watoto, R.drawable.egg, R.drawable.zabibu)
        val manenoSauti = listOf(
            R.raw.anga, R.raw.baba, R.raw.chura, R.raw.dawa, R.raw.embe, R.raw.furaha, R.raw.gari,
            R.raw.harusi, R.raw.imba, R.raw.jua, R.raw.kitabu, R.raw.lala, R.raw.mbwa, R.raw.nyota,
            R.raw.ofisi, R.raw.paka, R.raw.rafiki, R.raw.samaki, R.raw.tufaha, R.raw.ua, R.raw.vaa,
            R.raw.watoto,  R.raw.yai, R.raw.zabibu)

        var currentIndex by remember { mutableIntStateOf(0) }
        var feedback by remember { mutableStateOf("") }
        var score by remember { mutableIntStateOf(0) }
        var stars by remember { mutableIntStateOf(0) }
        var showConfetti by remember { mutableStateOf(false) }
        fun moveNext() {
            if (currentIndex < maneno.size - 1) {
                currentIndex++
            } else {
                currentIndex = maneno.size
            }
        }

        val context = LocalContext.current
        val progressManager = remember { ProgressManager(context) }
        if (currentIndex >= maneno.size) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center

            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("🎉 Hongera!", fontSize = 40.sp,
                        color = Color.Blue, textAlign = TextAlign.Center)
                    Text("Umekamilisha maneno yote!!!", fontSize = 50.sp,
                        color = Color.Blue, textAlign = TextAlign.Center)

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(onClick = { navController.popBackStack() }) {
                        Text("Rudi")
                    }
                }
            }
            return
        }
        var mediaPlayer by remember { mutableStateOf<MediaPlayer?>(null) }
        val correctSound = remember { MediaPlayer.create(context, R.raw.yaaay) }
        val wrongSound = remember { MediaPlayer.create(context, R.raw.wrong) }

        val speechRecognizer = remember { SpeechRecognizer.createSpeechRecognizer(context) }
        val speechIntent = remember {
            Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
                putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
                putExtra(RecognizerIntent.EXTRA_LANGUAGE, "sw")
            }
        }

        speechRecognizer.setRecognitionListener(object : RecognitionListener {
            override fun onReadyForSpeech(params: Bundle?) {}
            override fun onBeginningOfSpeech() {}
            override fun onRmsChanged(rmsdB: Float) {}
            override fun onBufferReceived(buffer: ByteArray?) {}
            override fun onEndOfSpeech() {}
            override fun onPartialResults(partialResults: Bundle?) {}
            override fun onEvent(eventType: Int, params: Bundle?) {}

            override fun onError(error: Int) {
                feedback = "Jaribu tena ❌"
                wrongSound.start()
                progressManager.saveWrongSwahili(currentIndex)

                Handler(Looper.getMainLooper()).postDelayed({
                    moveNext()
                    feedback = ""
                }, 1000)
            }

            override fun onResults(results: Bundle?) {
                val spokenText = results
                    ?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                    ?.firstOrNull()
                    ?.lowercase()
                    ?.trim()
                val expectedWord = maneno[currentIndex]
                if (spokenText != null && spokenText.contains(expectedWord)) {
                    feedback = "Sahihi! 🎉"
                    showConfetti = true
                    correctSound.start()

                    progressManager.saveCorrectAnswer()
                    score = progressManager.getScore()
                    if (score % 5 == 0) {
                        stars++
                        progressManager.saveStar()
                    }

                } else {
                    feedback = "Jaribu tena ❌"
                    wrongSound.start()
                    progressManager.saveWrongSwahili(currentIndex)
                }
                Handler(Looper.getMainLooper()).postDelayed({
                    moveNext()
                    showConfetti = false
                    feedback = ""
                }, 1200)
            }
        })

        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text("Maendeleo: ${currentIndex + 1} / ${maneno.size}", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(10.dp))

            Image(painter = painterResource(id = manenoPicha[currentIndex]),
                contentDescription = maneno[currentIndex],
                modifier = Modifier.size(150.dp))

            Spacer(modifier = Modifier.height(20.dp))
            Text(maneno[currentIndex].uppercase(), fontSize = 60.sp, fontWeight = FontWeight.Bold,
                color = Color(0xFF1565C0))
            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    try {
                        mediaPlayer?.stop()
                        mediaPlayer?.release()
                        mediaPlayer = null
                        mediaPlayer = MediaPlayer.create(context, manenoSauti[currentIndex])
                        mediaPlayer?.start()
                        mediaPlayer?.setOnCompletionListener {
                            it.release()
                            mediaPlayer = null
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF64B5F6)),
                modifier = Modifier.height(60.dp).width(220.dp)
            ) {
                Text("🔊 Skia Neno", fontSize = 18.sp, color = Color.White)
            }

            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { feedback = ""; speechRecognizer.startListening(speechIntent) }) {
                Text("Gusa na Sema Neno")
            }

            Spacer(modifier = Modifier.height(20.dp))
            AnimatedVisibility(visible = feedback.isNotEmpty()) {
                Text(feedback, fontSize = 28.sp, color = if (feedback.contains("Sahihi")) Color.Green else Color.Red)
            }
            AnimatedVisibility(visible = showConfetti) { Text("🎉🎊", fontSize = 50.sp) }

            Spacer(modifier = Modifier.height(20.dp))
            Text("Alama: $score", fontSize = 22.sp)
            Spacer(modifier = Modifier.height(30.dp))
            Text("Nyota: $stars ⭐", fontSize = 24.sp, fontWeight = FontWeight.Bold,
                color = Color(0xFFFFC107))
            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = { navController.popBackStack() }) { Text("Rudi") }
        }

    }
}
@Composable
fun ProgressScreen(navController: NavController) {

    val context = LocalContext.current
    val progressManager = remember { ProgressManager(context) }
    var stars by remember { mutableIntStateOf(progressManager.getStars()) }
    Text(
        text = "Stars: $stars ⭐",
        fontSize = 24.sp
    )


    var score by remember { mutableIntStateOf(progressManager.getScore()) }

    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Child Progress",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Total Score: $score ⭐",
                fontSize = 24.sp
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = {
                    progressManager.resetScore()
                    score = progressManager.getScore()
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ) {
                Text("Reset Progress", color = Color.White)
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = { navController.popBackStack() }) {
                Text("Back")
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                navController.navigate("practiceEnglish")
            }) {
                Text("Practice English")
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = {
                navController.navigate("practiceSwahili")
            }) {
                Text("Fanya Mazoezi ya Kiswahili")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {
                navController.navigate("mathProgress")
            }) {
                Text("Practice Math ")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {
                navController.navigate("hesabuProgress")
            }) {
                Text("Fanya mazoezi ya Hesabu")
            }



        }
    }
}

@Composable
fun MathProgressScreen(navController: NavController) {
    val context = LocalContext.current
    val progressManager = ProgressManager(context)
    val wrongIndices = progressManager.getWrongNumbers()

    val numbers = listOf(
        "one","two","three","four","five",
        "six","seven","eight","nine","ten"
    )

    val numberImages = listOf(
        R.drawable.num_1, R.drawable.num_2, R.drawable.num_3, R.drawable.num_4, R.drawable.num_5,
        R.drawable.num_6, R.drawable.num_7, R.drawable.num_8, R.drawable.num_9, R.drawable.num_10
    )

    val tts = remember { TextToSpeech(context) {} }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background3),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)

        ) {


            Spacer(modifier = Modifier.height(16.dp))

            if (wrongIndices.isEmpty()) {
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Text("No mistakes 🎉 Well Done!!!!!", fontSize = 50.sp,
                        color = Color.Blue, textAlign = TextAlign.Center)
                }
            } else {
                LazyVerticalGrid(columns = GridCells.Fixed(2),
                modifier = Modifier.weight(1f)) {
                    items(wrongIndices) { index ->
                        Column(
                            modifier = Modifier
                                .padding(10.dp)
                                .clickable {
                                    tts.speak(numbers[index], TextToSpeech.QUEUE_FLUSH, null, null)
                                },
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = numberImages[index]),
                                contentDescription = null,
                                modifier = Modifier.size(120.dp)
                            )
                            Text(numbers[index], color = Color.Blue)
                        }
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))

                Button(onClick = { progressManager.clearNumbers()
                    navController.popBackStack()},
                    modifier = Modifier.fillMaxWidth()) {
                    Text("Clear Math Progress")
                }
            }


        }
    }
}

@Composable
fun HesabuProgressScreen(navController: NavController) {
    val context = LocalContext.current
    val progressManager = ProgressManager(context)
    val wrongIndices = progressManager.getWrongHesabu()

    val numbers = listOf(
        "moja","mbili","tatu","nne","tano",
        "sita","saba","nane","tisa","kumi"
    )

    val numberImages = listOf(
        R.drawable.num_1, R.drawable.num_2, R.drawable.num_3, R.drawable.num_4, R.drawable.num_5,
        R.drawable.num_6, R.drawable.num_7, R.drawable.num_8, R.drawable.num_9, R.drawable.num_10
    )

    val numberSounds = listOf(
        R.raw.moja, R.raw.mbili, R.raw.tatu, R.raw.nne, R.raw.tano,
        R.raw.sita, R.raw.saba, R.raw.nane, R.raw.tisa, R.raw.kumi
    )

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background3),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {


            Spacer(modifier = Modifier.height(16.dp))

            if (wrongIndices.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Hakuna makosa 🎉 Swadakta!!!!!", fontSize = 50.sp,
                        color = Color.Blue, textAlign = TextAlign.Center)
                }
            } else {
                LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                    items(wrongIndices) { index ->
                        Column(
                            modifier = Modifier
                                .padding(10.dp)
                                .clickable {
                                    val mediaPlayer = MediaPlayer.create(context, numberSounds[index])
                                    mediaPlayer.start()
                                },
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = numberImages[index]),
                                contentDescription = null,
                                modifier = Modifier.size(120.dp)
                            )
                            Text(numbers[index], color = Color.Blue)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = { progressManager.clearHesabu()
                navController.popBackStack()}) {
                Text("Futa Makosa")
            }
        }
    }
}

@Composable
fun PracticeEnglishScreen(navController: NavController) {
    val context = LocalContext.current
    val progressManager = ProgressManager(context)
    val wrongIndices = progressManager.getWrongEnglish()

    val englishWords = listOf(
        "apple", "ball", "cat", "dog", "egg", "fish", "goat", "hat", "ice", "jug",
        "kite", "lion", "monkey", "nest", "orange", "pig", "queen", "rabbit", "sun", "tree",
        "umbrella", "van", "water", "xylophone", "yoghurt", "zebra"
    )
    val englishImages = listOf(
        R.drawable.apple, R.drawable.ball, R.drawable.cat, R.drawable.dog, R.drawable.egg,
        R.drawable.fish, R.drawable.goat, R.drawable.hat, R.drawable.ice, R.drawable.jug,
        R.drawable.kite, R.drawable.lion, R.drawable.monkey, R.drawable.nest, R.drawable.orange,
        R.drawable.pig, R.drawable.queen, R.drawable.rabbit, R.drawable.sun, R.drawable.tree,
        R.drawable.umbrella, R.drawable.van, R.drawable.water, R.drawable.xylophone,
        R.drawable.yoghurt, R.drawable.zebra
    )

    val englishSounds = listOf(
        R.raw.apple, R.raw.ball, R.raw.cat, R.raw.dog, R.raw.egg, R.raw.fish,
        R.raw.goat, R.raw.hat, R.raw.ice, R.raw.jug, R.raw.kite, R.raw.lion, R.raw.monkey,
        R.raw.nest, R.raw.orange, R.raw.pig, R.raw.queen, R.raw.rabbit, R.raw.sun, R.raw.tree,
        R.raw.umbrella, R.raw.van, R.raw.water, R.raw.xylophone, R.raw.yoghurt, R.raw.zebra
    )



    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background3),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Spacer(modifier = Modifier.height(16.dp))

            if (wrongIndices.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("No mistakes 🎉 Well Done!!!!", fontSize = 50.sp,
                        color = Color.Blue, textAlign = TextAlign.Center)
                }
            } else {
                LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                    items(wrongIndices) { index ->
                        Column(
                            modifier = Modifier
                                .padding(10.dp)
                                .clickable {
                                    val mediaPlayer = MediaPlayer.create(context, englishSounds[index])
                                    mediaPlayer.start()
                                },
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = englishImages[index]),
                                contentDescription = null,
                                modifier = Modifier.size(120.dp)
                            )
                            Text(englishWords[index], color = Color.Blue)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = { progressManager.clearEnglish()
                navController.popBackStack()}) {
                Text("Clear Mistakes")
            }
        }
    }
}

@Composable
fun PracticeSwahiliScreen(navController: NavController) {
    val context = LocalContext.current
    val progressManager = ProgressManager(context)
    val wrongIndices = progressManager.getWrongSwahili()

    val swahiliWords = listOf(
        "anga", "baba", "chura", "dawa", "embe", "furaha", "gari", "harusi", "imba",
        "jua", "kitabu", "lala", "mbwa", "nyota", "ofisi", "paka", "rafiki", "samaki", "tufaha",
        "ua", "vaa", "watoto", "yai", "zabibu"
    )
    val swahiliImages = listOf(
        R.drawable.anga, R.drawable.baba, R.drawable.chura, R.drawable.dawa, R.drawable.embe,
        R.drawable.furaha, R.drawable.car, R.drawable.harusi, R.drawable.imba, R.drawable.sun,
        R.drawable.book, R.drawable.lala, R.drawable.dog, R.drawable.nyota, R.drawable.ofisi,
        R.drawable.cat, R.drawable.rafiki, R.drawable.fish, R.drawable.apple, R.drawable.ua,
        R.drawable.vaa, R.drawable.watoto, R.drawable.egg, R.drawable.zabibu
    )
    val swahiliSounds = listOf(
        R.raw.anga, R.raw.baba, R.raw.chura, R.raw.dawa, R.raw.embe, R.raw.furaha,
        R.raw.gari, R.raw.harusi, R.raw.imba, R.raw.jua, R.raw.kitabu, R.raw.lala,
        R.raw.mbwa, R.raw.nyota, R.raw.ofisi, R.raw.paka, R.raw.rafiki, R.raw.samaki,
        R.raw.tufaha, R.raw.ua, R.raw.vaa, R.raw.watoto, R.raw.yai, R.raw.zabibu
    )




    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background3),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Spacer(modifier = Modifier.height(16.dp))

            if (wrongIndices.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Hakuna makosa 🎉 Swadakta!!!!",
                        fontSize = 50.sp, color = Color.Blue, textAlign = TextAlign.Center)
                }
            } else {
                LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                    items(wrongIndices) { index ->
                        Column(
                            modifier = Modifier
                                .padding(10.dp)
                                .clickable {
                                    val mediaPlayer = MediaPlayer.create(context, swahiliSounds[index])
                                    mediaPlayer.start()
                                },
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = swahiliImages[index]),
                                contentDescription = null,
                                modifier = Modifier.size(120.dp)
                            )
                            Text(swahiliWords[index], color = Color.Blue)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = { progressManager.clearSwahili()
                navController.popBackStack()}) {
                Text("Futa Makosa")
            }
        }
    }
}