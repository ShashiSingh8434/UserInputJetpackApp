package com.example.userinputjetpackapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    @SuppressLint("UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var text by remember {
                mutableStateOf("")
            }
            var nam by remember {
                mutableStateOf("")
            }
            var photo by remember {
                mutableIntStateOf(R.drawable.img)
            }

            Column(modifier = Modifier.padding(10.dp)) {

                TextField(
                    value = text,
                    onValueChange = {
                        text = it
                    },
                    label = {
                        Text("Enter your name: ")
                    }
                )
                Spacer(modifier = Modifier.padding(10.dp))

                Button(onClick = {
                    nam = "Hello, $text. \n\nThis is the profile picture of Shashi Singh"
                    photo = R.drawable.logo
                }) {
                    Text(text = "Submit")
                }
                Spacer(modifier = Modifier.padding(10.dp))

                Text(text = nam)
                Spacer(modifier = Modifier.padding(10.dp))

                Image(
                    painter = painterResource(id = photo),
                    contentDescription = "This is the profile picture of Shashi Singh"
                )

            }
        }
    }
}