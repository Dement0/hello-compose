package com.example.hello_compose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hello_compose.domain.Artist
import com.example.hello_compose.ui.HellocomposeTheme
import dev.chrisbanes.accompanist.coil.CoilImage


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
                    .height(48.dp)
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
        CoilImage(
            data = "https://upload.wikimedia.org/wikipedia/commons/e/e8/David-Bowie_Chicago_2002-08-08_photoby_Adam-Bielawski-cropped.jpg",
            contentDescription = "image",
            contentScale = ContentScale.Fit,
            modifier = modifier.height(64.dp).padding(8.dp),
            loading = {
                Box(modifier.matchParentSize()) {
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }
            },
            error = {
                Image(
                    painter = painterResource(R.drawable.ic_error),
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )
            }
        )
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
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

@ExperimentalMaterialApi
@Preview(showBackground = true, name = "Text Preview")
@Composable
fun DefaultPreview() {
    StartApp {
        SetScreenContent(artists = artists)
    }
}
