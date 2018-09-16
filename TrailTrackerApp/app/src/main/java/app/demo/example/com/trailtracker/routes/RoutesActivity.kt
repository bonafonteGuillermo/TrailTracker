package app.demo.example.com.trailtracker.routes

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import app.demo.example.com.trailtracker.app.App
import app.demo.example.com.trailtracker.routes.injection.DaggerRoutesComponent
import app.demo.example.com.trailtracker.routes.injection.RoutesContextModule
import javax.inject.Inject

/**
 *
 * Routes screen.ore proceeding.
 *
 * Created by Guillermo Bonafonte Criado
 */
class RoutesActivity : AppCompatActivity() {

    @Inject
    lateinit var view: IRoutesView

    @Inject
    lateinit var presenter: IRoutesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerRoutesComponent.builder()
                .appComponent(App.appComponent)
                .routesContextModule(RoutesContextModule(this))
                .build()
                .inject(this)


        setContentView(view.constructView())
        view.presenter = presenter

        presenter.onCreate()

    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}
