package app.demo.example.com.trailtracker.map

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import app.demo.example.com.trailtracker.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.PolylineOptions

/**
 *
 * View for map screen
 *
 * Created by Guillermo Bonafonte Criado
 */
class MapView(context: AppCompatActivity) : IMapView, OnMapReadyCallback {

    override var context: Context = context
    override var presenter: IMapPresenter? = null
    override fun constructView(): View = view

    private val mapView by lazy { view.findViewById<com.google.android.gms.maps.MapView>(R.id.map) }
    private var map: GoogleMap? = null
    var view: View

    init {
        val parent = FrameLayout(context)
        parent.layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        view = LayoutInflater.from(context).inflate(R.layout.activity_map, parent, true)
    }

    // Required lifecycle methods that must be invoked for the MapView
    override fun onCreate(savedInstanceState: Bundle?) {
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        googleMap ?: return


        with(googleMap) {
            addPolyline(PolylineOptions().apply {
                addAll(presenter?.getRouteLatLongArray())
                color(Color.BLUE)
            })
        }
    }

    override fun onStart() = mapView.onStart()

    override fun onResume() = mapView.onResume()

    override fun onPause() = mapView.onPause()

    override fun onStop() = mapView.onStop()

    override fun onDestroy() = mapView.onDestroy()

    override fun onSaveInstanceState(instanceState: Bundle?) = mapView.onSaveInstanceState(instanceState)

    override fun onLowMemory() = mapView.onLowMemory()
}