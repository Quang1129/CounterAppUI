package com.example.counterui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.counterui.ui.theme.CounterUITheme
import androidx.compose.material3.Button
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.unit.sp



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CounterUITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var number by rememberSaveable { mutableIntStateOf(0) }
                    CounterUIApp(number, { number++ } )
                }
            }
        }
    }
}

@Composable
fun CounterUIApp(number: Int,
                 onIncrement: () -> Unit,
                 modifier: Modifier = Modifier){

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier =  modifier.fillMaxSize()
    ) {
        Text (
            text = number.toString(),
            style = MaterialTheme.typography.displayLarge
        )

        Spacer(modifier = Modifier.height(100.dp))

        Button(
            onClick = onIncrement,
            shape = CircleShape,
            modifier = Modifier
                .size(100.dp)

        ) {
            Text(
                text = stringResource(id = R.string.button),
                fontSize = 20.sp,
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CounterUITheme {
        var number by remember { mutableIntStateOf(0) }
        CounterUIApp(number, { number++ })
    }
}