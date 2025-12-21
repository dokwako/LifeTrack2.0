package org.lifetrack.ltapp.ui.screens

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowCircleLeft
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.lifetrack.ltapp.presenter.AnalyticPresenter
import org.lifetrack.ltapp.ui.components.prescriptscreen.PrescriptionCard
import org.lifetrack.ltapp.ui.theme.Purple40
import org.lifetrack.ltapp.presenter.EPrescriptPresenter


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrescriptScreen(
    navController: NavController,
    analyticPresenter: AnalyticPresenter,
    presenter: EPrescriptPresenter
) {
    val prescriptions = analyticPresenter.dummyPrescriptions

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "E-Prescriptions",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold,
                        color = if (isSystemInDarkTheme()) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onPrimary
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowCircleLeft, "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Purple40)
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        Column(modifier = Modifier.fillMaxSize().padding(innerPadding)) {

            LazyRow(
                modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp),
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(presenter.filters) { filter ->
                    val isSelected = presenter.selectedFilter == filter
                    val chipTint = presenter.getStatusColor(filter)

                    FilterChip(
                        modifier = Modifier.fillParentMaxWidth(1f / presenter.filters.size),
                        selected = isSelected,
                        onClick = { presenter.selectedFilter = filter },
                        label = {
                            Text(
                                text = filter,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                fontSize = 12.sp,
                                fontWeight = if (isSelected) FontWeight.ExtraBold else FontWeight.Bold
                            )
                        },
                        shape = RoundedCornerShape(50.dp),
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = chipTint.copy(alpha = 0.2f),
                            selectedLabelColor = if (isSystemInDarkTheme()) chipTint else chipTint.copy(alpha = 0.9f)
                        )
                    )
                }
            }

            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
                state = presenter.listState, // MANAGED BY PRESENTER
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val filteredList = when (presenter.selectedFilter) {
                    "Active" -> prescriptions.filter { it.status == "Active" }
                    "Refills" -> prescriptions.filter { it.status == "Refill Due" }
                    "Expired" -> prescriptions.filter { presenter.isDateExpired(it.endDate) }
                    "History" -> prescriptions
                    else -> prescriptions
                }

                if (filteredList.isEmpty()) {
                    item {
                        Box(modifier = Modifier.fillParentMaxHeight(0.7f), contentAlignment = Alignment.Center) {
                            Text("No items found in ${presenter.selectedFilter}.", color = Color.Gray)
                        }
                    }
                } else {
                    items(filteredList, key = { it.id }) { prescription ->
                        PrescriptionCard(
                            prescription = prescription,
                            isExpired = presenter.isDateExpired(prescription.endDate)
                        )
                    }
                }
                item { Spacer(modifier = Modifier.height(24.dp)) }
            }
        }
    }
}