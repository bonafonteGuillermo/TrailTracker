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
    fun startLocation()

}

interface IGlobalView : BaseView<IGlobalPresenter> {
    fun showLocation(location : String)
    fun showSnack(string : String)

}