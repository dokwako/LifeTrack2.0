package org.lifetrack.ltapp.model.data.dclass

import androidx.room.PrimaryKey
import androidx.room.Entity

@Entity(tableName = "demChats")
data class MessageEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val text: String,
    val isUser: Boolean,
    val timestamp: Long = System.currentTimeMillis()
)