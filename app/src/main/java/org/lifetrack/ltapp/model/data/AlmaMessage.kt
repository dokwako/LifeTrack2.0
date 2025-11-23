package org.lifetrack.ltapp.model.data

data class AlmaMessage(
    val text: String,
    val check: Boolean? = false,
    val isUser: Boolean = true
)