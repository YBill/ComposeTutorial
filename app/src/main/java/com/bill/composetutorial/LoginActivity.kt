package com.bill.composetutorial

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloContent()
        }
    }
}

@Preview
@Composable
fun PreviewLogin() {
    HelloContent()
}

@Composable
fun HelloContent() {
    val context = LocalContext.current
    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            Toast.makeText(context, "back", Toast.LENGTH_SHORT).show()
        }

    var inputText by remember { mutableStateOf("") }
    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            text = "Login In", style = MaterialTheme.typography.h4
        )
        OutlinedTextField(value = inputText,
            label = { Text(text = "enter key here（666）:") },
            onValueChange = {
                inputText = it
            })
        Button(modifier = Modifier.padding(20.dp), onClick = {
            val key = "666"
            if (key == inputText) {
                android.util.Log.e("Bill", "context = $context")
                val intent = Intent(context, MainActivity::class.java)
//                context.startActivity(intent)
                launcher.launch(intent)

            } else {
                Toast.makeText(context, "Key is Error", Toast.LENGTH_SHORT).show()
            }
        }) {
            Text(text = "Login")
        }

    }
}