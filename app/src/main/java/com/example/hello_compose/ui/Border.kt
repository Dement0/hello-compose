package com.example.hello_compose.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp

object Border {

    @Composable
    fun build() {
        Column(
            modifier = Modifier.fillMaxWidth().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BorderComponent()
            BorderBrushComponent()
        }
    }

}

@Composable
fun BorderComponent() {
    Card(
        border = BorderStroke(2.dp, Color.Black)
    ) {
        Text(
            text = "Hello Compose",
            modifier = Modifier.padding(24.dp)
        )
    }
}

@Composable
fun BorderBrushComponent() {
    Card(
        border = BorderStroke(2.dp, SolidColor(Color.Red))
    ) {
        Text(
            text = "Hello Compose",
            modifier = Modifier.padding(24.dp)
        )
    }
}