package org.jetbrains.compose.demo.widgets.ui.utils

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.demo.widgets.theme.typography

@Composable
fun SubtitleText(subtitle: String, modifier: Modifier = Modifier) {
    Text(text = subtitle, style = typography.titleSmall, modifier = modifier.padding(8.dp))
}

@Composable
fun TitleText(title: String) {
    Text(
        text = title,
        style = typography.titleLarge.copy(fontSize = 14.sp),
        modifier = Modifier.padding(8.dp)
    )
}