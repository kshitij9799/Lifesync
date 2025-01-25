package com.example.lifesync.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lifesync.activity.ui.theme.LifesyncTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LifesyncTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Login(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}

@Composable
fun Login(name: String, modifier: Modifier = Modifier) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(
                text = "Hello User!",
            )
            TextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Enter Phone Number") },
            )
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Enter Password") },
            )
            Button(
                onClick = { Toast.makeText(context, "Submit", Toast.LENGTH_SHORT).show() },
                shape = RoundedCornerShape(8.dp), // Set rounded corners
                border = BorderStroke(1.dp, Color.Black), // Add a black border
                contentPadding = PaddingValues(16.dp), // Set padding
                modifier = Modifier.padding(0.dp,20.dp),
            ) {
                Text("Submit")
            }
        }


    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    LifesyncTheme {
        Login("Android")
    }
}