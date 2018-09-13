package app.demo.example.com.trailtracker.global

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import app.demo.example.com.trailtracker.app.App
import app.demo.example.com.trailtracker.global.injection.DaggerGlobalComponent
import app.demo.example.com.trailtracker.global.injection.GlobalContextModule
import app.demo.example.com.trailtracker.location.LocationProviderImplementation.Companion.REQUEST_CHECK_SETTINGS
import app.demo.example.com.trailtracker.location.LocationProviderImplementation.Companion.REQUEST_LOCATION

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

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            when (requestCode) {
                REQUEST_LOCATION -> presenter.permissionsGranted()
            }
        }else{
            presenter.permissionsDenied()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when(requestCode) {
            REQUEST_CHECK_SETTINGS ->
                when(resultCode){
                    Activity.RESULT_OK -> presenter.permissionsGranted()
                }
        }
    }
}
