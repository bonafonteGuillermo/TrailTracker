package app.demo.example.com.trailtracker.routename

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import app.demo.example.com.trailtracker.R

/**
 *
 * View for routename screen
 *
 * Created by Guillermo Bonafonte Criado
 */
class RouteNameView(context: AppCompatActivity) : IRouteNameView {

    var view: View

    override var context: Context = context
    override var presenter: IRouteNamePresenter? = null
    override fun constructView(): View = view

    init {
        val parent = FrameLayout(context)
        parent.layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        view = LayoutInflater.from(context).inflate(R.layout.activity_route_name, parent, true)
    }
}