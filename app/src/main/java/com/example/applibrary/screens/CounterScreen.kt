package com.example.applibrary.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun CounterScreen(){
    Column(
        modifier= Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var counter by rememberSaveable{
            mutableStateOf(0)
        }

        var email by remember{
            mutableStateOf("")
        }
        Text(
            text = "La cuenta es $counter ",
            fontSize = 30.sp
        )
        OutlinedTextField(
            value = email,
            onValueChange = {
                print("CounterScreen: $it")
                email = it
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text("Correo electronico")
            }
        )
        Button(
            onClick = {
                counter++
            }
        ) {
            Text(
                "Incrementar"
            )
        }
    }
}


@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun CounterScreenPreview(){
    CounterScreen()
}