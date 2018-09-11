package app.demo.example.com.trailtracker.routes

import app.demo.example.com.trailtracker.app.BasePresenter
import app.demo.example.com.trailtracker.app.BaseView
import app.demo.example.com.trailtracker.model.Route

/**
 *
 * Contracts for routes view and routes presenter
 *
 * Created by Guillermo Bonafonte Criado
 */
interface IRoutesPresenter : BasePresenter {

}

interface IRoutesView : BaseView<IRoutesPresenter> {
    fun bindRecyclerData(data : List<Route>)

}