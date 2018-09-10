package app.demo.example.com.trailtracker.global

import android.view.View
import app.demo.example.com.trailtracker.location.ILocationProvider
import app.demo.example.com.trailtracker.location.LocationProviderImplementation
import io.reactivex.disposables.Disposable
import app.demo.example.com.trailtracker.repository.IRepository
import app.demo.example.com.trailtracker.rx.Schedulers
import app.demo.example.com.trailtracker.utils.snack

/**
 *
 * Presenter for Splash screen.
 *
 * Created by Guillermo Bonafonte Criado
 */
class GlobalPresenter(private var view: IGlobalView, override var repository: IRepository, private var schedulers: Schedulers, var locationProvider : ILocationProvider) : IGlobalPresenter {

    private lateinit var subscription: Disposable

    override fun onCreate() {

    }

    override fun onDestroy() {
        subscription.dispose()
    }

    override fun permissionsGranted() {
        locationProvider.permissionsGranted()
    }

    override fun startLocation(buttonText : String) {
        if(buttonText == "START"){
            view.setStartButtonText("FINISH")
            getCurrentLocation()
        }else{
            view.setStartButtonText("FINISH")
            locationProvider.stopLocationUpdates()
        }

    }

    private fun getCurrentLocation() {
        locationProvider.getMyLocation()
                .observeOn(schedulers.internet())
                .observeOn(schedulers.androidThread())
                .subscribe(
                        { location ->
                            view.showSnack("Got")
                            view.showLatitude(location.latitude.toString())
                            view.showLongitude(location.longitude.toString())
                            view.showAltitude(location.altitude.toString())

                        },
                        { throwable -> view.showSnack(throwable.toString()) }
                )
    }



}
