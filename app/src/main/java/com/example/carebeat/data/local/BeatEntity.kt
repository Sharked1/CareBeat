package com.example.carebeat.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "beat")
data class BeatEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val value: Int,
    val timeStamp: Long
)
