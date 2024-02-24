package com.example.androidcomposepratice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidcomposepratice.ui.theme.AndroidComposePraticeTheme

class ComposeQuadrant : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComposePraticeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QuadrantLayout()
                }
            }
        }
    }
}

@Composable
fun QuadrantMessage(
    title: String,
    message: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = message,
            fontSize = 14.sp,
            textAlign = TextAlign.Justify
        )
    }
}


@Composable
fun QuadrantLayout() {
    Column(Modifier.fillMaxSize()) {
        Row(Modifier.weight(1f)) {
            QuadrantMessage(
                title = stringResource(R.string.title_1),
                message = stringResource(R.string.message_1),
                backgroundColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(0.5f)
            )
            QuadrantMessage(
                title = stringResource(R.string.title_2),
                message = stringResource(R.string.message_2),
                backgroundColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(0.5f)
            )
        }
        Row(Modifier.weight(1f)) {
            QuadrantMessage(
                title = stringResource(R.string.title_3),
                message = stringResource(R.string.message_3),
                backgroundColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(0.5f)
            )
            QuadrantMessage(
                title = stringResource(R.string.title_4),
                message = stringResource(R.string.message_4),
                backgroundColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(0.5f)
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun QuadrantPreview() {
    AndroidComposePraticeTheme {
        QuadrantLayout()
    }
}