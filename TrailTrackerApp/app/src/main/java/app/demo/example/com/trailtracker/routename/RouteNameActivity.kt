package app.demo.example.com.trailtracker.routename

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import app.demo.example.com.trailtracker.app.App
import app.demo.example.com.trailtracker.app.BaseView.Companion.EXTRA_ROUTE
import app.demo.example.com.trailtracker.model.Route
import app.demo.example.com.trailtracker.routename.injection.DaggerRouteNameComponent
import app.demo.example.com.trailtracker.routename.injection.RouteNameContextModule
import javax.inject.Inject

/**
 *
 * Created by Guillermo Bonafonte Criado
 *
 */
class RouteNameActivity : AppCompatActivity() {

    val ROUTE = "USER_NAME"

    @Inject
    lateinit var view: IRouteNameView

    @Inject
    lateinit var presenter: IRouteNamePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerRouteNameComponent.builder()
                .appComponent(App.appComponent)
                .routeNameContextModule(RouteNameContextModule(this))
                .build()
                .inject(this)

        setContentView(view.constructView())
        view.presenter = presenter

        val bundle = intent.extras
        if (bundle.getParcelable<Route>(EXTRA_ROUTE) != null){
            var route = bundle.getParcelable<Route>(EXTRA_ROUTE)
            presenter.onCreate(route)
        }else{
            presenter.onCreate()
        }
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}