package app.demo.example.com.trailtracker.map

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import app.demo.example.com.trailtracker.app.App
import app.demo.example.com.trailtracker.app.BaseView.Companion.EXTRA_ROUTE_DETAIL
import app.demo.example.com.trailtracker.map.injection.DaggerMapComponent
import app.demo.example.com.trailtracker.map.injection.MapContextModule
import app.demo.example.com.trailtracker.model.Route

import javax.inject.Inject

/**
 *
 * Map screen.ore proceeding.
 *
 * Created by Guillermo Bonafonte Criado
 */
class MapActivity : AppCompatActivity() {

    @Inject
    lateinit var view: IMapView

    @Inject
    lateinit var presenter: IMapPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerMapComponent.builder()
                .appComponent(App.appComponent)
                .mapContextModule(MapContextModule(this))
                .build()
                .inject(this)


        setContentView(view.constructView())
        view.presenter = presenter

        val bundle = intent.extras
        if (bundle.getParcelable<Route>(EXTRA_ROUTE_DETAIL) != null) {
            var route = bundle.getParcelable<Route>(EXTRA_ROUTE_DETAIL)
            presenter.onCreate(route)
            view.onCreate(savedInstanceState)
        }
    }

    override fun onStart() {
        super.onStart()
        view.onStart()
    }

    override fun onResume() {
        super.onResume()
        view.onResume()
    }

    override fun onPause() {
        super.onPause()
        view.onPause()
    }

    override fun onStop() {
        super.onStop()
        view.onStop()
    }

    override fun onDestroy() {
        view.onDestroy()
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        view.onSaveInstanceState(outState)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        view.onLowMemory()
    }

}
