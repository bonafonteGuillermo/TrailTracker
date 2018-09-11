package app.demo.example.com.trailtracker.routes.injection

import android.support.v7.app.AppCompatActivity
import app.demo.example.com.trailtracker.routes.*
import app.demo.example.com.trailtracker.repository.IRepository
import app.demo.example.com.trailtracker.rx.Schedulers


import dagger.Module
import dagger.Provides


/**
 *
 * Dagger module for routes screen
 *
 * Created by Guillermo Bonafonte Criado
 */
@Module
class RoutesModule {

    @RoutesScope
    @Provides
    fun providePresenter(view: IRoutesView, repository: IRepository, schedulers: Schedulers): IRoutesPresenter {
        return RoutesPresenter(view, repository, schedulers)
    }

    @RoutesScope
    @Provides
    fun provideView(context: AppCompatActivity): IRoutesView {
        return RoutesView(context)
    }

}