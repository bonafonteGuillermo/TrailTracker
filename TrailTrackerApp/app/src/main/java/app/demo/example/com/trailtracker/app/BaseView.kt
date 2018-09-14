package app.demo.example.com.trailtracker.app

import android.app.Activity
import android.content.*
import android.os.Bundle
import android.view.View
import app.demo.example.com.trailtracker.utils.snack

/**
 * Created by Guillermo Bonafonte Criado
 */
interface BaseView<P : BasePresenter> {

    companion object {
        val EXTRA_ROUTE = "route"
        val EXTRA_ROUTE_DETAIL = "route_details"
    }

    var presenter: P?
    var context: Context

    fun constructView(): View

    fun startActivity(activityClass: Class<*>,
                      finish: Boolean = false,
                      extras: Bundle?
    ) {
        val intent = Intent(context, activityClass)
        if (extras != null) intent.putExtras(extras)
        context.startActivity(intent)
        if (finish) (context as Activity).finish()
    }

    fun startActivity(activityClass: Class<*>,
                      extras: Bundle
    ) = startActivity(activityClass, false, extras)

    fun startActivity(activityClass: Class<*>, finish : Boolean = false) = startActivity(activityClass, finish, null)
}