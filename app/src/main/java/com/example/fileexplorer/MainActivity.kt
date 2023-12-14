package com.example.fileexplorer

import ListFiles
import RequestManageExternalStoragePermission
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.fileexplorer.ui.theme.FileExplorerTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FileExplorerTheme {
                HomePage()
            }
        }
    }

    @Composable
    fun HomePage() {
        val permissionGranted = remember { mutableStateOf(false) }

        Column {
            RequestManageExternalStoragePermission(
                onPermissionGranted = { granted ->
                    permissionGranted.value = granted
                }
            )

            if (permissionGranted.value) {
                // Display ListLearning only if the permission is granted
                ListFiles()
            } else {
                // Optionally, show a placeholder or message if permission is not granted
                Text("Permission not granted. Unable to display files.")
            }
        }
    }

}
