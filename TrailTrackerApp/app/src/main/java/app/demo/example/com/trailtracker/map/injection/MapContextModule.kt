package app.demo.example.com.trailtracker.map.injection

import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides

/**
 *
 * Dagger module for context of Map screen
 *
 * Created by Guillermo Bonafonte Criado
 */
@Module
class MapContextModule(context: AppCompatActivity) {

    var mapContext: AppCompatActivity = context

    @MapScope
    @Provides
    fun provideMapContext(): AppCompatActivity {
        return mapContext
    }

}
