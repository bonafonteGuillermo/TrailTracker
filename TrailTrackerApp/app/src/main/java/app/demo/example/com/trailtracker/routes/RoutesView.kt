package app.demo.example.com.trailtracker.routes

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import app.demo.example.com.trailtracker.R
import app.demo.example.com.trailtracker.map.MapActivity
import app.demo.example.com.trailtracker.model.Route
import app.demo.example.com.trailtracker.routename.RouteNameActivity
import kotlinx.android.synthetic.main.activity_routes.view.*
import app.demo.example.com.trailtracker.routes.adapter.RoutesAdapter
import app.demo.example.com.trailtracker.utils.snack


/**
 *
 * View for routes screen
 *
 * Created by Guillermo Bonafonte Criado
 */
class RoutesView(context: AppCompatActivity) : IRoutesView {
    var view: View

    private val adapter = RoutesAdapter { itemClicked(it) }

    override var context: Context = context

    override var presenter: IRoutesPresenter? = null
    override fun constructView(): View = view
    init {
        val parent = FrameLayout(context)
        parent.layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        view = LayoutInflater.from(context).inflate(R.layout.activity_routes, parent, true)
    }

    override fun bindRecyclerData(data : List<Route>) {
            view.recycler.addItemDecoration(DividerItemDecoration(view.recycler.context, DividerItemDecoration.VERTICAL))
            view.recycler.adapter = adapter
            adapter.data = data
    }

    override fun navigateToRouteDetailMap(route: Route) {
        val extras = Bundle().apply { putParcelable("routedetails", route) }
        startActivity(MapActivity::class.java, extras)
    }

    private fun itemClicked(item: Route) {
//        view.snack(item.name!!)
        presenter?.requestRouteMap(item)

        /*TODO **************

            TODO: Check Disposable in GlobalPresenter, do like in RoutesPresenter
            TODO: Bind all the data in the recycler
            TODO: Check if the saveRouteInLocalStorage has worked fine returning boolean value
            TODO: Refactor code
            TODO: Check navigation
            TODO: Check permission
            TODO: Check when to start the chronometer
            TODO: get bundle in MAP ACTIVITY
            TODO: center map camera in route
         */
    }
}