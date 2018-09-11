package app.demo.example.com.trailtracker.routename.injection

import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides

/**
 *
 * Dagger module for context of RouteName screen
 *
 * Created by Guillermo Bonafonte Criado
 */
@Module
class RouteNameContextModule(context: AppCompatActivity) {

    var routenameContext: AppCompatActivity = context

    @RouteNameScope
    @Provides
    fun provideRouteNameContext(): AppCompatActivity {
        return routenameContext
    }

}
