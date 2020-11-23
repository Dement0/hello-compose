package com.example.hello_compose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Providers
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.VectorAssetBuilder
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.hello_compose.domain.Artist
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
fun SetScreenContent() {
//    Border.build()
    SingerCard(
        artist = Artist(
            name = "David Bowie",
            albums = "10 albums"
        )
    )
//    SingerCard(
//        artist = Artist(
//            name = "Bon Jovi",
//            albums = "1 album"
//        )
//    )
}

@Composable
fun SingerCard(
    modifier: Modifier = Modifier,
    artist: Artist
) {
    Row(modifier = modifier
        .clickable(onClick = { /*TODO*/})
        .padding(8.dp)
        .clip(RoundedCornerShape(16.dp))
        .background(MaterialTheme.colors.background)
    ) {
        Surface(
            modifier = modifier.preferredSize(64.dp),
            shape = CircleShape,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.3f)
        ) {

        }
        Column(modifier = modifier.padding(8.dp).align(Alignment.CenterVertically)) {
            Text(text = artist.name)
            Text(
                text = artist.albums,
                modifier = modifier.wrapContentWidth(),
                style = MaterialTheme.typography.subtitle2
            )
        }
    }
}

@Preview(showBackground = true, name = "Text Preview")
@Composable
fun DefaultPreview() {
    SetScreenContent()
}
