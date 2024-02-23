package com.example.androidcomposepratice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidcomposepratice.ui.theme.AndroidComposePraticeTheme

class TaskManager : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComposePraticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ContentTask(
                        phraseOne = stringResource(R.string.phrase_one), phraseTwo = stringResource(
                            R.string.phrase_two
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun ContentTaskText(phraseOne: String, phraseTwo: String) {
    Text(
        text = phraseOne,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(0.dp, 24.dp, 0.dp,8.dp)
    )
    Text(
        text = phraseTwo,
        fontSize = 16.sp
    )
}

@Composable
fun ContentTask(phraseOne: String, phraseTwo: String) {
    val image = painterResource(R.drawable.ic_task_completed)
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = image,
            contentDescription = null
        )
        ContentTaskText(
            phraseOne = phraseOne,
            phraseTwo = phraseTwo
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ContentTaskPrewview() {
    AndroidComposePraticeTheme {
        ContentTask(
            phraseOne = stringResource(R.string.phrase_one), phraseTwo = stringResource(
                R.string.phrase_two
            )
        )
    }
}