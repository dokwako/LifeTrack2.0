package org.lifetrack.ltapp.ui.components.homescreen

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.lifetrack.ltapp.ui.theme.Purple40


@Composable
fun HealthMetric(
    label: String,
    value: String,
    icon: ImageVector
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(42.dp)
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = value,
            fontWeight = FontWeight.Bold,
            color = if (isSystemInDarkTheme()) MaterialTheme.colorScheme.primary else Purple40
        )
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = if (isSystemInDarkTheme()) MaterialTheme.colorScheme.primary else Purple40
        )
    }
}

