package app.demo.example.com.trailtracker.app.injection

import dagger.Module
import dagger.Provides
import app.demo.example.com.trailtracker.rx.Schedulers
import app.demo.example.com.trailtracker.rx.AppSchedulers

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