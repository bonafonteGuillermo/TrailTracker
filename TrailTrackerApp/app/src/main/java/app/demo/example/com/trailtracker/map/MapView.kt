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
import com.google.android.gms.maps.CameraUpdate
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.*
import com.google.android.gms.maps.model.RoundCap


/**
 *
 * View for map screen
 *
 * Created by Guillermo Bonafonte Criado
 */
class MapView(context: AppCompatActivity) : IMapView, OnMapReadyCallback {

    private val widthPx = 20

    override var context: Context = context
    override var presenter: IMapPresenter? = null
    override fun constructView(): View = view

    private val mapView by lazy { view.findViewById<com.google.android.gms.maps.MapView>(R.id.map) }
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

        val routeLatLongArray = presenter?.getRouteLatLongArray()

        drawPolyLine(routeLatLongArray, googleMap)
        centerMapCameraInRouteLocation(routeLatLongArray, googleMap)
    }

    override fun onStart() = mapView.onStart()

    override fun onResume() = mapView.onResume()

    override fun onPause() = mapView.onPause()

    override fun onStop() = mapView.onStop()

    override fun onDestroy() = mapView.onDestroy()

    override fun onSaveInstanceState(instanceState: Bundle?) = mapView.onSaveInstanceState(instanceState)

    override fun onLowMemory() = mapView.onLowMemory()

    private fun centerMapCameraInRouteLocation(routeLatLongArray: ArrayList<LatLng>?, googleMap: GoogleMap) {
        val builder = LatLngBounds.Builder()
        for (latLong in routeLatLongArray!!.iterator()) {
            builder.include(LatLng(latLong.latitude, latLong.longitude))
        }
        val bounds: LatLngBounds = builder.build()
        val width = context.resources.displayMetrics.widthPixels
        val height = context.resources.displayMetrics.heightPixels
        val padding = (width * 0.12).toInt() // offset from edges of the map 12% of screen
        val cu: CameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds, width, height, padding)
        val cuZoom: CameraUpdate = CameraUpdateFactory.zoomTo(15f)

        try {
            googleMap.moveCamera(cu)
            googleMap.animateCamera(cu)
            googleMap.moveCamera(cuZoom)
        } catch (ex: Exception) {
        }
    }

    private fun drawPolyLine(routeLatLongArray: ArrayList<LatLng>?, googleMap: GoogleMap) {
        var polyLineOptions: PolylineOptions = PolylineOptions().apply {
            addAll(routeLatLongArray)
            color(Color.BLUE)
            width(widthPx.toFloat())
        }

        var line = googleMap.addPolyline(polyLineOptions)
        line.startCap = RoundCap()
        line.endCap = RoundCap()
        line.jointType = JointType.ROUND
    }
}