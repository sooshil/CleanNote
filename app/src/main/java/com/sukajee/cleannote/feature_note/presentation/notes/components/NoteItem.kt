package com.sukajee.cleannote.feature_note.presentation.notes.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.graphics.ColorUtils
import com.sukajee.cleannote.feature_note.domain.model.Note
import com.sukajee.cleannote.ui.theme.CleanNoteTheme

@Composable
fun NoteItem(
    note: Note,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 16.dp,
    clipCornerSize: Dp = 30.dp,
    onDeleteClick: () -> Unit
) {
    Box(modifier = modifier) {
        Canvas(modifier = Modifier.matchParentSize()) {
            val clipPath = Path().apply {
                lineTo(size.width - clipCornerSize.toPx(), 0f)
                lineTo(size.width, clipCornerSize.toPx())
                lineTo(size.width, size.height)
                lineTo(0f, size.height)
                close()
            }
            clipPath(clipPath) {
                drawRoundRect(
                    color = Color(note.color),
                    cornerRadius = CornerRadius(cornerRadius.toPx()),
                    size = size
                )
                drawRoundRect(
                    color = Color(ColorUtils.blendARGB(note.color, 0x00000000, 0.2f)),
                    cornerRadius = CornerRadius(cornerRadius.toPx()),
                    topLeft = Offset(x = size.width - clipCornerSize.toPx(), -100f),
                    size = Size(clipCornerSize.toPx() + 100f, clipCornerSize.toPx() + 100f)
                )
            }
        }

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(end = 32.dp)
        ) {
            Text(
                text = note.title,
                style = MaterialTheme.typography.h6,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colors.onSurface
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = note.content,
                style = MaterialTheme.typography.body1,
                maxLines = 10
            )
        }

        IconButton(
            onClick = onDeleteClick,
            modifier = modifier.align(Alignment.BottomEnd)
        ) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete Note")
        }
    }
}
