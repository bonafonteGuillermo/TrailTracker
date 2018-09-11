package app.demo.example.com.trailtracker.app.injection

import app.demo.example.com.trailtracker.data.AppDatabase
import app.demo.example.com.trailtracker.repository.IRepository
import app.demo.example.com.trailtracker.repository.Repository
import dagger.Module
import dagger.Provides
import app.demo.example.com.trailtracker.rx.Schedulers

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
