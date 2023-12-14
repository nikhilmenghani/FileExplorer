package com.example.fileexplorer

import ValidateAndRunComposable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.fileexplorer.ui.theme.FileExplorerTheme
import com.example.fileexplorer.ui.view.FileExplorerApp


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FileExplorerTheme {
                ValidateAndRunComposable { FileExplorerApp() }
            }
        }
    }
}
