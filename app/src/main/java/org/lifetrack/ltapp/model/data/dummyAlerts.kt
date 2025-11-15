package org.lifetrack.ltapp.model.data

import org.lifetrack.ltapp.R

val epidemicAlerts = listOf(
    EpidemicAlert(
        id = 1,
        title = "Malaria Outbreak",
        location = "Nairobi County",
        severity = "High",
        date = "15 Nov - 30 Dec 2023",
        description = "Increased cases reported due to heavy rainfall and mosquito breeding",
        precautions = listOf(
            "Use mosquito nets",
            "Apply insect repellent",
            "Seek immediate treatment for symptoms"
        ),
        status = "Active",
        localImageRes = R.drawable.malaria
    ),
    EpidemicAlert(
        id = 2,
        title = "Cholera Alert",
        location = "Coastal Region",
        severity = "Critical",
        date = "1 Dec - Present",
        description = "Waterborne outbreak detected in informal settlements",
        precautions = listOf(
            "Drink boiled or treated water",
            "Maintain proper sanitation",
            "Oral rehydration for symptoms"
        ),
        status = "New",
        localImageRes = R.drawable.who
    ),
    EpidemicAlert(
        id = 3,
        title = "COVID-19 Variant",
        location = "Nationwide",
        severity = "Medium",
        date = "Ongoing",
        description = "New variant detected with increased transmissibility",
        precautions = listOf(
            "Get booster shots",
            "Wear masks in crowds",
            "Monitor for symptoms"
        ),
        status = "Active",
        localImageRes = R.drawable.covid
    ),
    EpidemicAlert(
        id = 4,
        title = "General Health Alert",
        location = "Multiple Regions",
        severity = "Low",
        date = "Ongoing",
        description = "Seasonal health advisory for common illnesses",
        precautions = listOf(
            "Practice good hygiene",
            "Stay hydrated",
            "Visit health centers if symptoms persist"
        ),
        status = "Contained",
        localImageRes = R.drawable.alerts
    )
)