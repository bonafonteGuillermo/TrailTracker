package app.demo.example.com.trailtracker.app.injection

import android.arch.persistence.room.Room
import android.content.Context
import app.demo.example.com.trailtracker.data.AppDatabase
import dagger.Module
import dagger.Provides

/**
 *
 * Dagger module for database.
 *
 */

@Module
class DatabaseModule {
    @Provides
    fun providesAppDatabase(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, "my-app-db").build()
}