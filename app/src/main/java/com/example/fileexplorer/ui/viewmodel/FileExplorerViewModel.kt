package com.example.fileexplorer.ui.viewmodel

import android.os.Environment
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import java.io.File

class FileExplorerViewModel : ViewModel() {
    private var currentDirectory = Environment.getExternalStorageDirectory()
    var files = mutableStateListOf<File>()
        private set

    init {
        listFiles()
    }

    fun listFiles(directory: File = currentDirectory) {
        currentDirectory = directory
        files.clear()
        directory.listFiles()?.let {
            files.addAll(it)
        }
    }

}