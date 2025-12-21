package org.lifetrack.ltapp.ui.components.prescriptscreen

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.lifetrack.ltapp.model.data.dclass.Prescription
import org.lifetrack.ltapp.ui.components.homescreen.GlassCard
import org.lifetrack.ltapp.ui.theme.Purple40


@Composable
fun PrescriptionCard(
    prescription: Prescription,
    isExpired: Boolean,
    onRefillRequest: (Prescription) -> Unit = {}
) {
    val isDark = isSystemInDarkTheme()
    val isRefillDue = prescription.status == "Refill Due" && !isExpired

    val headerColor = if (isExpired) Color(0xFFEF5350) else if (isDark) Color(0xFFE1BEE7) else Purple40
    val bodyTextColor = if (isDark) Color.White else Color(0xFF1A1C1E)

    val dateTextColor = if (isExpired) Color(0xFFEF5350) else Color.Gray
    val dateWeight = if (!isExpired) FontWeight.Bold else FontWeight.ExtraBold

    GlassCard(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = prescription.medicationName,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.ExtraBold,
                        color = headerColor
                    )
                    Spacer(Modifier.height(12.dp))
                    Text(
                        text = prescription.dosage,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.bodyMedium,
                        color = if (isDark) Color(0xFFCE93D8) else Purple40.copy(alpha = 0.8f)
                    )
                }

                if (isExpired) {
                    StatusBadge(text = "EXPIRED", color = Color(0xFFEF5350))
                } else if (isRefillDue) {
                    StatusBadge(text = "REFILL DUE", color = Color(0xFFFFB74D))
                }
            }
            Spacer(Modifier.height(12.dp))
            Text(
                text = prescription.instructions,
                style = MaterialTheme.typography.bodyMedium,
                color = bodyTextColor,
                lineHeight = 20.sp,
                fontWeight = dateWeight
            )
            if (!isExpired) {
                Spacer(Modifier.height(16.dp))

                if (prescription.refillProgress > 0) {
                    LinearProgressIndicator(
                        progress = { prescription.refillProgress },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(8.dp)
                            .clip(RoundedCornerShape(4.dp)),
                        color = if (isRefillDue) Color(0xFFFFB74D) else Color(0xFF81C784),
                        trackColor = Color.Gray.copy(alpha = 0.2f),
                    )
                }

                if (isRefillDue) {
                    Spacer(Modifier.height(12.dp))
                    Button(
                        onClick = { onRefillRequest(prescription) },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFFB74D).copy(alpha = 0.15f),
                            contentColor = if (isDark) Color(0xFFFFB74D) else Color(0xFFE65100)
                        ),
                        shape = RoundedCornerShape(12.dp),
                        border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFFFB74D).copy(0.4f))
                    ) {
                        Icon(Icons.Default.Share, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(Modifier.width(8.dp))
                        Text("Request Doctor Refill", fontWeight = FontWeight.Bold)
                    }
                }
            }

            Spacer(Modifier.height(16.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = "Ends: ${prescription.endDate}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = dateTextColor,
                    fontWeight = dateWeight
                )
                Text(
                    text = "Dr. ${prescription.prescribedBy}",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = if (isDark) Color(0xFFCE93D8) else Purple40
                )
            }
        }
    }
}
