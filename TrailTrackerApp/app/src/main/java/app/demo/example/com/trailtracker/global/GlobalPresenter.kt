package app.demo.example.com.trailtracker.global

import android.annotation.SuppressLint
import android.location.Location
import app.demo.example.com.trailtracker.R
import app.demo.example.com.trailtracker.location.ILocationProvider
import app.demo.example.com.trailtracker.model.Route
import app.demo.example.com.trailtracker.repository.IRepository
import app.demo.example.com.trailtracker.rx.Schedulers
import com.google.android.gms.maps.model.LatLng
import io.reactivex.Observable
import java.math.RoundingMode
import java.text.DecimalFormat
import java.util.*

/**
 *
 * Presenter for Splash screen.
 *
 * Created by Guillermo Bonafonte Criado
 */
class GlobalPresenter(private var view: IGlobalView, override var repository: IRepository, private var schedulers: Schedulers, var locationProvider: ILocationProvider) : IGlobalPresenter {

    private lateinit var route: Route

    override fun onCreate() {
    }

    override fun onDestroy() {
    }

    override fun startLocation(buttonText: String) {
        when (buttonText) {
            view.getStringResource(R.string.start) -> {
                view.showProgressBar()
                getCurrentLocation()
            }
            else -> finishRoute()
        }
    }

    override fun permissionsGranted() {
        locationProvider.permissionsGranted()
    }

    override fun permissionsDenied() {
        view.hideProgressBar()
    }

    private fun finishRoute() {
        view.setStartButtonText(view.getStringResource(R.string.start))
        view.stopChronometer()
        locationProvider.stopLocationUpdates()
        route.duration = view.getChronometerTime()
        view.resetView()
        view.navigateToSetRouteNameScreen(route)
    }

    private fun startNewRoute() {
        view.setStartButtonText(view.getStringResource(R.string.finish))
        view.startChronometer()
        route = Route()
        route.startDate = Calendar.getInstance().time
    }

    private fun getCurrentLocation() {
        val observable = locationProvider.getMyLocation()
                .observeOn(schedulers.internet())
                .observeOn(schedulers.androidThread())

        onFirstLocationReceived(observable)
        onFollowingLocationsReceived(observable)
    }

    @SuppressLint("CheckResult")
    private fun onFollowingLocationsReceived(observable: Observable<Location>) {
        observable.skip(1).subscribe(
                { locationReceived(it) },
                { view.showSnack(it.toString()) }
        )
    }

    @SuppressLint("CheckResult")
    private fun onFirstLocationReceived(observable: Observable<Location>) {
        observable.take(1).subscribe(
                {
                    view.hideProgressBar()
                    startNewRoute()
                    locationReceived(it)
                },
                {
                    view.showSnack(it.toString())
                }
        )
    }

    private fun locationReceived(location: Location) {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        route.locations.add(LatLng(location.latitude,location.longitude))
        view.showLatitude(df.format(location.latitude).toString())
        view.showLongitude(df.format(location.longitude).toString())
        view.showAltitude(df.format(location.altitude).toString())
    }
}