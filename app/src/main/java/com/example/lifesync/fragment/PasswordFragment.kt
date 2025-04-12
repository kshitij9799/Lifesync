package com.example.lifesync.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PasswordFragment : Fragment() {
    companion object {
        fun newInstance() = PasswordFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                PasswordScreen()

            }
        }
    }
}

@Composable
fun PasswordScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        val openDialog = remember { mutableStateOf(false) }
        val siteAppName = remember { mutableStateOf("") }
        var username = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }
        Text(
            "Password Data",
        )
        FloatingActionButton(
            onClick = { openDialog.value = true },
            modifier = Modifier.padding(12.dp).align(Alignment.BottomEnd),
            shape = RoundedCornerShape(4.dp),
            contentColor = Color.White
        ) {
            Icon(Icons.Filled.Add, contentDescription = "Add")
        }
        if (openDialog.value) {
            OpenDialog(
                onDismissRequest = { openDialog.value = false },
                username = username.value,
                siteAppName = siteAppName.value,
                password = password.value,
                onValueChange = {
                    username.value = it
                    password.value = it
                    siteAppName.value = it
                }
            )
        }
    }
}

@Composable
fun OpenDialog(
    onDismissRequest: () -> Unit,
    username: String = "",
    password: String = "",
    siteAppName: String = "",
    onValueChange: (String) -> Unit = {}
    ) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties()
    ) {

        Card(modifier = Modifier.fillMaxWidth(0.8f)) {
            Box(
                modifier = Modifier.padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column {
                    TextField(
                        value = username,
                        onValueChange = onValueChange,
                        label = { Text("Site Name") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    TextField(
                        value = password,
                        onValueChange = onValueChange,
                        label = { Text("Username") },
                        modifier = Modifier.fillMaxWidth())
                    TextField(
                        value = password,
                        onValueChange = onValueChange,
                        label = { Text("Password") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(
                        onClick = {},
                        modifier = Modifier.fillMaxWidth(),
                        content = {
                            Text("Submit")
                        }
                    )
                }
            }
        }
    }
}