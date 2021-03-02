package com.example.hello_compose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.ExperimentalLazyDsl
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.hello_compose.domain.Artist
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
    @ExperimentalLazyDsl
    @ExperimentalMaterialApi
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

@ExperimentalMaterialApi
@ExperimentalLazyDsl
@Composable
fun SetScreenContent(artists: List<Artist>) {
    val listState = rememberLazyListState()

    LazyColumn(
        state = listState,
        modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .wrapContentWidth(align = Alignment.Start)
            .background(MaterialTheme.colors.background)
    ) {
        items(artists) {
            SingerCard(
                artist = it,
                modifier = Modifier
                    .wrapContentWidth()
                    .height(32.dp)
            )
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
        Column(
            modifier = modifier.fillMaxWidth().padding(horizontal = 8.dp)
        ) {
            Text(text = artist.name)
            Text(
                text = artist.albums,
                modifier = modifier.wrapContentWidth(),
                style = MaterialTheme.typography.subtitle2
            )
        }
    }
}

@ExperimentalLazyDsl
@ExperimentalMaterialApi
@Preview(showBackground = true, name = "Text Preview")
@Composable
fun DefaultPreview() {
    SetScreenContent(artists = artists)
}
