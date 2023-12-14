package com.example.fileexplorer.ui.view

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fileexplorer.ui.viewmodel.FileExplorerViewModel
import java.io.File

@Composable
fun FileExplorerApp(viewModel: FileExplorerViewModel = FileExplorerViewModel()) {
    FileExplorerScreen(files = viewModel.files, onFileClick = viewModel::listFiles, onBack = viewModel::goBack)
}

@Composable
fun FileExplorerScreen(files: List<File>, onFileClick: (File) -> Unit, onBack: () -> Unit) {
    BackHandler() {
        onBack()
    }
    LazyColumn {
        items(files) { file ->
            FileItem(file, onFileClick)
        }
    }
}

@Composable
fun FileItem(
    file: File, onFileClick: (File) -> Unit
) {
    val color = if (file.isDirectory) {
        Color.Blue
    } else {
        Color.Red
    }
    Text(
        text = file.name,
        color = color,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onFileClick(file) }
    )
}

@Preview
@Composable
fun FileExplorerScreenPreview() {
    FileExplorerApp()
}