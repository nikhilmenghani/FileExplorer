import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.Settings
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

@Composable
fun RequestManageExternalStoragePermission(onPermissionGranted: (Boolean) -> Unit) {
    val context = LocalContext.current

    val openSettingsLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) {
        val granted = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            Environment.isExternalStorageManager()
        } else {
            // For versions below Android R, check for READ_EXTERNAL_STORAGE permission
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                context.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) ==
                        android.content.pm.PackageManager.PERMISSION_GRANTED
            } else {
                true
            }
        }
        onPermissionGranted(granted)
    }

    LaunchedEffect(key1 = Unit) {
        val granted = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            Environment.isExternalStorageManager()
        } else {
            // For versions below Android R, check for READ_EXTERNAL_STORAGE permission
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                context.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) ==
                        android.content.pm.PackageManager.PERMISSION_GRANTED
            } else {
                true
            }
        }
        onPermissionGranted(granted)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && !granted) {
            val intent = Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION)
            openSettingsLauncher.launch(intent)
        }
    }
}

@Composable
fun MyPhotoPickerComposable() {
    val selectedUris = remember { mutableStateListOf<Uri>() }

    val selectPhotosLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetMultipleContents()
    ) { uris: List<Uri> ->
        selectedUris.addAll(uris)
    }

    Column {
        Button(onClick = { selectPhotosLauncher.launch("image/*") }) {
            Text("Select Photos")
        }
        Text("Selected photos: ${selectedUris.toList()}")
        // Optionally, display the selected photos here
    }
}