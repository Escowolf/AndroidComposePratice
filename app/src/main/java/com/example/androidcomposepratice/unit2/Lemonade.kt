package com.example.androidcomposepratice.unit2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidcomposepratice.R
import com.example.androidcomposepratice.unit2.ui.theme.AndroidComposePraticeTheme

class Lemonade : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComposePraticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeSteps()
                }
            }
        }
    }
}

@Composable
fun LemonadeSteps(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    val image = when (result) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> {
            R.drawable.lemon_restart
        }
    }

    val string = when (result) {
        1 -> R.string.lemon_tree
        2 -> R.string.lemon
        3 -> R.string.glass_of_lemonade
        else -> {
            R.string.empty_glass
        }
    }

    Column (verticalArrangement = Arrangement.Center,
        horizontalAlignment =Alignment.CenterHorizontally) {
        Box (modifier = Modifier.align(Alignment.CenterHorizontally)){
            Button(onClick = { result = (1..4).random() },
                modifier = Modifier.padding(32.dp)
                    .width(250.dp)
                    .height(250.dp)) {
            }
            Image(
                painter = painterResource(image),
                contentDescription = image.toString(),
                modifier = Modifier.wrapContentSize()

            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(string),
            fontSize = 18.sp
        )
    }

}

@Preview(showBackground = true)
@Composable
fun LemonadePreview() {
    AndroidComposePraticeTheme {
        LemonadeSteps()
    }
}