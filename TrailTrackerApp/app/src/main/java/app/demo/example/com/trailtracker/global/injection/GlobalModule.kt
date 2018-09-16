package app.demo.example.com.trailtracker.global.injection

import android.support.v7.app.AppCompatActivity
import app.demo.example.com.trailtracker.global.GlobalPresenter
import app.demo.example.com.trailtracker.global.GlobalView
import app.demo.example.com.trailtracker.global.IGlobalPresenter
import app.demo.example.com.trailtracker.global.IGlobalView
import app.demo.example.com.trailtracker.location.ILocationProvider
import app.demo.example.com.trailtracker.repository.IRepository
import app.demo.example.com.trailtracker.rx.Schedulers
import dagger.Module
import dagger.Provides


/**
 *
 * Dagger module for global screen
 *
 * Created by Guillermo Bonafonte Criado
 */
@Module
class GlobalModule {

    @GlobalScope
    @Provides
    fun providePresenter(view: IGlobalView, repository: IRepository, schedulers: Schedulers, locationProvider : ILocationProvider): IGlobalPresenter {
        return GlobalPresenter(view, repository, schedulers, locationProvider)
    }

    @GlobalScope
    @Provides
    fun provideView(context: AppCompatActivity): IGlobalView {
        return GlobalView(context)
    }

}