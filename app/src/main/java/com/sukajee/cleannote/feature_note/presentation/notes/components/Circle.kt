package com.sukajee.cleannote.feature_note.presentation.notes.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Circle() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .aspectRatio(1f)
            .background(Color(0xFFc2f5e2))
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(
                brush = Brush.linearGradient(
                    listOf(
                        Color.White,
                        Color(0xFFD51E27),
                        Color.Black
                    )
                ),
                radius = size.minDimension / 2.0f,
                center = size.center
            )

        }
    }
}

@Preview
@Composable
fun CirclePreview() {
    Circle()
}
