package app.demo.example.com.trailtracker.global

import android.location.Location
import app.demo.example.com.trailtracker.R
import app.demo.example.com.trailtracker.location.ILocationProvider
import app.demo.example.com.trailtracker.model.Route
import app.demo.example.com.trailtracker.repository.IRepository
import app.demo.example.com.trailtracker.rx.Schedulers
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
            view.getStringResource(R.string.start) -> startNewRoute()
            else -> finishRoute()
        }
    }

    override fun permissionsGranted() {
        locationProvider.permissionsGranted()
    }

    override fun viewRoutesClicked() {
        view.navigateToRoutesList()
    }

    private fun finishRoute() {
        view.setStartButtonText(view.getStringResource(R.string.start))
        view.stopChronometer()
        locationProvider.stopLocationUpdates()
        route.duration = view.getChronometerTime()
        view.navigateToSetRouteNameScreen(route)

    }

    private fun startNewRoute() {
        view.setStartButtonText(view.getStringResource(R.string.finish))
        view.startChronometer()
        getCurrentLocation()
        route = Route()
        route.startDate = Calendar.getInstance().time
    }

    private fun getCurrentLocation() {
        locationProvider.getMyLocation()
                .observeOn(schedulers.internet())
                .observeOn(schedulers.androidThread())
                .subscribe(
                        { location -> locationReceived(location) },
                        { throwable -> view.showSnack(throwable.toString()) }
                )
    }

    private fun locationReceived(location: Location) {
        route.locations.add(location)
        view.showSnack("Got")
        view.showLatitude(location.latitude.toString())
        view.showLongitude(location.longitude.toString())
        view.showAltitude(location.altitude.toString())
    }
}
