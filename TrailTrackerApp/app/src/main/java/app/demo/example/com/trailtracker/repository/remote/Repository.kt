package app.demo.example.com.trailtracker.repository.remote

import android.content.SharedPreferences
import app.demo.example.com.trailtracker.data.AppDatabase
import app.demo.example.com.trailtracker.model.Route
import app.demo.example.com.trailtracker.repository.Api
import app.demo.example.com.trailtracker.repository.IRepository
import app.demo.example.com.trailtracker.rx.Schedulers

class Repository(private val api: Api,
                 private val localStorage: AppDatabase,
                 private val schedulers: Schedulers
) : IRepository {

    override fun saveRouteInLocalStorage(route: Route) {
    }


}