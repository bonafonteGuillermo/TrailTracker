package app.demo.example.com.trailtracker.repository

import app.demo.example.com.trailtracker.data.AppDatabase
import app.demo.example.com.trailtracker.model.Route
import app.demo.example.com.trailtracker.rx.Schedulers
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.subjects.SingleSubject

class Repository(private val localStorage: AppDatabase,
                 private val schedulers: Schedulers
) : IRepository {

    override fun saveRouteInLocalStorage(route: Route) {
        Observable.just(localStorage).subscribeOn(schedulers.io()).subscribe(
                {
                    localStorage.routesDao().insertRoute(route)
                },
                {

                })

    }

    override fun getRoutesSavedInLocalStorage() : Single<List<Route>> {
        var publisher = SingleSubject.create<List<Route>>()

        Observable.just(localStorage).subscribeOn(schedulers.io()).subscribe(
                {
                    var routesLocallySaved = localStorage.routesDao().getRoutes()
                    publisher.onSuccess(routesLocallySaved)
                },
                {
                    error -> publisher.onError(error)
                }
        )
        return publisher

    }
}