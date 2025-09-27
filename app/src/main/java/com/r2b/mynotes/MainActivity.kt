package com.r2b.mynotes

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.r2b.mynotes.constants.Screens
import com.r2b.mynotes.navigation.NoteApplicationNavigation
import com.r2b.mynotes.screens.HomeScreen
import com.r2b.mynotes.ui.theme.MynotesTheme
import com.r2b.mynotes.views.MainView

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MynotesTheme {
                MainView()
            }
        }
    }
}
