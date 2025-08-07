package com.example.selectdateofbirth

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SetDateOfBirth()
        }
    }
}

@Composable
fun SetDateOfBirth() {
    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(false) }
    if (showDialog) {
        BirthdayPickerDialog(
            onDismiss = { showDialog = false },
            onDateSelected = { year, month, day ->
                Toast.makeText(
                    context,
                    "${year}년 ${month}월 ${day}일",
                    Toast.LENGTH_SHORT
                ).show()
            }
        )
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = { showDialog = true }) {
            Text("생년월일 설정")
        }
    }
}
