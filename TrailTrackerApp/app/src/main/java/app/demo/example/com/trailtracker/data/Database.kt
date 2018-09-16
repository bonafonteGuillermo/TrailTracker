package app.demo.example.com.trailtracker.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import app.demo.example.com.trailtracker.model.Route

/**
 *
 * Created by Guillermo Bonafonte Criado
 *
 */

@Database(entities = [(Route::class)], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun routesDao(): RoutesDao

}