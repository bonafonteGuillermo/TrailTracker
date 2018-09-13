package app.demo.example.com.trailtracker.repository

import app.demo.example.com.trailtracker.model.Route
import io.reactivex.Single

interface IRepository {
    fun saveRouteInLocalStorage(route: Route) : Single<Route>
    fun getRoutesSavedInLocalStorage() : Single<List<Route>>
}
