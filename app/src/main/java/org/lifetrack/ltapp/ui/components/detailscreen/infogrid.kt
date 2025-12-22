package org.lifetrack.ltapp.ui.components.detailscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SafetyInfoGrid() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        SafetyItem(
            title = "Warnings",
            content = "Avoid alcohol. Take with food.",
            icon = Icons.Default.Warning,
            color = Color(0xFFD32F2F),
            modifier = Modifier.weight(1f)
        )
        SafetyItem(
            title = "Side Effects",
            content = "Dizziness, Dry Mouth.",
            icon = Icons.Default.Info,
            color = Color(0xFF0288D1),
            modifier = Modifier.weight(1f)
        )
    }
}