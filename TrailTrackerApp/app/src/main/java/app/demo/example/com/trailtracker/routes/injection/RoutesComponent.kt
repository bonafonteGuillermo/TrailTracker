package app.demo.example.com.trailtracker.routes.injection

import app.demo.example.com.trailtracker.app.injection.AppComponent
import app.demo.example.com.trailtracker.routes.RoutesActivity
import dagger.Component

/**
 *
 * Dagger component for Routes screen. Depends on AppComponent.
 *
 */
@RoutesScope
@Component(modules = [(RoutesContextModule::class), (RoutesModule::class)], dependencies = [(AppComponent::class)])
interface RoutesComponent {
    fun inject(activity: RoutesActivity)
}