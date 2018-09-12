package app.demo.example.com.trailtracker.map

import app.demo.example.com.trailtracker.model.Route
import app.demo.example.com.trailtracker.repository.IRepository
import app.demo.example.com.trailtracker.rx.Schedulers
import com.google.android.gms.maps.model.LatLng
import io.reactivex.disposables.Disposable

/**
 *
 * Presenter for Map screen.
 *
 * Created by Guillermo Bonafonte Criado
 */
class MapPresenter(private var view: IMapView, override var repository: IRepository, private var schedulers: Schedulers) : IMapPresenter {
    private lateinit var subscription: Disposable

    lateinit var route: Route

    override fun onCreate() {
    }

    override fun onCreate(route: Route) {
        this.route = route
    }

    override fun onDestroy() {
        subscription.dispose()
    }

    override fun getRouteLatLongArray(): ArrayList<LatLng> {
        val coordList = ArrayList<LatLng>()
        route.locations.forEach { location ->
            coordList.add(LatLng(location.latitude,location.longitude))
        }
        return coordList
    }
}