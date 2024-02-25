package com.example.androidcomposepratice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidcomposepratice.ui.theme.AndroidComposePraticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComposePraticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    val background = painterResource(R.drawable.bg_businesscard)

    Box {
        Image(
            painter = background,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize(1f)
        ) {
            Greeting(
                modifier = Modifier
                    .padding(8.dp)
            )
            Contact()
        }

    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.ph_devcard)
    val developer: String = stringResource(R.string.developer)
    val description: String = stringResource(R.string.dev_description)

    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(0.5f)
            .padding(16.dp)
    ) {
        Image(
            painter = image,
            contentDescription = null,
            Modifier
                .width(150.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = developer,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .padding(16.dp, 16.dp, 16.dp, 0.dp)
                .background(color = Color.Black)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = description,
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(1.dp)
                .background(color = Color.Black)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun Contact(modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
        .fillMaxHeight(0.5f)
            .fillMaxWidth(1f)
            .padding(16.dp)
    ){
        Text(
            text = stringResource(id = R.string.phone),
            color = Color.White,
            modifier = Modifier
                .background(color = Color.Black)
                .align(Alignment.CenterHorizontally)

        )
        Text(
            text = stringResource(id = R.string.github),
            color = Color.White,
            modifier = Modifier
                .background(color = Color.Black)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = stringResource(id = R.string.email),
            color = Color.White,
            modifier = Modifier
                .background(color = Color.Black)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    AndroidComposePraticeTheme {
        BusinessCard()
    }
}