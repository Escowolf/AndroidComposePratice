package com.example.androidcomposepratice.unit1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidcomposepratice.R
import com.example.androidcomposepratice.ui.theme.AndroidComposePraticeTheme

class TutorialJetpack : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComposePraticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Content(stringResource(R.string.title), stringResource(R.string.first_paragraph), stringResource(
                        R.string.second_paragraph
                    ))
                }
            }
        }
    }
}

@Composable
fun TextsPage(title: String, firstParagraph: String, secondParagraph: String, modifier: Modifier = Modifier) {

    Column (modifier = modifier){
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = firstParagraph,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp, 0.dp)
        )
        Text(
            text = secondParagraph,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun Content (title: String, firstParagraph: String, secondParagraph: String) {
    val image = painterResource(R.drawable.bg_compose_background)

    Column {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )

        TextsPage(
            title = title,
            firstParagraph = firstParagraph,
            secondParagraph = secondParagraph
        )
    }

}

@Preview(showBackground = true)
@Composable
fun ContentPreview() {
    AndroidComposePraticeTheme {
        Content(stringResource(R.string.title), stringResource(R.string.first_paragraph), stringResource(
            R.string.second_paragraph
        )
        )
    }
}