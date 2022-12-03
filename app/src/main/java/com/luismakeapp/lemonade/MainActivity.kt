package com.luismakeapp.lemonade

import android.graphics.ColorSpace.Rgb
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luismakeapp.lemonade.ui.theme.LemonadeTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun LemonadeWithImage() {
    var state by remember {
        mutableStateOf(1)
    }

    var squeeze by remember {
        mutableStateOf(Random.nextInt(2, 4))
    }

    Log.d("squeeze", squeeze.toString())

    when(state){
        1 -> {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = stringResource(id = R.string.tree_content_description_1), fontSize = 18.sp)
                Spacer(modifier = Modifier.size(16.dp))
                Image(painter = painterResource(id = R.drawable.lemon_tree),
                    contentDescription = stringResource(id = R.string.tree_content_description_2),
                    Modifier
                        .border(width = 3.dp, color = Color(105, 205, 216, 255))
                        .clickable {
                            state++
                        }
                )
            }
        }
        2 ->{
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = stringResource(id = R.string.lemon_content_description_1), fontSize = 18.sp)
                Spacer(modifier = Modifier.size(16.dp))
                Image(painter = painterResource(id = R.drawable.lemon_squeeze),
                    contentDescription = stringResource(id = R.string.lemon_content_description_2),
                    Modifier
                        .border(width = 3.dp, color = Color(105, 205, 216, 255))
                        .clickable {
                            if (squeeze > 0) {
                                squeeze--
                            } else {
                                state++
                            }
                        }
                )
            }
        }
        3 -> {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = stringResource(id = R.string.lemonade_content_description_1), fontSize = 18.sp)
                Spacer(modifier = Modifier.size(16.dp))
                Image(painter = painterResource(id = R.drawable.lemon_drink),
                    contentDescription = stringResource(id = R.string.lemonade_content_description_2),
                    Modifier
                        .border(width = 3.dp, color = Color(105, 205, 216, 255))
                        .clickable {
                            state++
                        }
                )
            }
        }
        4 -> {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = stringResource(id = R.string.glass_content_description_1), fontSize = 18.sp)
                Spacer(modifier = Modifier.size(16.dp))
                Image(painter = painterResource(id = R.drawable.lemon_restart),
                    contentDescription = stringResource(id = R.string.glass_content_description_2),
                    Modifier
                        .border(width = 3.dp, color = Color(105, 205, 216, 255))
                        .clickable {
                            state = 1
                            squeeze = Random.nextInt(2, 4)
                        }
                )
            }
        }
    }



}

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    LemonadeTheme {
        LemonadeWithImage()
    }
}