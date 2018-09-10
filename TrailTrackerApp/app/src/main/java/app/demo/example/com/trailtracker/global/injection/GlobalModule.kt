package app.demo.example.com.trailtracker.global.injection

import android.support.v7.app.AppCompatActivity
import app.demo.example.com.trailtracker.global.*
import app.demo.example.com.trailtracker.rx.Schedulers
import app.demo.example.com.trailtracker.repository.IRepository
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
    fun providePresenter(view: IGlobalView, repository: IRepository, schedulers: Schedulers): IGlobalPresenter {
        return GlobalPresenter(view, repository, schedulers)
    }

    @GlobalScope
    @Provides
    fun provideView(context: AppCompatActivity): IGlobalView {
        return GlobalView(context)
    }

}