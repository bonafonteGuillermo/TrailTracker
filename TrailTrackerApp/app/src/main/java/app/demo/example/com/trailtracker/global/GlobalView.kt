package app.demo.example.com.trailtracker.global

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.support.v7.app.AppCompatActivity
import app.demo.example.com.trailtracker.R
import app.demo.example.com.trailtracker.utils.snack
import kotlinx.android.synthetic.main.activity_splash.view.*

/**
 *
 * View for global screen
 *
 * Created by Guillermo Bonafonte Criado
 */
class GlobalView(context: AppCompatActivity) : IGlobalView {

    var view: View

    override var context: Context = context
    override var presenter: IGlobalPresenter? = null
    override fun constructView(): View = view

    init {
        val parent = FrameLayout(context)
        parent.layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        view = LayoutInflater.from(context).inflate(R.layout.activity_splash, parent, true)

        view.btn_start.setOnClickListener { presenter?.startLocation() }
    }

    override fun showSnack(string : String) {
        view.snack(string)
    }

    override fun showLocation(location : String) {
        view.textView.text = location
    }




}