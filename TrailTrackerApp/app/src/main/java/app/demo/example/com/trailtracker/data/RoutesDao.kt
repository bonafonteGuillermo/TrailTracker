package app.demo.example.com.trailtracker.data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import app.demo.example.com.trailtracker.model.Route

/**
 *
 * Created by Guillermo Bonafonte Criado
 *
 */
@Dao
interface RoutesDao {
    @Query("SELECT id,name,start_date,duration,locations FROM route ORDER BY start_date")
    fun getRoutes(): List<Route>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRoute(route: Route)
}