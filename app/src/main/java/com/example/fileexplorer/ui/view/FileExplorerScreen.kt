package com.example.fileexplorer.ui.view
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
    FileExplorerScreen(files = viewModel.files)
}

@Composable
fun FileExplorerScreen(files: List<File>) {
    LazyColumn {
        items(files) { file ->
            FileItem(file)
        }
    }
}

@Composable
fun FileItem(file: File) {
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
    )
}

@Preview
@Composable
fun FileExplorerScreenPreview() {
    FileExplorerApp()
}