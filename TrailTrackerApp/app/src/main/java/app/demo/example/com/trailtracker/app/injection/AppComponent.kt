package app.demo.example.com.trailtracker.app.injection

import android.content.SharedPreferences
import app.demo.example.com.trailtracker.data.AppDatabase
import app.demo.example.com.trailtracker.repository.IRepository
import app.demo.example.com.trailtracker.rx.Schedulers
import dagger.Component
import javax.inject.Singleton

/**
 *
 * Dagger component for app
 *
 * Created by Guillermo Bonafonte Criado
 */
@Singleton
@AppScope
@Component(modules = [
    (ApiModule::class),
    (AppContextModule::class),
    (NetworkingModule::class),
    (RepositoryModule::class),
    (RxModule::class),
    (DatabaseModule::class)]
)

interface AppComponent {

    fun rxSchedulers(): Schedulers
    fun repository(): IRepository
    fun database(): AppDatabase

}