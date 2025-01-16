package com.example.carebeat.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BeatEntity::class], version = 1, exportSchema = false)
abstract class Database: RoomDatabase() {
    abstract fun dao(): Dao

}