package com.example.hello_compose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.currentTextStyle
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.hello_compose.ui.Border
import com.example.hello_compose.ui.HellocomposeTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StartApp {
                SetScreenContent()
            }
        }
    }
}

@Composable
fun StartApp(content: @Composable () -> Unit) {
    HellocomposeTheme {
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}

@Composable
fun SetScreenContent(names: List<String> = listOf("Compose", "Reusable UI Components")) {
    val counterState = remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (name in names) {
            Greeting(name = name)
            Divider(color = Color.DarkGray)
        }

        Divider(color = Color.Transparent, thickness = 48.dp)

        Border.build()

        Counter(
            count = counterState.value,
            updateCount = { newCount -> counterState.value = newCount }
        )
    }
}

@Composable
fun Greeting(name: String) {
    Surface(color = Color.LightGray) {
        Text(
            text = "Hello $name!",
            modifier = Modifier.padding(24.dp),
            style = TextStyle(
                color = Color.White,
                textAlign = TextAlign.Center
            )
        )
    }
}

@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {
    Button(
        onClick = { updateCount(count + 1) },
        backgroundColor = if (count > 3) Color.Green else Color.Cyan,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Clicked $count times.")
    }
}

@Preview(showBackground = true, name = "Text Preview")
@Composable
fun DefaultPreview() {
    SetScreenContent()
}
