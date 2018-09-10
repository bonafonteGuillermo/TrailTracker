package app.demo.example.com.trailtracker.app.injection

import android.content.SharedPreferences
import app.demo.example.com.trailtracker.data.AppDatabase
import app.demo.example.com.trailtracker.repository.Api
import app.demo.example.com.trailtracker.repository.IRepository
import app.demo.example.com.trailtracker.repository.mock.Repository as MockRepository
import app.demo.example.com.trailtracker.repository.remote.Repository as RemoteRepository
import dagger.Module
import dagger.Provides
import app.demo.example.com.trailtracker.rx.Schedulers
import app.demo.example.com.trailtracker.utils.Configuration

/**
 * Created by Guillermo Bonafonte Criado
 */
@Module
class RepositoryModule {

    @AppScope
    @Provides
    fun provideRepository(api: Api, localStorage: AppDatabase, schedulers: Schedulers): IRepository =
        when (Configuration().Environment) {
            Configuration.Variant.MOCK -> MockRepository()
            else -> RemoteRepository(api, localStorage, schedulers)
        }
}