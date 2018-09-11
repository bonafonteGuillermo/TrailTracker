package app.demo.example.com.trailtracker.repository

import app.demo.example.com.trailtracker.model.Route

interface IRepository {
    fun saveRouteInLocalStorage(route : Route)
}
