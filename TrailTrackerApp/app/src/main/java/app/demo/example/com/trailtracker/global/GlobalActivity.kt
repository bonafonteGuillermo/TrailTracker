package app.demo.example.com.trailtracker.global

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import app.demo.example.com.trailtracker.app.App
import app.demo.example.com.trailtracker.global.injection.DaggerGlobalComponent
import app.demo.example.com.trailtracker.global.injection.GlobalContextModule

import javax.inject.Inject

/**
 *
 * Splash screen.ore proceeding.
 *
 * Created by Guillermo Bonafonte Criado
 */
class GlobalActivity : AppCompatActivity() {

    @Inject
    lateinit var view: IGlobalView

    @Inject
    lateinit var presenter: IGlobalPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerGlobalComponent.builder()
                .appComponent(App.appComponent)
                .globalContextModule(GlobalContextModule(this))
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
