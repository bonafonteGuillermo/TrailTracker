package app.demo.example.com.trailtracker.global.injection

import app.demo.example.com.trailtracker.app.injection.AppComponent
import app.demo.example.com.trailtracker.global.GlobalActivity
import dagger.Component

/**
 *
 * Dagger component for Global screen. Depends on AppComponent.
 *
 */
@GlobalScope
@Component(modules = [(GlobalContextModule::class), (GlobalModule::class)], dependencies = [(AppComponent::class)])
interface GlobalComponent {
    fun inject(activity: GlobalActivity)
}