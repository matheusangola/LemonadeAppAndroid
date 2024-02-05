package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeStory("Android")
                }
            }
        }
    }
}

@Composable
fun LemonadeStory(name: String, modifier: Modifier = Modifier) {
    var storyNumber by remember{ mutableStateOf(1) }
    var counter by remember{ mutableStateOf(1) }
    var imageResource = when(storyNumber) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    var titleResource = when(storyNumber) {
        1 -> R.string.title1
        2 -> R.string.title2
        3 -> R.string.title3
        else -> R.string.title4
    }
    Box(modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 650.dp).background(Color.Yellow)) {
        Text(
            text = "Lemonade", fontSize = 22.sp, fontWeight = Bold, modifier = Modifier.padding(135.dp, 65.dp, 16.dp, 10.dp)
        )
    }
    Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = imageResource), contentDescription = stringResource(R.string.Description1), Modifier.clip(RoundedCornerShape(20.dp)) .background(Color(0xFFC3ECD2))
            .clickable {
            if (storyNumber == 1) {
                counter = (1..3).random()
                storyNumber++
                titleResource++
            } else if (storyNumber == 2) {
                if (counter == 0) {
                    storyNumber++
                    titleResource++
                } else {
                    counter--
                }
            } else if (storyNumber == 3) {
                storyNumber++
                titleResource++
            } else if (storyNumber == 4) {
                    storyNumber = 1
                    titleResource = 1
                }


        })
        Text( modifier = Modifier.padding(16.dp),
            text = stringResource(titleResource), fontSize = 18.sp
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LemonadeStory("Android")
        }
    }
}