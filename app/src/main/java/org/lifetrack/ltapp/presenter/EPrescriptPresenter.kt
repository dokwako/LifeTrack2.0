package org.lifetrack.ltapp.presenter

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import org.lifetrack.ltapp.ui.theme.Purple40
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

class EPrescriptPresenter : ViewModel() {

    var selectedFilter by mutableStateOf("Active")
    val filters = listOf("Active", "Refills", "Expired", "History")
    val listState = LazyListState()

    fun getStatusColor(filter: String): Color {
        return when (filter) {
            "Active" -> Color(0xFF81C784)
            "Refills" -> Color(0xFFFFB74D)
            "Expired" -> Color(0xFFEF5350)
            else -> Purple40
        }
    }

    fun isDateExpired(endDateStr: String): Boolean {
        return try {
            val formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy", Locale.ENGLISH)
            val endDate = LocalDate.parse(endDateStr, formatter)
            endDate.isBefore(LocalDate.now())
        } catch (e: Exception) {
            false
        }
    }
}