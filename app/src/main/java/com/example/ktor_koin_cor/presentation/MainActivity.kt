package com.example.ktor_koin_cor.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.ktor_koin_cor.presentation.viewModel.MyViewModel
import com.example.ktor_koin_cor.ui.theme.KtorKoinCorTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KtorKoinCorTheme {

                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background ,
                    ) {
                MyScreen()
            }
            }
        }
    }
}

@Composable

fun MyScreen(viewModel: MyViewModel = koinViewModel()) {

    val data by viewModel.Response.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        if (data != null) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "ID: ${data?.data?.id}")
                Text(text = "Email: ${data?.data?.email}")
                Text(text = "First Name: ${data?.data?.firstName}")
                Text(text = "Last Name: ${data?.data?.lastName}")
                AsyncImage(
                    model = "${data?.data?.avatar}",
                    contentDescription = "Translated"

                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = data?.support?.text ?: "Support Text")
            }
        } else {
            Text(text = "Loading...")
        }
    }
}
