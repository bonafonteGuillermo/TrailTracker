package app.demo.example.com.trailtracker.app.injection

import app.demo.example.com.trailtracker.data.AppDatabase
import app.demo.example.com.trailtracker.repository.IRepository
import app.demo.example.com.trailtracker.repository.Repository
import app.demo.example.com.trailtracker.rx.Schedulers
import dagger.Module
import dagger.Provides

/**
 * Created by Guillermo Bonafonte Criado
 */
@Module
class RepositoryModule {

    @AppScope
    @Provides
    fun provideRepository( localStorage: AppDatabase, schedulers: Schedulers): IRepository =
         Repository(localStorage, schedulers)
}
