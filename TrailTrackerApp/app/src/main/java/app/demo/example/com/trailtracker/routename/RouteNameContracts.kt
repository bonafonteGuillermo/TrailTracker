package app.demo.example.com.trailtracker.routename

import app.demo.example.com.trailtracker.app.BasePresenter
import app.demo.example.com.trailtracker.app.BaseView
import app.demo.example.com.trailtracker.model.Route
import io.reactivex.Observable

/**
 *
 * Contracts for routename view and routename presenter
 *
 * Created by Guillermo Bonafonte Criado
 */
interface IRouteNamePresenter : BasePresenter {
    fun onCreate(route : Route)
    fun saveBtnClicked()
}

interface IRouteNameView : BaseView<IRouteNamePresenter> {
    fun getTextViewRouteText(): String
    fun routeName(): Observable<String>
    fun enableSaveButton()
    fun disableSaveButton()
}