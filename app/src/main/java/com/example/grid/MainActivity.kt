package com.example.grid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.grid.ui.theme.GridTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GridTheme {
                ListView()
            }
        }
    }
}

@Composable
fun ListView() {
    Surface(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize()
            .safeDrawingPadding()
    ) {
        ListApp(topic = topics, modifier = Modifier)
    }
}

@Composable
fun ListApp(topic: List<Topic>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.padding(2.dp)) {
        items(topic) { af ->
            ListCard(topic = af, modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun ListCard(topic: Topic, modifier: Modifier = Modifier) {
    Row{
    Column(modifier = modifier.weight(1f)) {
        Row {
            Image(
                painter = painterResource(id = topic.imageId),
                contentDescription = stringResource(id = topic.description),
                modifier = Modifier
                    .height(68.dp)
                    .width(68.dp)
                    .clip(RoundedCornerShape(8.dp))
                    ,

                contentScale = ContentScale.Fit
            )
            Column(
                modifier = Modifier
                    .background(color = colorResource(id = R.color.grid))
                    .width(120.dp)
                    .height(68.dp)
            ) {
                Text(
                    text = stringResource(id = topic.description),
                    style = MaterialTheme.typography.labelSmall,
                    maxLines = 1,
                    modifier = Modifier
                        .padding(top = 16.dp, end = 16.dp, start = 16.dp)
                )
                Row(modifier = Modifier.padding(top = 8.dp)) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_grain_24),
                        contentDescription = "icon",
                        modifier = Modifier.padding(start = 16.dp, end = 8.dp)
                    )
                    Text(
                        text = topic.num.toString()
                    )
                }
            }
        }
    }
        Column(modifier = modifier.weight(1f)) {
            Row {
                Image(
                    painter = painterResource(id = topic.imageId),
                    contentDescription = stringResource(id = topic.description),
                    modifier = Modifier
                        .height(68.dp)
                        .width(68.dp)
                        .clip(RoundedCornerShape(8.dp))
                    ,

                    contentScale = ContentScale.Fit
                )
                Column(
                    modifier = Modifier
                        .background(color = colorResource(id = R.color.grid))
                        .width(120.dp)
                        .height(68.dp)
                ) {
                    Text(
                        text = stringResource(id = topic.description),
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 1,
                        modifier = Modifier
                            .padding(top = 16.dp, end = 16.dp, start = 16.dp)
                    )
                    Row(modifier = Modifier.padding(top = 8.dp)) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_grain_24),
                            contentDescription = "icon",
                            modifier = Modifier.padding(start = 16.dp, end = 8.dp)
                        )
                        Text(
                            text = topic.num.toString()
                        )
                    }
                }
            }
        }
    }
}
