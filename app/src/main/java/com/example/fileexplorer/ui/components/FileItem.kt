import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.InsertDriveFile
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.io.File

@Composable
fun FileItem(file: File, onFileClick: (File) -> Unit) {
    val isDirectory = file.isDirectory
    val textColor = if (isDirectory) Color.Blue else Color.Black
    val icon = if (isDirectory) Icons.Filled.Folder else Icons.Filled.InsertDriveFile
    val backgroundColor = if (isDirectory) Color.LightGray.copy(alpha = 0.3f) else Color.Transparent

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onFileClick(file) }
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = if (isDirectory) "Folder" else "File",
            tint = textColor,
            modifier = Modifier.size(20.dp) // Adjust icon size
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = file.name,
            color = textColor,
            fontSize = 20.sp, // Adjust text size
            modifier = Modifier
                .weight(1f)
                .background(backgroundColor, shape = RoundedCornerShape(4.dp))
                .padding(8.dp)
        )
        Box(
            modifier = Modifier
                .height(1.dp)
                .background(Color.Gray)
        )
    }
}