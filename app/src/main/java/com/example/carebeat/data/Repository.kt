package com.example.carebeat.data

import com.example.carebeat.data.local.BeatEntity
import com.example.carebeat.data.local.Dao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val dao: Dao
) {
    fun getAllData(): Flow<List<BeatEntity>> {
        return dao.getAllData()
    }

    suspend fun insertData(beat: Int) {
        val entity = BeatEntity(
            value = beat,
            timeStamp = System.currentTimeMillis()
        )
        dao.insertBeat(entity)
    }
}