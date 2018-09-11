package app.demo.example.com.trailtracker.routes.injection

import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides

/**
 *
 * Dagger module for context of Routes screen
 *
 * Created by Guillermo Bonafonte Criado
 */
@Module
class RoutesContextModule(context: AppCompatActivity) {

    var routesContext: AppCompatActivity = context

    @RoutesScope
    @Provides
    fun provideRoutesContext(): AppCompatActivity {
        return routesContext
    }

}
