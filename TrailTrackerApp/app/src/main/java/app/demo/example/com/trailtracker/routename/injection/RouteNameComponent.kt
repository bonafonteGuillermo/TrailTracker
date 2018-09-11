package app.demo.example.com.trailtracker.routename.injection

import app.demo.example.com.trailtracker.app.injection.AppComponent
import app.demo.example.com.trailtracker.routename.RouteNameActivity
import dagger.Component

/**
 *
 * Dagger component for RouteName screen. Depends on AppComponent.
 *
 */
@RouteNameScope
@Component(modules = [(RouteNameContextModule::class), (RouteNameModule::class)], dependencies = [(AppComponent::class)])
interface RouteNameComponent {
    fun inject(activity: RouteNameActivity)
}