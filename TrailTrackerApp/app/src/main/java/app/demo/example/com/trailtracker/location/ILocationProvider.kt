package app.demo.example.com.trailtracker.location

import android.location.Location
import io.reactivex.Observable

/**
 *
 * Created by Guillermo Bonafonte Criado
 *
 */
interface ILocationProvider {
    fun getMyLocation(): Observable<Location>
    fun permissionsGranted()
    fun stopLocationUpdates()
}