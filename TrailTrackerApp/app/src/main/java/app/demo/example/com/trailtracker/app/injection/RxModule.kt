package app.demo.example.com.trailtracker.app.injection

import app.demo.example.com.trailtracker.rx.AppSchedulers
import app.demo.example.com.trailtracker.rx.Schedulers
import dagger.Module
import dagger.Provides

/**
 *
 * Dagger module for Rx schedulers
 *
 * Created by Guillermo Bonafonte Criado
 */
@Module
class RxModule {

    @Provides
    fun provideRxSchedulers(): Schedulers {
        return AppSchedulers()
    }
}