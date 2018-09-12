package app.demo.example.com.trailtracker.map

import android.os.Bundle
import app.demo.example.com.trailtracker.app.BasePresenter
import app.demo.example.com.trailtracker.app.BaseView
import app.demo.example.com.trailtracker.model.Route

/**
 *
 * Contracts for map view and map presenter
 *
 * Created by Guillermo Bonafonte Criado
 */
interface IMapPresenter : BasePresenter {
    fun onCreate(route : Route)
}

interface IMapView : BaseView<IMapPresenter> {
    fun onCreate(savedInstanceState: Bundle?)
    fun onStart()
    fun onResume()
    fun onPause()
    fun onStop()
    fun onDestroy()
    fun onSaveInstanceState(instanceState: Bundle?)
    fun onLowMemory()

}