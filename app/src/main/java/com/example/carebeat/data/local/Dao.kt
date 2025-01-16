package com.example.carebeat.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Query("SELECT * FROM beat")
    fun getAllData(): Flow<List<BeatEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertBeat(beatEntity: BeatEntity)

    @Delete
    suspend fun deleteBeat(beatEntity: BeatEntity)
}