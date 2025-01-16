package com.example.carebeat

import android.content.Context
import androidx.room.Room
import com.example.carebeat.data.Repository
import com.example.carebeat.data.local.Dao
import com.example.carebeat.data.local.Database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRepository(dao: Dao): Repository = Repository(dao)

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): Database {
        return Room.databaseBuilder(
            context,
            Database::class.java,
            "app_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDao(database: Database): Dao {
        return database.dao()
    }
}