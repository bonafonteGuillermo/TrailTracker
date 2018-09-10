package app.demo.example.com.trailtracker.location

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import app.demo.example.com.trailtracker.global.injection.GlobalScope
import dagger.Module
import dagger.Provides

/**
 *
 * Created by Guillermo Bonafonte Criado
 *
 */
@Module
class LocationProviderModule {

    @GlobalScope
    @Provides
    fun providesLocationProvider(activity : AppCompatActivity): ILocationProvider = LocationProviderImplementation(activity)

}