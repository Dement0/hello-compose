package com.example.hello_compose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.animation.FlingConfig
import androidx.compose.foundation.gestures.ScrollableController
import androidx.compose.foundation.gestures.scrollable
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
import androidx.compose.ui.gesture.scrollorientationlocking.Orientation
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


val artists = listOf(
    Artist(
        name = "Bon Jovi",
        albums = "1 album"
    ),
    Artist(
        name = "David Bowie",
        albums = "10 albums"
    ),
    Artist(
        name = "Pepe Ga",
        albums = "0 albums"
    ),
    Artist(
        name = "Mordor",
        albums = "22 albums"
    ),
    Artist(
        name = "Omega",
        albums = "2 albums"
    )
)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StartApp {
                SetScreenContent(artists = artists)
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
fun SetScreenContent(artists: List<Artist>) {
//    Border.build()
    Column(modifier = Modifier
        .clickable(onClick = { /*TODO*/ })
        .padding(8.dp)
        .clip(RoundedCornerShape(16.dp))
        .wrapContentWidth(align = Alignment.Start)
        .background(MaterialTheme.colors.background)
    ) {
        artists.forEach { artist ->
            SingerCard(artist = artist)
        }
    }
}

@Composable
fun SingerCard(
    modifier: Modifier = Modifier,
    artist: Artist
) {
    Row() {
        Surface(
                modifier = modifier.preferredSize(32.dp),
                shape = CircleShape,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.3f),
                elevation = 4.dp
        ) {

        }
        Column(modifier = modifier.padding(8.dp)) {
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
    SetScreenContent(artists = artists)
}
