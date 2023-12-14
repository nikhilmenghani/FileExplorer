package com.example.fileexplorer.ui.view
import FileItem
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
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