package com.example.alerts

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alerts.ui.theme.AlertsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlertsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NotificationScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun NotificationScreen(modifier: Modifier = Modifier) {
    var showToast by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            showToast = true
        }) {
            Text(text = "Показать всплывающее сообщение")
        }
        if (showToast) {
            Toast.makeText(
                LocalContext.current,
                "Это всплывающее сообщение (Toast)!",
                Toast.LENGTH_SHORT
            ).show()
            showToast = false
        }
    }
}
@Preview(showBackground = true)
@Composable
fun NotificationScreenPreview() {
    AlertsTheme {
        NotificationScreen()
    }
}
