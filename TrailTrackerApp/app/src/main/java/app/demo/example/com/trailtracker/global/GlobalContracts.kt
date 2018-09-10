package app.demo.example.com.trailtracker.global

import app.demo.example.com.trailtracker.app.BasePresenter
import app.demo.example.com.trailtracker.app.BaseView

/**
 *
 * Contracts for global view and global presenter
 *
 * Created by Guillermo Bonafonte Criado
 */
interface IGlobalPresenter : BasePresenter {
    fun permissionsGranted()
    fun startLocation(buttonText : String)
}

interface IGlobalView : BaseView<IGlobalPresenter> {
    fun showLatitude(latitude : String)
    fun showLongitude(longitude : String)
    fun showAltitude(altitude : String)
    fun showSnack(string : String)
    fun setStartButtonText(text : String)
}