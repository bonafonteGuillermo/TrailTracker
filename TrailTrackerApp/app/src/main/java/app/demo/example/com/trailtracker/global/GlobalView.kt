package app.demo.example.com.trailtracker.global

import android.content.Context
import android.os.Bundle
import android.os.SystemClock
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import app.demo.example.com.trailtracker.R
import app.demo.example.com.trailtracker.app.BaseView.Companion.EXTRA_ROUTE
import app.demo.example.com.trailtracker.model.Route
import app.demo.example.com.trailtracker.routename.RouteNameActivity
import app.demo.example.com.trailtracker.utils.getStringResource
import app.demo.example.com.trailtracker.utils.snack
import kotlinx.android.synthetic.main.activity_global.view.*

/**
 *
 * View for global screen
 *
 * Created by Guillermo Bonafonte Criado
 */
class GlobalView(context: AppCompatActivity) : IGlobalView {

    override var context: Context = context
    override var presenter: IGlobalPresenter? = null
    override fun constructView(): View = view

    var view: View

    init {
        val parent = FrameLayout(context)
        parent.layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        view = LayoutInflater.from(context).inflate(R.layout.activity_global, parent, true)
        view.btn_start.setOnClickListener { presenter?.startLocation(view.btn_start.text.toString()) }
    }

    override fun showSnack(string: String) = view.snack(string)

    override fun showLatitude(latitude: String) {
        view.tv_latitude.text = context.getString(R.string.latitude, latitude)
    }

    override fun showLongitude(longitude: String) {
        view.tv_longitude.text = context.getString(R.string.longitude, longitude)
    }

    override fun showAltitude(altitude: String) {
        view.tv_altitude.text = context.getString(R.string.altitude, altitude)
    }

    override fun setStartButtonText(text: String) {
        view.btn_start.text = text
    }

    override fun startChronometer() {
        view.chronometer.apply {
            base = SystemClock.elapsedRealtime()
            start()
        }
    }

    override fun showProgressBar() {
        view.btn_start.visibility = View.INVISIBLE
        view.progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        view.btn_start.visibility = View.VISIBLE
        view.progressBar.visibility = View.GONE
    }

    override fun resetView() {
        view.chronometer.base = SystemClock.elapsedRealtime()
        view.tv_latitude.text = getStringResource(R.string.empty_latitude)
        view.tv_longitude.text = getStringResource(R.string.empty_longitude)
        view.tv_altitude.text = getStringResource(R.string.empty_altitude)
    }

    override fun stopChronometer() = view.chronometer.stop()

    override fun getChronometerTime(): Long = SystemClock.elapsedRealtime() - view.chronometer.base

    override fun getStringResource(id: Int): String = context.getStringResource(id)

    override fun navigateToSetRouteNameScreen(route: Route) {
        val extras = Bundle().apply { putParcelable(EXTRA_ROUTE, route) }
        startActivity(RouteNameActivity::class.java, extras)
    }
}