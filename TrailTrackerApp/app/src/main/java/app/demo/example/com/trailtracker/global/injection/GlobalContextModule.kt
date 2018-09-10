package app.demo.example.com.trailtracker.global.injection

import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides

/**
 *
 * Dagger module for context of Global screen
 *
 * Created by Guillermo Bonafonte Criado
 */
@Module
class GlobalContextModule(context: AppCompatActivity) {

    var globalContext: AppCompatActivity = context

    @GlobalScope
    @Provides
    fun provideGlobalContext(): AppCompatActivity {
        return globalContext
    }

}
