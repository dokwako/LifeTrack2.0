package org.lifetrack.ltapp.ui.components.appointscreen

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.lifetrack.ltapp.model.data.dclass.Appointment

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppointmentSwipeCard(appointment: Appointment, onDismiss: () -> Unit) {
    val dismissState = rememberSwipeToDismissBoxState()
    LaunchedEffect(dismissState.currentValue) {
        if (dismissState.currentValue == SwipeToDismissBoxValue.EndToStart) {
            onDismiss()
            dismissState.snapTo(SwipeToDismissBoxValue.Settled)
        }
    }
    SwipeToDismissBox(
        state = dismissState,
        enableDismissFromStartToEnd = false,
        backgroundContent = {
            val color by animateColorAsState(if (dismissState.targetValue == SwipeToDismissBoxValue.EndToStart) Color.Red.copy(0.7f) else Color.Transparent, label = "")
            Box(Modifier.fillMaxSize().padding(horizontal = 16.dp).background(color, RoundedCornerShape(12.dp)), contentAlignment = Alignment.CenterEnd) {
                if (dismissState.progress > 0.1f) Icon(Icons.Default.Delete, null, tint = Color.White, modifier = Modifier.padding(end = 16.dp))
            }
        },
        modifier = Modifier.padding(horizontal = 16.dp)
    ) { AppointmentCard(appointment) }
}