package app.demo.example.com.trailtracker.map.injection

import android.support.v7.app.AppCompatActivity
import app.demo.example.com.trailtracker.map.IMapPresenter
import app.demo.example.com.trailtracker.map.IMapView
import app.demo.example.com.trailtracker.map.MapPresenter
import app.demo.example.com.trailtracker.map.MapView
import app.demo.example.com.trailtracker.repository.IRepository
import app.demo.example.com.trailtracker.rx.Schedulers

import dagger.Module
import dagger.Provides

/**
 *
 * Dagger module for map screen
 *
 * Created by Guillermo Bonafonte Criado
 */
@Module
class MapModule {

    @MapScope
    @Provides
    fun providePresenter(view: IMapView, repository: IRepository, schedulers: Schedulers): IMapPresenter {
        return MapPresenter(view, repository, schedulers)
    }

    @MapScope
    @Provides
    fun provideView(context: AppCompatActivity): IMapView {
        return MapView(context)
    }

}