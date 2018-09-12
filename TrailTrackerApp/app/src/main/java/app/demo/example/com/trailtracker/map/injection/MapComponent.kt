package app.demo.example.com.trailtracker.map.injection

import app.demo.example.com.trailtracker.app.injection.AppComponent
import app.demo.example.com.trailtracker.map.MapActivity
import dagger.Component

/**
 *
 * Dagger component for Map screen. Depends on AppComponent.
 *
 */
@MapScope
@Component(modules = [(MapContextModule::class), (MapModule::class)], dependencies = [(AppComponent::class)])
interface MapComponent {
    fun inject(activity: MapActivity)
}