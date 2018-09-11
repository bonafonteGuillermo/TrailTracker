package app.demo.example.com.trailtracker.routename.injection

import android.support.v7.app.AppCompatActivity
import app.demo.example.com.trailtracker.repository.IRepository
import app.demo.example.com.trailtracker.routename.IRouteNamePresenter
import app.demo.example.com.trailtracker.routename.IRouteNameView
import app.demo.example.com.trailtracker.routename.RouteNamePresenter
import app.demo.example.com.trailtracker.routename.RouteNameView
import app.demo.example.com.trailtracker.rx.Schedulers

import dagger.Module
import dagger.Provides

/**
 *
 * Dagger module for routename screen
 *
 * Created by Guillermo Bonafonte Criado
 */
@Module
class RouteNameModule {

    @RouteNameScope
    @Provides
    fun providePresenter(view: IRouteNameView, repository: IRepository, schedulers: Schedulers): IRouteNamePresenter {
        return RouteNamePresenter(view, repository, schedulers)
    }

    @RouteNameScope
    @Provides
    fun provideView(context: AppCompatActivity): IRouteNameView {
        return RouteNameView(context)
    }

}